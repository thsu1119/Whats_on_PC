package com.uk.whatson.client.gui;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*; 

/**@author ajpc500
 * @version 1.0
 * @since 13-03-13 **/

/** Main GUI assembly class. 
 * 
 * Creates the JFrame containing all other instances of other classes
 */

@SuppressWarnings("serial")

public class MainWindow extends JFrame implements ActionListener, MouseListener {

	  JPanel pane = new JPanel();
	  Image whatson; Image background; 
	  JPanel buttonbar = new JPanel();
	  JPanel addetails = new JPanel();
	  JLabel info = new JLabel("XXXX");
	  JLabel adtitle = new JLabel("YUSU");
	  JLabel adtitle2 = new JLabel("YUSU");
	  JTextArea selectedadinfo = new JTextArea();
	  JTextArea selectedadinfo1 = new JTextArea();
	    Graphics offScreenGraphics;  
	    Image offScreenImage;
	  Image test;
	  int xbb = 0; int ybb = 344;
	  
	  CustomButton button1,button2, button3,button4,button5 ,button6,button7,button8;
	  CustomButton collapseexpand = new CustomButton();
	  JButton admore = new JButton("Expand");
      Color white = new Color(255,255,255);
      int winexpand = 0;
      ListElement listitem1;
      ListElement listitem2;
      ListElement listitem3;
      JScrollPane listofads = new JScrollPane();
	  SlideShowElements slideshow = new SlideShowElements();
      JPanel listitems = new JPanel();
	 ListElement listitem4;
	 ListElement listitem5;
	 ListElement listitem6;
    JList<ListElement> listofitems = new JList<ListElement>();
    static Font font3 = new Font("Arial", Font.BOLD, 16);
    Color c = new Color (42,147,225);
    JScrollPane adinfoscroller = new JScrollPane();
    JPanel fulladinfo = new JPanel();
    ImagePanel fulladimage1 = new ImagePanel("Images/fulladinfoimage1.png");
    ImagePanel fulladimage2 = new ImagePanel("Images/fulladinfoimage1.png");

    
	  
