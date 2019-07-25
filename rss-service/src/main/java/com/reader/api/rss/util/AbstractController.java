package com.reader.api.rss.util;

public abstract class AbstractController extends ComponentLogs {

	public static final String CONTROLLER_LABEL = "Controller";

	public AbstractController() {
		this.objectType = CONTROLLER_LABEL;
		this.objectName = this.getClass().getSimpleName();
	}
}
