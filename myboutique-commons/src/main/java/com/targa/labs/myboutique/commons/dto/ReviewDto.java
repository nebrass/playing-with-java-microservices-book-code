/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.targa.labs.myboutique.commons.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author n.lamouchi
 */
@Data
@AllArgsConstructor
public class ReviewDto {
    private Long id;
    private String title;
    private String description;
    private Long rating;
}
