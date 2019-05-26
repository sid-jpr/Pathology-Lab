package Report;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JRadioButton;

import java.awt.Font;
import javax.swing.JEditorPane;
import java.awt.Color;
import javax.swing.SwingConstants;

public class PatientUpdate extends JDialog implements ActionListener {
	private JTextField pname;
	private JTextField fname;
	private JTextField age;
	private JTextField mobile;
	private JTextField testdetail;
	private JTextField regid;
	private JTextField date;
	private JRadioButton m;
	private JRadioButton f;
	private JButton test;
	private JButton close;
	private JButton submit;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField address;
	int rid;
	public PatientUpdate(int rid) {
		this.rid = rid;
		getContentPane().setEnabled(false);
		getContentPane().setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 12));
		setModal(true);
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
		pname.setBackground(Color.WHITE);
		pname.setEditable(false);
		pname.setFont(new Font("Tahoma", Font.PLAIN, 16));
		pname.setBounds(179, 56, 233, 29);
		getContentPane().add(pname);
		pname.setColumns(10);
		
		fname = new JTextField();
		fname.setBackground(Color.WHITE);
		fname.setEditable(false);
		fname.setFont(new Font("Tahoma", Font.PLAIN, 16));
		fname.setColumns(10);
		fname.setBounds(179, 98, 233, 27);
		getContentPane().add(fname);
		
		age = new JTextField();
		age.setBackground(Color.WHITE);
		age.setEditable(false);
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
		m.setForeground(Color.BLACK);
		m.setEnabled(false);
		buttonGroup.add(m);
		m.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		m.setBounds(179, 187, 89, 23);
		getContentPane().add(m);
		
		f = new JRadioButton("Female");
		f.setForeground(Color.BLACK);
		f.setEnabled(false);
		buttonGroup.add(f);
		f.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		f.setBounds(277, 187, 109, 23);
		getContentPane().add(f);
		
		ButtonGroup bg=new ButtonGroup();
		bg.add(f);		
		bg.add(m);
		
		test = new JButton("Test Details");
		test.setEnabled(false);
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
		regid.setText(String.valueOf(rid));
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
		address.setBackground(Color.WHITE);
		address.setFont(new Font("Tahoma", Font.PLAIN, 16));
		address.setBounds(179, 274, 283, 57);
		getContentPane().add(address);
		address.setColumns(10);

		//ImageIcon ii=new ImageIcon(getClass().getResource("project/images/back.png"));
		//JLabel lab=new JLabel(ii);
		//lab.setBounds(0, 0, 500, 453);
		//getContentPane().add(lab);
		setSize(575,656);
		setModal(true);
		getInfo();
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object ob = e.getSource();
		if(ob == close){
			dispose();
		} else if(ob == submit){
			String s = "update patientdetails set cno = ?,address = ? where rid = ?";
			 Connection con = MyConnection.connect();
			 String no = mobile.getText();
			 String a = address.getText();
			 try{
				 PreparedStatement ps = con.prepareStatement(s);
				 ps.setString(1, no);
				 ps.setString(2, a);
				 ps.setInt(3, rid);
				 ps.executeUpdate();
				 JOptionPane.showMessageDialog(null, "updated");
				 dispose();
			 }
			 catch(SQLException se){
				 se.printStackTrace();
			 }
		}
		
	}
	void getInfo(){
		String s = "select * from patientdetails where rid = ?";
		Connection con = MyConnection.connect();
		try{
			PreparedStatement ps = con.prepareStatement(s);
			ps.setInt(1, rid);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				pname.setText(rs.getString("pname"));
				fname.setText(rs.getString("fname"));
				age.setText(rs.getString("age"));
				if(rs.getString("gender").equals("Male"))
					m.setSelected(true);
				else
					f.setSelected(true);
				mobile.setText(rs.getString("cno"));
				address.setText(rs.getString("address"));
				testdetail.setText(rs.getString("tests"));
			}
		}
		catch(SQLException se){
			se.printStackTrace();
		}
	}
}
