package ru.nshpakov.rest_api_tutorial.repository;

import org.springframework.data.repository.CrudRepository;
import ru.nshpakov.rest_api_tutorial.entity.UserEntity;
//Слой абстракции работает только с бд
public interface UserRepo extends CrudRepository<UserEntity, Long> {
    UserEntity findByUsername(String username);
}