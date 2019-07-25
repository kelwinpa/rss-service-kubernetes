package com.reader.api.rss.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reader.api.rss.domain.RssModel;
import com.reader.api.rss.service.RssService;
import com.reader.api.rss.util.AbstractController;
import com.reader.api.rss.util.BaseResponse;
import com.reader.api.rss.util.CustomException;
import com.reader.api.rss.util.ResponseUtils;

@RestController
@RequestMapping("rss")
public class RssRestController extends AbstractController {

	@Autowired
	private RssService rssService;

	public RssRestController() {
		this.objectType = CONTROLLER_LABEL;
		this.objectName = "RssRestController";
	}

	private static final String LOG_CONTROLLER_LABEL = "%s (RssRestController) (controller)";

	@GetMapping("reader/{format}")
	public ResponseEntity<BaseResponse<?>> reader(@PathVariable("format") String format) {
		String methodName = "reader";
		logStart(methodName, format);
		StopWatch stopWatch = new StopWatch();
		stopWatch.start(String.format(LOG_CONTROLLER_LABEL, methodName));
		try {
			RssModel result = rssService.reader(format);
			logExit(methodName);
			return ResponseUtils.buildSuccessOperationResponse(result);
		} catch (CustomException ce) {
			logExitWithErrorsAndStack(methodName, ce);
			return ResponseUtils.buildErrorResponse(ce);
		} catch (Exception e) {
			logExitWithErrorsAndStack(methodName, e);
			return ResponseUtils.buildFailedOperationResponse(500, "Error retrieving rss");
		} finally {
			logTaskInfoAndStop(methodName, stopWatch);
		}
	}
}
