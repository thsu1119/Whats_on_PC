package com.uk.whatson.client;

import static org.junit.Assert.*;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.uk.whatson.communication.Request;
import com.uk.whatson.communication.show.SlideObject;;

/**
 * @author ls770, cw775
 * 
 */

public class ClientConnectionTest {

	// Objects used to simulate the server side connection
// Sockets	
	ServerSocket testSocket;
	Socket receiverSocket;
	Socket testSendSocket;
	
// Input streams	
	InputStream receiverStream;
	ObjectInputStream receiverObjectStream;

// Output streams	
	ObjectOutputStream serverObjectOutputStream;
	OutputStream serverOutputStream;

// Communicated objects
	SlideObject testServerSlideShow;
	SlideObject testClientSlideshowHolder;

// Connection under test
	ClientConnection testClientConnectivity;
	
	/**
	 * 
	 * Tests pass when run separately but second one fails if they are both run at the same time
	 * 
	 * sets up the Server Socket for the test and creates an instance
	 * of the class  ClientConnnection
	 * 
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		testSocket = new ServerSocket(4445);
		testClientConnectivity = new ClientConnection();
	}

	/**
	 * Checks all ports then closes the ones that are open 
	 * 
	 * @throws IOException
	 */
	@After
	public void cleanUp() throws IOException {
		
		testClientConnectivity.close();

		if(testSocket != null){
			testSocket.close();
			testSocket = null;
		}
		
		if(testSendSocket != null){
			testSendSocket.close();
			testSendSocket = null;
		}
		
		if (receiverObjectStream != null) {
			receiverObjectStream.close();
			receiverObjectStream = null;
		}

		if (receiverStream != null) {
			receiverStream.close();
			receiverStream = null;
		}

		if (receiverSocket != null) {
			receiverSocket.close();
			receiverSocket = null;
		}
		
		if (serverObjectOutputStream != null) {
			serverObjectOutputStream.close();
			serverObjectOutputStream = null;
		}
		
		if (serverOutputStream != null) {
			serverOutputStream.close();
			serverOutputStream = null;
		}
		
		
	}


	/**
	 * Simulates a server for the Client socket to connect to
	 * this is to verify the Client can connect to a server
	 * 
	 * @throws IOException
	 */
	@Test(timeout = 100)
	public void createSocketTest() throws IOException {

		testClientConnectivity.connect();
		testClientConnectivity.setUpOutputStreams();
		if (testSocket != null) {
			receiverSocket = testSocket.accept();
		}

	}

	/**
	 * Simulates the sending of a single request to a server.
	 * 
	 * Creates a connection and simulates the server side of the communication
	 * Protocol. Sends a request and verifies that it is received.
	 * 
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	@Test(timeout = 100)
	public void sendsRequestTest() throws IOException, ClassNotFoundException {
		Request myRequest;
		Request receivedRequest;
		int clientRequestID = 1;
		int serverDefaultID = 0;

		myRequest = new Request();
		myRequest.setRequest(clientRequestID);
		receivedRequest = new Request();
		receivedRequest.setRequest(serverDefaultID);

		// Setup
		testClientConnectivity.connect();
		testClientConnectivity.setUpOutputStreams();
		receiverSocket = testSocket.accept();
		receiverStream = receiverSocket.getInputStream();
		if (receiverStream == null) {
			System.out.println("Stream is NULL");
		}
		receiverObjectStream = new ObjectInputStream(receiverStream);

		// Request
		testClientConnectivity.sendRequest(myRequest);
		receivedRequest = (Request) receiverObjectStream.readObject();
		if (receivedRequest == null) {
			fail();
		}
		assertEquals(myRequest.getRequest(), receivedRequest.getRequest());
	}

	/**
	 * Simulates the sending of requests to a server.
	 * 
	 * Creates a connection and simulates the server side of the communication
	 * Protocol. Sends two requests and verifies that they are sent in the
	 * correct order.
	 * 
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	@Test(timeout = 100)
	public void sendMultipleRequestsTest() throws IOException,
			ClassNotFoundException {
		Request myRequest;
		Request mySecondRequest;
		Request received;
		int receivedID = 0;
		// Test Requests
		myRequest = new Request();
		myRequest.setRequest(Request.ACTION_REQUEST_SLIDESHOW);
		mySecondRequest = new Request();
		mySecondRequest.setRequest(Request.ACTION_SECOND_TYPE);
		received = new Request();
		received.setRequest(receivedID);

		// Setup
		testClientConnectivity.connect();
		testClientConnectivity.setUpOutputStreams();
		receiverSocket = testSocket.accept();
		receiverStream = receiverSocket.getInputStream();
		receiverObjectStream = new ObjectInputStream(receiverStream);

		// First
		testClientConnectivity.sendRequest(myRequest);
		received = (Request) receiverObjectStream.readObject();
		if (received == null) {
			fail();
		}

		assertEquals(myRequest.getRequest(), received.getRequest());

		// Second
		testClientConnectivity.sendRequest(mySecondRequest);
		received = (Request) receiverObjectStream.readObject();
		if (received == null) {
			fail();
		}

		assertEquals(mySecondRequest.getRequest(), received.getRequest());
	}

	
	/** 
	 * Simulates the receiving of a slideshow from the server.
	 * 
	 * Creates a connection and simulates the server side of the communication
	 * Protocol. Receives a Slideshow and verifies that it contains the same
	 * information as the one sent.
	 *
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	@Test(timeout = 100)
	public void doesItRecieveSlideshowShitTest() throws IOException,
			ClassNotFoundException {
		// Setup Test Client Simulation to receive an Object
		

		// Setup Client Socket Connection
		testClientConnectivity.connect();
		
		testSendSocket = testSocket.accept();

		// OutPut Stream for Sending Data

		// Link socket to Stream
		serverOutputStream = testSendSocket.getOutputStream();
		if (serverOutputStream == null) {
			System.out.println("Stream Undefined");
		}

		serverObjectOutputStream = new ObjectOutputStream(serverOutputStream);

		// Opens the input stream and object input streams for the Client instantiation
		testClientConnectivity.setUpInputStreams();
		

		// Setup SlideShow Object to be sent to the Client from the Server
		testServerSlideShow = new SlideObject();
		testServerSlideShow.setBgColor("000000");

		// Sends an Object of type Slideshow
		serverObjectOutputStream.writeObject(testServerSlideShow);
		testClientSlideshowHolder = testClientConnectivity.readSlideshow();

		if(testClientSlideshowHolder == null){
			fail();
		}
		
		// Check if the SlideShow attributes match
		assertEquals(testServerSlideShow.getBgColor(),
				testClientSlideshowHolder.getBgColor());
		
		System.out.println("Test Completed Successfully");
	}

}