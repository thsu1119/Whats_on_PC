package com.uk.whatson.communication.show;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


/**
 * @author ths 504, je575
 */
public class Show implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1594015356035352559L;
	
	protected List<SlideObject> SlideList =
			new ArrayList<SlideObject>();

	/**
	 * Creates a new slide and add's it to a list of slides.
	 * 
	 * This method creates a new slide and add's it to the List of
	 * slides.
	 * This can change depending on the functionality of the system.
	 * For example, create of list can be a separate method.
	 * 
	 */
	public List<SlideObject> getSlideList() {
		
		SlideObject slide1 = new SlideObject();
		SlideList.add(slide1);
		
		return SlideList;
	}

	/**
	 * Set's the list of slides.
	 * 
	 * Accepts a list of SlideObject. This list effectively
	 * represents the slide show.
	 * 
	 * @param slideList
	 */
	public void setSlideList(List<SlideObject> slideList) {
		SlideList = slideList;
	}
	

}
