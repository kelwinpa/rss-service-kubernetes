package com.reader.api.rss.service;

import java.io.StringReader;
import java.util.List;
import java.util.stream.Collectors;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;

import com.reader.api.rss.domain.Rss;
import com.reader.api.rss.domain.RssModel;
import com.reader.api.rss.entity.RssEntity;
import com.reader.api.rss.interfaces.RssIntefaces;
import com.reader.api.rss.repository.RssRepository;
import com.reader.api.rss.rest.RsstDriverRest;
import com.reader.api.rss.util.AbstractService;
import com.reader.api.rss.util.CustomException;
import com.reader.api.rss.util.ExceptionUtils;

@Service
public class RssService extends AbstractService implements RssIntefaces {

	public static final String RETRIEVE_RSS = "retrieving rss new form the external services";
	public static final String SAVE_RSS = "saving rss in db";

	@Autowired
	private RsstDriverRest rsstDriverRest;

	@Autowired
	private RssRepository rssRepository;

	public RssService() {
		this.objectType = SERVICE_LABEL;
		this.objectName = "RssService";
	}

	public RssModel reader(String format) {
		String methodName = "reader";
		logStart(methodName);
		StopWatch stopWatch = new StopWatch();
		stopWatch.start(RETRIEVE_RSS);
		ResponseEntity<String> response = rsstDriverRest.reader(format);
		logTaskInfoAndStop(methodName, stopWatch);
		RssModel rssModel = new RssModel();
		Rss rss = checkRssFeedResponse(response);
		stopWatch.start(SAVE_RSS);
		rssRepository.saveAll(mappingRss(rss));
		logTaskInfoAndStop(methodName, stopWatch);
		logExit(methodName, rss);
		rssModel.setRss(rss);
		return rssModel;
	}

	private Rss checkRssFeedResponse(ResponseEntity<String> response) {
		String methodName = "checkRssFeedResponse";
		logStart(methodName);
		if (response.getStatusCode() != HttpStatus.OK) {
			logExit(methodName);
			throw new CustomException(ExceptionUtils.NOT_RET_FEED);
		} else {
			JAXBContext jaxbContext;
			try {
				jaxbContext = JAXBContext.newInstance(Rss.class);
				Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
				return (Rss) jaxbUnmarshaller.unmarshal(new StringReader(response.getBody()));
			} catch (JAXBException e) {
				logExitWithErrors(methodName, e);
				throw new CustomException(ExceptionUtils.CONVERT_XML_TO_OBJECT, e);
			}
		}
	}

	private List<RssEntity> mappingRss(Rss rss) {
		String methodName = "saveRss";
		logStart(methodName);
		List<RssEntity> rssList = rss.getChannel().getItem().stream().map(item -> {
			RssEntity rssEntity = new RssEntity();
			rssEntity.setTitle(item.getTitle());
			rssEntity.setDescription(item.getDescription());
			rssEntity.setPubDate(item.getPubDate());
			rssEntity.setImage(item.getEnclosure().getUrl());
			return rssEntity;
		}).collect(Collectors.toList());
		logExit(methodName);
		return rssList;
	}
}
