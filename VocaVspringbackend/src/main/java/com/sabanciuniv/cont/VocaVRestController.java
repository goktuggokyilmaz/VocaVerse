package com.sabanciuniv.cont;
import java.util.List;



//need to delete all of these imports 
import org.springframework.web.bind.annotation.RestController;

import com.sabanciuniv.cont.VocaVRestController;
//import com.sabanciuniv.model.Author;
//import com.sabanciuniv.model.Book;
//import com.sabanciuniv.model.Publisher;
//import com.sabanciuniv.model.Author;
//import com.sabanciuniv.model.Book;
//import com.sabanciuniv.model.BookPayload;
import com.sabanciuniv.model.User;
import com.sabanciuniv.model.Word;
import com.sabanciuniv.repo.UserRepository;
import com.sabanciuniv.repo.WordRepository;

import jakarta.annotation.PostConstruct;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;



@RestController
@RequestMapping("/vocaverse")

public class VocaVRestController {

	@Autowired private UserRepository UserRepository;
	@Autowired private WordRepository WordRepository;
	
	private static final Logger logger = LoggerFactory.getLogger(VocaVRestController.class);
	
	@PostConstruct
	public void init() {
		
		if(UserRepository.count() ==0) {
			logger.info("Database is empty, initializing..");
			
			//save users from here
			
			
			
			User u1 = new User("Yagmur", "11", "eight", "Spanish", "French");
			User u2 = new User("Goktug", "10", "nine", "Turkish", "Spanish");
			User u3 = new User("Osman", "7", "ten", "English", "Turkish");
			User u4 = new User("Julia", "11", "one", "English", "Spanish");
			User u5 = new User("Messi", "8", "two", "Spanish", "Turkish");
			User u6 = new User("Taylor", "7", "three", "English", "French");
			User u7 = new User("Arda", "6", "four", "Turkish", "French");
			User u8 = new User("Sergio", "5", "five", "Spanish", "English");
			User u9 = new User("Khris", "5", "six", "French", "Turkish");
			User u10 = new User("Nazli", "10", "seven", "Turkish", "English");
			
			//need to add imagepath
			Word w1 = new Word("1", "Beginner", "https://dxcgs7v732qty.cloudfront.net/kopekler.jpg", "Dog", "Kopek", "Perro", "Chien");
			Word w2 = new Word("2", "Beginner", "https://ideacdn.net/shop/bm/44/myassets/blogs/kediszroulari.png?revision=1666793247", "Cat", "Kedi", "Gato", "Chat");
			Word w3 = new Word("3", "Beginner", "https://wp.oggusto.com/wp-content/uploads/2021/11/kus-bakimi.jpg", "Bird", "Kus", "Pajaro", "Oiseau");
			Word w4 = new Word("4", "Beginner", "https://cdn.yemek.com/mncrop/620/388/uploads/2014/11/hangi-balik-kac-santimetre.jpg", "Fish", "Balik", "Pez", "Poisson");
			Word w5 = new Word("5", "Beginner", "https://drahmetakcay.com/wp-content/uploads/2021/12/At-Alerjisi.jpg", "Horse", "At", "Caballo", "Cheval");
			Word w6 = new Word("6", "Beginner", "https://azinlikca1.net/wp-content/uploads/2017/04/inek-sut-meadow-1728908_1280-1140x694.jpeg", "Cow", "Inek", "Vaca", "Vache");
			Word w7 = new Word("7", "Beginner", "https://www.camli.com.tr/upload/merak-ettikleriniz/koyun_beslemesinde_onemli_donemler_konulu_e_bulten_gorseli_main.jpg", "Sheep", "Koyun", "Oveja", "Mouton");
			Word w8 = new Word("8", "Beginner", "https://popsci.com.tr/wp-content/uploads/2021/03/iStock-467227905.jpg", "Chicken", "Tavuk", "Pollo", "Poulet");
			Word w9 = new Word("9", "Beginner", "https://cdn1.img.sputniknews.com.tr/img/103464/98/1034649899_0:0:981:551_1920x0_80_0_0_385536b3ce3b02301b4a7f9b696f5b58.jpg", "Pig", "Domuz", "Cerdo", "Cochon");
			Word w10 = new Word("10", "Beginner", "https://kucukcekmece.istanbul/Content/piclib/bigsize/icerikler/31128/dsc-6151-58449-9301503.jpg", "Rabbit", "Tavsan", "Conejo", "Lapin");
			
			
			WordRepository.save(w1);
			WordRepository.save(w2);
			WordRepository.save(w3);
			WordRepository.save(w4);
			WordRepository.save(w5);
			WordRepository.save(w6);
			WordRepository.save(w7);
			WordRepository.save(w8);
			WordRepository.save(w9);
			WordRepository.save(w10);
			
			UserRepository.save(u1);
			UserRepository.save(u2);
			UserRepository.save(u3);
			UserRepository.save(u4);
			UserRepository.save(u5);
			UserRepository.save(u6);
			UserRepository.save(u7);
			UserRepository.save(u8);
			UserRepository.save(u9);
			UserRepository.save(u10);
			
		
			
			logger.info("All sample data saved!");
			
			

		}
		
	}
	
	
	
	@GetMapping("/users")
	public List<User> users(){
		
		return UserRepository.findAll();
	}
	
	@PostMapping("/users/save")
	public User saveUser(@RequestBody User user) {
		
		User userSaved = UserRepository.save(user);
		return userSaved;
	}
	

	@PostMapping("/users/search")
	public List<User> searchUser(@RequestBody User user){
		
		List<User> users = UserRepository.findByNativeLang(user.getNativeLang());
		
		return users;
	}
	
	
	@GetMapping("/words")
	public List<Word> words(){
		
		return WordRepository.findAll();
		
	}
	
	@GetMapping("/words/id/{wrdid}")
	public ResponseEntity<Word> getDataById(@PathVariable("wrdid") String wordId){
		java.util.Optional<Word> optionalWord = WordRepository.findById(wordId);
		
		if(optionalWord.isPresent()) {
			return ResponseEntity.ok(optionalWord.get());
			
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PostMapping("/words/save")
	public Word saveWords(@RequestBody Word word) {
		
		Word wordSaved = WordRepository.save(word);
		return wordSaved;
	}
	
	
	
	@PostMapping("/words/search")
	public List<Word> searchWord(@RequestBody Word word){
		
		List<Word> words = WordRepository.findByLevel(word.getLevel());
		
		return words;
	}
	
	
	
}
