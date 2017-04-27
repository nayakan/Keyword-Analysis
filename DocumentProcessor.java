/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package keyworddensity;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import org.jsoup.nodes.Document;

/**
 *
 * @author Akshatha
 */
public class DocumentProcessor {
    private static HashSet<String> stopwordsSet = new HashSet<>();
    
    static {
        Scanner sc = new Scanner(DocumentProcessor.class.getResourceAsStream("StopWords.txt"));
        while(sc.hasNext()) {
            stopwordsSet.add(sc.next());
        }
        sc.close();
    }
    
    public List<String> process(Document document) throws FileNotFoundException {
        List<String> wordList = new ArrayList<>();
        Scanner sc = new Scanner(document.text());
        while(sc.hasNext()) {
            String word = removeSpecialCharacters(sc.next());
            if(!isStopWord(word)) {
                if(isCandidateWord(word)) 
                    wordList.add(word);
            }
        }
        return wordList;
    }
    
    private boolean isStopWord(String word) {
       return stopwordsSet.contains(word.toLowerCase());
    }
    
    private boolean isCandidateWord(String word) {
        return !word.matches("^\\d+$");
    }
    
    private String removeSpecialCharacters(String str) {
        return str.trim().replaceAll("[\\*\\=\\!\\|\\[\\]\\+\\$\\s*\\?:,.;<>%\"'/)(]", "");
    }
}
