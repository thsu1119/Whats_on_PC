package com.uk.whatson.communication.show;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ths 504, je575
 */
public class SlideObject implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6986799940400737022L;
	
	//protected int sizeofTextList,sizeofImageList,sizeofAudioList,sizeofVideoList;
	protected String BgColor,ID;
	protected int Duration;
	
	protected List<TextElement> textList = new ArrayList<TextElement>();

	protected List<ImageElement> ImageList =  new ArrayList<ImageElement> ();

	protected List<AudioElement> AudioList = new ArrayList<AudioElement>();

	protected List<VideoElement> VideoList =  new ArrayList<VideoElement>();
	
	public  SlideObject(){
		BgColor = "FFFFFF";
		Duration = 0;
		ID = null;
	}

	/*public List<TextElement> getTextList() {
		
		//TextElement text1 = new TextElement();
		//textList.add(text1);
		
		return textList;
	}*/

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public int getDuration() {
		// TODO Auto-generated method stub
		return Duration;
	}

	public void setDuration(int duration) {
		Duration = duration;
	}

	public String getBgColor() {
		// TODO Auto-generated method stub
		return BgColor;
	}


	public void setBgColor(String bgColor) {
		BgColor = bgColor;
	}
		
}
