package com.parsers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.analysys.Mountain;
/**
 * 
 * @author jovantomasevic
 *
 */
public class ParseResult {
	
	private List<Mountain> mountains = new ArrayList<>();
	
	public void addMountain(Mountain m) {
		mountains.add(m);
	}
	
	public List<Mountain> getMountains() {
		return Collections.unmodifiableList(mountains);
	}
	
	@Override
	public String toString() {
		return "ParseResult [mountains=" + mountains + "]";
	}
}
