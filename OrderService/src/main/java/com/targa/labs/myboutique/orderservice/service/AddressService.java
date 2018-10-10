package com.targa.labs.myboutique.orderservice.service;

import com.targa.labs.myboutique.orderservice.domain.Address;
import com.targa.labs.myboutique.commons.dto.AddressDto;


public class AddressService {

    public static AddressDto mapToDto(Address address) {
        if (address != null) {
            return new AddressDto(
                    address.getAddress1(),
                    address.getAddress2(),
                    address.getCity(),
                    address.getPostcode(),
                    address.getCountry()
            );
        }
        return null;
    }
}
