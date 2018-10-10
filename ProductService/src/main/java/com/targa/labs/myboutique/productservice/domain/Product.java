package com.targa.labs.myboutique.productservice.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.targa.labs.myboutique.commons.domain.AbstractEntity;
import com.targa.labs.myboutique.productservice.domain.enumeration.ProductStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

/**
 * A Product.
 */
@Data
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "product")
public class Product extends AbstractEntity {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "name", nullable = false)
    private String name;

    @NotNull
    @Column(name = "description", nullable = false)
    private String description;

    @NotNull
    @Column(name = "price", precision = 10, scale = 2, nullable = false)
    private BigDecimal price;

    @Column(name = "quantity")
    private Integer quantity;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private ProductStatus status;

    @Column(name = "sales_counter")
    private Integer salesCounter;

    @OneToMany
    @JsonIgnore
    private Set<Review> reviews = new HashSet<>();

    @ManyToOne
    private Category category;

    public Product() {
        // Empty Constructor for JPA
    }

    public Product(String name, String description, BigDecimal price,
            Integer quantity, ProductStatus status,
            Integer salesCounter, Category category) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
        this.status = status;
        this.salesCounter = salesCounter;
        this.category = category;
    }

}
