package com.example.explorecalijpa.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.explorecalijpa.model.TourPackage;

@RepositoryRestResource(path = "packages", collectionResourceRel = "packages")
public interface TourPackageRepository extends JpaRepository<TourPackage, String>{
    Optional<TourPackage> findByName(String name);
}
