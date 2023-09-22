package com.kayrocesar.workshopmongo.config;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.kayrocesar.workshopmongo.domain.Post;
import com.kayrocesar.workshopmongo.domain.User;
import com.kayrocesar.workshopmongo.repository.PostRepository;
import com.kayrocesar.workshopmongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		userRepository.deleteAll();
		postRepository.deleteAll();
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
	
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		
		
		Post p1 = new Post(null, sdf.parse("21/03/2018") , "Partiu viagem", "Vou viajar para São Paulo. Abraços!",maria);
		Post p2 = new Post(null, sdf.parse("23/03/2018") , "Bom dia", "Acordei feliz hoje!",maria);
		
		
		
		userRepository.saveAll(Arrays.asList(maria,alex,bob));
		postRepository.saveAll(Arrays.asList(p1,p2));
		
	}

}
