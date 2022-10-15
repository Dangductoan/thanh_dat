package com.toandd.project.thanhdat;

import com.toandd.project.thanhdat.security.config.RsaKeyProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(RsaKeyProperties.class)
public class ThanhdatApplication {
    public static void main(String[] args) {
        SpringApplication.run(ThanhdatApplication.class, args);
    }

}

