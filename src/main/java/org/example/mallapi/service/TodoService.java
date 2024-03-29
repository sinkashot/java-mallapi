package org.example.mallapi.service;

import jakarta.transaction.Transactional;
import org.example.mallapi.domain.Todo;
import org.example.mallapi.dto.TodoDTO;

@Transactional
public interface TodoService {
    TodoDTO get(Long tno);

    Long register(TodoDTO dto);

    void modify(TodoDTO dto);

    void remove(Long tno);

    default TodoDTO entityToDTO(Todo todo) {
        return TodoDTO
                .builder()
                .tno(todo.getTno())
                .title(todo.getTitle())
                .content(todo.getContent())
                .dueDate(todo.getDueDate())
                .build();
    }

    default Todo dtoToEntity(TodoDTO todoDTO) {
        return Todo
                .builder()
                .tno(todoDTO.getTno())
                .title(todoDTO.getTitle())
                .content(todoDTO.getTitle())
                .dueDate(todoDTO.getDueDate())
                .build();
    }
}
