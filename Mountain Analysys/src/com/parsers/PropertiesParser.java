package com.parsers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

import com.analysys.Mountain;
import com.analysys.MountainTop;

import java.util.Properties;
import java.util.Set;

/**
 * 
 * @author jovantomasevic
 *
 */
public class PropertiesParser implements FileParser {

	@Override
	public ParseResult parse(File f) {
		
		Properties props = new Properties();
		ParseResult result = new ParseResult();
		
		try(InputStream input = new FileInputStream(f)) {
			
			props.load(input);
			
			Set<Entry<Object,Object>> entrySet = props.entrySet();
			
			List<Mountain> parsed = new ArrayList<>();
			
			for (Entry<Object, Object> e : entrySet) {
				
				String key = (String) e.getKey();
				String[] split = key.split("\\.");
				String mountainName = split[0];
				String topName = split[1];
				
				Mountain m = getMountainFromListByName(parsed, mountainName);
				
				if(m == null) {
					m = new Mountain(mountainName);
					parsed.add(m);
				}
				
				Double value = Double.valueOf((String) e.getValue());
				m.getTops().add(new MountainTop(topName, value));
			}
			
			for(Mountain m : parsed) {
				result.addMountain(m);
			}
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	private Mountain getMountainFromListByName(List<Mountain> parsed, String mountainName) {
		for(Mountain m : parsed) {
			if(m.getMountainName().equals(mountainName)) {
				return m;
			}
		}
		return null;
	}

}
