package Report;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Toolkit;

public class DashBoard extends JFrame implements ActionListener{
	static NewRegistration nr;
	private JMenuItem n,u,id,t,p,cl;
	private JMenu gen;
	private JMenuItem rep;
	int d,pa,to;
	public DashBoard() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(DashBoard.class.getResource("/project/images/back.jpg")));
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu nreg = new JMenu("Registration");
		nreg.setForeground(Color.BLACK);
		nreg.setMnemonic('R');
		nreg.setFont(new Font("Segoe UI", Font.BOLD, 16));
		menuBar.add(nreg);
		
		n = new JMenuItem("New");
		n.setForeground(Color.BLACK);
		n.setFont(new Font("Segoe UI Historic", Font.ITALIC, 16));
		nreg.add(n);
		
		u = new JMenuItem("Update");
		u.setForeground(Color.BLACK);
		u.setFont(new Font("Segoe UI", Font.ITALIC, 16));
		nreg.add(u);
		
		gen = new JMenu("Generate Report");
		gen.setForeground(Color.BLACK);
		gen.setMnemonic('G');
		gen.setFont(new Font("Segoe UI", Font.BOLD, 16));
		menuBar.add(gen);
		
		rep = new JMenuItem("Enter ID");
		rep.setHorizontalAlignment(SwingConstants.CENTER);
		gen.add(rep);
		
		JMenu payment = new JMenu("Payment Option");
		payment.setMnemonic('P');
		payment.setForeground(Color.BLACK);
		payment.setFont(new Font("Segoe UI", Font.BOLD, 16));
		menuBar.add(payment);
		
		id = new JMenuItem("By ID");
		id.setHorizontalAlignment(SwingConstants.LEFT);
		id.setForeground(Color.DARK_GRAY);
		id.setFont(new Font("Segoe UI", Font.ITALIC, 16));
		payment.add(id);
		
		JMenu view = new JMenu("View Details");
		view.setMnemonic('V');
		view.setForeground(Color.BLACK);
		view.setFont(new Font("Segoe UI", Font.BOLD, 16));
		menuBar.add(view);
		
		t = new JMenuItem("Tests Details");
		t.setFont(new Font("Segoe UI", Font.ITALIC, 16));
		t.setForeground(Color.BLACK);
		view.add(t);
		
		p = new JMenuItem("Patient Details");
		p.setForeground(Color.BLACK);
		p.setFont(new Font("Segoe UI", Font.ITALIC, 16));
		view.add(p);
		
		JMenu e = new JMenu("Exit");
		e.setFont(new Font("Segoe UI", Font.BOLD, 15));
		e.setForeground(Color.BLACK);
		e.setMnemonic('E');
		menuBar.add(e);
		
		cl = new JMenuItem("Close");
		cl.setFont(new Font("Segoe UI", Font.ITALIC, 16));
		cl.setForeground(Color.RED);
		cl.setHorizontalAlignment(SwingConstants.CENTER);
		e.add(cl);
		
		t.addActionListener(this);
		p.addActionListener(this);
		cl.addActionListener(this);
		u.addActionListener(this);
		n.addActionListener(this);
		id.addActionListener(this);
		rep.addActionListener(this);
		
		setSize(getMaximumSize());
		ImageIcon ii=new ImageIcon(getClass().getResource("/project/images/back.jpg"));
		JLabel lab=new JLabel(ii);
		lab.setSize(getMaximumSize());
		getContentPane().add(lab);
		setSize(getMaximumSize());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	public static void main(String[] args) {
		new DashBoard();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object ob = e.getSource();
		if(ob == t){
			new ViewTests();
		}
		else if(ob == p){
			new ViewPatients();
		}
		else if(ob == cl){
			int re = JOptionPane.showConfirmDialog(null, "Sure to close","Practice",JOptionPane.YES_NO_CANCEL_OPTION);
			if(re == 0){
				System.exit(0);
			}
		}
		else if(ob == u){
			String u = JOptionPane.showInputDialog(null, "Enter Registration ID");
			int p = Integer.parseInt(u);
			boolean x = Checks.checkID(p);
			if(x)
				new PatientUpdate(p);
		}
		else if(ob == n){
			nr=new NewRegistration();
		}
		else if(ob == id){
			String u = JOptionPane.showInputDialog(null, "Enter Registration ID");
			int p = Integer.parseInt(u);
			boolean x = Checks.checkID(p);
			if(x)
				new PaymentDetails(p);
		}
		else if(ob == rep){
			String u = JOptionPane.showInputDialog(null, "Enter Registration ID");
			int p = Integer.parseInt(u);
			boolean x = Checks.checkID(p);
			if(x){
				String s = "select due,paid,total from patientdetails where rid = ?";
				Connection con = MyConnection.connect();
				try{
					PreparedStatement ps = con.prepareStatement(s);
					ps.setInt(1, p);
					ResultSet rs = ps.executeQuery();
					rs.next();
					d = rs.getInt("due");
					pa = rs.getInt("paid");
					to = rs.getInt("total");
				}
				catch(SQLException se){
					se.printStackTrace();
				}
				if(d == 0 && pa-to == 0){
					new PatientReport(p);
				}
				else {
					JOptionPane.showMessageDialog(null, "First go, and clear all your dues then only you can get your report.");
					return;
				}
			}
				
		}
	}
}
