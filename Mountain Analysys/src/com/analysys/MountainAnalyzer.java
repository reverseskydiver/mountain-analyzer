package com.analysys;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import org.apache.commons.io.FilenameUtils;

import com.parsers.FileParser;
import com.parsers.ParseFactory;
import com.parsers.ParseResult;
import com.service.MountainListCalculationResult;
import com.service.MountainService;

/**
 * 
 * @author jovantomasevic
 *
 */
public class MountainAnalyzer {
	
	private static MountainAnalyzer instance;
	
	private MountainAnalyzer(){
		
	}
	
	static {
		instance = new MountainAnalyzer();
	}
	
	public static MountainAnalyzer getInstance(){
		return instance;
	}
	
	public void analyze(List<File> inputFiles, OutputStream report) {
		
		for(File file : inputFiles) {
			
			String extension = FilenameUtils.getExtension(file.getAbsolutePath());
			FileParser parser = ParseFactory.getParser(extension);
			
			// Can't use try-with-resources 'cause ParseResult can't implement AutoCloseable interface
			
			try {
				
				ParseResult result = parser.parse(file);
				
				MountainService service = new MountainService();
				MountainListCalculationResult calculateMountainsResult = service.calculateMountains(result.getMountains());
				
				writeParseResult(result.getMountains(), calculateMountainsResult, report);
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	private void writeParseResult(List<Mountain> mountains, MountainListCalculationResult calculateMountainsResult,
			OutputStream report) {
			
		// Building HTML file
		StringBuilder sb = new StringBuilder();
		
		sb.append("<html>"
				+ "<body>"
				+ "<table>"
				+ "<tr>"
				+ "<th>Ime Planine</th><th>Ukupan broj Vrhova</th><th>Prosecna visina vrhova</th><th>Najnizi vrh i visina</th><th>Najvisi vrh i visina</th>"
				+ "</tr>");
		
		for(Mountain m : mountains) {
			sb.append("<tr>"
					+ "<td>" + m.getMountainName() + "</td>"
					+ "<td>" + m.getCalculationResult().getNumOfTops() + "</td>"
					+ "<td>" + m.getCalculationResult().getAverageTopHeight() + "m" + "</td>"
					+ "<td>" + m.getCalculationResult().getLowest().getTopName() + " " + m.getCalculationResult().getLowest().getHeight() + "m" + "</td>"
					+ "<td>" + m.getCalculationResult().getHighest().getTopName() + " " + m.getCalculationResult().getHighest().getHeight() + "m" + "</td>"
					+ "</tr>");
		}
		sb.append("</table>");
		sb.append("<hr>");
		sb.append("<p>"
				+ "Planina sa najvisim vrhom: " + calculateMountainsResult.getMountainWithHighestTop().getMountainName() + "</br>"
				+ "Planina sa najvise vrhova: " + calculateMountainsResult.getMountainWithMostTops().getMountainName() + "</br>"
				+ "Planina sa najvecom prosecnom visinom vrhova " + calculateMountainsResult.getMountainWithHighestAverageTopHeight().getMountainName() + "</br>"
				+ "</p>");
		sb.append("</body>"
				+ "</html>");
		
		// Writing to stream
		try(OutputStream output = report) {
			byte[] bytesArray = sb.toString().getBytes();
			output.write(bytesArray);
			output.flush();			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
