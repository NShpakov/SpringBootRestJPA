package ru.nshpakov.rest_api_tutorial.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.nshpakov.rest_api_tutorial.entity.UserEntity;
import ru.nshpakov.rest_api_tutorial.exceptions.UserAlreadyExistException;
import ru.nshpakov.rest_api_tutorial.exceptions.UserNotFoundException;
import ru.nshpakov.rest_api_tutorial.model.User;
import ru.nshpakov.rest_api_tutorial.repository.UserRepo;

@Service
public class UserService {
	@Autowired
	private UserRepo userRepo;

	public UserEntity registration(UserEntity user) throws UserAlreadyExistException {
		if (userRepo.findByUsername(user.getUsername()) != null) {

			throw new UserAlreadyExistException("Пользователь с таким именем уже существует !!!");
		}
		return userRepo.save(user);
	}

	public User getOne(Long id) throws UserNotFoundException {
		UserEntity user = userRepo.findById(id).get();
		if (user == null) {
			throw new UserNotFoundException("Пользователь не найден");
		}
		return User.toModel(user);
	}

	public Long delete(Long id) {
		userRepo.deleteById(id);
		return id;
	}
}
