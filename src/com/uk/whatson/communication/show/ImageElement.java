package com.uk.whatson.communication.show;

/**
 * @author ths 504, je575
 */
public class ImageElement extends Element {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3380229630963892463L;
	protected String FileLocation;
	protected int StartTime, Duration,xSize,ySize;
	
	public ImageElement(){
		super();
		// File location can be changed..
		FileLocation = "C:\\";
		// size in pixels
		xSize = 100;
		ySize = 100;

		// Delays
		StartTime = 0;
		Duration = 0;
	}

	public String getFileLocation() {
		return FileLocation;
	}

	public void setFileLocation(String fileLocation) {
		FileLocation = fileLocation;
	}

	public int getXSize() {
		return xSize;
	}

	public void setXSize(int XSize) {
		xSize = XSize;
	}
	public int getYSize() {
		return ySize;
	}

	public void setYSize(int YSize) {
		ySize = YSize;
	}

	public int getStartTime() {
		return StartTime;
	}

	public void setStartTime(int startTime) {
		StartTime = startTime;
	}

	public int getDuration() {
		return Duration;
	}

	public void setDuration(int duration) {
		Duration = duration;
	}
	
}
