package com.service;

import com.analysys.MountainTop;

/**
 * 
 * @author jovantomasevic
 *
 */
public class MountainCalculationResult {
	
	private int numOfTops;
	private double averageTopHeight;
	private MountainTop highest;
	private MountainTop lowest;
	
	public int getNumOfTops() {
		return numOfTops;
	}
	public void setNumOfTops(int numOfTops) {
		this.numOfTops = numOfTops;
	}
	public double getAverageTopHeight() {
		return averageTopHeight;
	}
	public void setAverageTopHeight(double averageTopHeight) {
		this.averageTopHeight = averageTopHeight;
	}
	public MountainTop getHighest() {
		return highest;
	}
	public void setHighest(MountainTop highest) {
		this.highest = highest;
	}
	public MountainTop getLowest() {
		return lowest;
	}
	public void setLowest(MountainTop lowest) {
		this.lowest = lowest;
	}
	
	@Override
	public String toString(){
		return "MountainCalculationResult [numOfTops=" + numOfTops + ", averageTopHeight=" + averageTopHeight
				+ ", highest=" + highest + ", lowest=" + lowest + "]";
	}
	
}
