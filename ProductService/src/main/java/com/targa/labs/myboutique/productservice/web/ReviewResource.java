package com.targa.labs.myboutique.productservice.web;

import com.targa.labs.myboutique.commons.dto.ReviewDto;
import static com.targa.labs.myboutique.commons.utils.Web.API;
import com.targa.labs.myboutique.productservice.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * @author n.lamouchi
 */
@RequiredArgsConstructor
@RestController
@RequestMapping(API + "/reviews")
public class ReviewResource {

    private final ReviewService reviewService;

    @GetMapping
    public List<ReviewDto> findAll() {
        return this.reviewService.findAll();
    }

    @GetMapping("/{id}")
    public ReviewDto findById(@PathVariable Long id) {
        return this.reviewService.findById(id);
    }

    @PostMapping
    public ReviewDto create(@RequestBody ReviewDto reviewDto) {
        return this.reviewService.create(reviewDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        this.reviewService.delete(id);
    }
}
