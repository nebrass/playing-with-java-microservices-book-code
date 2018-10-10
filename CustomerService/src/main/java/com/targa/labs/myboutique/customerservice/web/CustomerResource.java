package com.targa.labs.myboutique.customerservice.web;

import com.targa.labs.myboutique.commons.dto.CustomerDto;
import com.targa.labs.myboutique.customerservice.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.targa.labs.myboutique.commons.utils.Web.API;

/**
 * @author n.lamouchi
 */
@RequiredArgsConstructor
@RestController
@RequestMapping(API + "/customers")
public class CustomerResource {

    private final CustomerService customerService;

    @GetMapping
    public List<CustomerDto> findAll() {
        return this.customerService.findAll();
    }

    @GetMapping("/{id}")
    public CustomerDto findById(@PathVariable Long id) {
        return this.customerService.findById(id);
    }

    @GetMapping("/active")
    public List<CustomerDto> findAllActive() {
        return this.customerService.findAllActive();
    }

    @GetMapping("/inactive")
    public List<CustomerDto> findAllInactive() {
        return this.customerService.findAllInactive();
    }

    @PostMapping
    public CustomerDto create(CustomerDto customerDto) {
        return this.customerService.create(customerDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        this.customerService.delete(id);
    }

}