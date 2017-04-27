/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package keyworddensity;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

/**
 *
 * @author Akshatha
 */
public class ConnectURL {
    private URL aUrl;
    
    public ConnectURL(String webUrl) {
       try {
            aUrl = new URL(webUrl);
        } catch(MalformedURLException e){
            System.out.println("Provided url is incorrect");
        } 
    }
    
    public Document getDocument() {
        Document doc = null;
        try {
            doc = Jsoup.connect(aUrl.toString()).get();
        } catch(IOException e) {
            System.out.println("Failed to retrieve document from the given url");
        }
        return doc;
    }
}
