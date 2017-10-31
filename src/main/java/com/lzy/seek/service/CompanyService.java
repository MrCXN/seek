package com.lzy.seek.service;

import java.util.Map;

/**
 * 
 * @author 李兆阳
 * @description : [公司业务层接口]
 *
 * @时间: 2017年10月19日 上午11:05:13
 */
public interface CompanyService {

	/**
	 * 
	 * @TODO: [公司列表]
	 * @param addTime : 添加时间
	 * @return: 
	 * @createTime:2017年10月23日下午3:34:08
	 */
	Map<String, Object> findCompanyList(String name);

}
