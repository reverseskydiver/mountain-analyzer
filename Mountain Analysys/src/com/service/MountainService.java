package com.service;

import java.util.List;

import com.analysys.Mountain;
import com.analysys.MountainTop;

/**
 * 
 * @author jovantomasevic
 *
 */
public class MountainService {
	
	public MountainListCalculationResult calculateMountains(List<Mountain> mountains) {
		
		for(Mountain m : mountains) {
			
			MountainCalculationResult calculationResult = m.getCalculationResult();
			
			int numOfTops = m.getTops().size();
			double averageHeight = 0;
			MountainTop highest = null;
			MountainTop lowest = null;
			
			for(MountainTop top : m.getTops()) {
				
				averageHeight = averageHeight + top.getHeight();
				
				if(highest == null || top.getHeight() > highest.getHeight()) {
					highest = top;
				}
				
				if(lowest == null || top.getHeight() < lowest.getHeight()) {
					lowest = top;
				}
				
			}
			
			calculationResult.setHighest(highest);
			calculationResult.setLowest(lowest);
			calculationResult.setAverageTopHeight(averageHeight / numOfTops);
			calculationResult.setNumOfTops(numOfTops);
			m.setCalculationResult(calculationResult);
			
		}
		
		MountainListCalculationResult result = new MountainListCalculationResult();
		
		Mountain withHighestTop = null;
		Mountain withMostTop = null;
		Mountain withHighestAverage = null;
		
		for(Mountain m : mountains) {
			if(withHighestTop == null || m.getCalculationResult().getHighest().getHeight() > withHighestTop.getCalculationResult().getHighest().getHeight()) {
				withHighestTop = m;
			}
			if(withMostTop == null || m.getCalculationResult().getNumOfTops() > withMostTop.getCalculationResult().getNumOfTops()) {
				withMostTop = m;
			}
			if(withHighestAverage == null || m.getCalculationResult().getAverageTopHeight() > withHighestAverage.getCalculationResult().getAverageTopHeight()) {
				withHighestAverage = m;
			}
		}
		
		result.setMountainWithHighestTop(withHighestTop);
		result.setMountainWithMostTops(withMostTop);
		result.setMountainWithHighestAverageTopHeight(withHighestAverage);
		
		return result;
	}
	
}
