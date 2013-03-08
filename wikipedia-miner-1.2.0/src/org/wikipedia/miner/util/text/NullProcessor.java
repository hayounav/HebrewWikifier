package org.wikipedia.miner.util.text;

public class NullProcessor extends TextProcessor {
	
	@Override
	public String processText(String text) {
		return text;
	}

}
