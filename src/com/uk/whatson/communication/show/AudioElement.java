package com.uk.whatson.communication.show;

/**
 * @author ths 504, je575
 */
public class AudioElement extends Element {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3325124958563685241L;
	
	
	protected String FileLocation;
	protected int StartTime, Duration,xSize,ySize;
	protected boolean InLineControl;
	
	public AudioElement(){
		super();
		     //File location can be changed..
				FileLocation = "C:\\";
				             
				xSize = 500;
				ySize = 100;
				
				//time in seconds 
				StartTime = 0;
				Duration = 0;
				
				InLineControl = false;
	}

	public boolean getInLineControl() {
		// TODO Auto-generated method stub
		return false;
	}

	public int getXSize() {
		// TODO Auto-generated method stub
		return xSize;
	}

	public void setXSize(int XSize) {
		xSize = XSize;
	}

	public int getYSize() {
		// TODO Auto-generated method stub
		return ySize;
	}

	public void setYSize(int YSize) {
		ySize = YSize;
	}

	public int getStartTime() {
		// TODO Auto-generated method stub
		return StartTime;
	}

	public void setStartTime(int startTime) {
		StartTime = startTime;
	}

	public int getDuration() {
		// TODO Auto-generated method stub
		return Duration;
	}

	public void setDuration(int duration) {
		Duration = duration;
	}

	public String getFileLocation() {
		// TODO Auto-generated method stub
		return FileLocation;
	}

	public void setFileLocation(String fileLocation) {
		FileLocation = fileLocation;
	}
	
	
	
		
		
}
