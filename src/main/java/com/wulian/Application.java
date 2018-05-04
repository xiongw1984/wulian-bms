package com.wulian;

import java.util.Properties;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import com.wulian.common.platform.CcpInitService;

@EnableEurekaClient
@EnableFeignClients
@SpringBootApplication
@EnableHystrix
@EnableCircuitBreaker
public class Application
{
    
    
    public static void main(String[] args)
        throws Exception
    {
        if (args.length != 3)
        {
            throw new Exception("Start server is error");
        }
        
        //设置系统环境参数
        CcpInitService.getInstance().setSystemProperty(args);
        
        
        // 加载配置文件
        Properties properties = CcpInitService.getInstance().loadProperty();
       
        
        SpringApplication springApplication = new SpringApplication(Application.class);
        springApplication.setDefaultProperties(properties);
        springApplication.run(args);
    }
}
