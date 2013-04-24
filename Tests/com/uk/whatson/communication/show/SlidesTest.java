package com.uk.whatson.communication.show;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.uk.whatson.communication.show.SlideObject;

/**
 * @author ths 504, je575
 */
public class SlidesTest {

	@Before
	public void setUp() throws Exception {
	}

	
	///////////Slide object variables//////
	@Test
	public void DurationofSlide(){
		SlideObject mySlide = new SlideObject();
		assertEquals(0,mySlide.getDuration());
	}
	
	@Test
	public void BgColorofslide(){
		SlideObject mySlide = new SlideObject();
		assertEquals("FFFFFF", mySlide.getBgColor());
	}
	
	
	
/////////////////List of TextElement test////////////////////	
	@Test
	public void createListofTextElements(){
		SlideObject mySlide = new SlideObject();
		assertTrue(mySlide.textList instanceof List);		
		
	}
	
	/*@Test
	public void TextListcontainsTextElement(){
		SlideObject mySlide = new SlideObject();
		//add arbitrary text element to list
		
		mySlide.getTextList();
		assertTrue(mySlide.textList.get(0) instanceof TextElement);
		
	}*/
	//////////////////List of ImageElement test///////////////
	@Test
	public void createListofImageElements(){
		SlideObject mySlide = new SlideObject();
		assertTrue(mySlide.ImageList instanceof List);
	}
	//////////////////List of AudioElement Test///////////////
	@Test
	public void createListofAudioElements(){
		SlideObject mySlide = new SlideObject();
		assertTrue(mySlide.AudioList instanceof List);
		
	}
	
	///////////////List of VideoElement Test////////////////
	@Test
	public void createListofVideoElement(){
		SlideObject mySlide = new SlideObject();
		assertTrue(mySlide.VideoList instanceof List);
	}

}
