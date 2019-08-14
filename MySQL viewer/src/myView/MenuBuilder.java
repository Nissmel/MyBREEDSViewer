package myView;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.LineBorder;

public class MenuBuilder extends MyBreed{
	
	public static  JPanel buildMenu(JLayeredPane layeredPane) 
	{
		menu = new JPanel();
		menu.setBackground(Color.WHITE);
		layeredPane.add(menu, "name_410359960271086");
		menu.setBounds(80, 0, 1200, 720);
		menu.setLayout(null);
		menu.add(header);

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
				viewBreed.add(header);
				layeredPane.repaint();
				layeredPane.revalidate();
				DataBaseView.setText("viewBreed");

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
				
		JPanel panel = new JPanel();
		JLabel label = new JLabel("Enter a password for database:");
		JPasswordField userPassword = new JPasswordField(10);
		
		panel.add(label);
		panel.add(userPassword);
		String[] options = new String[]{"OK", "Cancel"};
		
		int option = JOptionPane.showOptionDialog(null, panel, "Password required!",
				JOptionPane.NO_OPTION, JOptionPane.PLAIN_MESSAGE,null, options, options[1]);
		
		if(option == 0)
		{
			String passText = new String(userPassword.getPassword());
			
			if(passText.equals(getPassword()))
			{
				layeredPane.removeAll();
				layeredPane.add(addBreed);
				addBreed.add(header);
				layeredPane.repaint();
				layeredPane.revalidate();

				DataBaseView.setText("addBreed");
				DataBaseView.setField();
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Typed in password is wrong. Access denied!", 
						"Wrong password!", JOptionPane.INFORMATION_MESSAGE);
			}
		}

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

		return menu;		
	}
}
