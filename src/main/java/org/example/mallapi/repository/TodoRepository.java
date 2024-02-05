package org.example.mallapi.repository;

import org.example.mallapi.domain.Todo;
import org.example.mallapi.repository.search.TodoSearch;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Long>, TodoSearch {
}
