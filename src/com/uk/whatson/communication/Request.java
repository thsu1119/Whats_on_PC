package com.uk.whatson.communication;

import java.io.Serializable;

/**
 * @author cw775, ls770
 */
public class Request implements Serializable{

	/**
	 * Serial ID. Must be used in all future versions of the class that remain compatible with this system.
	 */
	private static final long serialVersionUID = -769894066891810565L;
	
	/** 
	 * Action Constants
	 */
	public static final int ACTION_SECOND_TYPE = 0;
	public static final int ACTION_REQUEST_SLIDESHOW = 1;
	
	private int RequestType = 666;
	
	public Request(){
		}
	
	/**
	 * A method which allows the value stored in the object
	 * to be changed, so that it can refer to different actions
	 * the Client may wish the Server to perform.
	 * 
	 * @param myRequestAction
	 */
	public void setRequest(int myRequestAction) {
		RequestType = myRequestAction; 
		if (RequestType == myRequestAction) {
			System.out.println("New Value adapted");
		}

	}
	
	/**
	 * Returns the value stored in the object which will refer
	 * an action which the Server is being asked to perform
	 * 
	 * @return ActionID
	 */
	public int getRequest(){
		
		return RequestType;
	}
}
