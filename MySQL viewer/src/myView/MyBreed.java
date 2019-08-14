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
	static String [] breedInfo = new String[250];

	final static  String URL = "jdbc:mysql://serwer1978625.home.pl/30826962_form_info";
	
	final static String USER = "30826962_form_info";
	final static String PASSWORD = "Rozamunda17*";	
	final static String CONNECTQUERY = "select * from puppers";		

	
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

		DataBaseView.connect(URL, USER, PASSWORD, CONNECTQUERY);
	}
	

	JFrame frame;
	static JPanel addBreed, viewBreed, menu, header;

	static JLabel[] textLabels = new JLabel[16];
	static JLabel[] breedLabels = new JLabel[16];

	static JTextField[] textBreedOptions;
	static JButton[] textBreedOptionsPlus;
	static JButton[] textBreedOptionsMinus;

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
		return CONNECTQUERY;
	}
	
	public static String getUser() {
		return USER;
	}
	
	public static String getPassword() {
		return PASSWORD;
	}
	

	public static String[] getBreedInfo() {
		return breedInfo;
	}


	public static void setBreedInfo(String[] breedInfo) {
		MyBreed.breedInfo = breedInfo;
	}


	public static JLabel[] getTextLabels() {
		return textLabels;
	}


	public static void setTextLabels(JLabel[] textLabels) {
		MyBreed.textLabels = textLabels;
	}
	
	public static JLabel[] getBreedLabels() {
		return breedLabels;
	}


	public static void setBreedLabels(JLabel[] breedLabels) {
		MyBreed.breedLabels = breedLabels;
	}
	
	public static String[] getBreedLabelsInfo() {
		return breedLabelsInfo;
	}


	public static void setBreedLabelsInfo(String[] breedLabelsInfo) {
		MyBreed.breedLabelsInfo = breedLabelsInfo;
	}

	

	public static JTextField[] getTextBreedOptions() {
		return textBreedOptions;
	}


	public static void setTextBreedOptions(JTextField[] textBreedOptions) {
		MyBreed.textBreedOptions = textBreedOptions;
	}


	public static JButton[] getTextBreedOptionsPlus() {
		return textBreedOptionsPlus;
	}


	public static void setTextBreedOptionsPlus(JButton[] textBreedOptionsPlus) {
		MyBreed.textBreedOptionsPlus = textBreedOptionsPlus;
	}


	public static JButton[] getTextBreedOptionsMinus() {
		return textBreedOptionsMinus;
	}


	public static void setTextBreedOptionsMinus(JButton[] textBreedOptionsMinus) {
		MyBreed.textBreedOptionsMinus = textBreedOptionsMinus;
	}



}