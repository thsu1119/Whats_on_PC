package com.uk.whatson.communication.show;
import java.io.Serializable;

/**
 * Changes
 * @Before 	: Element 'extends' Slide
 * @After	: Removed 'extends' because Element is not a Slide. A Slide is an array of Element
 * @DateModified:11/3/13 	
 * @author ths504, je575
 * 
 * @version 1.0
 *
 */
public class Element implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1338024827780469910L;
	
	protected int xPos,yPos;
	protected String ID;
	
	//constructor method declaration	
	public Element()
	{
		xPos = 0;
		yPos = 0;
		ID = null;
	}
	
	/** Method to update new position of point on screen
	 * 
	 * @param newX
	 * @param newY
	 */
    public void moveXY(int newX, int newY) {
        xPos = xPos + newX;
        yPos = yPos + newY;
    }



    public int getXPos(){
    	return xPos;
    }
    
    public void setXPos(int XPos){
    	xPos = XPos;
    }
    
    public int getYPos(){
    	return yPos;   	
    }
    
    public void setYPos(int YPos){
    	yPos = YPos;
    }
}


	

