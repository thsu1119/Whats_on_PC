package com.uk.whatson.communication.show;

/**
 * @author ths 504, je575
 */
public class TextElement extends Element {
	/**
	 * 
	 */
	private static final long serialVersionUID = 305675479818104813L;

	protected String FontFace,TextField,FontColor;

	protected int FontSize;
	protected boolean Underline, Bold, Italic;

	private int StartTime;

	private int Duration;
	
	
	public TextElement()
	{
		super();
		FontFace = "Arial";
		FontColor = "000000";
		FontSize = 20;
		Underline = false;
		Bold = false;
		Italic = false;
		TextField = "I am a Text";
	}
	
	public String getFontFace() {
		return FontFace;
	}


	public void setFontFace(String fontFace) {
		FontFace = fontFace;
	}

	public String getFontColor() {
		// TODO Auto-generated method stub
		return FontColor;
	}

	public void setFontColor(String fontColor) {
		FontColor = fontColor;
	}

	public int getFontSize() {
		// TODO Auto-generated method stub
		return FontSize;
	}

	public void setFontSize(int fontSize) {
		FontSize = fontSize;
	}

	

	public String getTextField() {
		// TODO Auto-generated method stub
		return TextField;
	}

	public void setTextField(String textField) {
		TextField = textField;
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
	
	public boolean getBold(){
		return Bold;
	}
	
	public void setBold(boolean bold){
		Bold = bold;
	}
	
	public boolean getItalic(){
		return Italic;
	}
	
	public void setItalic(boolean italic){
		Italic = italic;
	}
	
	public boolean getUnderline() {
		// TODO Auto-generated method stub
		return Underline;
	}

	public void setUnderline(boolean underline) {
		Underline = underline;
	}
	
}
