package ru.nshpakov.rest_api_tutorial.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "user")
//Размечаем таблицу в бд (креды бд в пропертях)
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String username;
    private String password;

    public List<TodoEntity> getLstTodo() {
        return lstTodo;
    }

    public void setLstTodo(List<TodoEntity> lstTodo) {
        this.lstTodo = lstTodo;
    }

    @OneToMany(cascade = CascadeType.ALL,mappedBy ="user")
    private List<TodoEntity> lstTodo;

    public UserEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
