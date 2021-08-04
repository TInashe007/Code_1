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
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SignIn extends JFrame {

	private JPanel contentPane;
	private JTextField Email_Field;
	private JPasswordField password_Field;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignIn frame = new SignIn();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SignIn() {
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
		Email_lbl.setBounds(26, 129, 74, 14);
		panel_1.add(Email_lbl);
		
		Email_Field = new JTextField();
		Email_Field.setBounds(134, 126, 142, 20);
		panel_1.add(Email_Field);
		Email_Field.setColumns(10);
		
		JLabel password_lbl = new JLabel("Password:");
		password_lbl.setHorizontalAlignment(SwingConstants.TRAILING);
		password_lbl.setBounds(26, 154, 74, 14);
		panel_1.add(password_lbl);
		
		JButton login_btn = new JButton("Login");
		login_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(password_Field.getText().length()!=0 && Email_Field.getText().length()!=0 ) {
					
					try {
						Class.forName("com.mysql.jdbc.Driver");
						Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo_project","root","");
						Statement stmt = conn.createStatement();
						String sql = "SELECT * FROM users WHERE password ='"+password_Field.getText()+"' AND email = '"+Email_Field.getText()+"'";
						ResultSet rs = stmt.executeQuery(sql);
						if(rs.next()) {
							JOptionPane.showMessageDialog(null, "You have successfully logged in");
							conn.close();
						}else JOptionPane.showMessageDialog(null, "Invalid Account Entered");
									
					}catch(Exception ex) {
						JOptionPane.showMessageDialog(null,ex);
					}
						
				}else 
					JOptionPane.showMessageDialog(null, "Please Enter all required fields");
			}
		});
		login_btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				login_btn.setBackground(Color.BLUE);
			}
		});
		login_btn.setBounds(75, 194, 89, 23);
		panel_1.add(login_btn);
		
		JButton newUser_btn = new JButton("Create User");
		newUser_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CreateUser user = new CreateUser();
				user.setVisible(true);
				dispose();
			}
		});
		newUser_btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				newUser_btn.setBackground(Color.BLUE);
			}
		});
		newUser_btn.setBounds(174, 194, 102, 23);
		panel_1.add(newUser_btn);
		
		JLabel lblNewLabel_2 = new JLabel("Account Login ");
		lblNewLabel_2.setFont(new Font("Serif", Font.BOLD, 20));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(75, 54, 169, 37);
		panel_1.add(lblNewLabel_2);
		
		password_Field = new JPasswordField();
		password_Field.setBounds(134, 151, 142, 20);
		panel_1.add(password_Field);
	}
}
