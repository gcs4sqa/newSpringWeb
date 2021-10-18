package com.gcs4sqa.repositories;

import com.gcs4sqa.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorsRepository extends CrudRepository<Author, Long> {
}
