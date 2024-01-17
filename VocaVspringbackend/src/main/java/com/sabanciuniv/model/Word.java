package com.sabanciuniv.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;




@Document
public class Word {
		
	@Id private String id;

    private String level;

    private String imagePath;

    private String englishWord;

    private String turkishWord;

    private String spanishWord;

    private String frenchWord;


    public Word(String id, String level,String imagePath,String englishWord,String turkishWord,String spanishWord, String frenchWord) {
        super();
        this.id = id;
        this.level = level;
        this.imagePath = imagePath;
        this.englishWord = englishWord;
        this.turkishWord = turkishWord;
        this.spanishWord = spanishWord;
        this.frenchWord = frenchWord;


    }

    public Word() {
        // TODO Auto-generated constructor stub
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }


    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

   

    public String getEnglishWord() {
		return englishWord;
	}

	public void setEnglishWord(String englishWord) {
		this.englishWord = englishWord;
	}

	public String getTurkishWord() {
        return turkishWord;
    }

    public void setTurkishWord(String turkishWord) {
        this.turkishWord = turkishWord;
    }

    public String getSpanishWord() {
        return spanishWord;
    }

    public void setSpanishWord(String spanishWord) {
        this.spanishWord = spanishWord;
    }

    public String getFrenchWord() {
        return frenchWord;
    }

    public void setFrenchWord(String frenchWord) {
        this.frenchWord = frenchWord;
    }
}


	
	

