package com.rhuangal.spring5webapp.repository;

import com.rhuangal.spring5webapp.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {


}

