package myView;

import java.awt.EventQueue;

import javax.swing.JFrame;

import java.awt.BasicStroke;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.Font;


import javax.swing.JLayeredPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import java.awt.CardLayout;
import javax.swing.JLabel;




public class Window  {

	public static void setBreed()
	{
		for(int i=0; i<16;i++) {
			breedLabels[i].setText(breedInfo[i]);
			breedLabels[i].setBounds(600,100+i*30,300, 100);
			breedLabels[i].setFont(new Font("Verdana", Font.PLAIN, 20));
			viewBreed.add(breedLabels[i]);
		}
	}
	
	public static void setText()
	{
		for(int i=0; i<16;i++) {
			textLabels[i].setText(text[i]);
			textLabels[i].setBounds(300,100+i*30,300, 100);
			textLabels[i].setFont(new Font("Verdana", Font.PLAIN, 20));
			viewBreed.add(textLabels[i]);
		}
	}
	
	
	public static String URL = "jdbc:mysql://localhost:3306/chooseyourpuppy";
	public static String user = "root";
	public static String password = "";	
	public static String query = "select * from breeds";
	
	static String [] breedInfo = new String[16];
	static String [] text = new String[16];

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
	

	private JFrame frame;
	public JPanel addBreed;
	public static JPanel viewBreed;
	public JPanel menu;
	public static JLabel[] textLabels;
	public static JLabel[] breedLabels;
	
public  void initialize() {
		
		
		final int WIDTH = 1280, HEIGHT = 720;
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.getContentPane().setLayout(null);
		

		frame.setBounds(100, 100, WIDTH, HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("MyBREEDS Viewer");
		frame.setResizable(false);
		frame.setVisible(true);

		
		
		//header
		JPanel red = new JPanel();
		red.setBounds(400, 0, 888, 80);
		frame.getContentPane().add(red);
		red.setBackground(new Color(204, 0, 0));
		red.setLayout(null);
		
		JPanel darkGrey = new JPanel();
		darkGrey.setBounds(0, 0, 387, 80);
		frame.getContentPane().add(darkGrey);
		darkGrey.setBackground(new Color(51, 51, 51));
		darkGrey.setLayout(null);
		
		JLabel txtpnChoose = new JLabel();
		txtpnChoose.setForeground(new Color(240, 240, 240));
		txtpnChoose.setBounds(56, 11, 367, 63);
		txtpnChoose.setFont(new Font("Verdana", Font.BOLD, 46));
		txtpnChoose.setText("Choose your");
		txtpnChoose.setBackground(null);
		darkGrey.add(txtpnChoose);
		
		JLabel txtpnPuppy = new JLabel();
		txtpnPuppy.setBounds(5, 11, 166, 63);
		txtpnPuppy.setForeground(new Color(240, 240, 240));
		txtpnPuppy.setFont(new Font("Nunito-Bold", Font.BOLD, 46));
		txtpnPuppy.setText("puppy");
		txtpnPuppy.setBackground(null);
		red.add(txtpnPuppy);
		
		

		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(0, 0, WIDTH, HEIGHT);
		frame.getContentPane().add(layeredPane);
		layeredPane.setLayout(new CardLayout(0, 0));
		
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
		btnMenu.setBounds(660, 20, 180, 40);
		btnMenu.setBorderPainted(false);
		btnMenu.setFocusPainted(false);
		red.add(btnMenu);
		
		
		
		//menu		
		menu = new JPanel();
		menu.setBackground(Color.WHITE);
		layeredPane.add(menu, "name_410359960271086");
		menu.setLayout(null);
		
		JButton btnBrowse = new JButton("Browse breeds");
		btnBrowse.setBounds(100, 300, 400, 200);
		btnBrowse.setFont(new Font("Verdana", Font.PLAIN, 40));
		btnBrowse.setBorder(new LineBorder(Color.DARK_GRAY));
		btnBrowse.setBorder(BorderFactory.createStrokeBorder(new BasicStroke(5.0f)));
		btnBrowse.setBackground(Color.WHITE);		
		btnBrowse.setRequestFocusEnabled(false);
		btnBrowse.setVisible(true);
		btnBrowse.setFocusPainted(false);
		btnBrowse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane.removeAll();
				layeredPane.add(viewBreed);
				layeredPane.repaint();
				layeredPane.revalidate();
				setText();
				setBreed();
			}
		});
		
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
		menu.add(btnBrowse);
		
		addBreed = new JPanel();
		layeredPane.add(addBreed, "name_410359942089403");
		addBreed.setVisible(false);
		addBreed.setBackground(Color.WHITE);
		addBreed.setLayout(null);	
		
		
		
		
		
		
		//view breed window
		viewBreed = new JPanel();
		layeredPane.add(viewBreed, "name_410359924014670");
		viewBreed.setLayout(null);
		viewBreed.setVisible(false);
		viewBreed.setBackground(Color.WHITE);
		
		
		ImageIcon previous = new ImageIcon("src/images/previous.png");
		ImageIcon previousHover = new ImageIcon("src/images/previousHover.png");

		JButton prevBreed = new JButton(previous);
		prevBreed.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				prevBreed.setIcon(previousHover);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				prevBreed.setIcon(previous);
			}
		});
		prevBreed.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				View.changeBreed(false);
			}
		});
		prevBreed.setBounds(30, 300, previous.getIconHeight(), previous.getIconWidth());
		viewBreed.add(prevBreed);
		prevBreed.setRequestFocusEnabled(false);
		prevBreed.setOpaque(false);
		prevBreed.setContentAreaFilled(false);
		prevBreed.setBorderPainted(false);
		prevBreed.setFocusPainted(false);
		

		ImageIcon next = new ImageIcon("src/images/next.png");
		ImageIcon nextHover = new ImageIcon("src/images/nextHover.png");
		
		JButton nextBreed = new JButton(next);
		nextBreed.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				nextBreed.setIcon(nextHover);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				nextBreed.setIcon(next);
			}
		});
		nextBreed.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				View.changeBreed(true);
			}
		});
		nextBreed.setBounds(1140, 300, previous.getIconHeight(), previous.getIconWidth());
		viewBreed.add(nextBreed);
		nextBreed.setRequestFocusEnabled(false);
		nextBreed.setVisible(true);
		nextBreed.setOpaque(false);
		nextBreed.setContentAreaFilled(false);
		nextBreed.setBorderPainted(false);
		nextBreed.setFocusPainted(false);
		
		
		
		
		//add breed window
		JButton btnAdd = new JButton("Add new breed");
		btnAdd.setBounds(780, 300, 400, 200);
		btnAdd.setFont(new Font("Verdana", Font.PLAIN, 40));
		btnAdd.setBorder(new LineBorder(Color.DARK_GRAY));
		btnAdd.setBorder(BorderFactory.createStrokeBorder(new BasicStroke(5.0f)));
		btnAdd.setBackground(Color.WHITE);		
		btnAdd.setRequestFocusEnabled(false);
		btnAdd.setFocusPainted(false);
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane.removeAll();
				layeredPane.add(addBreed);
				layeredPane.repaint();
				layeredPane.revalidate();
			}
		});
		
		btnAdd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnAdd.setBackground(new Color(237, 237, 237));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnAdd.setBackground(Color.WHITE);
			}
		});
		menu.add(btnAdd);
		


		
		breedLabels = new JLabel[breedInfo.length];

		for(int i=0; i<breedInfo.length; i++) {
			breedLabels[i] = new JLabel(breedInfo[i]);
		}
		
		
		textLabels = new JLabel[breedInfo.length];

		for(int i=0; i<breedInfo.length; i++) {
			textLabels[i] = new JLabel(breedInfo[i]);
		}


		
	}

}
