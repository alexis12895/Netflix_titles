package com.example.netflix;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "director", path = "director")
public interface DirectorRepository extends PagingAndSortingRepository<Director, Long> {


}