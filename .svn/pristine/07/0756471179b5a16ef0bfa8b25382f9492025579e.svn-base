/**    
* @{#} InitService.java Create on 2016年4月19日 下午4:43:36    
* Copyright (c) 2015.    
*/
package com.spring.common.service;

import javax.annotation.Resource;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.web.context.ContextLoader;

/**
 * @author <a href="mailto:liwei.fly@gmail.com">author</a>
 * @version 1.0
 * @description
 */
@Component
public class InitService implements ApplicationListener<ContextRefreshedEvent> {

	@Resource
	DataOperateService dataOperateService;

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		// TODO Auto-generated method stub
		if (event.getApplicationContext().getParent() == null) {
//			while (ContextLoader.getCurrentWebApplicationContext() == null) {
//				
//			}
			dataOperateService.refreshData();
		}
	}

}
