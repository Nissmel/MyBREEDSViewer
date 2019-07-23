package myView;

import java.sql.*;

public class View extends Window{

	public static void connect(String URL, String user, String password, String query, String breed_name)
	{
		try {
			Connection myConn = DriverManager.getConnection(URL, user, password);
			
			Statement myStmt = myConn.createStatement();
			
			ResultSet myRs = myStmt.executeQuery(query);
			
			while(myRs.next())
			{
				System.out.println(myRs.getString(breed_name));
	
			}
			
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
	}


}
