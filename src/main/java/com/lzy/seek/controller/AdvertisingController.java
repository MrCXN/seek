package com.lzy.seek.controller;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.lzy.seek.service.AdvertisingService;

/**
 * 
 * @author 李兆阳
 * @description : [广告controller层]
 * 				springboot:快速开发,集成大量的技术,使用简单, 只需配置相应的文件即可使用,内置容器,直接运行main方法,即可运行整个
 * 				项目
 *
 * @时间: 2017年10月19日 上午11:02:30
 */
@Controller
@RequestMapping("advertising")
public class AdvertisingController {

	@Resource
	private AdvertisingService advertisingService;
	
	/**
	 * 
	 * @TODO: [广告管理页面]
	 * @createTime:2017年10月23日下午2:38:00
	 */
	@RequestMapping(value = "/advertisingIndex" )
	public ModelAndView advertisingIndex(Integer id,Model model){
		ModelAndView andView= new ModelAndView();
		andView.addObject("msg1", "test");
		model.addAttribute("msg","test1");
		return new ModelAndView("advertising_Index");
	}
	
	/**
	 * @TODO: [广告列表]
	 * @createTime:2017年10月23日下午3:30:09
	 */
	@RequestMapping("/getAdvertisingList")
	public @ResponseBody Map<String, Object> getAdvertisingList(int companyId,String name,Model model){
		Map<String, Object> map = advertisingService.findAdvertisingList(companyId,name);
		model.addAttribute("msg","test1");
		return map;
	}
	
	/**
	 * 
	 * @TODO: [应聘成功页面]
	 * @return: 
	 * @createTime:2017年11月8日下午6:21:51
	 */
	@RequestMapping(value = "/successIndex" )
	public ModelAndView successIndex(){
		return new ModelAndView("success");
	}
}
