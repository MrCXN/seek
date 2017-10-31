package com.lzy.seek.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.lzy.seek.entity.Company;
import com.lzy.seek.service.CompanyService;
import com.lzy.seek.utils.CheckUtil;
import com.lzy.seek.utils.Result;

/**
 * 
 * @author 李兆阳
 * @description : [公司controller层]
 *
 * @时间: 2017年10月19日 上午11:02:30
 */
@Controller
@RequestMapping("company")
public class CompanyController {

	@Resource
	private CompanyService companyService;
	
	/**
	 * 
	 * @TODO: [公司管理页面]
	 * @createTime:2017年10月23日下午2:38:00
	 */
	@RequestMapping(value = "/companyIndex" )
	public ModelAndView companyIndex(){
		return new ModelAndView("company_Index");
	}
	
	/**
	 * @TODO: [公司列表]
	 * @createTime:2017年10月23日下午3:30:09
	 */
	@RequestMapping(value="/getCompanyList" ,method = { RequestMethod.POST, RequestMethod.POST })
	public @ResponseBody Map<String, Object> getCompanyList(String name){
		Map<String, Object> map = companyService.findCompanyList(name);
		return map;
	}
}
