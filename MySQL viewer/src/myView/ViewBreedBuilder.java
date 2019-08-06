package myView;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

public class ViewBreedBuilder extends Window{
	
	private static JPanel viewBreed;
	
	
	
	public static JPanel buildView(JLayeredPane layeredPane)
	{
		viewBreed = new JPanel();
		layeredPane.add(viewBreed, "name_410359924014670");
		viewBreed.setLayout(null);
		viewBreed.setVisible(false);
		viewBreed.setBackground(Color.WHITE);
		View.populateText();

		ImageIcon previous = new ImageIcon("src/images/previous.png");
		ImageIcon previousHover = new ImageIcon("src/images/previousHover.png");

		JButton prevBreed = new JButton(previous);
		prevBreed.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				prevBreed.setIcon(previousHover);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				prevBreed.setIcon(previous);
			}
		});
		prevBreed.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				View.changeBreed(false);
			}
		});
		prevBreed.setBounds(30, 300, previous.getIconHeight(), previous.getIconWidth());
		viewBreed.add(prevBreed);
		prevBreed.setRequestFocusEnabled(false);
		prevBreed.setOpaque(false);
		prevBreed.setContentAreaFilled(false);
		prevBreed.setBorderPainted(false);
		prevBreed.setFocusPainted(false);
		

		ImageIcon next = new ImageIcon("src/images/next.png");
		ImageIcon nextHover = new ImageIcon("src/images/nextHover.png");
		
		JButton nextBreed = new JButton(next);
		nextBreed.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				nextBreed.setIcon(nextHover);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				nextBreed.setIcon(next);
			}
		});
		nextBreed.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				View.changeBreed(true);
			}
		});
		nextBreed.setBounds(1140, 300, previous.getIconHeight(), previous.getIconWidth());
		viewBreed.add(nextBreed);
		nextBreed.setRequestFocusEnabled(false);
		nextBreed.setVisible(true);
		nextBreed.setOpaque(false);
		nextBreed.setContentAreaFilled(false);
		nextBreed.setBorderPainted(false);
		nextBreed.setFocusPainted(false);
		
		return viewBreed;
	}

}
