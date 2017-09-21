package com.spring.base.websocket.common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;


/**
 * 系统变量
 * 
 * @author Administrator
 * 
 */
public class Global {

	public static ApplicationContext ctx = null;
	// 系统变量配置文件
	public static final String CONFIGPATH = "/";
	/** 系统配置路径 */
	public static final String CONSTANT_PROPERTIES = "systemConstant.properties";
	/** 系统常量配置文件 */
	public static final String CONFIG_XMLFILE = "systemConfig.xml";
	/** 系统配置动态配置文件 */

	public transient static int cpu_count = 0;
	public static String today;
	
	
	public static ArrayList g_Cpu_list = new ArrayList();
    public static ArrayList g_memory_list = new ArrayList();
    public static ArrayList g_disk_list = new ArrayList();
    public static Map g_memory_map = new HashMap();
}
