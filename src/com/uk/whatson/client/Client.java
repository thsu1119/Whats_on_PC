package com.uk.whatson.client;
import java.io.IOException;

import com.uk.whatson.client.ClientConnection;
import com.uk.whatson.communication.Request;
import com.uk.whatson.communication.show.SlideObject;

/**
 * @author cw775, ls770
 */
public class Client {
	
	public Request SlideShowRequest;
	public ClientConnection connection;
	public SlideObject currentSlideshow;

	public Client() throws IOException {
		
	//Instantiate New Connection setup
	connection = new ClientConnection();
	//Establish Connection
	connection.connect();
	//Setup an appropriate Request
	SlideShowRequest = new Request();
	SlideShowRequest.setRequest(Request.ACTION_REQUEST_SLIDESHOW);
	
	/*
	connection.sendRequest(SlideShowRequest);
	*/
	
	}
	
	public void Communicate() throws IOException {
	
	
	//PART 1 [X]
	
	//Send Request to Server for a Slideshow
	connection.sendRequest(SlideShowRequest);
	System.out.println("Client : A request has been sent");
	
	//PART 2 [X]
	
	/*
	//Create and set the Slideshow object holder
	currentSlideshow = new Slideshow();
	//Receive incoming Slideshow from Server
	connection.readSlideshow(currentSlideshow);
	*/
	
	}
	

}