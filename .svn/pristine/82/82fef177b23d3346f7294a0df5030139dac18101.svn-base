package com.spring.common.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.base.controller.BaseController;

/*负责显示 各种统计数据*/

@Controller
@RequestMapping(value = "/datashow")
public class DataShowController extends BaseController {
	
	
	@RequestMapping(value = "/index/{paper}")
	public String view(HttpServletRequest request, @PathVariable String paper,
			@RequestParam(value = "twId", required = false) String twId) {
		
		if ("list".equals(paper)) {
			return "datashow/home_show";
		}
		
		return "baseData/" + paper;
	}
	
	
	
	
	

}