	  public JPanel createContentPane() // the frame constructor method
	  {
		JPanel fullGUI = new JPanel(); //fullGUI is the main JPanel to which all elements are added.
	    fullGUI.setLayout(null);
	    fullGUI.setBackground(white);
    	fullGUI.addMouseListener(this);

	    ImagePanel background = new ImagePanel("Images/background.png");
	    
	    
	    background.setLocation(0,0);
	    background.setOpaque(true);
	    background.setSize(1136,722);
	    
	    ImagePanel whatson = new ImagePanel("Images/whatson.png");
	    
	    whatson.setLocation(670,0); 
	    whatson.setOpaque(false);
	    whatson.setSize(341,75);
		fullGUI.add(whatson);
		
		
		slideshow = new SlideShowElements();
		slideshow.setSize(1007,260);
		slideshow.setLocation(5,78);
		//fullGUI.add(slideshow);
		
	    buttonbar = new JPanel();
    	//buttonbar.addMouseListener(this);

        buttonbar.setLayout(null);
        buttonbar.setLocation(0, 344);
        buttonbar.setSize(1136, 56);
        buttonbar.setBackground(Color.white);
        buttonbar.setUI(null);
        fullGUI.add(buttonbar);
	    
        int count = 1;
        while (count < 9) {	//While loop used to create the 8 buttons present as tabs for each category.
     
        	CustomButton buttonToAdd = new CustomButton();
        	
        	if (count == 1){button1 = new CustomButton(); buttonToAdd = button1;}
        	if (count == 2){button2 = new CustomButton(); buttonToAdd = button2;}
        	if (count == 3){button3 = new CustomButton(); buttonToAdd = button3;}
        	if (count == 4){button4 = new CustomButton(); buttonToAdd = button4;}
        	if (count == 5){button5 = new CustomButton(); buttonToAdd = button5;}
        	if (count == 6){button6 = new CustomButton(); buttonToAdd = button6;}
        	if (count == 7){button7 = new CustomButton(); buttonToAdd = button7;}
        	if (count == 8){button8 = new CustomButton(); buttonToAdd = button8;}
        	
        	buttonToAdd.buttonChoice(count);
        	buttonToAdd.addActionListener(this);
        	buttonToAdd.addMouseListener(this);
        	buttonToAdd.setBorder(null);

        	buttonToAdd.setLocation(125*(count - 1), 0);
        	buttonToAdd.setSize(142, 56);
            //buttonToAdd.setHorizontalAlignment(0);
            buttonbar.add(buttonToAdd);
           // buttonbar.setComponentZOrder(buttonToAdd, buttonbar.getComponentCount()-1);
            count++;
        }
        
          button1.setFade(false, 1); //sets the first tab to the focus for startup.
          button2.setFade(true, 2);
	      button3.setFade(true, 3);
	      button4.setFade(true, 4);
	      button5.setFade(true, 5);
	      button6.setFade(true, 6);
	      button7.setFade(true, 7);
	      button8.setFade(true, 8);
        
        Color c = new Color (42,147,225);
        addetails = new JPanel();
        addetails.setBackground(c);
        addetails.setLayout(null);
        addetails.addMouseListener(this);

        addetails.setLocation(0,400);
        addetails.setSize(1017,300);
        
        adtitle = new JLabel();
        adtitle.setLocation(10,-10);
        adtitle.setText("YUSU");
        Font font1 = new Font("Arial Black", Font.BOLD, 70);
        adtitle.setFont(font1);
        adtitle.setBackground(c);
        adtitle.setForeground(Color.black);
        adtitle.setSize(new Dimension(400,100));
        addetails.add(adtitle); 
        
        adtitle2 = new JLabel();
        adtitle2.setLocation(10,50);
        adtitle2.setText("");
        adtitle2.setFont(font1);
        adtitle2.setBackground(c);
        adtitle2.setForeground(Color.black);
        adtitle2.setSize(new Dimension(400,100));
        addetails.add(adtitle2);
        
        info = new JLabel();
        info.setLocation(10,65);
        info.setText("INFO ON ADVERT");
        info.setFont(new Font("Arial Black", Font.PLAIN, 30));       
        info.setForeground(new Color(255,255,255));
        info.setSize(info.getPreferredSize());
        addetails.add(info); 
        
        
        //below populates the, currently static, scrollpane with examples of ads.
        listitem1 = new ListElement("Images/listelement1.png", new Color(42,147,225), "AD1: YUSU", 
    			"MORE INFORMATION", "01/01/2013", "location");
        listitem1.setSize(400,82);
        listitem1.addActionListener(this);
        listitem2 = new ListElement("Images/listelement2.png", new Color(32,106,199), "AD2: ARTS", 
    			"MORE INFORMATION", "02/01/2013", "location");
        listitem2.setSize(400,82);
        listitem2.addActionListener(this);
        listitem3 = new ListElement("Images/listelement3.png", new Color(224,21,65), "AD3: LIVE MUSIC", 
    			"MORE INFORMATION", "03/01/2013", "location");
        listitem3.setSize(400,82);
        listitem3.addActionListener(this);
        listitem4 = new ListElement("Images/listelement1.png", new Color(42,147,225), "AD4: YUSU", 
    			"MORE INFORMATION", "01/01/2013", "location");
        listitem4.setSize(400,82);
        listitem4.addActionListener(this);
        listitem5 = new ListElement("Images/listelement2.png", new Color(32,106,199), "AD5: ART & CULTURE", 
    			"MORE INFORMATION", "02/01/2013", "location");
        listitem5.setSize(400,82);
        listitem5.addActionListener(this);
        listitem6 = new ListElement("Images/listelement3.png", new Color(224,21,65), "AD6: LIVE MUSIC", 
    			"MORE INFORMATION", "03/01/2013", "location");
        listitem6.setSize(400,82);
        listitem6.addActionListener(this);
        
        
        listitems = new JPanel();
        listitems.setBackground(c);
        
        listitems.setLayout(new GridLayout(6,0));
        
      
        listitems.add(listitem1);
        //listitem1.setLocation(0, 0*82);
        listitems.add(listitem2);
       // listitem2.setLocation(0,1*82);
        listitems.add(listitem3);
       // listitem3.setLocation(0,2*82);
        listitems.add(listitem4);
       // listitem4.setLocation(0,3*82);
        listitems.add(listitem5);
       // listitem5.setLocation(0,4*82);
        listitems.add(listitem6);
       // listitem6.setLocation(0,5*82);
        listitems.setPreferredSize(new Dimension(400,492));
        
        
        
        listofads = new JScrollPane();
        listofads.setSize(420,225);

        listofads.setViewportView(listitems);
        listofads.addMouseListener(this);
		listofads.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        listofads.createVerticalScrollBar();
        listofads.setLocation(575,55);
        listofads.setFocusable(true);
        listofads.setBackground(null);
        listofads.setBorder(null);
        //listofads.validate();
        addetails.add(listofads);
        
        
        admore = new JButton();
        admore.setLocation(900,10);
        admore.setSize(100,30);
        admore.setText("Expand");
        admore.addActionListener(this);
        //addetails.add(admore);
        
        collapseexpand = new CustomButton();
        collapseexpand.customImageButton("Images/expand.png");
        collapseexpand.setSize(40,40);
        collapseexpand.setLocation(957,7);
        collapseexpand.addActionListener(this);
        addetails.add(collapseexpand);
        
        
        
        fulladinfo = new JPanel();
        fulladinfo.setLayout(null);
        fulladinfo.setBackground(c);
        fulladinfo.setPreferredSize(new Dimension(535,700));
               
        selectedadinfo = new JTextArea();
        selectedadinfo.setText("Some Text.");
        selectedadinfo.setLocation(0,10);
        selectedadinfo.setSize(535,50);
        selectedadinfo.setBackground(null);
        selectedadinfo.setForeground(Color.white);
        selectedadinfo.setFont(font3);
        selectedadinfo.setLineWrap(true);
        selectedadinfo.setCaretPosition(0);
        selectedadinfo.setEditable(false);
        fulladinfo.add(selectedadinfo);
        
        fulladimage1 = new ImagePanel("Images/fulladinfoimage1.png"); //currently these two images just allow for 
        fulladimage1.setSize(535,200);						   //a different image to be displayed. Will add a 
        fulladimage1.setLocation(0, 80);					   //function to alter the content of an imagepanel 
        fulladinfo.add(fulladimage1);						   //in next iteration.
        
        fulladimage2 = new ImagePanel("Images/fulladinfoimage2.png");
        fulladimage2.setSize(535,200);
        fulladimage2.setLocation(0, 80);
        fulladimage2.setVisible(false);
        fulladinfo.add(fulladimage2);
        
        
        selectedadinfo1 = new JTextArea();
        selectedadinfo1.setText("Some More Text.");
        selectedadinfo1.setLocation(0,300);
        selectedadinfo1.setSize(535,50);
        selectedadinfo1.setBackground(null);
        selectedadinfo1.setForeground(Color.white);
        selectedadinfo1.setFont(font3);
        selectedadinfo1.setLineWrap(true);
        selectedadinfo1.setCaretPosition(0);
        selectedadinfo1.setEditable(false);
        fulladinfo.add(selectedadinfo1);
        
        adinfoscroller = new JScrollPane(fulladinfo);
       // adinfoscroller.setViewportView(selectedadinfo);
        adinfoscroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        adinfoscroller.createVerticalScrollBar();
        adinfoscroller.setSize(555,500);
        adinfoscroller.setLocation(10,110);
        adinfoscroller.setBackground(null);       
        adinfoscroller.setVisible(false);
        addetails.add(adinfoscroller);
        
        //addetails.add(selectedadinfo);
        
        fullGUI.add(addetails);

        
        
	    fullGUI.add(background);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    fullGUI.setBackground(white);
	    fullGUI.setOpaque(true);
        return fullGUI;
	   
	  }

