package com.analysys;
/**
 * 
 * @author jovantomasevic
 *
 */
public class MountainTop {
	
	private String topName;
	private Double height;
	
	public MountainTop(String topName, double height) {
		super();
		this.topName = topName;
		this.height = height;
	}

	public String getTopName() {
		return topName;
	}

	public void setTopName(String topName) {
		this.topName = topName;
	}

	public Double getHeight() {
		return height;
	}

	public void setHeight(Double height) {
		this.height = height;
	}
	
	@Override
	public String toString(){
		return "Mountain Top [topName=" + topName + ", height=" + height + "]";
	}

}
