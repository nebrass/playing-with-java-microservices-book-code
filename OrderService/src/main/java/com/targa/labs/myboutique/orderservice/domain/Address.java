package com.targa.labs.myboutique.orderservice.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * A Address.
 */
@Data
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Embeddable
public class Address implements Serializable {

    @Column(name = "address_1")
    private String address1;

    @Column(name = "address_2")
    private String address2;

    @Column(name = "city")
    private String city;

    //@NotNull
    @Size(max = 10)
    @Column(name = "postcode", length = 10)//, nullable = false)
    private String postcode;

    //@NotNull
    @Size(max = 2)
    @Column(name = "country", length = 2)//, nullable = false)
    private String country;

}
