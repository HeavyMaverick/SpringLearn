package com.heavymaverick.webapp.config;

import com.heavymaverick.webapp.client.RestClientProductsRestClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.support.BasicAuthenticationInterceptor;
import org.springframework.web.client.RestClient;

import java.nio.charset.StandardCharsets;

@Configuration
public class ClientBeans {

    @Bean
    public RestClientProductsRestClient productsRestClient(
            @Value("${com.heavymaverick.catalogue.uri:http://localhost:8081}") String catalogueBaseUri,
            @Value("${com.heavymaverick.catalogue.username:}") String catalogueUsername,
            @Value("${com.heavymaverick.catalogue.password:}") String cataloguePassword) {
        return new RestClientProductsRestClient(RestClient.builder()
                .baseUrl(catalogueBaseUri)
                .requestInterceptor(new BasicAuthenticationInterceptor(catalogueUsername, cataloguePassword, StandardCharsets.UTF_8))
                .build());
    }
}