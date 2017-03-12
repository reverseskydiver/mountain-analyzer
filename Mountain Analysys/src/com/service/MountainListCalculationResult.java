package com.service;

import com.analysys.Mountain;

/**
 * 
 * @author jovantomasevic
 *
 */
public class MountainListCalculationResult {
	
	private Mountain mountainWithHighestTop;
	private Mountain mountainWithMostTops;
	private Mountain mountainWithHighestAverageTopHeight;
	
	public Mountain getMountainWithHighestTop() {
		return mountainWithHighestTop;
	}
	public void setMountainWithHighestTop(Mountain mountainWithHighestTop) {
		this.mountainWithHighestTop = mountainWithHighestTop;
	}
	public Mountain getMountainWithMostTops() {
		return mountainWithMostTops;
	}
	public void setMountainWithMostTops(Mountain mountainWithMostTops) {
		this.mountainWithMostTops = mountainWithMostTops;
	}
	public Mountain getMountainWithHighestAverageTopHeight() {
		return mountainWithHighestAverageTopHeight;
	}
	public void setMountainWithHighestAverageTopHeight(Mountain mountainWithHighestAverageTopHeight) {
		this.mountainWithHighestAverageTopHeight = mountainWithHighestAverageTopHeight;
	}
	
	@Override
	public String toString() {
		return "MountainListCalculationResult [mountainWithHighestTop=" + mountainWithHighestTop
				+ ", mountainWithMostTops=" + mountainWithMostTops + ", mountainWithHighestAverageTopHeight="
				+ mountainWithHighestAverageTopHeight + "]";
	}
}