	  public void update(Graphics g) { 
	    	
	        paint(g);  
	    } 
	  
	  public void paint(Graphics g) {  //not used in this iteration
          
	        int width  = getWidth();  
	        int height = getHeight(); 
	        
	          
	        if (offScreenImage == null) {  
	            offScreenImage    = createImage(width, height);  
	            offScreenGraphics = offScreenImage.getGraphics();  
	        } 
	        
	        ((Graphics2D) g).setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
	                RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
	        ((Graphics2D) g).setRenderingHint(RenderingHints.KEY_RENDERING,
	                RenderingHints.VALUE_RENDER_QUALITY);
	          
	        // clear the off screen image  
	        offScreenGraphics.clearRect(0, 0, width + 1, height + 1);  
	          
	        // draw your image off screen  
	        offScreenGraphics.drawImage(test, 0, 0, this);  
	          
	        // show the off screen image  
	        g.drawImage(offScreenImage, 0, 0, this); 
	          
	    }
	  
	  public void moveImage() {  //not used in this iteration.
          
	    	for ( int i = 1 ; i < 50 ; i++ ){              
	                
	    			if (xbb <= 500){
	            	xbb += ((1 + 1/i)^i);  
	            	repaint();  
	            	// then sleep for a bit for your animation  
	            	try { Thread.sleep(10); }   /* this will pause for 50 milliseconds */  
	            	catch (InterruptedException e) { System.err.println("sleep exception"); }
	            } }            
	    }
	  
