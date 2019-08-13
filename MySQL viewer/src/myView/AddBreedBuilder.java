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
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;

public class AddBreedBuilder extends MyBreed {

	
    static JButton finish;
	static ImageIcon userIcon;
	static JLabel userImagePreview;
	static String userImagePath;
	
    static Image userImage;


	public static void enableSendButton(String path)
	{
		if(path!=null) 
			finish.setEnabled(true);
		else
			finish.setEnabled(false);
	}
	
	
	public static ImageIcon resize(ImageIcon resIco, int width, int height)
	{
	    Image resImg = resIco.getImage(); 

		double xImageSize = resIco.getIconWidth();
	    double yImageSize = resIco.getIconHeight();
	    
	    double xImageSizeResized, yImageSizeResized;
	    
		if(xImageSize<yImageSize)
		{
			xImageSizeResized = xImageSize/(yImageSize/height);
			yImageSizeResized = height;
		}
		
		else
		{
				yImageSizeResized = yImageSize/(xImageSize/width);
				xImageSizeResized = width;
		}
		
		 resImg = resImg.getScaledInstance((int) xImageSizeResized, (int) yImageSizeResized, java.awt.Image.SCALE_SMOOTH); 
		 resIco = new ImageIcon(resImg);
		 
		// System.out.println("Orginal resolution: x" + (int) xImageSize +"   y"+(int) yImageSize+"\nResolutionafter resize: x"+(int) xImageSizeResized+"   y"+ (int) yImageSizeResized);

		return resIco;
	}
	
	
	public static void sendToFTP(String fileName, String name)
	{
		FTPClient client = new FTPClient();
				
		name = name +".jpg";

	        try {
	  		  	FileInputStream fis = new FileInputStream(new File(fileName));

	            client.connect("serwer1978625.home.pl");
	            client.login("nissmel@chooseyourpuppy.pl", MyBreed.getPassword());
	            client.setFileType(FTP.BINARY_FILE_TYPE);

	            
	            client.storeFile(fileName, fis);
	            client.rename(fileName, name);
	            client.logout();
	        } catch (IOException e) {e.printStackTrace();} 
	        finally 
	        {
	            try{client.disconnect();} catch (IOException e) {e.printStackTrace();}
	        }
	}

	
	
	public static JPanel buildAdd(JLayeredPane layeredPane) 
	{
		String [] userBreedInfo = new String[17];
		
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
					
					for(int i=1;i<16;i++)
					{
						userBreedInfo[i] =  textBreedOptions[i].getText();
					}
					
					String [] queryToSave = new String [17];
					
					queryToSave[0] = "ALTER TABLE puppers ADD COLUMN `" + (DataBaseView.getColumnCount() + 1) + "` VARCHAR(" + userBreedInfo[0].length() + ");";				

					for(int i =0;i<16;i++)
					{
						String userInfo = breedLabelsInfo[i].replace(" " , "");
						
						queryToSave[i+1] = "UPDATE puppers SET `" + (DataBaseView.getColumnCount() + 1) + "` = '" + userBreedInfo[i] + "' WHERE `1` = '" + userInfo + "';";
						queryToSave[i+1] = queryToSave[i+1].replace(":", "");
					}					
					
					//DataBaseView.insert(getURL(),getUser(), getPassword(), queryToSave);		

					

				     userImage = resize(userIcon, 900, 600).getImage(); 	
					 BufferedImage bimage = new BufferedImage(userImage.getWidth(null), userImage.getHeight(null), BufferedImage.TYPE_INT_RGB);
	
					    Graphics2D bGr = bimage.createGraphics();
					    bGr.drawImage(userImage, 0, 0, null);
					    bGr.dispose();
					    
					    try {
					        File outputfile = new File("C:\\Users\\Mariola\\git\\MySQL-viwer\\MySQL viewer\\src\\database_images\\"+userBreedInfo[0]+".jpg");
					        ImageIO.write(bimage, "png", outputfile);
					    } catch (IOException exc) {
					    	exc.printStackTrace();
					    }
					    
				        
				        String imgPath = "C:\\Users\\Mariola\\git\\MySQL-viwer\\MySQL viewer\\src\\database_images\\"+userBreedInfo[0]+".jpg";
					    
					    sendToFTP(imgPath, userBreedInfo[0]);
				}
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

			    userImagePath = userImagePath.replace("/", "\\");
			    
			    userIcon = new ImageIcon(userImagePath);
			    
			    userIcon = resize(userIcon, 580, 410);
				userImagePreview.setIcon(userIcon);	
				 
				 enableSendButton(userImagePath);
			}
		});
		addBreed.add(uploadPhoto);
		
		userImagePreview= new JLabel();
		userImagePreview.setBounds(650, 145, 580, 410);
	    addBreed.add(userImagePreview);

	    
	    
		breedLabels = new JLabel[getBreedInfo().length];

		for(int i=0; i<getBreedInfo().length; i++) {
			breedLabels[i] = new JLabel(getBreedInfo()[i]);
		}
		
		textBreedOptions = new JTextField[getBreedInfo().length];

		for(int i=0; i<getBreedInfo().length; i++) {
			textBreedOptions[i] = new JTextField();
		}
		
		
		textBreedOptionsPlus = new JButton[getBreedInfo().length];

		for(int i=0; i<getBreedInfo().length; i++) {
			textBreedOptionsPlus[i] = new JButton("+");
		}
		
		textBreedOptionsMinus = new JButton[getBreedInfo().length];

		for(int i=0; i<getBreedInfo().length; i++) {
			textBreedOptionsMinus[i] = new JButton("-");
		}
		

		return addBreed;
	}
}
