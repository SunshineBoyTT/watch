/**    
* @{#} WsResponse.java Create on 2016年4月19日 下午4:01:33    
* Copyright (c) 2015.    
*/     
package com.spring.base.websocket;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/**     
* @author <a href="mailto:liwei.fly@gmail.com">author</a>    
* @version 1.0     
* @description
*/
public class WsResponse {
	private ArrayList cpu_info_list;
	private ArrayList menory_info_list;
	private ArrayList disk_info_list;
	private Map menory_info_map;

	public ArrayList getCpu_info_list() {
		return cpu_info_list;
	}

	public void setCpu_info_list(ArrayList cpu_info_list) {
		this.cpu_info_list = cpu_info_list;
	}

	public ArrayList getMenory_info_list() {
		return menory_info_list;
	}

	public void setMenory_info_list(ArrayList menory_info_list) {
		this.menory_info_list = menory_info_list;
	}

	public ArrayList getDisk_info_list() {
		return disk_info_list;
	}

	public void setDisk_info_list(ArrayList disk_info_list) {
		this.disk_info_list = disk_info_list;
	}

	public Map getMenory_info_map() {
		return menory_info_map;
	}

	public void setMenory_info_map(Map menory_info_map) {
		this.menory_info_map = menory_info_map;
	}
}
