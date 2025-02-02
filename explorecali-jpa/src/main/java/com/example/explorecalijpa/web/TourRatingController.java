package com.example.explorecalijpa.web;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.explorecalijpa.business.TourRatingService;
import com.example.explorecalijpa.model.TourRating;

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

    @GetMapping
    public List<RatingDto> getAllRatingsForTour(@PathVariable(value = "tourId") int tourId) {
        List<TourRating> tourRatings = tourRatingService.lookupRatings(tourId);
        
        return tourRatings.stream().map(RatingDto::new).toList();
    }

    @GetMapping("/average")
    public Map<String, Double> getAverage(@PathVariable(value = "tourId") int tourId) {
        return Map.of("average", tourRatingService.getAverageScore(tourId));
    }

    @PutMapping
    public RatingDto updateWithPut(
        @PathVariable(value = "tourId") int tourId,
        @RequestBody 
        @Valid RatingDto ratingDto) {

            return new RatingDto(tourRatingService.update(
                        tourId,
                        ratingDto.getCustomerId(),
                        ratingDto.getScore(),
                        ratingDto.getComment()
                    ));
    }

    @PatchMapping
    public RatingDto updateWithPatch(
        @PathVariable(value = "tourId") int tourId, 
        @RequestBody 
        @Valid RatingDto ratingDto) {
        return new RatingDto(tourRatingService.updateSome(
            tourId, 
            ratingDto.getCustomerId(), 
            Optional.ofNullable(ratingDto.getScore()), 
            Optional.ofNullable(ratingDto.getComment())));
    }
   
    @DeleteMapping("/{customerId}")
    public void delete(
        @PathVariable(value = "tourId") int tourId, 
        @PathVariable(value = "customerId") int customerId) {

            tourRatingService.delete(tourId, customerId);
    }

    @ExceptionHandler(NoSuchElementException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String return404(NoSuchElementException exception){
        return exception.getMessage();
    }
}
