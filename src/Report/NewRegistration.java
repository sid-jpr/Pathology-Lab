package Report;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class NewRegistration extends JFrame implements ActionListener {
	private JTextField pname;
	private JTextField fname;
	private JTextField age;
	private JTextField mobile;
	static JTextField testdetail;
	private JTextField regid;
	private JTextField date;
	private JRadioButton m;
	private JRadioButton f;
	private JButton test;
	private JButton close;
	private JButton submit;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField address;
	private int id = 1001;

	public NewRegistration() {
		getContentPane().setEnabled(false);
		getContentPane().setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 12));
		setTitle("New Registration ");
		getContentPane().setLayout(null);
		
		JLabel lblName = new JLabel("Patient Name");
		lblName.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		lblName.setBounds(21, 57, 129, 29);
		getContentPane().add(lblName);
		
		JLabel lblNewLabel = new JLabel("Father Name");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel.setBounds(21, 104, 129, 24);
		getContentPane().add(lblNewLabel);
		
		JLabel lblAge = new JLabel("Age");
		lblAge.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		lblAge.setBounds(21, 141, 100, 29);
		getContentPane().add(lblAge);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		lblGender.setBounds(21, 183, 129, 26);
		getContentPane().add(lblGender);
		
		JLabel lblMobileNo = new JLabel("Mobile No.");
		lblMobileNo.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		lblMobileNo.setBounds(21, 222, 129, 29);
		getContentPane().add(lblMobileNo);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		lblAddress.setBounds(21, 286, 129, 29);
		getContentPane().add(lblAddress);
		
		pname = new JTextField();
		pname.setFont(new Font("Tahoma", Font.PLAIN, 16));
		pname.setBounds(179, 56, 233, 29);
		getContentPane().add(pname);
		pname.setColumns(10);
		
		fname = new JTextField();
		fname.setFont(new Font("Tahoma", Font.PLAIN, 16));
		fname.setColumns(10);
		fname.setBounds(179, 98, 233, 27);
		getContentPane().add(fname);
		
		age = new JTextField();
		age.setFont(new Font("Tahoma", Font.PLAIN, 16));
		age.setColumns(10);
		age.setBounds(179, 138, 89, 32);
		getContentPane().add(age);
		
		mobile = new JTextField();
		mobile.setFont(new Font("Tahoma", Font.PLAIN, 16));
		mobile.setColumns(10);
		mobile.setBounds(179, 221, 233, 30);
		getContentPane().add(mobile);
		
		m = new JRadioButton("Male");
		buttonGroup.add(m);
		m.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		m.setBounds(179, 187, 89, 23);
		getContentPane().add(m);
		
		f = new JRadioButton("Female");
		buttonGroup.add(f);
		f.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		f.setBounds(277, 187, 109, 23);
		getContentPane().add(f);
		
		ButtonGroup bg=new ButtonGroup();
		bg.add(f);		
		bg.add(m);
		
		test = new JButton("Test Details");
		test.setHorizontalAlignment(SwingConstants.LEADING);
		test.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		test.setBounds(21, 396, 129, 29);
		getContentPane().add(test);
		
		testdetail = new JTextField();
		testdetail.setFont(new Font("Tahoma", Font.PLAIN, 16));
		testdetail.setBackground(Color.WHITE);
		testdetail.setEditable(false);
		testdetail.setBounds(179, 354, 283, 115);
		getContentPane().add(testdetail);
		testdetail.setColumns(10);
		
		JLabel lblRegistrationId = new JLabel("Registration ID");
		lblRegistrationId.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		lblRegistrationId.setBounds(21, 502, 129, 24);
		getContentPane().add(lblRegistrationId);
		
		close = new JButton("Close");
		close.addActionListener(this);
		close.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		close.setBounds(337, 573, 89, 23);
		getContentPane().add(close);
		
		submit = new JButton("Submit");
		submit.addActionListener(this);
		submit.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		submit.setBounds(72, 573, 89, 23);
		getContentPane().add(submit);
		
		regid = new JTextField();
		regid.setBackground(Color.WHITE);
		regid.setEditable(false);
		regid.setFont(new Font("Tahoma", Font.PLAIN, 16));
		regid.setBounds(179, 500, 233, 28);
		getContentPane().add(regid);
		regid.setColumns(10);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setHorizontalAlignment(SwingConstants.CENTER);
		lblDate.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		lblDate.setBounds(254, 11, 77, 17);
		getContentPane().add(lblDate);
		
		date = new JTextField(new java.sql.Date(new java.util.Date().getTime()).toString());
		date.setFont(new Font("Tahoma", Font.PLAIN, 16));
		date.setEditable(false);
		date.setBackground(Color.WHITE);
		date.setBounds(333, 8, 129, 23);
		getContentPane().add(date);
		date.setColumns(10);
		
		address = new JTextField();
		address.setFont(new Font("Tahoma", Font.PLAIN, 16));
		address.setBounds(179, 274, 283, 57);
		getContentPane().add(address);
		address.setColumns(10);

		//ImageIcon ii=new ImageIcon(getClass().getResource("project/images/back.png"));
		//JLabel lab=new JLabel(ii);
		//lab.setBounds(0, 0, 500, 453);
		//getContentPane().add(lab);
		test.addActionListener(this);
		setSize(575,656);
		generateId();
		setVisible(true);
	}

	public static void main(String[] args) {
		new NewRegistration();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object ob = e.getSource();
		if(ob == test){
			String s = "insert into patientdetails(rid) values(?)";
			Connection cc = MyConnection.connect();
			try{
				PreparedStatement ps  = cc.prepareStatement(s);
				ps.setInt(1, id);
				ps.executeUpdate();
			}
			catch(SQLException se){
				se.printStackTrace();
			}
			if(pname.getText().isEmpty() || fname.getText().isEmpty() || age.getText().isEmpty() || mobile.getText().isEmpty() || address.getText().isEmpty()){
				JOptionPane.showMessageDialog(null, "You will have to fill all the above details.");
				return;
			}
			else if(m.isSelected() || f.isSelected()){
				String u = regid.getText();
				int p = Integer.parseInt(u);
				new Choice(p);
			} else{
				JOptionPane.showMessageDialog(null, "You didn't choose your gender.");
				return;
			}
			//getTestInfo();
		}
		if(ob == submit){
			String name = pname.getText();
			String name1 = fname.getText();
			int a = Integer.parseInt(age.getText());
			String gender = null;
			if(m.isSelected()){
				gender = "Male";
			}
			else{
				gender = "Female";
			}
			String mn = mobile.getText();
			if(mn.length() != 10){
				JOptionPane.showMessageDialog(null, "Enter valid phone No.");
				return;
			}
			String add = address.getText();
			String s = "update patientdetails set pname=?,fname=?,age=?,gender=?,cno=?,address=?,paid=?,due=? where rid = ?";
			Connection cc = MyConnection.connect();
			try{
				PreparedStatement ps  = cc.prepareStatement(s);
				ps.setString(1, name);
				ps.setString(2, name1);
				ps.setInt(3, a);
				ps.setString(4, gender);
				ps.setString(5, mn);
				ps.setString(6, add);
				ps.setInt(7, 0);
				ps.setInt(8, Choice.getDue());
				ps.setInt(9, id);
				ps.executeUpdate();
			}
			catch(SQLException se){
				se.printStackTrace();
			}
			dispose();
			JOptionPane.showMessageDialog(null, "Patient info added");
		}
		else if(ob == close){
			dispose();
		}
	}
	void generateId(){
		String s = "select max(rid) from patientdetails";
		Connection c = MyConnection.connect();
		try{
			PreparedStatement ps = c.prepareStatement(s);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				id = rs.getInt(1);
			}
		}
		catch(SQLException se){
			se.printStackTrace();
		}
		if(id ==0){
			id = 1001;
		} else{
			++id;
		}
		regid.setText(String.valueOf(id));
	}
}
