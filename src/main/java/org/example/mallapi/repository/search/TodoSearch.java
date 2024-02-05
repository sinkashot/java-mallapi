package org.example.mallapi.repository.search;

import org.example.mallapi.domain.Todo;
import org.springframework.data.domain.Page;

public interface TodoSearch {
    Page<Todo> search1();
}
