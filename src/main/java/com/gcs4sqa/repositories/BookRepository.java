package com.gcs4sqa.repositories;

import com.gcs4sqa.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
