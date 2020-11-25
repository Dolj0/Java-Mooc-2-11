/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dictionary;

import java.io.FileWriter;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author Joel
 */
public class SaveableDictionary {
    private HashMap<String,String> dictionary; 
    private String file;
    
    public SaveableDictionary(){
        this.dictionary = new HashMap<>();
    }
    
    public SaveableDictionary(String file){
        this.dictionary = new HashMap<>();
        this.file = file;
    }
    
    public void add(String word, String translation){
        if (!(dictionary.containsKey(word))){
            dictionary.put(word,translation);
        }
        
        if (!(dictionary.containsKey(translation))){
            dictionary.put(translation,word);
        }
        
    }
    
    public String translate(String word){
        return dictionary.get(word);
    }
    
    public void delete(String word){
        if (dictionary.containsKey(word)){
            String x = dictionary.get(word);
            dictionary.remove(word);
            dictionary.remove(x);
        }
    }
    
    public boolean load(){
        try (Scanner scanner = new Scanner(Paths.get(this.file))){
            while (scanner.hasNextLine()){
                String[] words = scanner.nextLine().split(":");
                this.add(words[0], words[1]);
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    public boolean save(){
        ArrayList<String> usedWords = new ArrayList<>();
        try {
            FileWriter dictionary = new FileWriter(this.file);
            for (String key: this.dictionary.keySet()) {
                String translatedWord = this.dictionary.get(key);
                usedWords.add(translatedWord);
                if (!(usedWords.contains(key))) {
                    dictionary.write(key + ":" + this.dictionary.get(key) + "\n");     
              } 
            }
            dictionary.close();
            return true;
        } catch (Exception e) {
            return false;
        }   
    }
}
