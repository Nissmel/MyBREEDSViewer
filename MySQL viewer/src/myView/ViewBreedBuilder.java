package myView;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import java.net.*;


public class ViewBreedBuilder extends MyBreed{
    
	public static ImageIcon loadServerImage()
	{		
		try {
			String imgURL = "http://chooseyourpuppy.pl/breeds/"+getBreedInfo()[0]+".jpg";
			imgURL = imgURL.replace(" ", "%20");
			BufferedImage img = ImageIO.read(new URL(imgURL));
			ImageIcon icon = new ImageIcon(img);
			icon = AddBreedBuilder.resize(icon, 450, 410);
			return icon;
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
			System.err.println();
			return null;		

		} catch (IOException e) {
			e.printStackTrace();
			System.err.println();
			return null;		
		}
	}

	
public static JPanel buildView(JLayeredPane layeredPane)
	{
		viewBreed = new JPanel();
		layeredPane.add(viewBreed, "name_410359924014670");
		viewBreed.setLayout(null);
		viewBreed.setVisible(false);
		viewBreed.setBackground(Color.WHITE);

		JLabel userImageDOG= new JLabel();
		userImageDOG.setBounds(650, 185, 450, 410);
		viewBreed.add(userImageDOG);
		
		DataBaseView.populateText();
		
		ImageIcon previousHover = new ImageIcon("src/images/previousHover.png");
		ImageIcon previous = new ImageIcon("src/images/previous.png");

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
				DataBaseView.changeBreed(false);
				userImageDOG.setIcon(loadServerImage());
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
				DataBaseView.changeBreed(true);
				userImageDOG.setIcon(loadServerImage());
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
		

		for(int i=0; i<16; i++) {
			getBreedLabels()[i] = new JLabel(getBreedInfo()[i]);
		}
		
		for(int i=0; i<16; i++) {
			getTextLabels()[i] = new JLabel(getBreedInfo()[i]);
		}		
		
		return viewBreed;
	}

}
