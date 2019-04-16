package com.hhh.exp;

import org.apache.log4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;

/**
 * springboot的启动类
 * @version 1.0
 * @author gaozhen
 * @date 创建时间：2017年6月25日 下午8:29:18
 * 
 */
@SpringBootApplication
@ServletComponentScan
@ComponentScan(basePackages ="com.hhh.exp")
public class Application implements CommandLineRunner {
	
	private static Logger log=Logger.getLogger(ApplicationTest.class);
	
	public static void main(String[] args) {
				
		SpringApplication app=new SpringApplication(ApplicationTest.class);
		app.run(args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		log.info("----->>>>>>>EXP is running!<<<<<<-------");
	}
	
	
	
}
