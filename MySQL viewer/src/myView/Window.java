package myView;

import java.awt.EventQueue;

import javax.swing.JFrame;

import java.awt.BasicStroke;
import java.awt.Color;
import javax.swing.JTextPane;
import javax.swing.border.LineBorder;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.Font;
import javax.swing.JLayeredPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;



public class Window {

	private JFrame frame;
	public JPanel addBreed;
	public JPanel viewBreed;

	

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
		
		String URL = "jdbc:mysql://localhost:3306/chooseyourpuppy";
		String user = "root";
		String password = "";	
		String query = "select * from breeds";
		
		View.connect(URL, user, password, query, "Akita");


	}


	public Window() {
		initialize();
	}
	
	
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
		layeredPane.setLayout(null);
		
		JPanel darkGrey = new JPanel();
		darkGrey.setBackground(new Color(51, 51, 51));
		darkGrey.setBounds(0, 0, 393, 80);
		layeredPane.add(darkGrey);
		darkGrey.setLayout(null);
		
		JTextPane txtpnChoose = new JTextPane();
		txtpnChoose.setForeground(new Color(255, 255, 255));
		txtpnChoose.setBounds(56, 11, 367, 63);
		txtpnChoose.setFont(new Font("Verdana", Font.BOLD, 46));
		txtpnChoose.setText("Choose your");
		txtpnChoose.setBackground(null);
		darkGrey.add(txtpnChoose);
		
		JPanel red = new JPanel();
		red.setBounds(400, 0, 880, 80);
		layeredPane.add(red);
		red.setBackground(new Color(204, 0, 0));
		red.setLayout(null);
		
		JTextPane txtpnPuppy = new JTextPane();
		txtpnPuppy.setBounds(5, 11, 166, 63);
		txtpnPuppy.setForeground(new Color(255, 255, 255));
		txtpnPuppy.setFont(new Font("Verdana", Font.BOLD, 46));
		txtpnPuppy.setText("puppy");
		txtpnPuppy.setBackground(null);
		red.add(txtpnPuppy);
		
		
		
		
		viewBreed = new JPanel();
		viewBreed.setBounds(0, 0, 1274, 691);
		layeredPane.add(viewBreed);
		viewBreed.setLayout(null);
		viewBreed.setVisible(false);
		viewBreed.setBackground(Color.WHITE);
		
		JButton prevBreed = new JButton("<");
		prevBreed.setFont(new Font("Verdana", Font.PLAIN, 78));
		prevBreed.setBounds(34, 274, 100, 100);
		viewBreed.add(prevBreed);
		prevBreed.setVisible(true);
		prevBreed.setBorder(new LineBorder(Color.WHITE));
		prevBreed.setBackground(Color.WHITE);
		
		JButton nextBreed = new JButton(">");
		nextBreed.setFont(new Font("Verdana", Font.PLAIN, 78));
		nextBreed.setBounds(1144, 274, 100, 100);
		viewBreed.add(nextBreed);
		nextBreed.setBackground(Color.WHITE);
		
		
		addBreed = new JPanel();
		addBreed.setBounds(0, 0, 1280, 691);
		layeredPane.add(addBreed);
		addBreed.setVisible(false);
		addBreed.setBackground(Color.WHITE);
		addBreed.setLayout(null);
		
		JPanel menu = new JPanel();
		menu.setBounds(0, 0, 1270, 691);
		layeredPane.add(menu);
		menu.setLayout(null);
		
		JButton btnBrowse = new JButton("Browse breeds");
		btnBrowse.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnBrowse.setBackground(new Color(237, 237, 237));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnBrowse.setBackground(Color.WHITE);
			}
		});
		btnBrowse.setBounds(100, 300, 400, 200);
		btnBrowse.setFont(new Font("Verdana", Font.PLAIN, 40));
		btnBrowse.setBorder(new LineBorder(Color.DARK_GRAY));
		btnBrowse.setBorder(BorderFactory.createStrokeBorder(new BasicStroke(5.0f)));
		btnBrowse.setBackground(Color.WHITE);
		btnBrowse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				viewBreed.setVisible(true);
			}
		});
		menu.add(btnBrowse);
		
		JButton btnAdd = new JButton("Add new breed");
		btnAdd.setBounds(780, 300, 400, 200);
		btnAdd.setFont(new Font("Verdana", Font.PLAIN, 40));
		btnAdd.setBorder(new LineBorder(Color.DARK_GRAY));
		btnAdd.setBorder(BorderFactory.createStrokeBorder(new BasicStroke(5.0f)));
		btnAdd.setBackground(Color.WHITE);		
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addBreed.setVisible(true);
			}
		});
		menu.add(btnAdd);

		
	}
}
