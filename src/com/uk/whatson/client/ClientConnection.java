package com.uk.whatson.client;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

import com.uk.whatson.communication.Request;
import com.uk.whatson.communication.show.SlideObject;


/**
 * Class used to facilitate the communication from the Client to Server. Manages
 * requests and receives images, slides etc.
 * 
 * @author ls770, cw775
 * 
 */
public class ClientConnection {

// Sockets
	private Socket clientSendSocket;
	private Socket clientReceiveSocket;
	
// Output Streams
	private OutputStream clientOutputStream;
	private ObjectOutputStream clientObjectOutputStream;
	
// Input Streams
	private InputStream clientInputStream;
	private ObjectInputStream clientObjectInputStream;
	
// Addresses
	private InetAddress myInetAddress;

	
	public ClientConnection() {
	}

	/**
	 * Attempts to Connect to the Server.
	 * 
	 * @throws IOException
	 * @throws UnknownHostException
	 */
	public void connect() throws UnknownHostException, IOException {

		myInetAddress = InetAddress.getLocalHost();

		//*****************************************************************\\
		//*Add Stream management to the methods so that ONE socket is used*\\
		//*****************************************************************\\
		clientSendSocket = new Socket(myInetAddress, 4445);

		System.out.println("Client Socket Connected");
	}

	/**
	 * Sets up the Client output streams so objects can be sent from the Client
	 * to the Server
	 * 
	 * @throws IOException
	 */
	public void setUpOutputStreams() throws IOException {

		clientOutputStream = clientSendSocket.getOutputStream();
		
		// Creates a new object stream from the client output stream
		clientObjectOutputStream = new ObjectOutputStream(clientOutputStream);

		System.out.println("Client is setting up . . . Done (Output Stream)");

	}

	/**
	 * Sets up the Client input streams so objects can be read by the Client
	 * from the Server
	 * 
	 * @throws IOException
	 */
	public void setUpInputStreams() throws IOException {

		clientInputStream = clientSendSocket.getInputStream();
		
		// Creates a new object stream from the client input
		clientObjectInputStream = new ObjectInputStream(clientInputStream);

		System.out.println("Client is setting up . . . Done (Input Stream)");

	}

	/**
	 * Takes in an object of type request and writes it to an output stream so
	 * it can be sent to the client via a socket
	 * 
	 * @param myRequest
	 * @throws IOException
	 */
	public void sendRequest(Request myRequest) throws IOException {

		clientObjectOutputStream.writeObject(myRequest);

		System.out.println("Request Send");
	}

	public SlideObject readSlideshow() throws ClassNotFoundException, IOException {

		SlideObject recievedSlideshow = null;

		System.out.println("Reading Slideshow . . .");

		// Reads an object from the input stream and writes it to recievedSlideshow
		recievedSlideshow = (SlideObject) clientObjectInputStream.readObject();

		System.out.println("Sideshow Red");

		return recievedSlideshow;
	}

	/**
	 * A method which calls the close method of all ports and streams used by
	 * the Client
	 */
	public void close() {
		try {
		// Sockets	
			clientReceiveSocket.close();
			clientSendSocket.close();
			
		// Output streams	
			clientObjectOutputStream.close();
			clientOutputStream.close();
			
		// Input streams	
			clientObjectInputStream.close();
			clientInputStream.close();
		} catch (Exception e) {

		}
	}
}
