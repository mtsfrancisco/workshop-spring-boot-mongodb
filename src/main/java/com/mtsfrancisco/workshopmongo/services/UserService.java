package com.mtsfrancisco.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mtsfrancisco.workshopmongo.domain.User;
import com.mtsfrancisco.workshopmongo.repository.UserRepository;
import com.mtsfrancisco.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repo;
	
	
	public List<User> findAll() {
		return repo.findAll();
	}
	
	public User findById(String id) {
		Optional<User> user = repo.findById(id);
		if (user.isPresent()) {
			User newUser = user.get();
			return newUser;
		} else {
			throw new ObjectNotFoundException("Objeto não encontrado");
		}
		
	}
}
