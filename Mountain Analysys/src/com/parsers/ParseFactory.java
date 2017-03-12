package com.parsers;
/**
 * 
 * @author jovantomasevic
 *
 */
public class ParseFactory {
	
	private static ParseFactory instance;
	
	private ParseFactory(){
		
	}
	
	static {
		instance = new ParseFactory();
	}
	
	public static ParseFactory getInstance() {
		return instance;
	}
	
	public static FileParser getParser(String extension) {
		
		if(extension.equals("csv")) {
			return new CsvParser();
		}
		if(extension.equals("properties")) {
			return new PropertiesParser();
		}
		
		return null;
		
	}
	
}
