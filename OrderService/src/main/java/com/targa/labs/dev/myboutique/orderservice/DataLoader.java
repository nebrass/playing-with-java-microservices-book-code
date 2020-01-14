/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.targa.labs.dev.myboutique.orderservice;

import com.targa.labs.dev.myboutique.commons.dto.ProductDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author n.lamouchi
 */
@Slf4j
@Component
public class DataLoader implements CommandLineRunner {

    private final RestTemplate restTemplate;

    public DataLoader(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public void run(String... strings) throws Exception {
        ResponseEntity<ProductDto> productResponseEntity
                = this.restTemplate.getForEntity(
                        "http://product-service/api/products/{id}",
                        ProductDto.class,
                        6
                );

        log.error("############  " + productResponseEntity.getBody().toString() + "   ###############");
    }
}
