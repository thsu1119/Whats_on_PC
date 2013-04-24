package com.uk.whatson.client.gui;

import javax.swing.*;
import java.awt.*;

/**@author ajpc500
 * @version 1.0
 * @since 13-03-13 **/

/**
 * Used to create the custom tab buttons in MainWindow Also includes a fade
 * function.
 */
@SuppressWarnings("serial")
public class CustomButton extends JButton {

	int buttonNumber;
	String imageChoice;

	public void customImageButton(String imagename) {
		imageChoice = imagename;
		repaint();
	}

	public void buttonChoice(int buttonNumber) {
		if (buttonNumber == 1) {
			imageChoice = "Images/yusu.png";
		}
		if (buttonNumber == 2) {
			imageChoice = "Images/artsculture.png";
		}
		if (buttonNumber == 3) {
			imageChoice = "Images/barsclubs.png";
		}
		if (buttonNumber == 4) {
			imageChoice = "Images/fooddrink.png";
		}
		if (buttonNumber == 5) {
			imageChoice = "Images/livemusic.png";
		}
		if (buttonNumber == 6) {
			imageChoice = "Images/sports.png";
		}
		if (buttonNumber == 7) {
			imageChoice = "Images/retail.png";
		}
		if (buttonNumber == 8) {
			imageChoice = "Images/transport.png";
		}
	}

	public void setFade(Boolean fadevalue, int chosenButton) {
		if (fadevalue == true) {
			if (chosenButton == 1) {
				imageChoice = "Images/yusufade.png";
			}
			if (chosenButton == 2) {
				imageChoice = "Images/artsculturefade.png";
			}
			if (chosenButton == 3) {
				imageChoice = "Images/barsclubsfade.png";
			}
			if (chosenButton == 4) {
				imageChoice = "Images/fooddrinkfade.png";
			}
			if (chosenButton == 5) {
				imageChoice = "Images/livemusicfade.png";
			}
			if (chosenButton == 6) {
				imageChoice = "Images/sportsfade.png";
			}
			if (chosenButton == 7) {
				imageChoice = "Images/retailfade.png";
			}
			if (chosenButton == 8) {
				imageChoice = "Images/transportfade.png";
			}
		}
		if (fadevalue == false) {
			if (chosenButton == 1) {
				imageChoice = "Images/yusu.png";
			}
			if (chosenButton == 2) {
				imageChoice = "Images/artsculture.png";
			}
			if (chosenButton == 3) {
				imageChoice = "Images/barsclubs.png";
			}
			if (chosenButton == 4) {
				imageChoice = "Images/fooddrink.png";
			}
			if (chosenButton == 5) {
				imageChoice = "Images/livemusic.png";
			}
			if (chosenButton == 6) {
				imageChoice = "Images/sports.png";
			}
			if (chosenButton == 7) {
				imageChoice = "Images/retail.png";
			}
			if (chosenButton == 8) {
				imageChoice = "Images/transport.png";
			}
		}
		repaint();
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		super.setBackground(null);
		super.setBorder(null);
		Image image = new ImageIcon(imageChoice).getImage();
		g.drawImage(image, 0, 0, this);
	}

	@Override
	public Dimension getPreferredSize() {
		Dimension size = super.getPreferredSize();
		size.setSize(142, 56);
		return size;
	}
}
