/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package keyworddensity;

import java.io.IOException;
import org.jsoup.nodes.Document;

/**
 *
 * @author Akshatha
 */
public class Main {
   
    
    public static void main(String[] args) throws IOException{
        /*if(args.length <= 0)
            throw new IOException("Url missing.Please provide a url.");
        
        String webUrl = args[0];*/
        String webUrl = 
        "http://www.amazon.com/Cuisinart-CPT-122-Compact-2-Slice-Toaster/dp/B009GQ034C/ref=sr_1_1?s=kitchen&ie=UTF8&qid=1431620315&sr=1-1&keywords=toaster";
        //String webUrl = "https://www.gutenberg.org/files/15675/15675-h/15675-h.htm";
        
        // Validate the URL
        ConnectURL connectURL = new ConnectURL(webUrl);
        // Retrieve text document from URL
        Document doc = connectURL.getDocument();
        // Preprocess the document by removing stopwords and special characters
        DocumentProcessor docProcessor = new DocumentProcessor();
        // Perform keyword Analysis
        KeywordDensityAnalyzer ng = new KeywordDensityAnalyzer(docProcessor.process(doc));        
        ng.bestMatch();
    }
}
