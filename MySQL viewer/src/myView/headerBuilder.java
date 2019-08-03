package myView;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

public class headerBuilder extends Window{

	static JPanel header;
	public static JPanel buildHeader(JLayeredPane layeredPane)
	{
		
		
	    header = new JPanel();
		header.setBounds(0, 0, 1280, 80);
		frame.getContentPane().add(header);
		header.setLayout(null);
		
		JPanel darkGrey = new JPanel();
		darkGrey.setBackground(new Color(51, 51, 51));
		darkGrey.setBounds(0, 0, 387, 80);
		header.add(darkGrey);
		darkGrey.setLayout(null);
		
		JLabel txtpnChoose = new JLabel();
		txtpnChoose.setBounds(55, 11, 322, 57);
		darkGrey.add(txtpnChoose);
		txtpnChoose.setForeground(new Color(240, 240, 240));
		txtpnChoose.setFont(new Font("Verdana", Font.BOLD, 46));
		txtpnChoose.setText("Choose your");
		txtpnChoose.setBackground(null);	

		
		JPanel red = new JPanel();
		red.setBounds(397, 0, 888, 80);
		header.add(red);
		red.setBackground(new Color(204, 0, 0));
		red.setLayout(null);
		
		JLabel txtpnPuppy = new JLabel();
		txtpnPuppy.setBounds(5,11, 166, 57);
		txtpnPuppy.setForeground(new Color(240, 240, 240));
		txtpnPuppy.setFont(new Font("Verdana", Font.BOLD, 46));
		txtpnPuppy.setText("puppy");
		txtpnPuppy.setBackground(null);
		red.add(txtpnPuppy);
		
		
		
		return header;
	}
}
