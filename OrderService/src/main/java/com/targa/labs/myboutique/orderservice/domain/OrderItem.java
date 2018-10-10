package com.targa.labs.myboutique.orderservice.domain;

import com.targa.labs.myboutique.commons.domain.AbstractEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * A OrderItem.
 */
@Data
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "order_items")
public class OrderItem extends AbstractEntity {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "quantity", nullable = false)
    private Long quantity;

    private Long productId;

    @ManyToOne
    private Order order;

    public OrderItem() {
        // Empty Constructor for JPA
    }

    public OrderItem(Long quantity, Long productId, Order order) {
        this.quantity = quantity;
        this.productId = productId;
        this.order = order;
    }

}
