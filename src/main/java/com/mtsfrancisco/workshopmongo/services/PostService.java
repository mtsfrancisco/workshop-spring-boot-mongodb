package com.mtsfrancisco.workshopmongo.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mtsfrancisco.workshopmongo.domain.Post;
import com.mtsfrancisco.workshopmongo.repository.PostRepository;
import com.mtsfrancisco.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class PostService {
	
	@Autowired
	private PostRepository repo;
	
	
	public Post findById(String id) {
		Optional<Post> user = repo.findById(id);
		if (user.isPresent()) {
			Post newUser = user.get();
			return newUser;
		} else {
			throw new ObjectNotFoundException("Objeto não encontrado");
		}
	}
	
	public List<Post> findByTitle (String text) {
		return repo.searchByTitle(text);
	}
	
	public List<Post> fullSearch( String text, Date minDate, Date maxDate) {
		maxDate = new Date(maxDate.getTime() + 24 * 60 * 60 * 1000);
		return repo.fullSearch(text, minDate, maxDate);
		
	}
	
}
