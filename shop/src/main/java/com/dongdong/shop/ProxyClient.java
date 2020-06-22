package com.dongdong.shop;

import com.dongdong.service.Subject;
import com.dongdong.service.impl.SubjectStaticFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 代理类测试
 *
 * @author Mona
 * @date 2020/6/9 19:23
 */
@SpringBootApplication(scanBasePackages = "com.dongdong")
public class ProxyClient {
    public static void main(String[] args) {

        SpringApplication.run(ProxyClient.class,args);

        Subject proxy = SubjectStaticFactory.getInstance();
        proxy.dealTask("DBQueryTask");
    }
}
