package Report;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

import javax.swing.JTextField;

import javax.swing.JButton;
import javax.swing.JPasswordField;

public class Login extends JFrame implements ActionListener{
	private JTextField u;
	private JButton login;
	private JButton cancel;
	private JPasswordField p;

	public Login() {
		setTitle("PATHALOGY LOGIN");
		getContentPane().setLayout(null);
		
		JLabel lblUsername = new JLabel("Username:\r\n");
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblUsername.setBounds(29, 44, 130, 35);
		getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblPassword.setBounds(29, 121, 130, 35);
		getContentPane().add(lblPassword);
		
		u = new JTextField();
		u.setFont(new Font("Tahoma", Font.PLAIN, 14));
		u.setBounds(202, 44, 152, 35);
		getContentPane().add(u);
		u.setColumns(10);
		
		login = new JButton("Login");
		login.setFont(new Font("Tahoma", Font.BOLD, 18));
		login.setBounds(52, 198, 118, 35);
		getContentPane().add(login);
		
		cancel = new JButton("Cancel");
		cancel.setFont(new Font("Tahoma", Font.BOLD, 18));
		cancel.setBounds(235, 198, 118, 35);
		getContentPane().add(cancel);
		
		login.addActionListener(this);
		cancel.addActionListener(this);
		
		login.setEnabled(false);
		
		p = new JPasswordField();
		p.setFont(new Font("Tahoma", Font.PLAIN, 14));
		p.setBounds(202, 121, 152, 35);
		getContentPane().add(p);
		setSize(400,300);
		setLocationRelativeTo(null);
		
		u.addKeyListener(new KeyAdapter(){
			public void keyReleased(KeyEvent k){
				if(u.getText().length()==0){
					login.setEnabled(false);
				}
				else{
					login.setEnabled(true);
				}	
			}
		});
		
		setVisible(true);
	}

	public static void main(String[] args) {
		new Login();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object ob = e.getSource();
		if(ob == login){
			String user = u.getText();
			String pass = new String(p.getPassword());
			String st = "select * from login where uname = ? and pass = ?";
			Connection c = MyConnection.connect();
			try{
				PreparedStatement ps = c.prepareStatement(st);
				ps.setString(1, user);
				ps.setString(2, pass);
				ResultSet rs = ps.executeQuery();
				if(rs.next()){
					dispose();
					new DashBoard();
				}
				else{
					JOptionPane.showMessageDialog(null, "Invalid");
					p.setText("");
					u.setText("");
					u.requestFocusInWindow();
					
				}
			}
			catch(SQLException se){
				se.printStackTrace();
			}
			
		}
		else if(ob == cancel){
			dispose();
		}
	}
}
