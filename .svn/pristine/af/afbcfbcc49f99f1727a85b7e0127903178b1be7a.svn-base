package com.spring.common.controller;

import com.spring.base.controller.BaseController;
import com.spring.base.utils.GlobalStatic;
import com.spring.common.entity.TbMonitor;
import com.spring.common.service.TbMonitorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController extends BaseController {

	@Resource
	private TbMonitorService tbMonitorService;


	@RequestMapping(value = "/monitor")
	public String Monitor(){
		return "monitor";
	}

	@RequestMapping(value="/index", produces = "text/html")
	public String index(Model model, HttpServletRequest request, HttpServletResponse response, Integer id) {
		if (id==null) {
			request.setAttribute("message", "请选择正确的监控服务器");
			request.setAttribute("code", -1);
			return "index";
		}
		TbMonitor tbMonitor=tbMonitorService.findById(id);
		if (tbMonitor==null) {
			request.setAttribute("message", "监控服务器不存在");
			request.setAttribute("code", -1);
			return "index";
		}
		request.setAttribute("tbMonitor", tbMonitor);
		request.setAttribute("message", "success");
		request.setAttribute("code", 100);
		return "index";
	}
	
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String login(HttpServletRequest request) {
		return "login";
	}
	/**
	 * 注销 登录
	 * @return
	 */
	@RequestMapping(value="/logout")
	public String logout(Model model , HttpSession session){
		//User user2 = (User)session.getAttribute(GlobalStatic.DEFAULT_LOGIN_SESSION_NAME);
		session.removeAttribute(GlobalStatic.DEFAULT_LOGIN_SESSION_NAME);
		//SecurityUtils.getSubject().logout();
		return "/login";
	}
}
