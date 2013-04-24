package com.uk.whatson.client.handlers;

import java.awt.Color;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

import com.uk.whatson.communication.show.ImageElement;

/**
 * @author aoh501, tlcb500
 */
public class ManualImageTest {

	ImageHandler myHandler;
	JFrame myFrame;
	
	public ManualImageTest() {
		myFrame = new JFrame();
		
		myFrame.setLayout(null);
		ImageElement newElement = new ImageElement();
		
		myHandler = new ImageHandler(newElement);
		
		try {
			myHandler.setImage(new File("C:/Users/Public/Pictures/Sample Pictures/Desert.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myFrame.add(myHandler);
		myFrame.setSize(500, 500);
		
		myFrame.setBackground(Color.white);
		myFrame.setVisible(true);
	}
	
	public static void main(String[] args) {
		ManualImageTest newTest = new ManualImageTest();
		return;
	}

}
