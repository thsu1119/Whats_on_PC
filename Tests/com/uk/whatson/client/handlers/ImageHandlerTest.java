package com.uk.whatson.client.handlers;

import static org.junit.Assert.*;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author aoh501, tlcb500
 */
public class ImageHandlerTest {
	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void acceptsAnImage() throws IOException{
		ImageHandler myHandler = new ImageHandler();
		Image testImage;
		testImage = ImageIO.read(new File("C:/Keil/UV4/TraceView.bmp"));

		myHandler.setSize(100, 100);
		myHandler.setImage(testImage);
		assertEquals(myHandler.myImage, testImage);
	}

	@Test
	public void drawsAFrame() {
		
	}
}
