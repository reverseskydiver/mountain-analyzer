package com.parsers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.analysys.Mountain;
import com.analysys.MountainTop;

/**
 * 
 * @author jovantomasevic
 *
 */
public class CsvParser implements FileParser {

	@Override
	public ParseResult parse(File f) {
		
		String line = "";
		String delimiter = ",";
		
		ParseResult result = new ParseResult();
		
		try(BufferedReader br = new BufferedReader(new FileReader(f))) {
			
			while((line = br.readLine()) != null) {
				
				Mountain m = new Mountain();
				
				String[] mountain = line.split(delimiter);
				
				m.setMountainName(mountain[0]);
				
				List<MountainTop> tops = new ArrayList<>();
				
				for (int i = 1; i < mountain.length; i++) {
					MountainTop top = new MountainTop(mountain[i], Double.valueOf(mountain[i+1]));
					tops.add(top);
					i = i + 1;
				}
				
				m.setTops(tops);
				result.getMountains().add(m);
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return result;
	}

}
