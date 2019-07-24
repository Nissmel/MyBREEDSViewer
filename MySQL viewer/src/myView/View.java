package myView;

import java.sql.*;

import com.mysql.cj.util.TestUtils;


public class View extends Window{
	
	static int currentBreed = 2;
	static int count = 1;
	

	public static void connect(String URL, String user, String password, String query)
	{
		populateText();
		try {
			Connection myConn = DriverManager.getConnection(URL, user, password);
			
			Statement myStmt = myConn.createStatement();
			
			ResultSet myRs = myStmt.executeQuery(query);
			
			count =0;
			while(myRs.next())
			{
				breedInfo[count]=(myRs.getString(Integer.toString(currentBreed)));	
				Window.setBreed();
				count++;
			}
			
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
	}
	
	public static void changeBreed(boolean change)
	{
		if(change)
		{
			if(currentBreed<17)
				currentBreed++;
		}
		
		if(!change)
		{
			if(currentBreed>1)
				currentBreed--;
		}
		
		connect(URL, user, password, query);
		
		for(int i=0;i<16;i++)
		{
			//System.out.println(breedInfo[i]);	
		}
	}
	
	public static void populateText()
	{
		text[0]="Breed name:";
		text[1]="Weight:";
		text[2]="Life Span:";
		text[3]="Size:";
		text[4]="Popularity:";
		text[5]="Intelligence";
		text[6]="Sensitivity Level:";
		text[7]="Easy To Groom:";
		text[8]="Drooling Potential:";
		text[9]="General Health:";
		text[10]="Tolerates Being Alone:";
		text[11]="Easy To Train:";
		text[12]="Prey Drive:";
		text[13]="Wanderlust Potential:";
		text[14]="Tendency To Bark:";
		text[15]="Potentail For Mouthiness:";
	}


}
