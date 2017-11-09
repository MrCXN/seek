package com.lzy.seek.service;

import java.util.Map;

/**
 * 
 * @author CXN
 * @description : [广告业务层接口]
 *
 * @时间: 2017年10月25日 下午7:45:55
 */
public interface AdvertisingService {

	/**
	 * 
	 * @TODO: [列表]
	 * @param name
	 * @return: 
	 * @createTime:2017年10月25日下午8:09:24
	 */
	Map<String, Object> findAdvertisingList(int companyId,String name);
	

}
