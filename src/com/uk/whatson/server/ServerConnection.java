package com.uk.whatson.server;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.io.InputStream;
import java.net.InetAddress;

import java.net.ServerSocket;
import java.net.Socket;

import com.uk.whatson.communication.Request;
import com.uk.whatson.communication.show.SlideObject;

/**
 * @author cw775, ls770
 */
public class ServerConnection {

// Sockets	
	private ServerSocket serverSocket;
	private Socket receivedSocket;
	private Socket sendSocket;
	
// Input streams	
	private ObjectInputStream serverObjectInputStream;
	private InputStream serverInputStream;
	
// Output streams	
	private ObjectOutputStream serverObjectOutputStream;
	private OutputStream serverOutputStream;
	
// Addresses	
	private InetAddress myInetAddress;

	
	public ServerConnection() throws IOException {
	}

	/**
	 * Sets up the Server Socket on the given port (4445)
	 * 
	 * @throws IOException
	 */
	public void serverSetup() throws IOException {
		// Initial setup
		// IP = 127.0.0.1
		myInetAddress = InetAddress.getLocalHost();

		// Port = 4445
		// backlog = 1 (number of serial connections at a time)
		serverSocket = new ServerSocket(4445, 4, myInetAddress);

		System.out.println("Server Socket Setup!");
	}

	/**
	 * Calls the accept() method on the server socket to establish a connection
	 * between two ports
	 * 
	 * Sets up the input streams from the socket - objects can now be received
	 * from the Client
	 */
	public void connectionReceive() {
		try {

			// Accept Client's Socket ID details and Listen to the attached stream
			receivedSocket = serverSocket.accept();

			// Link socket to Stream
			serverInputStream = receivedSocket.getInputStream();

			System.out.println("Loading . . . Server Input Stream");

			if (serverInputStream == null) {
				System.out.println("Stream Undefined");
			}
			
			// Place Stream in Object
			serverObjectInputStream = new ObjectInputStream(serverInputStream);

			System.out
					.println("Server is setting up . . . Done (Input Stream)");

		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}

	/**
	 * Calls the accept() method on the server socket to establish a connection
	 * between two ports
	 * 
	 * Sets up the output streams from the socket - objects can now be sent to
	 * the Client
	 */
	public void connectionSend() {
		try {

			sendSocket = serverSocket.accept();

			// Link socket to Stream
			serverOutputStream = sendSocket.getOutputStream();
			if (serverOutputStream == null) {
				System.out.println("Stream Undefined");
			}

			// Place Stream in Object
			serverObjectOutputStream = new ObjectOutputStream(
					serverOutputStream);

			System.out
					.println("Server is setting up . . . Done (Output Stream)");

		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}

	/**
	 * Calls the accept() method on the server socket to establish a connection
	 * between ports
	 * 
	 * @throws IOException
	 */
	public void listen() throws IOException {

		receivedSocket = serverSocket.accept();
	}

	// Receives an Object of type Request
	public Request readRequest() {
		Request receivedRequest = null;
		try {

			receivedRequest = (Request) serverObjectInputStream.readObject();
			System.out.println("Reading Data . . .");

			System.out.println("Request Red");

			// Close Streams after reading the object

		} catch (Exception e) {

			System.out.println(e.toString());
		}
		return receivedRequest;
	}

	/**
	 * Takes in an object of type Slideshow and writes it to an output stream so
	 * it can be sent to the client via a socket
	 * 
	 * @param myRequest
	 * @throws IOException
	 */
	public void sendSlideshow(SlideObject mySlideshow) throws IOException {

		serverObjectOutputStream.writeObject(mySlideshow);

		System.out.println("Sending SlideShow Data. . .");

	}

	/**
	 * A method which calls the close method of all ports and streams used by
	 * the Client
	 */
	public void close() {
		try {
			// Terminate connections
			if(receivedSocket != null){
				receivedSocket.close();
			}
			
			if(sendSocket != null){
				sendSocket.close();
			}
			
			if(serverSocket != null){
				serverSocket.close();
				serverObjectInputStream.close();
				serverObjectOutputStream.close();
				serverInputStream.close();
				serverOutputStream.close();
			}
		} catch (Exception e) {

		}

	}

}
