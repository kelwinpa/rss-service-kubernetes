package com.reader.api.rss.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;
import org.springframework.web.client.RestTemplate;

import com.reader.api.rss.util.AbstractRsstDriverRest;
import com.reader.api.rss.util.CustomException;
import com.reader.api.rss.util.ExceptionUtils;

@Component
public class RsstDriverRest extends AbstractRsstDriverRest {

	@Value("${endpoint.url}")
	private String endpointUrlRss;

	private static final String REQUEST_LABEL = "contacting rss new site";

	public RsstDriverRest() {
		this.objectType = DRIVER_LABEL;
		this.objectName = "RsstDriverRest";
	}

	public ResponseEntity<String> reader(String format) {
		String methodName = "reader";
		logStart(methodName, format);
		StopWatch stopWatch = new StopWatch();
		RestTemplate restTemplate = new RestTemplate();
		try {
			stopWatch.start(REQUEST_LABEL);
			ResponseEntity<String> response = restTemplate.getForEntity(endpointUrlRss + format, String.class);
			logTaskInfoAndStop(methodName, stopWatch);
			logExit(methodName, response);
			return response;
		} catch (CustomException ce) {
			logExitWithErrors(methodName, ce);
			throw ce;
		} catch (Exception e) {
			logExitWithErrors(methodName, e);
			throw new CustomException(ExceptionUtils.NOT_RET_FEED, e);
		} finally {
			logTaskInfoAndStop(methodName, stopWatch);
		}
	}

}
