package ru.nshpakov.rest_api_tutorial.model;

import ru.nshpakov.rest_api_tutorial.entity.UserEntity;

import java.util.List;
import java.util.stream.Collectors;

public class User {

    private Long id;
    private String userName;

    public List<Todo> getLstTodos() {
        return lstTodos;
    }

    public void setLstTodos(List<Todo> lstTodos) {
        this.lstTodos = lstTodos;
    }

    private List<Todo> lstTodos;

    public static User toModel(UserEntity entity) {
        User model = new User();
        model.setId(entity.getId());
        model.setUserName(entity.getUsername());
        model.setLstTodos(entity.getLstTodo().stream().map(Todo::toModel).collect(Collectors.toList()));
        return model;
    }

    public User() {

    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Long getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }
}