package com.library.library.repositories;

import com.library.library.model.LibraryModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibraryRepository extends JpaRepository<LibraryModel, Long> {
}
