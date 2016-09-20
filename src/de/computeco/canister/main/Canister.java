package de.computeco.canister.main;

import java.io.IOException;
import java.net.URISyntaxException;

import javax.swing.*;

import de.computeco.canister.gui.*;

public class Canister {

	public static void main(String[] args) {
		
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	
				try {
					MainGUI.createAndShowGUI();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        });

	}

}
