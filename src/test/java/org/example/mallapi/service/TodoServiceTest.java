package org.example.mallapi.service;

import lombok.extern.log4j.Log4j2;
import org.example.mallapi.dto.TodoDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

@SpringBootTest
@Log4j2
public class TodoServiceTest {
    @Autowired
    TodoService todoService;

    @Test
    public void testGet() {
        Long tno = 50L;
        log.info(todoService.get(tno));
    }

    @Test
    public void testRegister() {
        TodoDTO todoDTO = TodoDTO
                .builder()
                .title("title")
                .content("content")
                .dueDate(LocalDate.of(2024,2,6))
                .build();

        log.info(todoService.register(todoDTO));
    }
}
