package com.lzy.seek.service.impl;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.lzy.seek.dao.LoginDao;
import com.lzy.seek.entity.SeekUser;
import com.lzy.seek.entity.User;
import com.lzy.seek.service.LoginService;
import com.lzy.seek.utils.AESCoder;
import com.lzy.seek.utils.CodeConstant;
import com.lzy.seek.utils.ErrorCode;
import com.lzy.seek.utils.Result;

/**
 * 
 * @author 李兆阳
 * @description : [登录业务实现类]
 *
 * @时间: 2017年10月19日 上午11:04:48
 */
@Service("loginService")  
public class LoginServiceImpl implements LoginService {
	
	Logger log = Logger.getLogger(this.getClass());
	
	@Resource
	private LoginDao loginDao;

	/*
	 * @TODO: [登录验证]
	 * @下午5:16:55
	 * @see com.lzy.parttime.service.LoginService#doLogin(com.lzy.parttime.entity.User)
	 */
	@Override
	public Result doLogin(String phone, String password) {
		Result result = new Result();
		result.setMsg("加载成功");
		result.setCode(CodeConstant.CODE1000);
		Map<String, Object> params = new HashMap<>();
		params.put("phone",phone);
		params.put("password",password);
		try {
			SeekUser verifyUser = loginDao.getLoginUser(params);
			if(verifyUser==null){
				result.setCode(CodeConstant.CODE201);
				result.setMsg("用户不存在");
				return result;
			}
			if(!new String(AESCoder.decode(verifyUser.getPassword())).equals(password)){
				result.setCode(CodeConstant.CODE202);
				result.setMsg("账户密码不匹配，请重新输入");
				return result;
			}
			result.setData(verifyUser);
		} catch (Exception e) {
			result.setCode(CodeConstant.CODE200);
			result.setMsg("加载失败");
			log.error("\r\n 登录验证 ： errorcode=" + ErrorCode.geterrocode(this)+ "  \r\n" + e + "\r\n\r\n");
			e.printStackTrace();
		}
		return result;
	}

	/*
	 * @TODO: [注册]
	 * @下午5:59:14
	 * @see com.lzy.seek.service.LoginService#register(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public Result register(String phone, String password, String seekNm) {
		Result result = new Result();
		result.setMsg("加载成功");
		result.setCode(CodeConstant.CODE1000);
		Map<String, Object> params = new HashMap<>();
		params.put("phone",phone);
		params.put("password",AESCoder.encode(password.getBytes()));
		params.put("seekNm",seekNm);
		try {
			loginDao.register(params);
		} catch (Exception e) {
			result.setCode(CodeConstant.CODE200);
			result.setMsg("加载失败");
			log.error("\r\n 注册失败 ： errorcode=" + ErrorCode.geterrocode(this)+ "  \r\n" + e + "\r\n\r\n");
			e.printStackTrace();
		}
		return result;
	}
}
