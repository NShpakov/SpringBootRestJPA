package ru.nshpakov.rest_api_tutorial.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.nshpakov.rest_api_tutorial.entity.UserEntity;
import ru.nshpakov.rest_api_tutorial.exceptions.UserAlreadyExistException;
import ru.nshpakov.rest_api_tutorial.exceptions.UserNotFoundException;
import ru.nshpakov.rest_api_tutorial.repository.UserRepo;
import ru.nshpakov.rest_api_tutorial.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity registration(@RequestBody UserEntity user) {
        try {
            userService.registration(user);
            return ResponseEntity.ok("Польхователь усппешно сохранен");
        } catch (UserAlreadyExistException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка !!!");
        }
    }

    @GetMapping
    public ResponseEntity getUser(@RequestParam Long id) {
        try {
            return ResponseEntity.ok(userService.getOne(id));
        } catch (UserNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());

        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка !");

        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteUser(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(userService.delete(id));

        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка !");

        }
    }
}