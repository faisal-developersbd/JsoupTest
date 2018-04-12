/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsouptest;

/**
 *
 * @author faisal-shakiba
 */


import java.awt.Font;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class UriImplements implements Url{
private Document doc=null;
int d=0;

    public UriImplements() {
    }
 public void setDoc(String url)
 {
      try {
         this.doc=doc=(Document) Jsoup.connect(url).get();
     } catch (IOException ex) {
         Logger.getLogger(UriImplements.class.getName()).log(Level.SEVERE, null, ex);
     }
 }
public UriImplements(String url)
{
     try {
         this.doc=(Document) Jsoup.connect(url).get();
     } catch (Exception ex) {
         Logger.getLogger(UriImplements.class.getName()).log(Level.SEVERE, null, ex);
     }
}

    public boolean setDocUrl(String urlstr) {
       try {
         this.doc=(Document) Jsoup.connect(urlstr).get();
         return true;
     } catch (Exception ex) {
         return false;
     }
    }

    @Override
    public String getLinkText() {
         String txt;
         String parseText = null;
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       try{
            String title;
           title = doc.html();
            Font banglaFont=new Font("Vrinda", Font.PLAIN, 16);        
           System.out.println("Title :"+title);
           Elements links;
           //
//
           links = doc.select("*");
           StringBuilder builder=new StringBuilder();
           for(Element link:links)
           { 
             // System.out.println("\nlink :"+link.attr("href"));
               txt=link.text();
               ArrayList<String> wordArray;
              builder.append(link.text()+"\n");
              System.out.println("Text :"+txt);
              // 
              
           }
           parseText=""+builder;
             //String parseTextlink = ""+builderlink;
       }catch(Exception e)
       {
           System.out.println("Error: "+e);
       }
       return parseText;
    }

    @Override
    public boolean setTextFile(String filename,String text) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  boolean flag=false;
        try{
       File file=new File(filename+".txt");
            PrintWriter writer=new PrintWriter(file);
            writer.println(text);
            writer.close();
            flag=true;
   }catch(Exception e)
   {
       System.out.println("Error: "+e);
   }
        return false;
    }

    @Override
    public String displayText(String text) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    System.out.println(text);
    return text;
    }

    @Override
    public String getWords(String filename) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

       StringBuilder builder=new StringBuilder();
       
    Scanner input = null;
    String parseText;
    String f;
    int count=0;
    try {
         boolean flag=false;
        File file=new File(filename+".txt");
        input = new Scanner(file);
    } catch (FileNotFoundException ex) {
        Logger.getLogger(UriImplements.class.getName()).log(Level.SEVERE, null, ex);
    }   // count occurrences
        Map<String, Integer> wordCounts = new TreeMap<String, Integer>();
        while (input.hasNext()) {
            String next = input.next().toLowerCase();
            if (!wordCounts.containsKey(next)) {
                wordCounts.put(next, 1);
            } else {
                wordCounts.put(next, wordCounts.get(next) + 1);
            }
        }
    for (Iterator<String> it = wordCounts.keySet().iterator(); it.hasNext();) {
        String word = it.next();
        
        count = wordCounts.get(word);
        if (count >= 1)
            System.out.println(count + "\t" + word);
         f=(word+"\t"+count+"\n");
         builder.append(f);
    }      
    parseText=""+builder;
         return parseText;
        
    }

    @Override
    public String Link() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   
         String ln;
         String parselink=null;
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       try{
            String title;
           title = doc.html(); 
           System.out.println("Title :"+title);
           Elements links;
           //
           links = doc.select("*");
           StringBuilder builderlink=new StringBuilder();
           for(Element link:links)
           { 
               ln=link.attr("href");
               ArrayList<String> wordArray;
              builderlink.append(ln+"\n");
              System.out.println("links :"+ln);
              //       
           }
           parselink=""+builderlink;
       }catch(Exception e)
       {
           System.out.println("Error: "+e);
       }
       return parselink;
    }   
 
}
