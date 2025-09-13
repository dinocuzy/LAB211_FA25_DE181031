/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package week1;

import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author ASUS
 */
public class LetterAndCharacterCount {

    private String content;

    public LetterAndCharacterCount() {
    }

    public LetterAndCharacterCount(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public HashMap<String, Integer> countWords() {
        HashMap<String, Integer> wordCount = new HashMap<>();
        String[] words = content.split(" ");
        for (String word : words) {
            if (!word.isEmpty()) {
                word = word.toLowerCase();
                wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
            }
        }
        return wordCount;
    }
    public HashMap<Character, Integer> countChars(){
        HashMap<Character, Integer> charCount = new HashMap<>();
        for (char c : content.toLowerCase().toCharArray()) {
            if (c != ' ') {
                charCount.put(c, charCount.getOrDefault(c, 0) + 1);
            }
        }
        return charCount;
    }

    
}
