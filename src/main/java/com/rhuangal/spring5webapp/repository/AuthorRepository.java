package com.rhuangal.spring5webapp.repository;

import com.rhuangal.spring5webapp.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {


}
