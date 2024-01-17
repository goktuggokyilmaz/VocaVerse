package com.sabanciuniv.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

//import com.sabanciuniv.model.User;
import com.sabanciuniv.model.Word;

public interface WordRepository extends MongoRepository<Word, String>{


	public List<Word> findByLevel(String level);
	public Word findByimagePath(String imagePath);
	public Word findByid(String id);
	public Word findByenglishWord(String englishWord);
	public Word findByturkishWord(String turkishWord);
	public Word findByspanishWord(String spanishWord);
	public Word findByfrenchWord(String frenchWord);
	
	
	
}
