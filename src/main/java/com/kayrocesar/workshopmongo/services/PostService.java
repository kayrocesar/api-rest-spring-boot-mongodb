package com.kayrocesar.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kayrocesar.workshopmongo.domain.Post;
import com.kayrocesar.workshopmongo.repository.PostRepository;
import com.kayrocesar.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class PostService {

	@Autowired
	private PostRepository repo;

	public List<Post> findAll() {
		return repo.findAll();
	}

	public Post findById(String id) {
		Optional<Post> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}


	public List<Post> findByTitle(String text){
		return repo.findByTitleContainingIgnoreCase(text);
	}
}
