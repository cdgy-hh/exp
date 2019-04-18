package com.hhh.exp;

import org.apache.log4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;


/**
 * springboot的启动类
 * @version 1.0
 * @author gaozhen
 * @date 创建时间：2017年6月25日 下午8:29:18
 * 
 */
@SpringBootApplication
@ServletComponentScan
public class Application implements CommandLineRunner {
	
	private static Logger log=Logger.getLogger(Application.class);
	
	public static void main(String[] args) {
				
		SpringApplication app=new SpringApplication(Application.class);
		app.run(args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		log.info("----->>>>>>>EXP is running!<<<<<<-------");
	}
	
	private CorsConfiguration buildConfig() {  
        CorsConfiguration corsConfiguration = new CorsConfiguration();  
        corsConfiguration.addAllowedOrigin("*");  
        corsConfiguration.addAllowedHeader("*");  
        corsConfiguration.addAllowedMethod("*");  
        return corsConfiguration;  
    }  
      
    /** 
     * 跨域过滤器 
     * @return 
     */  
    @Bean  
    public CorsFilter corsFilter() {  
        UrlBasedCorsConfigurationSource source= new UrlBasedCorsConfigurationSource();  
        source.registerCorsConfiguration("/**", buildConfig()); // 4  
        return new CorsFilter(source);  
    } 
	
}
