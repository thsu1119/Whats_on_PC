/**
 * 
 */
package com.uk.whatson.client.handlers;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextPane;
import javax.swing.Timer;

import com.uk.whatson.communication.show.TextElement;

/**
 * @author jdk502, sjh541
 * 
 * @version 1.0
 *
 */

@SuppressWarnings("serial")
public class TextHandler extends JTextPane implements ActionListener {

	private TextElement textInfo; //New text element
	private Timer timer;           //Create timer
	private int x, y;
	private static final Color backgroundColor = new Color(0, 0, 0, 0);
	
/**
 * Accepts a text element and initialises the handler according to it's parameters.
 * 
 * @param TextElement
 */
public TextHandler(TextElement element){
	this.textInfo = element;
	this.setText(textInfo.getTextField());
	
	//Sets the style of the font
	int fontCode = 0;
	if(textInfo.getItalic()){
		fontCode |= Font.ITALIC;
	}
	if(textInfo.getBold()){
		fontCode |= Font.BOLD;
	}
	this.setEditable(false);
	super.setFont(new Font(textInfo.getFontFace(), fontCode, textInfo.getFontSize()));
	
	//Convert colour from hex to rgb value
	int intColor = Integer.parseInt(textInfo.getFontColor(), 16);
	Color textColour = new Color(intColor);
	
	//Set JLabel text colour
	this.setForeground(textColour); 
	this.setBackground(backgroundColor);
	
	//Position and size the Text Box
	setBounds();
	
	// Visibility Timer
	if (textInfo.getDuration() != 0) {
		timer = new Timer(textInfo.getDuration() * 1000, this);
		if (textInfo.getStartTime() != 0) {
			this.setVisible(false);
			timer.setInitialDelay(textInfo.getStartTime() * 1000);
			timer.setRepeats(true);
		}
		timer.start();
	} else if (textInfo.getStartTime() != 0) {
		timer = new Timer(textInfo.getStartTime() * 1000, this);
		timer.setRepeats(false);
		timer.start();
	}
}

/**
 * Accepts a text element and initialises the handler according to it's parameters.
 * 
 * @param TextElement
 */
public TextHandler(){
	this.x = 0;
	this.y = 0;
}

/**
 * Accepts the string to display.
 * 
 * @param newText
 */
public void setText(String newText){
	super.setText(newText);
	setBounds();
	repaint();
}

/**
 * Sets the text to bold. 
 * @param bold - Bold if true, else normal
 */
public void setBold(boolean bold){
	Font thisFont = this.getFont();
	int newCode = thisFont.getStyle();
	if(bold){
		newCode |= (Font.BOLD);
		
	}else{
		newCode &= ~(Font.BOLD);
	}
	Font newFont = new Font(thisFont.getName(), newCode, thisFont.getSize());
	this.setFont(newFont);
	setBounds();
	repaint();
}

/**
 * Sets the text to italic
 * @param italic - Italic if true, else normal
 */
public void setItalic(boolean italic){
	Font thisFont = this.getFont();
	int newCode = thisFont.getStyle();
	if(italic){
		newCode |= (Font.ITALIC);
		
	}else{
		newCode &= ~(Font.ITALIC);
	}
	Font newFont = new Font(thisFont.getName(), newCode, thisFont.getSize());
	super.setFont(newFont);
	setBounds();
	repaint();
}

/**
 * Changes the size of the text font.
 * @param newSize
 */
public void setFontSize(int newSize){
	Font thisFont = this.getFont();
	super.setFont(new Font(thisFont.getName(), thisFont.getStyle(), newSize));
	setBounds();
	repaint();
}

/**
 * Changes text colour.
 * @param newColor
 */
public void setColor(Color newColor){
	super.setForeground(newColor);
	repaint();
}


/**
 * Changes text colour. Converts the string into a hex representation of the colour.
 * @param newColor
 */
public void setColor(String newColor){
	int intColor = Integer.parseInt(newColor, 16);
	Color newColour = new Color(intColor);
	setColor(newColour);
}

/**
 * Changes the font face of the text to the name specified.
 * Fails to change if font is misspelled.
 * 
 * @param name
 */
public void setFontFace(String name){
	Font oldFont = this.getFont();
	super.setFont(new Font(name, oldFont.getStyle(), oldFont.getSize()));
}

/**
 * Changes the text font to the specified font.
 * 
 * @param name
 */
@Override
public void setFont(Font newFont){
	super.setFont(newFont);
	setBounds();
	repaint();
}

/**
 * Re-sizes the view according to contents.
 */
private void setBounds(){
	Dimension bounds = this.getPreferredSize();
	super.setBounds(this.x, this.y, bounds.width, bounds.height);
}

/** Changes the position relative to the container.
 * 
 * @param x
 * @param y
 */
public void setPosition(int x, int y){
	this.x = x;
	this.y = y;
	setBounds();
	repaint();
}

/**
 * Used by the timer to toggle visibility.
 * @param e
 */
@Override
public void actionPerformed(ActionEvent e) {
	if(this.isVisible()){
		this.setVisible(false);
		repaint();
		timer.stop();
	}else{
		this.setVisible(true);
		repaint();
		if(textInfo.getDuration() == 0){
			timer.stop();
		}
	}
}
}

