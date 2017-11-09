package com.lzy.seek.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lzy.seek.dao.AdvertisingDao;
import com.lzy.seek.entity.Advertising;
import com.lzy.seek.entity.Company;
import com.lzy.seek.service.AdvertisingService;
import com.lzy.seek.utils.CodeConstant;
import com.lzy.seek.utils.ErrorCode;
import com.lzy.seek.utils.Result;

/**
 * 
 * @author 李兆阳
 * @description : [广告业务实现类]
 *
 * @时间: 2017年10月19日 上午11:04:48
 */
@Service("advertisingService")
@Transactional
public class AdvertisingServiceImpl implements AdvertisingService {

	Logger log = Logger.getLogger(this.getClass());
	@Resource
	private AdvertisingDao advertisingDao;

	/*
	 * @TODO: [广告列表]
	 * 
	 * @下午3:34:41
	 * 
	 * @see
	 * com.lzy.parttime.service.CompanyService#findCompanyList(java.lang.String,
	 * java.lang.String, int, int)
	 */
	@Override
	public Map<String, Object> findAdvertisingList(int companyId, String name) {
		Map<String, Object> map = new HashMap<>();
		map.put("code",1000);
		map.put("msg", "查询成功");
		Map<String, Object> params = new HashMap<>();
		params.put("name", name);
		params.put("companyId", companyId);
		try {
			List<Advertising> list = advertisingDao.findAdvertisingList(params);
			map.put("list", list);
			return map;
		} catch (Exception e) {
			map.put("code", CodeConstant.CODE200);
			map.put("msg", "查询失败");
			log.error("\r\n 广告列表 ： errorcode=" + ErrorCode.geterrocode(this) + "  \r\n" + e + "\r\n" + ",name:" + name
					+ "\r\n\r\n");
			e.printStackTrace();
		}
		return map;
	}
}
