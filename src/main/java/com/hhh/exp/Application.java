package com.hhh.exp;

import javax.servlet.MultipartConfigElement;

import org.apache.log4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.MultipartConfigFactory;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * springboot的启动类
 * @version 1.0
 * @author gaozhen
 * @date 创建时间：2017年6月25日 下午8:29:18
 * 
 */
@SpringBootApplication
@ServletComponentScan
@EnableTransactionManagement
public class Application implements CommandLineRunner {
	
	private static Logger log=Logger.getLogger(Application.class);
	
	public static void main(String[] args) {
				
		SpringApplication app=new SpringApplication(Application.class);
		app.run(args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		log.info("----->>>>>>>DESNEW is running!<<<<<<-------");
	}
	
	@Bean                 
    public MultipartConfigElement multipartConfigElement() { 
        MultipartConfigFactory factory = new MultipartConfigFactory();
        //// 设置文件大小限制 ,超了，页面会抛出异常信息，这时候就需要进行异常信息的处理了;
        factory.setMaxFileSize("5MB");
        /// 设置总上传数据总大小
        factory.setMaxRequestSize("6MB"); 
        //Sets the directory location where files will be stored.
        //factory.setLocation("路径地址");
        return factory.createMultipartConfig(); 
    } 
	
	
}
