package myView;

import java.awt.Color;

import javax.swing.JLayeredPane;
import javax.swing.JPanel;

public class AddBreedBuilder extends Window {

	private static JPanel addBreed;
	
	public static JPanel buildAdd(JLayeredPane layeredPane) 
	{
		
		addBreed = new JPanel();
		layeredPane.add(addBreed, "name_410359942089403");
		addBreed.setVisible(false);
		addBreed.setBackground(Color.WHITE);
		addBreed.setLayout(null);
		
		
		return addBreed;
	}
}
