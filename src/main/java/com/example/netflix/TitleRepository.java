package com.example.netflix;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//Debido a la extension de Pading... nos crear una interfaz comoda para navegar por medio de enlaces, evitando los controladores
@RepositoryRestResource(collectionResourceRel = "title", path = "title")
public interface TitleRepository extends PagingAndSortingRepository<Title, Long> {

    //Consulta sobre los 10 mejores titulos
    @Query(value = "SELECT * FROM title ORDER BY user_rating DESC LIMIT ?1", nativeQuery = true)
    List<Title> findBest(Integer top);

}