package com.lzy.seek.dao;

import java.util.Map;

import com.lzy.seek.entity.SeekUser;

/**
 * 
 * @author 李兆阳
 * @description : [登录数据接口]
 *
 * @时间: 2017年10月19日 上午11:06:32
 */
public interface LoginDao {

	/**
	 * 
	 * @param params 
	 * @TODO: [登录验证]
	 * @return: user
	 * @createTime:2017年10月23日上午9:20:37
	 */
	SeekUser getLoginUser(Map<String, Object> params);

	/**
	 * 
	 * @TODO: [注册]
	 * @param params: 
	 * @createTime:2017年11月4日下午6:00:49
	 */
	void register(Map<String, Object> params);

}
