package com.example.explorecalijpa.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.explorecalijpa.model.TourRating;

@RepositoryRestResource(exported = false)
public interface TourRatingRepository extends JpaRepository<TourRating, Integer>, CrudRepository<TourRating, Integer>{

    /** Returns all ratings for a tour. */
    List<TourRating> findByTourId(Integer tourId);
    /** Fetches a specific rating. */
    Optional<TourRating> findByTourIdAndCustomerId(Integer tourId, Integer customerId);
}
