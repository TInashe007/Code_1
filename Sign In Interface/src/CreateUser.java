import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JSplitPane;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JPasswordField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CreateUser extends JFrame {

	private JPanel contentPane;
	private JTextField Email_Field;
	private JPasswordField password_Field;
	private JTextField sname_Field;
	private JTextField fname_Field;

	
	/**
	 * Create the frame.
	 */
	public CreateUser() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(220, 220, 220));
		panel.setBounds(0, 0, 180, 361);
		contentPane.add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(204, 204, 204));
		panel_1.setBounds(179, 0, 305, 361);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel Email_lbl = new JLabel("Email:");
		Email_lbl.setHorizontalAlignment(SwingConstants.TRAILING);
		Email_lbl.setBounds(26, 186, 74, 14);
		panel_1.add(Email_lbl);
		
		Email_Field = new JTextField();
		Email_Field.setBounds(134, 183, 142, 20);
		panel_1.add(Email_Field);
		Email_Field.setColumns(10);
		
		JLabel password_lbl = new JLabel("Password:");
		password_lbl.setHorizontalAlignment(SwingConstants.TRAILING);
		password_lbl.setBounds(26, 214, 74, 14);
		panel_1.add(password_lbl);
		
		JButton login_btn = new JButton("Login");
		login_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SignIn user = new SignIn();
				user.setVisible(true);
				dispose();
			}
		});
		login_btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				login_btn.setBackground(Color.BLUE);
			}
		});
		login_btn.setBounds(187, 245, 89, 23);
		panel_1.add(login_btn);
		
		JButton newUser_btn = new JButton("Create User");
		newUser_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(password_Field.getText().length()!=0 && fname_Field.getText().length()!=0 && Email_Field.getText().length()!=0 && sname_Field.getText().length()!=0) {
					
					try {
					
						Class.forName("com.mysql.jdbc.Driver");
						Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo_project","root","");
						Statement stmt = conn.createStatement();
						String sql = "INSERT INTO users (fname, lname, email, password) VALUES ('"+fname_Field.getText()+"','"+sname_Field.getText()+"','"+Email_Field.getText()+"','"+password_Field.getText()+"')";
						stmt.executeUpdate(sql);
						conn.close();
					
						//JavaMail.sendMail(Email_Field.getText().toString());
					
						JOptionPane.showMessageDialog(null, "An email has been sent to your email address: "+Email_Field.getText().toString());
						SignIn user = new SignIn();
						user.setVisible(true);
						dispose();
					}catch(Exception ex) {
						JOptionPane.showMessageDialog(null,ex);
					}
						
				}else 
					JOptionPane.showMessageDialog(null, "Please enter all required information");
			}
		});
		newUser_btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				newUser_btn.setBackground(Color.BLUE);
			}
		});
		newUser_btn.setBounds(75, 245, 102, 23);
		panel_1.add(newUser_btn);
		
		JLabel lblNewLabel_2 = new JLabel("Create New User");
		lblNewLabel_2.setFont(new Font("Serif", Font.BOLD, 20));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(75, 54, 169, 37);
		panel_1.add(lblNewLabel_2);
		
		password_Field = new JPasswordField();
		password_Field.setBounds(134, 211, 142, 20);
		panel_1.add(password_Field);
		
		JLabel sname_lbl = new JLabel("Last Name:");
		sname_lbl.setHorizontalAlignment(SwingConstants.TRAILING);
		sname_lbl.setBounds(26, 158, 74, 14);
		panel_1.add(sname_lbl);
		
		sname_Field = new JTextField();
		sname_Field.setColumns(10);
		sname_Field.setBounds(134, 155, 142, 20);
		panel_1.add(sname_Field);
		
		JLabel fname_lbl = new JLabel("First Name:");
		fname_lbl.setHorizontalAlignment(SwingConstants.TRAILING);
		fname_lbl.setBounds(26, 133, 74, 14);
		panel_1.add(fname_lbl);
		
		fname_Field = new JTextField();
		fname_Field.setColumns(10);
		fname_Field.setBounds(134, 130, 142, 20);
		panel_1.add(fname_Field);
	}
	
	
	
}
