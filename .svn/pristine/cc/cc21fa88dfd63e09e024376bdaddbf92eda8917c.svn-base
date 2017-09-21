package com.spring.base.websocket.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.web.context.ContextLoader;

/**
 * $Id: AppCtx.java,v 1.1 2010/07/26 10:30:23 weijiguang Exp $
 */

public final class AppCtx implements ApplicationContextAware {

	public static ApplicationContext appCtx = null;

	static class AppContextHeader {
		static AppCtx instance = new AppCtx();
	}

	public AppCtx() {
		appCtx = ContextLoader.getCurrentWebApplicationContext();
	}

	public static ApplicationContext appCtx() {
		if (appCtx == null) {
			appCtx = ContextLoader.getCurrentWebApplicationContext();
		}
		return appCtx;
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		// TODO Auto-generated method stub
		if (appCtx == null) {
			appCtx = applicationContext;
		}
	}
	
}
