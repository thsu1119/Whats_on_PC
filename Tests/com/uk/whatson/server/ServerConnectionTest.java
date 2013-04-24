package com.uk.whatson.server;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.uk.whatson.communication.Request;
import com.uk.whatson.communication.show.SlideObject;

/**
 * @author ls770, cw775
 * 
 */
public class ServerConnectionTest {
	// Create Basic Elements
// Sockets
	ServerSocket testServerSocket;
	Socket testClientSocket;
	
// Output streams	
	ObjectOutputStream testObjectOutputStream; 
	OutputStream testOutputStream;
	
// Input streams
	ObjectInputStream testObjectInputStream;
	InputStream testInputStream;
	
//Communication objects
	Request testClientRequest;
	Request newClientRequest;
	Request testServerRequestHolder;
	SlideObject testServerSlideShow;
	SlideObject testClientSlideshowHolder;
	
// Addresses
	InetAddress testInetAddress;
	
// Connection under test
	ServerConnection testServerConnectivity;
	
	/**
	 * Creates an instance of the class  ServerConnnection and sets up
	 * a simulated Client
	 * 
	 * @throws Exception
	 */
	@Before
	public void setUp() throws IOException {
		testServerConnectivity = new ServerConnection();
		testServerConnectivity.serverSetup();
		}

	/**
	 * Checks all ports then closes the ones that are open 
	 * 
	 * @throws IOException
	 */
	@After
	public void cleanUp() throws IOException {

		testServerConnectivity.close();
		
		if(testObjectInputStream != null){
			testObjectInputStream.close();
			testObjectInputStream = null;
		}
		
		if(testInputStream != null){
			testInputStream.close();
			testInputStream = null;
		}
		
		if(testClientSocket != null){
			testClientSocket.close();
			testClientSocket = null;
		}
		
		if(testObjectOutputStream != null){
			testObjectOutputStream.close();
			testObjectOutputStream = null;
		}
		
		if(testOutputStream != null){
			testOutputStream.close();
			testOutputStream = null;
		}
		
		if(testServerSocket != null){
			testServerSocket.close();
			testServerSocket = null;
		}
		



		

	}
	
	/**
	 * Uses a simulated Client to send a Request object and verifies the Server
	 * receives it
	 * 
	 * @throws IOException
	 * @throws Exception
	 */
	@Test(timeout=100)
	public void testServerRequestReceiving() throws IOException, Exception {
				
		//Setup Test Client Simulation
		testInetAddress = InetAddress.getLocalHost();
		testClientSocket = new Socket(testInetAddress, 4445);
		testOutputStream = testClientSocket.getOutputStream();
		testObjectOutputStream = new ObjectOutputStream(testOutputStream);
		testObjectOutputStream.flush();

		System.out.println("Test Client Setup is Done");
		
		//Setup the Server
		testServerConnectivity.connectionReceive();	
		
		//Setup a Request for the Client to send
		testClientRequest = new Request();
		int clientID = 1;	
		testClientRequest.setRequest(clientID);
		
		//Setup a Request holder for the Server to receive
		testServerRequestHolder = new Request();
		int serverID = 0;
		testServerRequestHolder.setRequest(serverID);
		
		//Check if Request's Priority is the Default Value
		//Server
		assertEquals(testServerRequestHolder.getRequest(), serverID);
		//Client
		assertEquals(testClientRequest.getRequest(), clientID);
		
		
		//Send Request from Client to Server
		testObjectOutputStream.writeObject(testClientRequest);
		testServerRequestHolder = testServerConnectivity.readRequest();

		System.out.println("Server: Attempting to receive a Request");
	
		// Check if the RequestID has changed on the Server side
		assertEquals(testServerRequestHolder.getRequest(), 1);
		assertEquals(testServerRequestHolder.getRequest(), clientID);
		assertEquals(testServerRequestHolder.getRequest(), testClientRequest.getRequest());
			
		
		//Try again with a different Request to confirm functionality
		//Setup new Request
		newClientRequest = new Request();
		int newclientID = 5;
		newClientRequest.setRequest(newclientID);		
		
		//Confirm that Request is set correctly
		assertEquals(newClientRequest.getRequest(), newclientID);
	
		//Send Request from Client to Server
		testObjectOutputStream.writeObject(newClientRequest);
		testServerRequestHolder = testServerConnectivity.readRequest();
		
		System.out.println("Server: Attempting to receive a new Request");
		
		//Check if the sent Request ID has been overwritten
		assertEquals(testServerRequestHolder.getRequest(), newclientID);
		assertEquals(testServerRequestHolder.getRequest(), newClientRequest.getRequest());
		
		System.out.println("Test Completed Successfully");
		
	}
	
	
	/**
	 * Checks to see if the Sever can send a Slideshow object to the simulated client
	 * 
	 * @throws IOException
	 * @throws Exception
	 */
	@Test(timeout=100)
	public void testServerSlideshowSending() throws IOException, Exception {
		
		//Setup Test Client Simulation to RECEIVE an Object
		testInetAddress = InetAddress.getLocalHost();
		testClientSocket = new Socket(testInetAddress, 4445);

		testInputStream = testClientSocket.getInputStream();
		
		System.out.println("Test Client Setup is Done");
				
		//Call the Server Setup
		testServerConnectivity.connectionSend();
	
		testObjectInputStream = new ObjectInputStream(testInputStream);
		
		//Setup SlideShow Object to be sent to the Client from the Server
		testServerSlideShow = new SlideObject();
		testServerSlideShow.setBgColor("0000");
		
		// Setup Slideshow Holder 
		// This will be overwritten when a SlideShow is received on Client's Side
		System.out.println("SlideShow Settings are set");
		
		//Send SlideShow
		testServerConnectivity.sendSlideshow(testServerSlideShow);
		
		//Receive Slideshow
		testClientSlideshowHolder = (SlideObject) testObjectInputStream.readObject();
		
		//Check if the SlideShow attributes match
		if(testClientSlideshowHolder == null){
			fail();
		}
		assertEquals(	testServerSlideShow.getBgColor(),
						testClientSlideshowHolder.getBgColor());
		
		System.out.println("Test Completed Successfully");
	}
}
