package com.test.rest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class DataAccesor {

	TrieDataStructure trie;
	
	public DataAccesor() {
		trie = new TrieDataStructure();
		populateTrie();
		
		
	}
	
	
	@SuppressWarnings("resource")
	private void populateTrie(){
		
		
		File f = new File("dict.txt");
		
		FileInputStream fin;
		try {
			fin = new FileInputStream(f);

			Scanner sc  = new Scanner(fin);
			
			while (sc.hasNext()) {
				
				trie.put(sc.nextLine());
				
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			trie.put("abysmal");
			trie.put("amicable");
			trie.put("abayence");
			trie.put("abode");
		}
		
	}
	
	public List<String> keysThatMatch(String prefix){
		
		return trie.keysWithPrefix(prefix);
		
	}
	
}
