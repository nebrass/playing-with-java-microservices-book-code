package com.targa.labs.myboutique.orderservice.service;

import com.targa.labs.myboutique.commons.dto.OrderItemDto;
import com.targa.labs.myboutique.commons.dto.ProductDto;
import com.targa.labs.myboutique.orderservice.domain.Order;
import com.targa.labs.myboutique.orderservice.domain.OrderItem;
import com.targa.labs.myboutique.orderservice.repository.OrderItemRepository;
import com.targa.labs.myboutique.orderservice.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@RequiredArgsConstructor
@Slf4j
@Service
@Transactional
public class OrderItemService {

    private final OrderItemRepository orderItemRepository;
    private final OrderRepository orderRepository;
    private final RestTemplate restTemplate;

    public List<OrderItemDto> findAll() {
        log.debug("Request to get all OrderItems");
        return this.orderItemRepository.findAll()
                .stream()
                .map(OrderItemService::mapToDto)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public OrderItemDto findById(Long id) {
        log.debug("Request to get OrderItem : {}", id);
        return this.orderItemRepository
                .findById(id)
                .map(OrderItemService::mapToDto)
                .orElse(null);
    }

    public OrderItemDto create(OrderItemDto orderItemDto) {
        log.debug("Request to create OrderItem : {}", orderItemDto);
        Order order = this.orderRepository
                .findById(orderItemDto.getOrderId())
                .orElseThrow(
                        () -> new IllegalStateException("The Order does not exist!")
                );

        ResponseEntity<ProductDto> productResponseEntity
                = this.restTemplate.getForEntity(
                        "http://product-service/api/products/{id}",
                        ProductDto.class,
                        orderItemDto.getProductId()
                );

        return mapToDto(
                this.orderItemRepository.save(
                        new OrderItem(
                                orderItemDto.getQuantity(),
                                productResponseEntity.getBody().getId(),
                                order
                        )));
    }

    public void delete(Long id) {
        log.debug("Request to delete OrderItem : {}", id);
        this.orderItemRepository.deleteById(id);
    }

    public static OrderItemDto mapToDto(OrderItem orderItem) {
        if (orderItem != null) {
            return new OrderItemDto(
                    orderItem.getId(),
                    orderItem.getQuantity(),
                    orderItem.getProductId(),
                    orderItem.getOrder().getId()
            );
        }
        return null;
    }

}
