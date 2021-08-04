import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class RegFrame extends JFrame {

	private JPanel contentPane;
	private JTextField fnField;
	private JTextField lnField;
	private JTextField dobField;
	private JTextField psField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegFrame frame = new RegFrame();
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
	public RegFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Please enter your details");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(206, 32, 197, 38);
		contentPane.add(lblNewLabel);
		
		fnField = new JTextField();
		fnField.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				fnField.setBackground(Color.DARK_GRAY);
			}
		});
		fnField.setBounds(317, 96, 86, 20);
		contentPane.add(fnField);
		fnField.setColumns(10);
		
		JLabel fnLabel = new JLabel("First Name");
		fnLabel.setBounds(245, 99, 76, 14);
		contentPane.add(fnLabel);
		
		lnField = new JTextField();
		lnField.setColumns(10);
		lnField.setBounds(317, 127, 86, 20);
		contentPane.add(lnField);
		
		JLabel lblNewLabel_1_1 = new JLabel("Last Name");
		lblNewLabel_1_1.setBounds(245, 130, 76, 14);
		contentPane.add(lblNewLabel_1_1);
		
		dobField = new JTextField();
		dobField.setColumns(10);
		dobField.setBounds(317, 158, 86, 20);
		contentPane.add(dobField);
		
		JLabel lblNewLabel_1_2 = new JLabel("D.O.B");
		lblNewLabel_1_2.setBounds(245, 161, 76, 14);
		contentPane.add(lblNewLabel_1_2);
		
		psField = new JTextField();
		psField.setColumns(10);
		psField.setBounds(317, 191, 86, 20);
		contentPane.add(psField);
		
		JLabel lblNewLabel_1_3 = new JLabel("Password");
		lblNewLabel_1_3.setBounds(245, 194, 76, 14);
		contentPane.add(lblNewLabel_1_3);
	}
}
