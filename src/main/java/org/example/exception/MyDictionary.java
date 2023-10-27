package org.example.exception;

import java.util.HashMap;
import java.util.Map;

public class MyDictionary {

	private final Map<String, String> wordMap;

	public MyDictionary() {
		wordMap = new HashMap<>();
	}

	public void add(String word, String meaning) {
		wordMap.put(word, meaning);
	}

	public String getMeaning(String word) {
		return wordMap.get(word);
	}
}
