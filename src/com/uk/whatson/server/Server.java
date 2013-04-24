package com.uk.whatson.server;

import java.io.IOException;

import com.uk.whatson.communication.Request;
import com.uk.whatson.communication.show.SlideObject;
import com.uk.whatson.server.ServerConnection;

/**
 * @author cw775, ls770
 */
public class Server {

	public ServerConnection ServerConnectivity;
	//myRequest changed from private
	public Request myRequest;
	public int serverDefault = 0;	//Starting Value for Request Holder
	public int requestPriority = 1;//Use for comparison 
	public SlideObject currentSlideshow;

	public Server() throws IOException {

		// Make a Slideshow object
		currentSlideshow = new SlideObject();
		
		// Setup a Request to store incoming requests
		myRequest = new Request();
		myRequest.setRequest(serverDefault);
		
		// Instantiate Server Connectivity
		ServerConnectivity = new ServerConnection();
		//Establish Connection
		ServerConnectivity.connectionReceive();
		
		/*
		//Now Read a Request in
		ServerConnectivity.readRequest(myRequest);
		*/
	}
		
		
	//The following method should not be called anywhere 
	//due to the fact that it is unfinished
	
	public void Communicate() throws IOException {
		
		
		while(true)
		{
	//Part 1 [X]
		
		// Read incoming requests
		ServerConnectivity.listen();
		ServerConnectivity.readRequest();
		System.out.println("Server: Attempting to receive a Request");
		
		
	//Part 2 [X]
		
		
		if (myRequest.getRequest() == requestPriority) {
			
			// Send The SlideShow Object over to the client if they match
			ServerConnectivity.sendSlideshow(currentSlideshow);
			System.out.println("Server :  SlideShow Has been sent!");

														}
		
		}
		
	}

}
