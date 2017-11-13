package com.lzy.seek;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**
 * 
 * @author 李兆阳
 * @description : [seek启动入口]
 *
 * @时间: 2017年10月19日 上午10:59:36
 */
@SpringBootApplication
@MapperScan("com.lzy.seek.dao")
public class SeekApplication {

	public static void main(String[] args) {
		SpringApplication.run(SeekApplication.class, args);
	}
}
