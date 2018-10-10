/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.targa.labs.myboutique.orderservice.web;

import com.targa.labs.myboutique.commons.dto.PaymentDto;
import com.targa.labs.myboutique.orderservice.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.targa.labs.myboutique.commons.utils.Web.API;

/**
 * @author n.lamouchi
 */
@RequiredArgsConstructor
@RestController
@RequestMapping(API + "/payments")
public class PaymentResource {

    private final PaymentService paymentService;

    @GetMapping
    public List<PaymentDto> findAll() {
        return this.paymentService.findAll();
    }

    @GetMapping("/{id}")
    public PaymentDto findById(@PathVariable Long id) {
        return this.paymentService.findById(id);
    }

    @PostMapping
    public PaymentDto create(@RequestBody PaymentDto orderItemDto) {
        return this.paymentService.create(orderItemDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        this.paymentService.delete(id);
    }
}
