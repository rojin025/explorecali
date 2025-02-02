package com.example.explorecalijpa.web;

import java.util.NoSuchElementException;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.explorecalijpa.business.TourRatingService;

import jakarta.validation.Valid;


@RestController
@RequestMapping(path = "/tours/{tourId}/ratings")
public class TourRatingController {
    private TourRatingService tourRatingService;

    public TourRatingController(TourRatingService tourRatingService){
        this.tourRatingService = tourRatingService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createTourRating(
    @PathVariable(value = "tourId") int tourId, 
        @RequestBody @Valid RatingDto ratingDto) {
            tourRatingService.createNew(
                tourId, 
                ratingDto.getCustomerId(), 
                ratingDto.getScore(), 
                ratingDto.getComment());
    }
    
    @ExceptionHandler(NoSuchElementException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String return404(NoSuchElementException exception){
        return exception.getMessage();
    }
}
