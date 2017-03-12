package com.parsers;

import java.io.File;
/**
 * 
 * @author jovantomasevic
 *
 */
public interface FileParser {
	ParseResult parse(File f);
}
