package myView;

import java.awt.EventQueue;
import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

import java.awt.Font;
import javax.swing.JLayeredPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.CardLayout;
import javax.swing.JLabel;
import javax.swing.JSpinner;

public class MyBreed  {

	static String [] breedLabelsInfo = new String[16];
	static String [] breedInfo = new String[43];

	static String URL = "jdbc:mysql://serwer1978625.home.pl/30826962_form_info";
	static String user = "30826962_form_info";
	static String password = "Rozamunda17*";	
	static String connectQuery = "select * from puppers";	
	static String columnQuery = "";
	static String insertQuery = "";


	

	public static String getInsertQuery() {
		return insertQuery;
	}


	public static void setInsertQuery(String insertQuery) {
		MyBreed.insertQuery = insertQuery;
	}


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
	

	public JFrame frame;
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
}
