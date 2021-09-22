package com.dogoo.training.service;

import com.dogoo.training.entity.TodoEntity;
import com.dogoo.training.mapper.TodoMapper;
import com.dogoo.training.model.TodoList;
import com.dogoo.training.model.TodoReq;
import com.dogoo.training.model.TodoRes;
import com.dogoo.training.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {
    private final TodoMapper mapper;
    private final TodoRepository repo;

    @Autowired
    public TodoService(TodoMapper mapper,
                       TodoRepository repo) {
        this.mapper = mapper;
        this.repo = repo;
    }

    public TodoRes addTodo(TodoReq todoReq) {
        TodoEntity entity = mapper.mapTodoEntityFromTodoReq(todoReq);

        TodoEntity saved = repo.save(entity);

        return mapper.mapTodoResFromTodoEntity(saved);
    }

    public TodoRes updateTodo(String id, TodoReq todoReq) {
        TodoEntity entity = mapper.mapTodoEntityFromTodoReq(id, todoReq);

        TodoEntity saved = repo.save(entity);

        return mapper.mapTodoResFromTodoEntity(saved);
    }


    public TodoList getAllTodo() {

        TodoList ls = mapper.mapTodoListFromTodoEntities(repo.findAll());

        return ls;
    }

    public void removeTodo(String todoId) {
        TodoEntity entity = repo.getOne(todoId);

        repo.delete(entity);
    }


}
