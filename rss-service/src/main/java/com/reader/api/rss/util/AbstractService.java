package com.reader.api.rss.util;

import org.springframework.stereotype.Component;

@Component
public abstract class AbstractService extends ComponentLogs {

	public static final String SERVICE_LABEL = "Service";

	public AbstractService() {
		this.objectType = SERVICE_LABEL;
		this.objectName = this.getClass().getSimpleName();
	}
}
