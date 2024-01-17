package com.sabanciuniv.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.sabanciuniv.model.User;



public interface UserRepository extends MongoRepository<User, String>{


	public List<User> findByAgeGreaterThan(String age);
	public List<User> findByAgeLessThan(String age);
	public User findByName(String name);
	public List<User> findByNativeLang(String NativeLang);
	public List<User> findByDesiredLang(String DesiredLang);
	
	
	
}