	  public void actionPerformed(ActionEvent event)
	  {
	    Object source = event.getSource();
	    //System.out.println(source);
	    if (source == listitem1)
	    { 
	        adinfoscroller.setVisible(true);
	    	collapseexpand.customImageButton("Images/collapse.png");
			buttonbar.setLocation(0,80);
			addetails.setLocation(0,136);
			addetails.setSize(1017,600);
			admore.setText("Collapse");
			slideshow.setVisible(false);
			winexpand = 1;
			listofads.setSize(420,495);
			listofads.revalidate();
			adinfoscroller.setVisible(true);
			adinfoscroller.setSize(555, 435);
			selectedadinfo.setText("Some Text.");
			selectedadinfo1.setText("Some More Text.");
			fulladimage1.setVisible(true);
			fulladimage2.setVisible(false);
	        repaint();

			}
	    if (source == listitem2)
	    { 
	        adinfoscroller.setVisible(true);
	    	collapseexpand.customImageButton("Images/collapse.png");
			buttonbar.setLocation(0,80);
			addetails.setLocation(0,136);
			addetails.setSize(1017,600);
			admore.setText("Collapse");
			slideshow.setVisible(false);
			winexpand = 1;
			listofads.setSize(420,495);
			listofads.revalidate();
			adinfoscroller.setVisible(true);
			adinfoscroller.setSize(555, 435);
			selectedadinfo.setText("Other text about the second ad.");
			selectedadinfo1.setText("Some more text about the second ad.");
			fulladimage1.setImage("Images/yusu.png");
			fulladimage1.setVisible(false);
			fulladimage2.setVisible(true);
	        repaint();

			}
	    
	    if (source == button1)
	    {
	      adtitle.setText("YUSU");
	      adtitle2.setText("");
          info.setLocation(10,65);

	      info.setText("INFO ON ADVERT");
	      button1.setFade(false, 1);
	      button2.setFade(true, 2);
	      button3.setFade(true, 3);
	      button4.setFade(true, 4);
	      button5.setFade(true, 5);
	      button6.setFade(true, 6);
	      button7.setFade(true, 7);
	      button8.setFade(true, 8);
	      Color c = new Color (42,147,225);
	      addetails.setBackground(c);
	      adtitle.setBackground(c);
	      adinfoscroller.setLocation(10,110);
			adinfoscroller.setSize(555, 435);

	        listitems.setBackground(c);
	        fulladinfo.setBackground(c);

	        listitems.repaint();
	      
	      
	    }
	    else if (source == button2) {
		  adtitle.setText("ARTS&");
	      adtitle2.setText("CULTURE");

	      info.setText("INFO ON ADVERT");
	        info.setLocation(10,130);

	      button1.setFade(true, 1);
	      button2.setFade(false, 2);
	      button3.setFade(true, 3);
	      button4.setFade(true, 4);
	      button5.setFade(true, 5);
	      button6.setFade(true, 6);
	      button7.setFade(true, 7);
	      button8.setFade(true, 8);
	      Color c = new Color (32,106,199);
	      addetails.setBackground(c);
	        adtitle.setBackground(c);
	        adinfoscroller.setLocation(10,175);
	        adinfoscroller.setSize(555,370);

	        //selectedadinfo.setBackground(c);
	        listitems.setBackground(new Color (32,106,199));
	        adinfoscroller.setBackground(c);
	        fulladinfo.setBackground(c);

	        listitems.repaint();
	        
	    }
	    else if (source == button3) {
	    	adtitle.setText("CLUBS&");
		      adtitle2.setText("BARS");
	    	
	    	info.setText("INFO ON ADVERT");
	        info.setLocation(10,130);

		  button1.setFade(true, 1);
	      button2.setFade(true, 2);
	      button3.setFade(false, 3);
	      button4.setFade(true, 4);
	      button5.setFade(true, 5);
	      button6.setFade(true, 6);
	      button7.setFade(true, 7);
	      button8.setFade(true, 8);
	      Color c = new Color (171,60,220);
	      addetails.setBackground(c);
	        adtitle.setBackground(c);
	        adinfoscroller.setLocation(10,175);
		       // selectedadinfo.setBackground(c);
	        fulladinfo.setBackground(c);

		        listitems.setBackground(c);



		    }
	    else if (source == button4) {
	    	adtitle.setText("FOOD&");
		      adtitle2.setText("DRINK");
		  info.setText("INFO ON ADVERT");
	        info.setLocation(10,130);

		  button1.setFade(true, 1);
	      button2.setFade(true, 2);
	      button3.setFade(true, 3);
	      button4.setFade(false, 4);
	      button5.setFade(true, 5);
	      button6.setFade(true, 6);
	      button7.setFade(true, 7);
	      button8.setFade(true, 8);
	      Color c = new Color (219,11,140);
	      addetails.setBackground(c);
	        adtitle.setBackground(c);
	        adinfoscroller.setLocation(10,175);
		       // selectedadinfo.setBackground(c);
		        listitems.setBackground(c);
		        fulladinfo.setBackground(c);





		     }
		else if (source == button5) {
			adtitle.setText("LIVE");
		      adtitle2.setText("MUSIC");
		  info.setText("INFO ON ADVERT");
	        info.setLocation(10,130);

		  button1.setFade(true, 1);
	      button2.setFade(true, 2);
	      button3.setFade(true, 3);
	      button4.setFade(true, 4);
	      button5.setFade(false, 5);
	      button6.setFade(true, 6);
	      button7.setFade(true, 7);
	      button8.setFade(true, 8);
	      Color c = new Color (224,21,65);
	      addetails.setBackground(c);
	        adtitle.setBackground(c);
	        adinfoscroller.setLocation(10,175);
		       // selectedadinfo.setBackground(c);
		        listitems.setBackground(c);
		        fulladinfo.setBackground(c);





			}
		 else if (source == button6) {
			 adtitle.setText("SPORTS&");
		      adtitle2.setText("LEISURE");
	      info.setText("INFO ON ADVERT");
	        info.setLocation(10,130);

	      button1.setFade(true, 1);
	      button2.setFade(true, 2);
	      button3.setFade(true, 3);
	      button4.setFade(true, 4);
	      button5.setFade(true, 5);
	      button6.setFade(false, 6);
	      button7.setFade(true, 7);
	      button8.setFade(true, 8);
	      Color c = new Color (231,134,0);
	      addetails.setBackground(c);
	        adtitle.setBackground(c);
	        adinfoscroller.setLocation(10,175);
		       // selectedadinfo.setBackground(c);
		        listitems.setBackground(c);
		        fulladinfo.setBackground(c);





		    }
		 else if (source == button7) {
			 adtitle.setText("RETAIL");
		      adtitle2.setText("");
	      info.setText("INFO ON ADVERT");
	        info.setLocation(10,130);

	      button1.setFade(true, 1);
	      button2.setFade(true, 2);
	      button3.setFade(true, 3);
	      button4.setFade(true, 4);
	      button5.setFade(true, 5);
	      button6.setFade(true, 6);
	      button7.setFade(false, 7);
	      button8.setFade(true, 8);
	      Color c = new Color (214,201,8);
	      addetails.setBackground(c);
	        adtitle.setBackground(c);
	        adinfoscroller.setLocation(10,175);
		       // selectedadinfo.setBackground(c);
		        listitems.setBackground(c);
		        fulladinfo.setBackground(c);





			}
		 else if (source == button8) {
			 adtitle.setText("TAXIS&");
		      adtitle2.setText("TRANSPORT");
		  info.setText("INFO ON ADVERT");
	        info.setLocation(10,130);

		  button1.setFade(true, 1);
	      button2.setFade(true, 2);
	      button3.setFade(true, 3);
	      button4.setFade(true, 4);
	      button5.setFade(true, 5);
	      button6.setFade(true, 6);
	      button7.setFade(true, 7);
	      button8.setFade(false, 8);
	      Color c = new Color (146,199,32);
	      addetails.setBackground(c);
	        adtitle.setBackground(c);
	        adinfoscroller.setLocation(10,175);
		       // selectedadinfo.setBackground(c);
		        listitems.setBackground(c);
		        fulladinfo.setBackground(c);
	      
		    }
		 else if (source == collapseexpand) {
		  
			if (winexpand == 0){ 
		        adinfoscroller.setVisible(true);
		    	collapseexpand.customImageButton("Images/collapse.png");
				buttonbar.setLocation(0,80);
				addetails.setLocation(0,136);
				addetails.setSize(1017,600);
				admore.setText("Collapse");
				slideshow.setVisible(false);
				winexpand = 1;
				listofads.setSize(420,495);
				listofads.revalidate();
				adinfoscroller.setVisible(true);
				adinfoscroller.setSize(555, 435);
		        repaint();

				}
			
			else if (winexpand == 1){
				buttonbar.setLocation(0,344);
				addetails.setLocation(0,400);
				addetails.setSize(1017,300);
		        collapseexpand.customImageButton("Images/expand.png");

				slideshow.setVisible(true);
				listofads.setSize(new Dimension(420,225));
				listofads.revalidate();
				//adinfoscroller.setSize(550, 130);
				adinfoscroller.setVisible(false);

				repaint();

				winexpand = 0;	
			}
		 	}
	  }
	  
	  private static void createAndShowGUI() {

	        JFrame.setDefaultLookAndFeelDecorated(true);
	        JFrame frame = new JFrame("What's On?");

	        //Create and set up the content pane.
	        MainWindow demo = new MainWindow();
	        frame.setContentPane(demo.createContentPane());

	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame.setSize(1017, 722);
	        frame.setResizable(false);
	        frame.setVisible(true);
	    }

	    public static void main(String[] args) {
	        //Schedule a job for the event-dispatching thread:
	        //creating and showing this application's GUI.
	        SwingUtilities.invokeLater(new Runnable() {
	            public void run() {
	                createAndShowGUI();
	            }
	        });
	    }

		@Override
		public void mouseClicked(MouseEvent event) {
			if (event.getSource() == listofads){
			System.out.println("EXPAND");
				
				
			}
		}

		@Override
		public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		
	}

