package org.wikipedia.miner.demo;

import java.io.File;

import org.wikipedia.miner.db.WEnvironment;
import org.wikipedia.miner.util.WikipediaConfiguration;
import org.wikipedia.miner.util.text.TextProcessor;
import org.wikipedia.miner.util.text.NullProcessor;

public class Lemmatize {
	
public static void main(String args[]) throws Exception {
                
        TextProcessor folder = new NullProcessor() ;
                
        WikipediaConfiguration conf = new WikipediaConfiguration(new File(args[0])) ;
        WEnvironment.prepareTextProcessor(folder, conf, new File("tmp"), true, 5) ;
                
    }
}
