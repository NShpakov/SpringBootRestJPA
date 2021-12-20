package ru.nshpakov.rest_api_tutorial.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.nshpakov.rest_api_tutorial.entity.TodoEntity;
import ru.nshpakov.rest_api_tutorial.entity.UserEntity;
import ru.nshpakov.rest_api_tutorial.model.Todo;
import ru.nshpakov.rest_api_tutorial.repository.TodoRepo;
import ru.nshpakov.rest_api_tutorial.repository.UserRepo;

@Service
public class TodoService {
    @Autowired
    private TodoRepo todoRepo;
    @Autowired
    private UserRepo userRepo;

    public Todo createTodo(TodoEntity todo, Long userId) {
        //Ищем пользователя по id
        UserEntity user = userRepo.findById(userId).get();
        todo.setUser(user);
        return Todo.toModel(todoRepo.save(todo));
    }

    public Todo completeTodo(Long id) {
        TodoEntity todo = todoRepo.findById(id).get();
        todo.setCompleted(!todo.getCompleted());
        return Todo.toModel(todoRepo.save(todo));
    }
}
