package com.uk.whatson.client.handlers;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

import com.uk.whatson.communication.show.ImageElement;

/**
 * 
 * @author aoh501, tlcb500
 *
 */

@SuppressWarnings("serial")
public class ImageHandler extends JPanel implements ActionListener {

	protected Image myImage;
	protected int x, y, xImg, yImg, height, width;
	private Timer timer;
	private ImageElement info;
	
	/**
	 * Default Constructor
	 */
	public ImageHandler(){
		super();
		x = 0;
		y = 0;
		width = 0;
		height = 0;
	}
	
	/**
	 * Used when the handler is used for things other than the slide image handler.
	 * 
	 * @param x
	 * @param y
	 * @param setImage
	 */
	public ImageHandler(int x, int y, Image setImage){
		super();
		this.x = x;
		this.y = y;
		myImage = setImage;
	}
	
	/**
	 * Sets up the image with the specified parameters.
	 * 
	 * @param ImageElement
	 */
	public ImageHandler(ImageElement info){
		super();
		this.info = info;
		//Sizing
		x = info.getXPos();
		y = info.getYPos();
		height = info.getYSize();
		width = info.getXSize();
		this.setBounds(x, y, width, height);
		
		//Visibility Timer
		if(info.getDuration() != 0){
			timer = new Timer(info.getDuration()*1000, this);
			if(info.getStartTime() != 0){
				this.setVisible(false);
				timer.setInitialDelay(info.getStartTime()*1000);
				timer.setRepeats(true);
			}
			
			timer.start();
		}else if(info.getStartTime() != 0){
			timer=new Timer(info.getStartTime()*1000, this);
			timer.setRepeats(false);
			timer.start();
		}
	}
	
	/**
	 * Sets the image to be displayed. Scaled Automatically when drawn.
	 * 
	 * @param newImage
	 */
	public void setImage(Image newImage) {
		myImage = newImage;
		repaint();
	}
	
	/**
	 * Attempts to load the image from a file. If the load fails, an Exception
	 * is thrown.
	 * 
	 * @param imageFile - File to load the image from.
	 * @throws IOException
	 */
	public void setImage(File imageFile) throws IOException{
		myImage = ImageIO.read(imageFile);
		repaint();
	}
	
	/**
	 * Sets the size of the image in pixels.
	 * 
	 * @param width
	 * @param height
	 */
	public void setSize(int width, int height){
		this.width = width;
		this.height = height;
		this.setBounds(x, y, width, height);
		repaint();
	}
	
	/**
	 * Returns the height of the image handler.
	 * 
	 * @return height
	 */
	public int getHeight(){
		return height;
	}
	
	/**
	 * Returns the width of the iamge handler.
	 * 
	 * @return width
	 */
	public int getWidth(){
		return width;
	}
	
	/**
	 * Called by the swing system to draw the component.
	 * 
	 * @param graphic
	 * 
	 */
	public void paintComponent(Graphics graphic){
		super.paintComponent(graphic);
		int intrinsicWidth, intrinsicHeight;
		intrinsicWidth = myImage.getWidth(null)/width;
		intrinsicHeight = myImage.getHeight(null)/height;
		
		if(intrinsicWidth > intrinsicHeight){
			myImage = myImage.getScaledInstance(width, -1, Image.SCALE_DEFAULT);
			yImg = height/2 - myImage.getHeight(null)/2;
			
			//graphic.drawImage(myImage, x, yImg, null);
			graphic.drawImage(myImage, 0, yImg, null);
		}else{
			myImage = myImage.getScaledInstance(-1, height, Image.SCALE_DEFAULT);
			xImg = width/2 - myImage.getWidth(null)/2;
			
			//graphic.drawImage(myImage, xImg, y, null);
			graphic.drawImage(myImage, xImg, 0, null);
		}
	}

	/**
	 * Method used by the timer to toggle the image visibility.
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(this.isVisible()){
			this.setVisible(false);
			repaint();
			timer.stop();
		}else{
			this.setVisible(true);
			repaint();
			if(info.getDuration() == 0){
				timer.stop();
			}
		}
	}

}
