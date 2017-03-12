package com.analysys;

import java.util.ArrayList;
import java.util.List;

import com.service.MountainCalculationResult;

/**
 * 
 * @author jovantomasevic
 *
 */
public class Mountain {

	private String mountainName;
	private List<MountainTop> tops;
	private MountainCalculationResult calculationResult;
	
	public Mountain(String mountainName) {
		super();
		this.mountainName = mountainName;
		this.tops = new ArrayList<>();
		this.calculationResult = new MountainCalculationResult();
	}
	
	public Mountain(){
		
	}
	
	public String getMountainName() {
		return mountainName;
	}

	public void setMountainName(String mountainName) {
		this.mountainName = mountainName;
	}

	public List<MountainTop> getTops() {
		return tops;
	}

	public void setTops(List<MountainTop> tops) {
		this.tops = tops;
	}

	public MountainCalculationResult getCalculationResult() {
		return calculationResult;
	}

	public void setCalculationResult(MountainCalculationResult calculationResult) {
		this.calculationResult = calculationResult;
	}
	
	@Override
	public String toString(){
		return "Mountain [mountainName=" + mountainName + ", tops=" + tops + ", calculationResult=" + calculationResult
				+ "]";
	}
	
}
