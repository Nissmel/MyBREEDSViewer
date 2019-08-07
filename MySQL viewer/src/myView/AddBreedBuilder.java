package myView;

import java.awt.Color;
import java.awt.FileDialog;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;





public class AddBreedBuilder extends Window {

	private static JPanel addBreed;
	public static String [] userBreedInfo = new String[17];
	
	public static JButton finish;
	static ImageIcon userIcon;
	static JLabel userImagePreview;
	static String userImagePath;
	 public static Image userImage;
	public static double xImageSize;
	public static double yImageSize;
	public static Image resizedUserImage;
	
	public static double xImageSizeResized;
	public static double yImageSizeResized;

	public static void enableSendButton()
	{
		if(userImagePath!=null) 
			finish.setEnabled(true);
		else
			finish.setEnabled(false);
	}
	
	public static void resizeAndSet()
	{
		
	    xImageSize = userIcon.getIconWidth();
	    yImageSize = userIcon.getIconHeight();
	    
		if(xImageSize<yImageSize)
		{
			xImageSizeResized = xImageSize/(yImageSize/410);
			yImageSizeResized = 410;
		}
		
		else
		{
				yImageSizeResized = yImageSize/(xImageSize/560);
				xImageSizeResized = 560;
		}
		
		 resizedUserImage = userImage.getScaledInstance((int) xImageSizeResized, (int) yImageSizeResized, java.awt.Image.SCALE_SMOOTH); 
		 userIcon = new ImageIcon(resizedUserImage);
		 userImagePreview.setIcon(userIcon);
		
		System.out.println("Wymiary oryginalne: x" + (int) xImageSize +"   y"+(int) yImageSize+"\nWymiary po skalowaniu: x"+(int) xImageSizeResized+"   y"+ (int) yImageSizeResized);
	}
	
	public static JPanel buildAdd(JLayeredPane layeredPane) 
	{
		
		addBreed = new JPanel();
		layeredPane.add(addBreed, "name_410359942089403");
		addBreed.setVisible(false);
		addBreed.setBackground(Color.WHITE);
		addBreed.setLayout(null);
		
		finish = new JButton("Send puppy!");		
		finish.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				if(textBreedOptions[0].getText().contentEquals("") || textBreedOptions[0].getText() == null)
				{
					JOptionPane.showMessageDialog(null,
					          "Error: Please enter breed name to proceed", "Error Message",
					          JOptionPane.ERROR_MESSAGE);
				}
				else
				{
					userBreedInfo[16] = userImagePath;				
					userBreedInfo[0] =  textBreedOptions[0].getText();
					userBreedInfo[0] = userBreedInfo[0].substring(0, 1).toUpperCase() + userBreedInfo[0].substring(1);
					System.out.println(userBreedInfo[0]);
					
					for(int i=1;i<16;i++)
					{
						userBreedInfo[i] =  textBreedOptions[i].getText();
						System.out.println(userBreedInfo[i]);
					}
					
					System.out.println(userBreedInfo[16]);
	
					 BufferedImage bimage = new BufferedImage(userImage.getWidth(null), userImage.getHeight(null), BufferedImage.TYPE_INT_ARGB);
	
					    Graphics2D bGr = bimage.createGraphics();
					    bGr.drawImage(userImage, 0, 0, null);
					    bGr.dispose();
					    
					    try {
					        // retrieve image
					        BufferedImage bi = bimage;
					        File outputfile = new File("C:\\Users\\Mariola\\git\\MySQL-viwer\\MySQL viewer\\src\\database_images\\"+userBreedInfo[0]+".jpg");
					        ImageIO.write(bi, "png", outputfile);
					    } catch (IOException e1) {
					        
					    }
				}
				System.gc();
			}
		});
		finish.setForeground(Color.WHITE);
		finish.setBackground(new Color(51, 51, 51));
		finish.setFont(new Font("Verdana", Font.BOLD, 18));
		finish.setBounds(1050, 580, 180, 40);
		finish.setBorderPainted(false);
		finish.setRequestFocusEnabled(false);
		finish.setFocusPainted(false);
		finish.setEnabled(false);
		addBreed.add(finish);
		
	
		
		
		JButton uploadPhoto = new JButton("Choose photo file to upload...");
		uploadPhoto.setForeground(Color.WHITE);
		uploadPhoto.setBackground(new Color(51, 51, 51));
		uploadPhoto.setFont(new Font("Verdana", Font.BOLD, 18));
		uploadPhoto.setBounds(650, 580, 340, 40);
		uploadPhoto.setBorderPainted(false);
		uploadPhoto.setRequestFocusEnabled(false);
		uploadPhoto.setFocusPainted(false);
		uploadPhoto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FileDialog imageFinder = new FileDialog((Frame)null, "Select jpg file to open:");
				imageFinder.setFile("*.jpg; *.png; *.gif; *.jpeg");
			    imageFinder.setMode(FileDialog.LOAD);
			    imageFinder.setVisible(true);
			    userImagePath = new File(imageFinder.getDirectory()).getAbsolutePath()+"\\"+imageFinder.getFile();

			    userImagePath = userImagePath.replace("\\", "/");
			    
			    userIcon = new ImageIcon(userImagePath);
			    userImage = userIcon.getImage(); 
			    resizeAndSet();
			    enableSendButton();
			}
		});
		addBreed.add(uploadPhoto);
		
		userImagePreview= new JLabel();
		userImagePreview.setBounds(650, 145, 580, 410);
	    addBreed.add(userImagePreview);

	    
	    
		breedLabels = new JLabel[View.breedInfo.length];

		for(int i=0; i<View.breedInfo.length; i++) {
			breedLabels[i] = new JLabel(View.breedInfo[i]);
		}
		
		textBreedOptions = new JTextField[View.breedInfo.length];

		for(int i=0; i<View.breedInfo.length; i++) {
			textBreedOptions[i] = new JTextField();
		}
		
		
		textBreedOptionsPlus = new JButton[View.breedInfo.length];

		for(int i=0; i<View.breedInfo.length; i++) {
			textBreedOptionsPlus[i] = new JButton("+");
		}
		
		textBreedOptionsMinus = new JButton[View.breedInfo.length];

		for(int i=0; i<View.breedInfo.length; i++) {
			textBreedOptionsMinus[i] = new JButton("-");
		}
		

		return addBreed;
	}
}
