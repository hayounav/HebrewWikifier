package org.wikipedia.miner.demo;

import java.io.File;

import org.wikipedia.miner.db.WEnvironment;
import org.wikipedia.miner.util.WikipediaConfiguration;
import org.wikipedia.miner.util.text.HebrewLemmatizer;

public class Lemmatize {
	
public static void main(String args[]) throws Exception {
                
        HebrewLemmatizer folder = new HebrewLemmatizer() ;
                
        WikipediaConfiguration conf = new WikipediaConfiguration(new File(args[0])) ;
        WEnvironment.prepareTextProcessor(folder, conf, new File("tmp"), true, 5) ;
                
    }
}