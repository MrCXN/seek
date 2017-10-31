package com.lzy.seek.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.lzy.seek.entity.User;
import com.lzy.seek.service.LoginService;
import com.lzy.seek.utils.CheckUtil;
import com.lzy.seek.utils.Result;

/**
 * 
 * @author 李兆阳
 * @description : [登录入口]
 *
 * @时间: 2017年10月20日 上午9:43:13
 */
@RestController
@Controller
public class LoginController {

	@Resource
	private LoginService loginService;
	
	@RequestMapping("/")
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("login");
		return mv;
	}

	/**
	 * @TODO: [登录验证]
	 * @createTime:2017年10月20日下午4:59:36
	 */
	@RequestMapping(value = "/doLogin")
	public Map<String, Object> loginIndex(HttpServletRequest request) {
		String phone = request.getParameter("phone");
		String password = request.getParameter("password");
		
		Map<String, Object> map = new HashMap<>();
		Result result =  loginService.doLogin(phone,password);
		return CheckUtil.returnResult(map,result.getCode(), result.getMsg(), "");
	}
	
	/**
	 * 
	 * @TODO: [登录首页]
	 * @createTime:2017年10月23日下午2:38:00
	 */
	@RequestMapping(value = "/index" )
	public ModelAndView loginIndex(){
		return new ModelAndView("index");
	}
	
	/**
	 * 
	 * @TODO: [主页]
	 * @createTime:2017年10月23日下午2:38:00
	 */
	@RequestMapping(value = "/main" )
	public ModelAndView main(){
		return new ModelAndView("main");
	}
}
