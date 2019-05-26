//aclko@rediffmail.com
package Report;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class PatientReport extends JDialog implements ActionListener{
	private JTextField txtDigipodiumPathology;
	private JTextField txtLabratoryReport;
	HashMap<String,String>ranges=new HashMap<String,String>();
	String [][] d = null;
	
	
	private JTextField name;
	private JTextField id;
	private JTextField date;
	private JTextField age;
	private JTextField sex;
	private JTextField doctor;
	private JTextField t1;
	private JTextField t2;
	private JTextField t3;
	private JTextField t4;
	private JTextField t5;
	private JTextField t6;
	private JTextField t7;
	private JTextField t8;
	private JTextField t9;
	private JTextField t10;
	private JTextField r1;
	private JTextField r2;
	private JTextField r3;
	private JTextField r4;
	private JTextField r5;
	private JTextField r6;
	private JTextField r7;
	private JTextField r8;
	private JTextField r9;
	private JTextField r10;
	private JTextField nr1;
	private JTextField nr2;
	private JTextField nr3;
	private JTextField nr4;
	private JTextField nr5;
	private JTextField nr6;
	private JTextField nr7;
	private JTextField nr8;
	private JTextField nr9;
	private JTextField nr10;
	private JTextField u1;
	private JTextField u2;
	private JTextField u3;
	private JTextField u4;
	private JTextField u5;
	private JTextField u6;
	private JTextField u7;
	private JTextField u8;
	private JTextField u9;
	private JTextField u10;
	private JButton print;
	int rid;
	private JTextField total;
	int t;
	Color col;
	private JButton show;
	JPanel panel=new JPanel();
	JFrame frame = new JFrame();
	public PatientReport(int rid) {
		this.rid  = rid;
		panel.setLayout(null);
//		getContentPane().setLayout(null);
		JScrollPane jsp=new JScrollPane(panel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		JLabel lblLowerGroundFloor = new JLabel(" Lower Ground Floor, Rajaram Kumar Plaza, Hazratganj, Lucknow, Uttar Pradesh 226001");
		lblLowerGroundFloor.setForeground(Color.BLACK);
		lblLowerGroundFloor.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblLowerGroundFloor.setBounds(29, 91, 639, 43);
		panel.add(lblLowerGroundFloor);
		
		txtDigipodiumPathology = new JTextField();
		txtDigipodiumPathology.setEditable(false);
		txtDigipodiumPathology.setForeground(Color.BLUE);
		txtDigipodiumPathology.setBackground(Color.YELLOW);
		txtDigipodiumPathology.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 30));
		txtDigipodiumPathology.setText("DIGIPODIUM PATHOLOGY");
		txtDigipodiumPathology.setBounds(29, 26, 430, 52);
		panel.add(txtDigipodiumPathology);
		txtDigipodiumPathology.setColumns(10);
		
		txtLabratoryReport = new JTextField();
		txtLabratoryReport.setEditable(false);
		txtLabratoryReport.setForeground(Color.BLACK);
		txtLabratoryReport.setBackground(Color.PINK);
		txtLabratoryReport.setFont(new Font("Tahoma", Font.BOLD, 16));
		txtLabratoryReport.setHorizontalAlignment(SwingConstants.CENTER);
		txtLabratoryReport.setText("Labratory Report");
		txtLabratoryReport.setBounds(29, 149, 918, 33);
		panel.add(txtLabratoryReport);
		txtLabratoryReport.setColumns(10);
		
		JLabel lblName = new JLabel("Name");
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setFont(new Font("Tahoma", Font.ITALIC, 16));
		lblName.setBounds(29, 195, 85, 26);
		panel.add(lblName);
		
		name = new JTextField();
		name.setHorizontalAlignment(SwingConstants.CENTER);
		name.setBackground(Color.WHITE);
		name.setEditable(false);
		name.setFont(new Font("Tahoma", Font.BOLD, 16));
		name.setBounds(122, 195, 160, 33);
		panel.add(name);
		name.setColumns(10);
		
		JLabel lblRegistrationId = new JLabel("Registration ID");
		lblRegistrationId.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegistrationId.setFont(new Font("Tahoma", Font.ITALIC, 16));
		lblRegistrationId.setBounds(505, 195, 124, 26);
		panel.add(lblRegistrationId);
		
		id = new JTextField();
		id.setHorizontalAlignment(SwingConstants.CENTER);
		id.setBackground(Color.WHITE);
		id.setEditable(false);
		id.setFont(new Font("Tahoma", Font.BOLD, 16));
		id.setBounds(641, 195, 124, 28);
		id.setText(String.valueOf(rid));
		panel.add(id);
		id.setColumns(10);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setHorizontalAlignment(SwingConstants.CENTER);
		lblDate.setFont(new Font("Tahoma", Font.ITALIC, 16));
		lblDate.setBounds(29, 246, 85, 26);
		panel.add(lblDate);
		
		date = new JTextField(new java.sql.Date(new java.util.Date().getTime()).toString());
		date.setHorizontalAlignment(SwingConstants.CENTER);
		date.setFont(new Font("Tahoma", Font.BOLD, 16));
		date.setBackground(Color.WHITE);
		date.setEditable(false);
		date.setBounds(122, 246, 164, 33);
		panel.add(date);
		date.setColumns(10);
		
		JLabel lblAge = new JLabel("Age");
		lblAge.setHorizontalAlignment(SwingConstants.CENTER);
		lblAge.setFont(new Font("Tahoma", Font.ITALIC, 16));
		lblAge.setBounds(425, 246, 85, 26);
		panel.add(lblAge);
		
		JLabel lblSex = new JLabel("Sex");
		lblSex.setHorizontalAlignment(SwingConstants.CENTER);
		lblSex.setFont(new Font("Tahoma", Font.ITALIC, 16));
		lblSex.setBounds(651, 246, 85, 26);
		panel.add(lblSex);
		
		age = new JTextField();
		age.setHorizontalAlignment(SwingConstants.CENTER);
		age.setFont(new Font("Tahoma", Font.BOLD, 16));
		age.setEditable(false);
		age.setColumns(10);
		age.setBackground(Color.WHITE);
		age.setBounds(492, 245, 75, 28);
		panel.add(age);
		
		sex = new JTextField();
		sex.setHorizontalAlignment(SwingConstants.CENTER);
		sex.setFont(new Font("Tahoma", Font.BOLD, 16));
		sex.setEditable(false);
		sex.setColumns(10);
		sex.setBackground(Color.WHITE);
		sex.setBounds(716, 245, 139, 28);
		panel.add(sex);
		
		JLabel lblDoctor = new JLabel("Doctor");
		lblDoctor.setHorizontalAlignment(SwingConstants.CENTER);
		lblDoctor.setFont(new Font("Tahoma", Font.ITALIC, 16));
		lblDoctor.setBounds(29, 303, 85, 26);
		panel.add(lblDoctor);
		
		doctor = new JTextField();
		doctor.setHorizontalAlignment(SwingConstants.CENTER);
		doctor.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		doctor.setEditable(false);
		doctor.setColumns(10);
		doctor.setBackground(Color.WHITE);
		doctor.setBounds(122, 301, 240, 33);
		doctor.setText("Dr. Anupam Chaurasia");
		panel.add(doctor);
		
		JLabel lblTestName = new JLabel("Test Name");
		lblTestName.setHorizontalAlignment(SwingConstants.CENTER);
		lblTestName.setFont(new Font("Tahoma", Font.ITALIC, 18));
		lblTestName.setBounds(64, 375, 91, 26);
		panel.add(lblTestName);
		
		JLabel lblResult = new JLabel("Result");
		lblResult.setHorizontalAlignment(SwingConstants.CENTER);
		lblResult.setFont(new Font("Tahoma", Font.ITALIC, 18));
		lblResult.setBounds(257, 375, 91, 26);
		panel.add(lblResult);
		
		JLabel lblNormalRange = new JLabel("Normal Range");
		lblNormalRange.setHorizontalAlignment(SwingConstants.CENTER);
		lblNormalRange.setFont(new Font("Tahoma", Font.ITALIC, 18));
		lblNormalRange.setBounds(466, 375, 124, 26);
		panel.add(lblNormalRange);
		
		JLabel lblUnits = new JLabel("Units");
		lblUnits.setHorizontalAlignment(SwingConstants.CENTER);
		lblUnits.setFont(new Font("Tahoma", Font.ITALIC, 18));
		lblUnits.setBounds(733, 375, 124, 26);
		panel.add(lblUnits);
		
		t1 = new JTextField();
		t1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		t1.setHorizontalAlignment(SwingConstants.CENTER);
		t1.setEditable(false);
		t1.setColumns(10);
		t1.setBackground(Color.WHITE);
		t1.setBounds(29, 428, 164, 33);
		panel.add(t1);
		
		t2 = new JTextField();
		t2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		t2.setHorizontalAlignment(SwingConstants.CENTER);
		t2.setEditable(false);
		t2.setColumns(10);
		t2.setBackground(Color.WHITE);
		t2.setBounds(29, 474, 164, 33);
		panel.add(t2);
		
		t3 = new JTextField();
		t3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		t3.setHorizontalAlignment(SwingConstants.CENTER);
		t3.setEditable(false);
		t3.setColumns(10);
		t3.setBackground(Color.WHITE);
		t3.setBounds(29, 520, 164, 33);
		panel.add(t3);
		
		t4 = new JTextField();
		t4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		t4.setHorizontalAlignment(SwingConstants.CENTER);
		t4.setEditable(false);
		t4.setColumns(10);
		t4.setBackground(Color.WHITE);
		t4.setBounds(29, 566, 164, 33);
		panel.add(t4);
		
		t5 = new JTextField();
		t5.setFont(new Font("Tahoma", Font.PLAIN, 16));
		t5.setHorizontalAlignment(SwingConstants.CENTER);
		t5.setEditable(false);
		t5.setColumns(10);
		t5.setBackground(Color.WHITE);
		t5.setBounds(29, 612, 164, 33);
		panel.add(t5);
		
		t6 = new JTextField();
		t6.setFont(new Font("Tahoma", Font.PLAIN, 16));
		t6.setHorizontalAlignment(SwingConstants.CENTER);
		t6.setEditable(false);
		t6.setColumns(10);
		t6.setBackground(Color.WHITE);
		t6.setBounds(29, 658, 164, 33);
		panel.add(t6);
		
		t7 = new JTextField();
		t7.setFont(new Font("Tahoma", Font.PLAIN, 16));
		t7.setHorizontalAlignment(SwingConstants.CENTER);
		t7.setEditable(false);
		t7.setColumns(10);
		t7.setBackground(Color.WHITE);
		t7.setBounds(29, 704, 164, 33);
		panel.add(t7);
		
		t8 = new JTextField();
		t8.setFont(new Font("Tahoma", Font.PLAIN, 16));
		t8.setHorizontalAlignment(SwingConstants.CENTER);
		t8.setEditable(false);
		t8.setColumns(10);
		t8.setBackground(Color.WHITE);
		t8.setBounds(29, 750, 164, 33);
		panel.add(t8);
		
		t9 = new JTextField();
		t9.setFont(new Font("Tahoma", Font.PLAIN, 16));
		t9.setHorizontalAlignment(SwingConstants.CENTER);
		t9.setEditable(false);
		t9.setColumns(10);
		t9.setBackground(Color.WHITE);
		t9.setBounds(29, 796, 164, 33);
		panel.add(t9);
		
		t10 = new JTextField();
		t10.setFont(new Font("Tahoma", Font.PLAIN, 16));
		t10.setHorizontalAlignment(SwingConstants.CENTER);
		t10.setEditable(false);
		t10.setColumns(10);
		t10.setBackground(Color.WHITE);
		t10.setBounds(29, 842, 164, 33);
		panel.add(t10);
		
		r1 = new JTextField();
		r1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		r1.setHorizontalAlignment(SwingConstants.CENTER);
		r1.setColumns(10);
		r1.setBackground(Color.WHITE);
		r1.setBounds(263, 428, 85, 33);
		panel.add(r1);
		
		r2 = new JTextField();
		r2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		r2.setHorizontalAlignment(SwingConstants.CENTER);
		r2.setColumns(10);
		r2.setBackground(Color.WHITE);
		r2.setBounds(263, 474, 85, 33);
		panel.add(r2);
		
		r3 = new JTextField();
		r3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		r3.setHorizontalAlignment(SwingConstants.CENTER);
		r3.setColumns(10);
		r3.setBackground(Color.WHITE);
		r3.setBounds(263, 525, 85, 33);
		panel.add(r3);
		
		r4 = new JTextField();
		r4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		r4.setHorizontalAlignment(SwingConstants.CENTER);
		r4.setColumns(10);
		r4.setBackground(Color.WHITE);
		r4.setBounds(263, 571, 85, 33);
		panel.add(r4);
		
		r5 = new JTextField();
		r5.setFont(new Font("Tahoma", Font.PLAIN, 16));
		r5.setHorizontalAlignment(SwingConstants.CENTER);
		r5.setColumns(10);
		r5.setBackground(Color.WHITE);
		r5.setBounds(263, 617, 85, 33);
		panel.add(r5);
		
		r6 = new JTextField();
		r6.setFont(new Font("Tahoma", Font.PLAIN, 16));
		r6.setHorizontalAlignment(SwingConstants.CENTER);
		r6.setColumns(10);
		r6.setBackground(Color.WHITE);
		r6.setBounds(263, 663, 85, 33);
		panel.add(r6);
		
		r7 = new JTextField();
		r7.setFont(new Font("Tahoma", Font.PLAIN, 16));
		r7.setHorizontalAlignment(SwingConstants.CENTER);
		r7.setColumns(10);
		r7.setBackground(Color.WHITE);
		r7.setBounds(263, 709, 85, 33);
		panel.add(r7);
		
		r8 = new JTextField();
		r8.setFont(new Font("Tahoma", Font.PLAIN, 16));
		r8.setHorizontalAlignment(SwingConstants.CENTER);
		r8.setColumns(10);
		r8.setBackground(Color.WHITE);
		r8.setBounds(263, 755, 85, 33);
		panel.add(r8);
		
		r9 = new JTextField();
		r9.setFont(new Font("Tahoma", Font.PLAIN, 16));
		r9.setHorizontalAlignment(SwingConstants.CENTER);
		r9.setColumns(10);
		r9.setBackground(Color.WHITE);
		r9.setBounds(263, 801, 85, 33);
		panel.add(r9);
		
		r10 = new JTextField();
		r10.setFont(new Font("Tahoma", Font.PLAIN, 16));
		r10.setHorizontalAlignment(SwingConstants.CENTER);
		r10.setColumns(10);
		r10.setBackground(Color.WHITE);
		r10.setBounds(263, 847, 85, 33);
		panel.add(r10);
		
		nr1 = new JTextField();
		nr1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		nr1.setHorizontalAlignment(SwingConstants.CENTER);
		nr1.setEditable(false);
		nr1.setColumns(10);
		nr1.setBackground(Color.WHITE);
		nr1.setBounds(450, 433, 164, 33);
		panel.add(nr1);
		
		nr2 = new JTextField();
		nr2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		nr2.setHorizontalAlignment(SwingConstants.CENTER);
		nr2.setEditable(false);
		nr2.setColumns(10);
		nr2.setBackground(Color.WHITE);
		nr2.setBounds(450, 479, 164, 33);
		panel.add(nr2);
		
		nr3 = new JTextField();
		nr3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		nr3.setHorizontalAlignment(SwingConstants.CENTER);
		nr3.setEditable(false);
		nr3.setColumns(10);
		nr3.setBackground(Color.WHITE);
		nr3.setBounds(450, 525, 164, 33);
		panel.add(nr3);
		
		nr4 = new JTextField();
		nr4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		nr4.setHorizontalAlignment(SwingConstants.CENTER);
		nr4.setEditable(false);
		nr4.setColumns(10);
		nr4.setBackground(Color.WHITE);
		nr4.setBounds(450, 571, 164, 33);
		panel.add(nr4);
		
		nr5 = new JTextField();
		nr5.setFont(new Font("Tahoma", Font.PLAIN, 16));
		nr5.setHorizontalAlignment(SwingConstants.CENTER);
		nr5.setEditable(false);
		nr5.setColumns(10);
		nr5.setBackground(Color.WHITE);
		nr5.setBounds(450, 617, 164, 33);
		panel.add(nr5);
		
		nr6 = new JTextField();
		nr6.setFont(new Font("Tahoma", Font.PLAIN, 16));
		nr6.setHorizontalAlignment(SwingConstants.CENTER);
		nr6.setEditable(false);
		nr6.setColumns(10);
		nr6.setBackground(Color.WHITE);
		nr6.setBounds(450, 663, 164, 33);
		panel.add(nr6);
		
		nr7 = new JTextField();
		nr7.setFont(new Font("Tahoma", Font.PLAIN, 16));
		nr7.setHorizontalAlignment(SwingConstants.CENTER);
		nr7.setEditable(false);
		nr7.setColumns(10);
		nr7.setBackground(Color.WHITE);
		nr7.setBounds(450, 709, 164, 33);
		panel.add(nr7);
		
		nr8 = new JTextField();
		nr8.setFont(new Font("Tahoma", Font.PLAIN, 16));
		nr8.setHorizontalAlignment(SwingConstants.CENTER);
		nr8.setEditable(false);
		nr8.setColumns(10);
		nr8.setBackground(Color.WHITE);
		nr8.setBounds(450, 755, 164, 33);
		panel.add(nr8);
		
		nr9 = new JTextField();
		nr9.setFont(new Font("Tahoma", Font.PLAIN, 16));
		nr9.setHorizontalAlignment(SwingConstants.CENTER);
		nr9.setEditable(false);
		nr9.setColumns(10);
		nr9.setBackground(Color.WHITE);
		nr9.setBounds(450, 801, 164, 33);
		panel.add(nr9);
		
		nr10 = new JTextField();
		nr10.setFont(new Font("Tahoma", Font.PLAIN, 16));
		nr10.setHorizontalAlignment(SwingConstants.CENTER);
		nr10.setEditable(false);
		nr10.setColumns(10);
		nr10.setBackground(Color.WHITE);
		nr10.setBounds(450, 847, 164, 33);
		panel.add(nr10);
		
		u1 = new JTextField();
		u1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		u1.setHorizontalAlignment(SwingConstants.CENTER);
		u1.setEditable(false);
		u1.setColumns(10);
		u1.setBackground(Color.WHITE);
		u1.setBounds(703, 433, 164, 33);
		panel.add(u1);
		
		u2 = new JTextField();
		u2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		u2.setHorizontalAlignment(SwingConstants.CENTER);
		u2.setEditable(false);
		u2.setColumns(10);
		u2.setBackground(Color.WHITE);
		u2.setBounds(703, 479, 164, 33);
		panel.add(u2);
		
		u3 = new JTextField();
		u3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		u3.setHorizontalAlignment(SwingConstants.CENTER);
		u3.setEditable(false);
		u3.setColumns(10);
		u3.setBackground(Color.WHITE);
		u3.setBounds(703, 525, 164, 33);
		panel.add(u3);
		
		u4 = new JTextField();
		u4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		u4.setHorizontalAlignment(SwingConstants.CENTER);
		u4.setEditable(false);
		u4.setColumns(10);
		u4.setBackground(Color.WHITE);
		u4.setBounds(703, 571, 164, 33);
		panel.add(u4);
		
		u5 = new JTextField();
		u5.setFont(new Font("Tahoma", Font.PLAIN, 16));
		u5.setHorizontalAlignment(SwingConstants.CENTER);
		u5.setEditable(false);
		u5.setColumns(10);
		u5.setBackground(Color.WHITE);
		u5.setBounds(703, 617, 164, 33);
		panel.add(u5);
		
		u6 = new JTextField();
		u6.setFont(new Font("Tahoma", Font.PLAIN, 16));
		u6.setHorizontalAlignment(SwingConstants.CENTER);
		u6.setEditable(false);
		u6.setColumns(10);
		u6.setBackground(Color.WHITE);
		u6.setBounds(703, 663, 164, 33);
		panel.add(u6);
		
		u7 = new JTextField();
		u7.setFont(new Font("Tahoma", Font.PLAIN, 16));
		u7.setHorizontalAlignment(SwingConstants.CENTER);
		u7.setEditable(false);
		u7.setColumns(10);
		u7.setBackground(Color.WHITE);
		u7.setBounds(703, 709, 164, 33);
		panel.add(u7);
		
		u8 = new JTextField();
		u8.setFont(new Font("Tahoma", Font.PLAIN, 16));
		u8.setHorizontalAlignment(SwingConstants.CENTER);
		u8.setEditable(false);
		u8.setColumns(10);
		u8.setBackground(Color.WHITE);
		u8.setBounds(703, 755, 164, 33);
		panel.add(u8);
		
		u9 = new JTextField();
		u9.setFont(new Font("Tahoma", Font.PLAIN, 16));
		u9.setHorizontalAlignment(SwingConstants.CENTER);
		u9.setEditable(false);
		u9.setColumns(10);
		u9.setBackground(Color.WHITE);
		u9.setBounds(703, 801, 164, 33);
		panel.add(u9);
		
		u10 = new JTextField();
		u10.setFont(new Font("Tahoma", Font.PLAIN, 16));
		u10.setHorizontalAlignment(SwingConstants.CENTER);
		u10.setEditable(false);
		u10.setColumns(10);
		u10.setBackground(Color.WHITE);
		u10.setBounds(703, 847, 164, 33);
		panel.add(u10);
		
		print = new JButton("Print");
		print.addActionListener(this);
		print.setFont(new Font("Tahoma", Font.PLAIN, 18));
		print.setBounds(746, 925, 120, 50);
		panel.add(print);
		
		int cnt,c=0,r=0;
		
		String s = "select * from tests";
		Connection cc = MyConnection.connect();
		try{
			PreparedStatement ps = cc.prepareStatement(s);
			ResultSet rs = ps.executeQuery();
			rs.last();
			cnt = rs.getRow();
			rs.beforeFirst();
			d = new String[cnt][6];
			while(rs.next()){
				d[r][c] = rs.getString("tname");
				++c;
				d[r][c] = String.valueOf(rs.getInt("amount"));
				++c;
				d[r][c] = rs.getString("nrange");
				++c;
				d[r][c] = String.valueOf(rs.getDouble("upper"));
				++c;
				d[r][c] = String.valueOf(rs.getDouble("lower"));
				++c;
				d[r][c] = rs.getString("units");
				c = 0;
				++r;
				ranges.put(rs.getString("tname"), rs.getString("lower")+"-"+rs.getString("upper"));
				
			}
			System.out.println(ranges);
		}
		catch(SQLException se){
			se.printStackTrace();
		}
		t1.setText(d[1][0]);
		t2.setText(d[2][0]);
		t3.setText(d[3][0]);
		t4.setText(d[4][0]);
		t5.setText(d[5][0]);
		t6.setText(d[6][0]);
		t7.setText(d[7][0]);
		t8.setText(d[8][0]);
		t9.setText(d[9][0]);
		t10.setText(d[10][0]);
		
		nr1.setText(d[1][2]);
		nr2.setText(d[2][2]);
		nr3.setText(d[3][2]);
		nr4.setText(d[4][2]);
		nr5.setText(d[5][2]);
		nr6.setText(d[6][2]);
		nr7.setText(d[7][2]);
		nr8.setText(d[8][2]);
		nr9.setText(d[9][2]);
		nr10.setText(d[10][2]);
		
		u1.setText(d[1][5]);
		u2.setText(d[2][5]);
		u3.setText(d[3][5]);
		u4.setText(d[4][5]);
		u5.setText(d[5][5]);
		u6.setText(d[6][5]);
		u7.setText(d[7][5]);
		u8.setText(d[8][5]);
		u9.setText(d[9][5]);
		u10.setText(d[10][5]);
		
		String s1 = "select pname,age,gender,tests,total from patientdetails where rid = ?";
		String test = "";
		try{
			PreparedStatement ps = cc.prepareStatement(s1);
			ps.setInt(1, rid);
			ResultSet rs = ps.executeQuery();
			rs.next();
			name.setText(rs.getString("pname"));
			age.setText(String.valueOf(rs.getInt("age")));
			sex.setText(rs.getString("gender"));	
			test = rs.getString("tests");
			t = rs.getInt("total");
		}
		catch(SQLException se){
			se.printStackTrace();
		}
		
		List<String> result = Arrays.asList(test.split("\\s*,\\s*"));
		
		for(String k:result){
			if(k.contains(d[1][0])){
				t1.setBackground(Color.green);
			}
			if(k.contains(d[2][0])){
				t2.setBackground(Color.green);
			}
			if(k.contains(d[3][0])){
				t3.setBackground(Color.green);
			}
			if(k.contains(d[4][0])){
				t4.setBackground(Color.green);
			}
			if(k.contains(d[5][0])){
				t5.setBackground(Color.green);
			}
			if(k.contains(d[6][0])){
				t6.setBackground(Color.green);
			}
			if(k.contains(d[7][0])){
				t7.setBackground(Color.green);
			}
			if(k.contains(d[8][0])){
				t8.setBackground(Color.green);
			}
			if(k.contains(d[9][0])){
				t9.setBackground(Color.green);
			}
			if(k.contains(d[10][0])){
				t10.setBackground(Color.green);
			}
		}
		
		if(test.equals("CBC")){
			t1.setBackground(Color.green);
			t2.setBackground(Color.green);
			t3.setBackground(Color.green);
			t4.setBackground(Color.green);
			t5.setBackground(Color.green);
			t6.setBackground(Color.green);
			t7.setBackground(Color.green);
			t8.setBackground(Color.green);
			t9.setBackground(Color.green);
			t10.setBackground(Color.green);
		}
		col = Color.green;
		r1.setText("-");
		r1.setEditable(false);
		r2.setText("-");
		r2.setEditable(false);
		r3.setText("-");
		r3.setEditable(false);
		r4.setText("-");
		r4.setEditable(false);
		r5.setText("-");
		r5.setEditable(false);
		r6.setText("-");
		r6.setEditable(false);
		r7.setText("-");
		r7.setEditable(false);
		r8.setText("-");
		r8.setEditable(false);
		r9.setText("-");
		r9.setEditable(false);
		r10.setText("-");
		r10.setEditable(false);
		
		JLabel lbltotal = new JLabel("Total");
		lbltotal.setHorizontalAlignment(SwingConstants.CENTER);
		lbltotal.setFont(new Font("Tahoma", Font.ITALIC, 16));
		lbltotal.setBounds(450, 309, 85, 26);
		panel.add(lbltotal);
		
		total = new JTextField();
		total.setText("0");
		total.setHorizontalAlignment(SwingConstants.CENTER);
		total.setFont(new Font("Tahoma", Font.BOLD, 16));
		total.setEditable(false);
		total.setColumns(10);
		total.setBackground(Color.WHITE);
		total.setBounds(539, 306, 113, 28);
		total.setText(String.valueOf(t));
		panel.add(total);
		
		show = new JButton("Show");
		show.addActionListener(this);
		show.setFont(new Font("Tahoma", Font.PLAIN, 18));
		show.setBounds(35, 925, 120, 50);
		panel.add(show);
		
		if(t1.getBackground().equals(col)){
			r1.setText("");
			r1.setEditable(true);
		}
		if(t2.getBackground().equals(col)){
			r2.setText("");
			r2.setEditable(true);
		}
		if(t3.getBackground().equals(col)){
			r3.setText("");
			r3.setEditable(true);
		}
		if(t4.getBackground().equals(col)){
			r4.setText("");
			r4.setEditable(true);
		}
		if(t5.getBackground().equals(col)){
			r5.setText("");
			r5.setEditable(true);
		}
		if(t6.getBackground().equals(col)){
			r6.setText("");
			r6.setEditable(true);
		}
		if(t7.getBackground().equals(col)){
			r7.setText("");
			r7.setEditable(true);
		}
		if(t8.getBackground().equals(col)){
			r8.setText("");
			r8.setEditable(true);
		}
		if(t9.getBackground().equals(col)){
			r9.setText("");
			r9.setEditable(true);
		}
		if(t10.getBackground().equals(col)){
			r10.setText("");
			r10.setEditable(true);
		}
		JPanel panelToScroleOver = new JPanel();
		panelToScroleOver.setLayout(new BorderLayout());
		frame.getContentPane().add(panelToScroleOver);

		JTabbedPane documents = new JTabbedPane();
		panel.setPreferredSize(new Dimension(800,1000));

		JScrollPane editorScroll = new JScrollPane(panel);
//		documents.add("doc1", editorScroll);

		frame.getContentPane().add(editorScroll);
		frame.setSize(getMaximumSize());

		frame.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object ob = e.getSource();
		if(ob == print){
			if(t1.getBackground().equals(col)){
				r1.setEditable(false);
			}
			if(t2.getBackground().equals(col)){
				r2.setEditable(false);
			}
			if(t3.getBackground().equals(col)){
				r3.setEditable(false);
			}
			if(t4.getBackground().equals(col)){
				r4.setEditable(false);
			}
			if(t5.getBackground().equals(col)){
				r5.setEditable(false);
			}
			if(t6.getBackground().equals(col)){
				r6.setEditable(false);
			}
			if(t7.getBackground().equals(col)){
				r7.setEditable(false);
			}
			if(t8.getBackground().equals(col)){
				r8.setEditable(false);
			}
			if(t9.getBackground().equals(col)){
				r9.setEditable(false);
			}
			if(t10.getBackground().equals(col)){
				r10.setEditable(false);
			}
		}
		else if(ob==show){
			double res,lower,upper;
			if(t1.getBackground().equals(col)){
				res=Double.parseDouble(r1.getText());
				lower=Double.parseDouble(d[1][4]);
				upper=Double.parseDouble(d[1][3]);
				if(res<lower || res>upper)
					r1.setBackground(Color.red);
			}
			if(t2.getBackground().equals(col)){
				res=Double.parseDouble(r2.getText());
				lower=Double.parseDouble(d[2][4]);
				upper=Double.parseDouble(d[2][3]);
				if(res<lower || res>upper)
					r2.setBackground(Color.red);
			}
			if(t3.getBackground().equals(col)){
				res=Double.parseDouble(r3.getText());
				lower=Double.parseDouble(d[3][4]);
				upper=Double.parseDouble(d[3][3]);
				if(res<lower || res>upper)
					r3.setBackground(Color.red);
			}
			if(t4.getBackground().equals(col)){
				res=Double.parseDouble(r4.getText());
				lower=Double.parseDouble(d[4][4]);
				upper=Double.parseDouble(d[4][3]);
				if(res<lower || res>upper)
					r4.setBackground(Color.red);
			}
			if(t5.getBackground().equals(col)){
				res=Double.parseDouble(r5.getText());
				lower=Double.parseDouble(d[5][4]);
				upper=Double.parseDouble(d[5][3]);
				if(res<lower || res>upper )
					r5.setBackground(Color.red);
			}
			if(t6.getBackground().equals(col)){
				res=Double.parseDouble(r6.getText());
				lower=Double.parseDouble(d[6][4]);
				upper=Double.parseDouble(d[6][3]);
				if(res<lower || res>upper )
					r6.setBackground(Color.red);
			}
			if(t7.getBackground().equals(col)){
				res=Double.parseDouble(r7.getText());
				lower=Double.parseDouble(d[7][4]);
				upper=Double.parseDouble(d[7][3]);
				if(res<lower || res>upper )
					r7.setBackground(Color.red);
			}
			if(t8.getBackground().equals(col)){
				res=Double.parseDouble(r8.getText());
				lower=Double.parseDouble(d[8][4]);
				upper=Double.parseDouble(d[8][3]);
				if(res<lower || res>upper )
					r8.setBackground(Color.red);
			}
			if(t9.getBackground().equals(col)){
				res=Double.parseDouble(r9.getText());
				lower=Double.parseDouble(d[9][4]);
				upper=Double.parseDouble(d[9][3]);
				if(res<lower || res>upper )
					r9.setBackground(Color.red);
			}
			if(t10.getBackground().equals(col)){
				res=Double.parseDouble(r10.getText());
				lower=Double.parseDouble(d[10][4]);
				upper=Double.parseDouble(d[10][3]);
				if(res<lower || res>upper)
					r10.setBackground(Color.red);
			}
		}
		
	}
}
