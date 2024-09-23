package com.julio.springboot.di.app.springboot_di;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.julio.springboot.di.app.springboot_di.repositories.ProductRepository;
import com.julio.springboot.di.app.springboot_di.repositories.ProductRepositoryJson;


@Configuration
@PropertySource(value = "classpath:values.properties",encoding = "UTF-8")
public class AppConfig {

    @Bean("productJson")
    ProductRepository productRepositoryJson() {
        return new ProductRepositoryJson();
    }

}
