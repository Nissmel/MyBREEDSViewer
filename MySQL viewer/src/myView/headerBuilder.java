package myView;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class headerBuilder extends Window{

	static JPanel header;
	public static JPanel buildHeader()
	{
		JPanel red = new JPanel();
		red.setBounds(400, 0, 888, 80);
		frame.getContentPane().add(red);
		red.setBackground(new Color(204, 0, 0));
		red.setLayout(null);
		
		JPanel darkGrey = new JPanel();
		darkGrey.setBounds(0, 0, 387, 80);
		frame.getContentPane().add(darkGrey);
		darkGrey.setBackground(new Color(51, 51, 51));
		darkGrey.setLayout(null);
		
		JLabel txtpnChoose = new JLabel();
		txtpnChoose.setForeground(new Color(240, 240, 240));
		txtpnChoose.setBounds(56, 11, 367, 63);
		txtpnChoose.setFont(new Font("Verdana", Font.BOLD, 46));
		txtpnChoose.setText("Choose your");
		txtpnChoose.setBackground(null);
		darkGrey.add(txtpnChoose);
		
		JLabel txtpnPuppy = new JLabel();
		txtpnPuppy.setBounds(5, 11, 166, 63);
		txtpnPuppy.setForeground(new Color(240, 240, 240));
		txtpnPuppy.setFont(new Font("Nunito-Bold", Font.BOLD, 46));
		txtpnPuppy.setText("puppy");
		txtpnPuppy.setBackground(null);
		red.add(txtpnPuppy);
		
		return header;
	}
}
