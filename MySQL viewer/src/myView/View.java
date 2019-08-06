package myView;

import java.awt.Font;
import java.sql.*;



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
			breedLabels[i].setBounds(600,100+i*30,300, 100);
			breedLabels[i].setFont(new Font("Verdana", Font.PLAIN, 20));
			viewBreed.add(breedLabels[i]);
		}
	}
	
	public static void setText()
	{
		for(int i=0; i<16;i++) {
			textLabels[i].setText(breedLabelsInfo[i]);
			textLabels[i].setBounds(300,100+i*30,300, 100);
			textLabels[i].setFont(new Font("Verdana", Font.PLAIN, 20));
			viewBreed.add(textLabels[i]);
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
