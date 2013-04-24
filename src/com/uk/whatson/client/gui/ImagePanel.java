package com.uk.whatson.client.gui;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**@author ajpc500
 * @version 1.0
 * @since 13-03-13 **/

/** Used to create a JPanel of a chosen image. */
@SuppressWarnings("serial")
public class ImagePanel extends JPanel {

	String imagefile;

	private BufferedImage image;

	/**
	 * @param newfilepath
	 *            is the new file path for an image
	 **/
	public void setImage(String newfilepath) {
		imagefile = newfilepath;
		revalidate();
	}

	/**
	 * @param imagefile
	 *            is the location of file as a string
	 * @return JPanel of image
	 **/
	public ImagePanel(String imagefile) {
		try {
			image = ImageIO.read(new File(imagefile));
		} catch (IOException ex) {
			// handle exception...
		}
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(image, 0, 0, null); // see javadoc for more info on the
										// parameters
	}

}
