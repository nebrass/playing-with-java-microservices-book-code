package com.targa.labs.myboutique.customerservice.service;

import com.targa.labs.myboutique.commons.dto.CartDto;
import com.targa.labs.myboutique.commons.dto.OrderDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 *
 * @author n.lamouchi
 */
@FeignClient(name = "order-service")
public interface OrderServiceClient {

    @RequestMapping(value = "/api/orders", method = POST)
    OrderDto create(CartDto cartDto);

}
