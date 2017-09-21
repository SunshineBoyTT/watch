package com.spring.base.websocket.util;



import org.springframework.context.ApplicationContext;

import com.spring.base.websocket.common.Global;


public class SpringHelper {

	public static Object getBean(String name) {
		ApplicationContext ctx = AppCtx.appCtx();
		
//		System.out.println("-------------------bb:"+ctx);
		if (ctx == null) {
			return Global.ctx.getBean(name);
		} else {
			return ctx.getBean(name);
		}
	}
}
