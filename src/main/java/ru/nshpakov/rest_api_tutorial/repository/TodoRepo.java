package ru.nshpakov.rest_api_tutorial.repository;

import org.springframework.data.repository.CrudRepository;
import ru.nshpakov.rest_api_tutorial.entity.TodoEntity;

public interface TodoRepo extends CrudRepository<TodoEntity,Long> {
}