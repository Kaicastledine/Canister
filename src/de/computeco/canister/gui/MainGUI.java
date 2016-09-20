package de.computeco.canister.gui;

import javax.imageio.ImageIO;
import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.Base64;

public class MainGUI extends JPanel
implements ActionListener {
	protected JButton b1, b2, b3;

	public MainGUI() throws IOException {
		
		//String base64 = "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";
		
		//byte[] btDataFile = (Base64.getDecoder()).decode(base64);
		//BufferedImage iconGif = ImageIO.read(new ByteArrayInputStream(btDataFile));
		//JLabel windowIcon = new JLabel(new ImageIcon(iconGif));

		b1 = new JButton("Add Sample");
		b1.setVerticalTextPosition(AbstractButton.CENTER);
		b1.setHorizontalTextPosition(AbstractButton.LEADING); //aka LEFT, for left-to-right locales
		b1.setMnemonic(KeyEvent.VK_D);
		b1.setActionCommand("add");

		b2 = new JButton("Extract Sample");
		b2.setVerticalTextPosition(AbstractButton.BOTTOM);
		b2.setHorizontalTextPosition(AbstractButton.CENTER);
		b2.setMnemonic(KeyEvent.VK_M);
		b2.setActionCommand("extract");

		b3 = new JButton("Remove Sample");
		//Use the default text position of CENTER, TRAILING (RIGHT).
		b3.setMnemonic(KeyEvent.VK_E);
		b3.setActionCommand("remove");

		//Listen for actions on buttons 1 and 3.
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);

		b1.setToolTipText("Click this button to add a sample to your canister.");
		b2.setToolTipText("Click this button to pull a safe version of a sample out of your canister.");
		b3.setToolTipText("Click this button to delete a specific sample from your canister.");

		//Add Components to this container, using the default FlowLayout.
		//add(windowIcon);
		add(b1);
		add(b2);
		add(b3);
		setLayout(new GridLayout(3,1));
		setPreferredSize(new Dimension(100, 200));
		
	}

	public void actionPerformed(ActionEvent e) {
		if ("add".equals(e.getActionCommand())) {
			
		} else if("extract".equals(e.getActionCommand())) {
			
		} else if("remove".equals(e.getActionCommand())) {
			
		}
	}

	/** Returns an ImageIcon, or null if the path was invalid. 
	protected static ImageIcon createImageIcon(String path) {
		java.net.URL imgURL = MainGUI.class.getResource(path);
		if (imgURL != null) {
			return new ImageIcon(imgURL);
		} else {
			System.err.println("Couldn't find file: " + path);
			return null;
		}
	}*/
	
	public static void createAndShowGUI() throws IOException {

		try {
	            // Set System L&F
	        UIManager.setLookAndFeel(
            UIManager.getSystemLookAndFeelClassName());
	    } 
	    catch (UnsupportedLookAndFeelException e) {
	       // handle exception
	    }
	    catch (ClassNotFoundException e) {
	       // handle exception
	    }
	    catch (InstantiationException e) {
	       // handle exception
	    }
	    catch (IllegalAccessException e) {
	       // handle exception
	    }
		
        //Create and set up the window.
        JFrame frame = new JFrame("Canister");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Create and set up the content pane.
        MainGUI newContentPane = new MainGUI();
        newContentPane.setOpaque(false); //content panes must be opaque
        frame.setContentPane(newContentPane);

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }
}