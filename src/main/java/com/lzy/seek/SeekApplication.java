package com.lzy.seek;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**
 * 
 * @author 陈喜楠
 * @description : [seek启动入口]
 *
 * @时间: 2017年10月19日 上午10:59:36
 */
@SpringBootApplication
@MapperScan("com.lzy.seek.dao")
public class SeekApplication {

	/**
	 * test head
	 * @TODO: [run as main方法就能执行]
	 * @param args: 
	 * @createTime:2017年12月13日下午6:07:46
	 */
	public static void main(String[] args) {
		SpringApplication.run(SeekApplication.class, args);
	}
}
