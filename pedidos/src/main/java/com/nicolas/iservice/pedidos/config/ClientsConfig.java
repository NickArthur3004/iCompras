package com.nicolas.iservice.pedidos.config;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients(basePackages = "com.nicolas.iservice.pedidos.client")
public class ClientsConfig {
}
