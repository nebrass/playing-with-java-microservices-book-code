package com.targa.labs.myboutique.orderservice.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.targa.labs.myboutique.commons.domain.AbstractEntity;
import com.targa.labs.myboutique.orderservice.domain.enumeration.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.Set;

/**
 * A Orders.
 */
@Data
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "orders")
public class Order extends AbstractEntity {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "total_price", precision = 10, scale = 2, nullable = false)
    private BigDecimal totalPrice;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private OrderStatus status;

    @Column(name = "shipped")
    private ZonedDateTime shipped;

    @OneToOne
    @JoinColumn(unique = true)
    private Payment payment;

    @Embedded
    private Address shipmentAddress;

    @OneToMany(mappedBy = "order")
    @JsonIgnore
    private Set<OrderItem> orderItems;

    private Long cartId;

    public Order() {
        // Empty Constructor for JPA
    }

    public Order(BigDecimal totalPrice, OrderStatus status,
            ZonedDateTime shipped, Payment payment,
            Address shipmentAddress, Set<OrderItem> orderItems, Long cartId) {
        this.totalPrice = totalPrice;
        this.status = status;
        this.shipped = shipped;
        this.payment = payment;
        this.shipmentAddress = shipmentAddress;
        this.orderItems = orderItems;
        this.cartId = cartId;
    }

}
