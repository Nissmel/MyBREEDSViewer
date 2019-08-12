package myView;

import java.awt.EventQueue;
import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLayeredPane;
import java.awt.CardLayout;
import javax.swing.JLabel;

public class MyBreed  {

	static String [] breedLabelsInfo = new String[16];
	static String [] breedInfo = new String[43];

	static String URL = "jdbc:mysql://serwer1978625.home.pl/30826962_form_info";
	
	static String user = "30826962_form_info";
	static String password = "Rozamunda17*";	
	static String connectQuery = "select * from puppers";	
	static String columnQuery = "";
	static String alterQuery = "";
	
	


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyBreed window = new MyBreed();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});				
	}


	public MyBreed() {
		initialize();	

		DataBaseView.connect(URL, user, password, connectQuery);
	}
	

	JFrame frame;
	public static JPanel addBreed, viewBreed, menu, header;

	public static JLabel[] textLabels;
	public static JLabel[] breedLabels;
	
	public static JTextField[] textBreedOptions;
	public static JButton[] textBreedOptionsPlus;
	public static JButton[] textBreedOptionsMinus;

private  void initialize() {
	
		final int WIDTH = 1280, HEIGHT = 720;
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.getContentPane().setLayout(null);
		

		frame.setBounds(100, 100, WIDTH, HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("MyBREEDS Viewer");
		frame.setResizable(false);
		frame.setVisible(true);

		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(0, 0, WIDTH, HEIGHT);
		frame.getContentPane().add(layeredPane);
		layeredPane.setLayout(new CardLayout(0, 0));
		
		HeaderBuilder.buildHeader(layeredPane);		

		MenuBuilder.buildMenu(layeredPane);		
	
		ViewBreedBuilder.buildView(layeredPane);
		
		AddBreedBuilder.buildAdd(layeredPane);
		
	}
	
	
	public static String getURL() {
		return URL;
	}
	
	public static String getConnectQuery() {
		return connectQuery;
	}
	
	public static String getUser() {
		return user;
	}
	
	public static String getPassword() {
		return password;
	}
	
	public static String getColumnQuery() {
		return columnQuery;
	}
	
	public static void setColumnQuery(String columnQuery) {
		MyBreed.columnQuery = columnQuery;
	}
	
	public static String getAlterQuery() {
		return alterQuery;
	}
	
	public static void setAlterQuery(String insertQuery) {
		MyBreed.alterQuery = insertQuery;
	}

}