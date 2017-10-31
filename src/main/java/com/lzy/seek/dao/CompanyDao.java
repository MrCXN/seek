package com.lzy.seek.dao;

import java.util.List;
import java.util.Map;

import com.lzy.seek.entity.Company;

/**
 * 
 * @author 李兆阳
 * @description : [公司数据接口]
 *
 * @时间: 2017年10月19日 上午11:06:32
 */
public interface CompanyDao {

	/**
	 * 
	 * @param params 
	 * @TODO: [获取公司集合]
	 * @return: List<Company>
	 * @createTime:2017年10月19日上午11:26:41
	 */
	List<Company> getCompanyList(Map<String, Object> params);
}
