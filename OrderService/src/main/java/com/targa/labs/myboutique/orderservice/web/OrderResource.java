/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.targa.labs.myboutique.orderservice.web;

import com.targa.labs.myboutique.orderservice.service.OrderService;
import com.targa.labs.myboutique.commons.dto.OrderDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.targa.labs.myboutique.commons.utils.Web.API;

/**
 * @author n.lamouchi
 */
@RequiredArgsConstructor
@RestController
@RequestMapping(API + "/orders")
public class OrderResource {

    private final OrderService orderService;

    @GetMapping
    public List<OrderDto> findAll() {
        return this.orderService.findAll();
    }

    /*@GetMapping("/customer/{id}")
    public List<OrderDto> findAllByUser(@PathVariable Long id) {
        return this.orderService.findAllByUser(id);
    }*/

    @GetMapping("/{id}")
    public OrderDto findById(@PathVariable Long id) {
        return this.orderService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        this.orderService.delete(id);
    }
}
