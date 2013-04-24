package com.uk.whatson.client.handlers;

import java.awt.Color;

import javax.swing.JFrame;

import com.uk.whatson.communication.show.TextElement;

public class ManualTextTest {

		TextHandler myHandler;
		JFrame myFrame;
		
		public ManualTextTest() {
			myFrame = new JFrame();
			
			myFrame.setLayout(null);
			TextElement newElement = new TextElement();
			newElement.setTextField("Text\nNewLine");
			
			myHandler = new TextHandler(newElement);
			myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			myFrame.add(myHandler);
			myFrame.setSize(500, 500);
			
			myFrame.setBackground(Color.white);
			myFrame.setVisible(true);
		}
		
		public static void main(String[] args) {
			ManualTextTest newTest = new ManualTextTest();
			return;
		}
}
