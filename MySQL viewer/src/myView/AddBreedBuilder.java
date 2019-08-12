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

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

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
	
	
	public static void sendToFTP(String fileName)
	{
		FTPClient client = new FTPClient();
		FileInputStream fis = null;

		try {
		    client.connect("serwer1978625.home.pl");
		    client.login("serwer1978625", MyBreed.getPassword());

		    fis = new FileInputStream(fileName);

		    client.storeFile(fileName, fis);
		    client.logout();
		} catch (IOException e) {
		    e.printStackTrace();
		} finally {
		    try {
		        if (fis != null) {
		            fis.close();
		        }
		        client.disconnect();
		    } catch (IOException e) {
		        e.printStackTrace();
		    }
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
					
					
					
					MyBreed.setAlterQuery("ALTER TABLE puppers ADD COLUMN `" + (DataBaseView.getColumnCount() + 1) + "` VARCHAR(" + userBreedInfo[0].length() + ")");
					
					DataBaseView.insert(URL, user, password, MyBreed.getAlterQuery());	

					for(int i =0;i<16;i++)
					{
						String userInfo = breedLabelsInfo[i].replace(" " , "");
						MyBreed.setColumnQuery("UPDATE puppers SET `" + (DataBaseView.getColumnCount() + 1) + "` = '" + userBreedInfo[i] + "' WHERE `1` = '" + userInfo + "';");
						
						MyBreed.setColumnQuery((MyBreed.getColumnQuery()).replace(":", ""));
						
						//DataBaseView.insert(URL, user, password, MyBreed.getColumnQuery());		
						
						textBreedOptions[i].setBorder(new LineBorder(Color.GREEN));
					}					
					
					
					

				     userImage = resize(userIcon, 900, 600).getImage(); 	
					 BufferedImage bimage = new BufferedImage(userImage.getWidth(null), userImage.getHeight(null), BufferedImage.TYPE_INT_RGB);
	
					    Graphics2D bGr = bimage.createGraphics();
					    bGr.drawImage(userImage, 0, 0, null);
					    bGr.dispose();
					    
					    try {
					        File outputfile = new File("C:\\Users\\Mariola\\git\\MySQL-viwer\\MySQL viewer\\src\\database_images\\"+userBreedInfo[0]+".jpg");
					        ImageIO.write(bimage, "png", outputfile);
					    } catch (IOException e1) {
					        
					    }
					    
					    sendToFTP("C:\\Users\\Mariola\\git\\MySQL-viwer\\MySQL viewer\\src\\database_images\\"+userBreedInfo[0]+".jpg");
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

	    
	    
		breedLabels = new JLabel[DataBaseView.breedInfo.length];

		for(int i=0; i<DataBaseView.breedInfo.length; i++) {
			breedLabels[i] = new JLabel(DataBaseView.breedInfo[i]);
		}
		
		textBreedOptions = new JTextField[DataBaseView.breedInfo.length];

		for(int i=0; i<DataBaseView.breedInfo.length; i++) {
			textBreedOptions[i] = new JTextField();
		}
		
		
		textBreedOptionsPlus = new JButton[DataBaseView.breedInfo.length];

		for(int i=0; i<DataBaseView.breedInfo.length; i++) {
			textBreedOptionsPlus[i] = new JButton("+");
		}
		
		textBreedOptionsMinus = new JButton[DataBaseView.breedInfo.length];

		for(int i=0; i<DataBaseView.breedInfo.length; i++) {
			textBreedOptionsMinus[i] = new JButton("-");
		}
		

		return addBreed;
	}
}
