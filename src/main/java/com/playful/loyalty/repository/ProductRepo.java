package com.playful.loyalty.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.playful.loyalty.domain.Product;;

@RepositoryRestResource
public interface ProductRepo extends PagingAndSortingRepository<Product, Long> {
}
