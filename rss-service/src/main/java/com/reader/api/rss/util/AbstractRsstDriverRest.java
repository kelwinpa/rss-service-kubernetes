package com.reader.api.rss.util;

public abstract class AbstractRsstDriverRest extends ComponentLogs {

	public static final String DRIVER_LABEL = "Driver";

	protected AbstractRsstDriverRest() {
		objectType = DRIVER_LABEL;
		this.objectName = this.getClass().getSimpleName();
	}
}
