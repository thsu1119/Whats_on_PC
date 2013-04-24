package com.uk.whatson.communication.show;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.uk.whatson.communication.show.Show;
import com.uk.whatson.communication.show.SlideObject;

/**
 * @author ths 504, je575
 */
public class ShowTest {

	@Before
	public void setUp() throws Exception {
	}

	/*@Test
	public void test() {
		fail("Not yet implemented");
	}*/
	
	@Test
	public void createListofSlides(){
	  Show myShow = new Show();
	  assertTrue(myShow.SlideList instanceof List);
	}
	
	@Test
	public void SlideListcontainsSlides(){
		Show myShow = new Show();
		myShow.getSlideList();
		assertTrue(myShow.SlideList.get(0) instanceof SlideObject);
	}

}
