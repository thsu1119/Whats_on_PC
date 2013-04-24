package com.uk.whatson.communication.show;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.uk.whatson.communication.show.AudioElement;
import com.uk.whatson.communication.show.ImageElement;
import com.uk.whatson.communication.show.TextElement;
import com.uk.whatson.communication.show.VideoElement;

/**
 * @author ths 504, je575
 */
public class ElementTest{

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void defaultPosition() {
		TextElement myElement = new TextElement();
		assertEquals(200, myElement.xPos);
		assertEquals(100, myElement.yPos);
	}
	
	@Test 
	public void movePosition(){
		TextElement myElement = new TextElement();
		myElement.moveXY(100, 200);
		assertEquals(300,myElement.getXPos());
		assertEquals(300,myElement.getYPos());
	}
	
	@Test
	public void fontType(){
		TextElement myElement = new TextElement();
		assertEquals("Arial", myElement.getFontFace());
	}
	
	@Test
	public void fontColor(){
		TextElement myElement = new TextElement();
		assertEquals("FFFFFF",myElement.getFontColor());
	}
	
	@Test
	public void fontSize(){
		TextElement myElement = new TextElement();
		assertEquals(20,myElement.getFontSize());
	}
	
	@Test
	public void isTextUnderline(){
		TextElement myElement = new TextElement();
		assertFalse(myElement.getUnderline());
	}
	
	@Test
	public void TextFieldContent(){
		TextElement myElement = new TextElement();
		assertEquals("I am a Text",myElement.getTextField());
	}
	
	
////////////////////Test Video Element////////////////////////////////////	
	 @Test
	 public void videodefaultPosition(){
		 VideoElement videoElement = new VideoElement();
		 assertEquals(200,videoElement.getXPos());
		 assertEquals(100,videoElement.getYPos());
	 }

	 @Test
	 public void videoSize(){
		 VideoElement videoElement = new VideoElement();
		 assertEquals(1024,videoElement.getXSize());
		 assertEquals(768,videoElement.getYSize());
	 }
	 
	 @Test 
	 public void videoStartTime(){
		 VideoElement videoElement = new VideoElement();
		 assertEquals(0, videoElement.getStartTime());
		 
	 }
	 
	 @Test
	 public void videoDuration(){
		 VideoElement videoElement = new VideoElement();
		 assertEquals(0, videoElement.getDuration());
	 }
	 
	 @Test
	 public void videoFileLocation(){
		 VideoElement videoElement = new VideoElement();
		 assertEquals("C:\\",videoElement.getFileLocation());
	 }
	 @Test
	 public void videoInLineControl(){
		 VideoElement videoElement = new VideoElement();
		 assertFalse(videoElement.getInLineControl());
	 }
	 
	 
	 //////////////////////////Test Audio Element/////////////////////////////
	 
	 //Audio position and size only relevant when InlineControl is True.
	 @Test
	 public void audioInLineControl(){
		 AudioElement audioElement = new AudioElement();
		 assertFalse(audioElement.getInLineControl());		 
	 } 
	 
	 @Test
	 public void audioPosition(){
		 AudioElement audioElement = new AudioElement();
		 assertEquals(200,audioElement.getXPos());
		 assertEquals(100,audioElement.getYPos());
	 }
	 
	 @Test
	 public void audioSize(){
		 AudioElement audioElement = new AudioElement();
		 assertEquals(500,audioElement.getXSize());
		 assertEquals(100,audioElement.getYSize());
	 }
	 
	 @Test 
	 public void audioStartTime(){
		 AudioElement audioElement = new AudioElement();
		 assertEquals(0, audioElement.getStartTime());
		 
	 }
	 
	 @Test
	 public void audioDuration(){
		 AudioElement audioElement = new AudioElement();
		 assertEquals(0, audioElement.getDuration());
	 }
	 
	 @Test
	 public void audioFileLocation(){
		 AudioElement audioElement = new AudioElement();
		 assertEquals("C:\\",audioElement.getFileLocation());
	 }
	 ///////////////////////////////// Test Image Element ///////////////////////////
	 
	 @Test
	 public void imagedefaultPosition(){
		 ImageElement imageElement = new ImageElement();
		 assertEquals(200,imageElement.getXPos());
		 assertEquals(100,imageElement.getYPos());
	 }
	 @Test
	 public void imageSize(){
		 ImageElement imageElement = new ImageElement();
		 assertEquals(640,imageElement.getXSize());
		 assertEquals(280,imageElement.getYSize());
	 }
	 
	 @Test 
	 public void imageStartTime(){
		 ImageElement imageElement = new ImageElement();
		 assertEquals(0, imageElement.getStartTime());
		 
	 }
	 @Test
	 public void imageDuration(){
		 ImageElement imageElement = new ImageElement();
		 assertEquals(0, imageElement.getDuration());
	 }
	  
	 
	 
}