/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsouptest;
import java.util.Map;
import org.jsoup.nodes.Document;

/**
 *
 * @author faisal-shakiba
 */
public interface Url {
    
    public String getLinkText();
    public String Link();
    public boolean setTextFile(String filename,String text);
    public String displayText(String text);
    public String getWords(String filename);
    public boolean setDocUrl(String urlstr);
    
}
