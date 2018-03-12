package com.playful.loyalty.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.playful.loyalty.domain.*;

@RepositoryRestResource(collectionResourceRel = "front-tags", path= "front-tags")
public interface FrontTagsRepo extends CrudRepository<FrontTags, Long> {
	
	
}
