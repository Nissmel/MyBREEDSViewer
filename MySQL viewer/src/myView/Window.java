package myView;

import java.awt.EventQueue;
import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.Font;
import javax.swing.JLayeredPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.CardLayout;
import javax.swing.JLabel;
import javax.swing.JSpinner;

public class Window  {

	public static String URL = "jdbc:mysql://localhost:3306/chooseyourpuppy";
	public static String user = "root";
	public static String password = "";	
	public static String query = "select * from breeds";

	static String [] breedLabelsInfo = new String[16];
	static String [] breedInfo = new String[16];


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Window window = new Window();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});		

		View.connect(URL, user, password, query);
	}


	public Window() {
		initialize();
	}
	

	public static JFrame frame;
	public static JPanel addBreed;
	public static JPanel viewBreed;
	private static JPanel menu;
	private static JPanel header;
	public static JLabel[] textLabels;
	public static JLabel[] breedLabels;
	
	public static JTextField[] textBreedOptions;
	public static JButton[] textBreedOptionsPlus;
	public static JButton[] textBreedOptionsMinus;
	public JLayeredPane layeredPane;

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
		
		header = HeaderBuilder.buildHeader(layeredPane);

		
		
		layeredPane = new JLayeredPane();
		layeredPane.setBounds(0, 0, WIDTH, HEIGHT);
		frame.getContentPane().add(layeredPane);
		layeredPane.setLayout(new CardLayout(0, 0));

		menu = MenuBuilder.buildMenu(layeredPane);
	
		viewBreed = ViewBreedBuilder.buildView(layeredPane);
		
		addBreed = AddBreedBuilder.buildAdd(layeredPane);
		
		

		JButton btnMenu = new JButton("Back to menu");
		btnMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane.removeAll();
				layeredPane.add(menu);
				layeredPane.repaint();
				layeredPane.revalidate();
			}
		});
		btnMenu.setForeground(Color.WHITE);
		btnMenu.setBackground(new Color(51, 51, 51));
		btnMenu.setFont(new Font("Verdana", Font.BOLD, 18));
		btnMenu.setBounds(1050, 20, 180, 40);
		btnMenu.setBorderPainted(false);
		btnMenu.setRequestFocusEnabled(false);
		btnMenu.setFocusPainted(false);
		header.add(btnMenu);
	}
}
