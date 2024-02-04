package org.example.mallapi.repository;

import lombok.extern.log4j.Log4j2;
import org.example.mallapi.domain.Todo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.Optional;

@SpringBootTest
@Log4j2
public class TodoRepositoryTests {

    @Autowired
    private TodoRepository todoRepository;

    @Test
    public void test1() {

        Assertions.assertNotNull(todoRepository);
        log.info(todoRepository.getClass().getName());

    }

    @Test
    public void testInsert() {

        Todo todo = Todo.builder()
                .title("Ttile")
                .content("Content...")
                .dueDate(LocalDate.of(2024,2,4))
                .build();

        Todo result = todoRepository.save(todo);
        log.info(result);

    }

    @Test
    public void testRead() {

        Long tno = 1L;

        Optional<Todo> result = todoRepository.findById(tno);

        Todo todo = result.orElseThrow();
        log.info(todo);

    }

    @Test
    public void testUpdate() {

        //가져오기
        Long tno = 1L;
        Optional<Todo> result = todoRepository.findById(tno);
        Todo todo = result.orElseThrow();

        //업데이트
        todo.changeTitle("update title");
        todo.changeContent("update content");
        todo.changeComplete(true);

        todoRepository.save(todo);

    }

}
