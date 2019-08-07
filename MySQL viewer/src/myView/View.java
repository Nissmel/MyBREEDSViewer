package myView;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;



public class View extends Window{
	
	static int currentBreed = 2;
	static int count = 1;
	public static int columnCount; 
	

	public static void connect(String URL, String user, String password, String query)
	{
		
		try {
			Connection myConn = DriverManager.getConnection(URL, user, password);
			
			Statement myStmt = myConn.createStatement();
			
			ResultSet myRs = myStmt.executeQuery(query);
			
			ResultSetMetaData metadata = myRs.getMetaData();
			columnCount = metadata.getColumnCount();

			
			count =0;
			while(myRs.next())
			{
				breedInfo[count]=(myRs.getString(Integer.toString(currentBreed)));	
				setBreed();
				count++;
			}
			
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
	}

	
	public static void setBreed()
	{
		for(int i=0; i<columnCount-1;i++) {
			breedLabels[i].setText(breedInfo[i]);
			breedLabels[i].setBounds(500,100+i*30,300, 100);
			breedLabels[i].setFont(new Font("Verdana", Font.PLAIN, 20));
			viewBreed.add(breedLabels[i]);
		}
	}
	
	public static void setField()
	{
		for(int i=0; i<columnCount-1;i++) {
			int z=i;
			
			textBreedOptionsMinus[i].setBounds(385,145+i*30,40, 25);
			textBreedOptionsMinus[i].setForeground(Color.WHITE);
			textBreedOptionsMinus[i].setBackground(new Color(51, 51, 51));
			textBreedOptionsMinus[i].setFont(new Font("Verdana", Font.PLAIN, 7));
			textBreedOptionsMinus[i].setRequestFocusEnabled(false);
			textBreedOptionsMinus[i].setFocusPainted(false);
			textBreedOptionsMinus[i].addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					int  text = Integer.valueOf(textBreedOptions[z].getText())-1;
					if(text > 0)
						textBreedOptions[z].setText(Integer.toString (text));		
				}
			});
			addBreed.add(textBreedOptionsMinus[i]);
			
			
			textBreedOptionsPlus[i].setBounds(535,145+i*30,40, 25);
			textBreedOptionsPlus[i].setForeground(Color.WHITE);
			textBreedOptionsPlus[i].setBackground(new Color(51, 51, 51));
			textBreedOptionsPlus[i].setFont(new Font("Verdana", Font.PLAIN, 7));
			textBreedOptionsPlus[i].setBorderPainted(false);
			textBreedOptionsPlus[i].setRequestFocusEnabled(false);
			textBreedOptionsPlus[i].setFocusPainted(false);
			textBreedOptionsPlus[i].addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					int  text = Integer.valueOf(textBreedOptions[z].getText())+1;
					if(text < 6)
						textBreedOptions[z].setText(Integer.toString (text));		
				}
			});
			addBreed.add(textBreedOptionsPlus[i]);
			
			
			textBreedOptions[i].setBounds(430,145+i*30,100, 25);
			textBreedOptions[i].setHorizontalAlignment(JTextField.CENTER);
			textBreedOptions[i].setText("1");
			textBreedOptions[i].setBorder(new LineBorder(Color.RED));
			textBreedOptions[i].setFont(new Font("Verdana", Font.PLAIN, 20));
			addBreed.add(textBreedOptions[i]);

		}
		textBreedOptions[0].setFont(new Font("Verdana", Font.PLAIN, 16));
		textBreedOptionsMinus[0].setVisible(false);
		textBreedOptionsPlus[0].setVisible(false);
		textBreedOptions[0].setBounds(385,145,190, 25);
		textBreedOptions[0].setText("");	    
	}
	
	public static void setText(String which)
	{
		for(int i=0; i<16;i++) {
			textLabels[i].setText(breedLabelsInfo[i]);
			textLabels[i].setFont(new Font("Verdana", Font.PLAIN, 20));
			textLabels[i].setBounds(100,100+i*30,300, 100);
			
			if(which.equals("viewBreed"))
			{
				textLabels[i].setBounds(200,100+i*30,300, 100);
				viewBreed.add(textLabels[i]);
			}
				
			if(which.equals("addBreed"))
			{				
				addBreed.add(textLabels[i]);
			}
		}
	}
	

	
	
	public static void changeBreed(boolean change)
	{
		if(change)
		{
			if(currentBreed<columnCount)
				currentBreed++;
		}
		
		if(!change)
		{
			if(currentBreed>2)
				currentBreed--;
		}
		
		connect(URL, user, password, query);
	}
	
	public static void populateText()
	{
		breedLabelsInfo[0]="Breed name:";
		breedLabelsInfo[1]="Weight:";
		breedLabelsInfo[2]="Life Span:";
		breedLabelsInfo[3]="Size:";
		breedLabelsInfo[4]="Popularity:";
		breedLabelsInfo[5]="Intelligence";
		breedLabelsInfo[6]="Sensitivity Level:";
		breedLabelsInfo[7]="Easy To Groom:";
		breedLabelsInfo[8]="Drooling Potential:";
		breedLabelsInfo[9]="General Health:";
		breedLabelsInfo[10]="Tolerates Being Alone:";
		breedLabelsInfo[11]="Easy To Train:";
		breedLabelsInfo[12]="Prey Drive:";
		breedLabelsInfo[13]="Wanderlust Potential:";
		breedLabelsInfo[14]="Tendency To Bark:";
		breedLabelsInfo[15]="Potentail For Mouthiness:";
	}


}
