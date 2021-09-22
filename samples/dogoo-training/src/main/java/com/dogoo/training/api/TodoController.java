package com.dogoo.training.api;

import com.dogoo.training.model.TodoList;
import com.dogoo.training.model.TodoReq;
import com.dogoo.training.model.TodoRes;
import com.dogoo.training.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/training/backend/v1")
public class TodoController {

    private final TodoService service;

    @Autowired
    public TodoController(TodoService service) {
        this.service = service;
    }

    @RequestMapping(value = "/todos",
            produces = { "application/json" },
            method = RequestMethod.GET)
    public ResponseEntity<TodoList> getAllTodos() {

        TodoList response = service.getAllTodo();

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @RequestMapping(value = "/todos",
            produces = { "application/json" },
            consumes = { "application/json" },
            method = RequestMethod.POST)
    public ResponseEntity<TodoRes> addTodo(@RequestBody TodoReq todoReq) {

        TodoRes response = service.addTodo(todoReq);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @RequestMapping(value = "/todos/{id}",
            produces = { "application/json" },
            method = RequestMethod.DELETE)
    public ResponseEntity<TodoRes> delTodo(@PathVariable("id") String id) {

        service.removeTodo(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/todos/{id}",
            produces = { "application/json" },
            method = RequestMethod.PATCH)
    public ResponseEntity<TodoRes> pathTodo(@PathVariable("id") String id, @RequestBody TodoReq todoReq) {

        service.updateTodo(id, todoReq);

        return new ResponseEntity<>(HttpStatus.OK);
    }


}
