package com.spring.common.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.spring.base.websocket.common.Global;
import com.spring.common.entity.TbMonitor;
import com.spring.common.service.DataOperateService;
import com.spring.common.service.TbMonitorService;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.base.controller.BaseController;

import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/monitor")
public class SystemMonitorController extends BaseController{
	@Resource
	DataOperateService dataOperateService;
	
	@Resource
	private TbMonitorService tbMonitorService;

	@RequestMapping(value = "/index/{paper}")
	public String view(HttpServletRequest request, @PathVariable String paper) {
		
		if ("jiankong".equals(paper)) {
			return "monitor/jiankong";
		}
		
		return "baseData/" + paper;
	}

	/**
	 * 获取信息
	 * @param request
	 * @param session
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/sigar/list")
	public Map<String, Object> getSigarList(HttpServletRequest request, HttpSession session) {
		Map<String, Object> map = new HashMap<>();
		Global.g_Cpu_list = dataOperateService.getCPUInfo();
//		Global.g_memory_list = dataOperateService.addMemoryList(dataOperateService.getMEMORYInfo());
		Global.g_disk_list = dataOperateService.getDiskInfo();
		Global.g_memory_map = dataOperateService.getMEMORYInfo();
		try{
			map.put("cpu_info_list",Global.g_Cpu_list);
//			map.put("menory_info_list",Global.g_memory_list);
			map.put("disk_info_list",Global.g_disk_list);
			map.put("menory_info_map",Global.g_memory_map);
		}catch (Exception e){
			e.printStackTrace();
			logger.error("请求失败："+e.getMessage());
		}
		return map;
	}
	
	@RequestMapping(value = "/list")
	@ResponseBody
	public Map<String, Object> listMonitor(HttpServletRequest request){
		Map<String, Object> result=new HashMap<>();
		List<TbMonitor> list=tbMonitorService.findAll();
		//根据Sort字段从小到大排序
//		list.sort((c1,c2)->c1.getTbmSort().toString().compareTo(c2.getTbmSort().toString()));
		result.put("list", list);
		result.put("code", 100);
		result.put("message", "success");
		return result;
	}
}
