package com.dogoo.training.mapper;

import com.dogoo.training.entity.TodoEntity;
import com.dogoo.training.model.TodoList;
import com.dogoo.training.model.TodoReq;
import com.dogoo.training.model.TodoRes;
import com.dogoo.training.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TodoMapper {

    private final TodoRepository repo;

    @Autowired
    public TodoMapper(TodoRepository repo) {
        this.repo = repo;
    }

    public TodoRes mapTodoResFromTodoEntity(TodoEntity from) {
        TodoRes to = new TodoRes();

        to.setId(from.getId());
        to.setTitle(from.getTitle());
        to.setCompleted(from.isSelected());

        return to;
    }

    public TodoList mapTodoListFromTodoEntities(List<TodoEntity> from) {
        TodoList to = new TodoList();

        from.stream().forEach(todo -> {
            to.add(mapTodoResFromTodoEntity(todo));
        });

        return to;
    }

    public TodoEntity mapTodoEntityFromTodoReq(TodoReq from) {
        TodoEntity to = new TodoEntity();

        to.setId(UUID.randomUUID().toString());
        to.setTitle(from.getTitle());
        to.setSelected(false);

        return to;
    }
    public TodoEntity mapTodoEntityFromTodoReq(String id, TodoReq from) {
        TodoEntity to = repo.getOne(id);

        to.setSelected(from.isCompleted());

        return to;
    }
}
