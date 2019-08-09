package myView;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

public class HeaderBuilder extends MyBreed{

	public static  JPanel buildHeader(JLayeredPane layeredPane)
	{
	    header = new JPanel();
		layeredPane.add(header, "name_410359960271086");
		header.setBounds(0, 0, 1280, 80);
		header.setLayout(null);
	
		JButton btnMenu = new JButton("Back to menu");
		btnMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane.removeAll();
				layeredPane.add(menu);
				menu.add(header);				
				layeredPane.repaint();
				layeredPane.revalidate();
			}
		});
		btnMenu.setForeground(Color.WHITE);
		btnMenu.setBackground(new Color(51, 51, 51));
		btnMenu.setFont(new Font("Verdana", Font.BOLD, 18));
		btnMenu.setBounds(1050, 20, 180, 40);
		btnMenu.setBorderPainted(false);
		btnMenu.setRequestFocusEnabled(false);
		btnMenu.setFocusPainted(false);
		header.add(btnMenu);
		
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
