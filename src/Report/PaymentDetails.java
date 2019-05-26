package Report;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Color;

public class PaymentDetails extends JDialog implements ActionListener
{
	private JTextField tta;
	private JTextField tpa;
	private JTextField tap;
	private JTextField tba;
	private JButton submit;
	private JButton cancel;
	int rid;
	int total,paid,bal;
	public PaymentDetails(int rid) {
		this.rid = rid;
		getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		setTitle("Payment Details ");
		setSize(500,500);
		getContentPane().setLayout(null);
		
		JLabel lblTotalAmount = new JLabel("Total Amount");
		lblTotalAmount.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		lblTotalAmount.setBounds(29, 57, 129, 23);
		getContentPane().add(lblTotalAmount);
		
		JLabel lblPaidAmount = new JLabel("Paid Amount");
		lblPaidAmount.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		lblPaidAmount.setBounds(29, 107, 129, 29);
		getContentPane().add(lblPaidAmount);
		
		JLabel lblBalanceAmount = new JLabel("Balance Amount");
		lblBalanceAmount.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		lblBalanceAmount.setBounds(29, 204, 129, 29);
		getContentPane().add(lblBalanceAmount);
		
		JLabel lblAmountToPay = new JLabel("Amount to Pay");
		lblAmountToPay.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		lblAmountToPay.setBounds(29, 157, 129, 23);
		getContentPane().add(lblAmountToPay);
		
		submit = new JButton("Submit");
		submit.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		submit.setBounds(29, 286, 101, 37);
		getContentPane().add(submit);
		
		cancel = new JButton("Cancel");
		cancel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		cancel.setBounds(300, 286, 96, 37);
		getContentPane().add(cancel);
		
		tta = new JTextField();
		tta.setBackground(Color.WHITE);
		tta.setEditable(false);
		tta.setBounds(210, 48, 186, 32);
		getContentPane().add(tta);
		tta.setColumns(10);
		
		tpa = new JTextField();
		tpa.setBackground(Color.WHITE);
		tpa.setEditable(false);
		tpa.setColumns(10);
		tpa.setBounds(210, 104, 186, 32);
		getContentPane().add(tpa);
		
		tap = new JTextField();
		tap.setColumns(10);
		tap.setBounds(210, 159, 186, 29);
		getContentPane().add(tap);
		
		tba = new JTextField();
		tba.setBackground(Color.WHITE);
		tba.setEditable(false);
		tba.setColumns(10);
		tba.setBounds(210, 209, 186, 32);
		getContentPane().add(tba);
		String s = "select paid,due,total from patientdetails where rid = ?";
		Connection con = MyConnection.connect();
		try{
			PreparedStatement ps = con.prepareStatement(s);
			ps.setInt(1, rid);
			ResultSet rs = ps.executeQuery();
			rs.next();
			total = rs.getInt("total");
			paid = rs.getInt("paid");
			bal = total-paid;
			tpa.setText(String.valueOf(paid));
			tba.setText(String.valueOf(bal));
			tta.setText(String.valueOf(total));
		}
		catch(SQLException se){
			se.printStackTrace();
		}
		tap.addActionListener(this);
		submit.addActionListener(this);
		cancel.addActionListener(this);
		setVisible(true);

	}

	
	public void actionPerformed(ActionEvent e) {
		Object ob = e.getSource();
		if(ob == submit){
			String s = "update patientdetails set paid = ?,due = ? where rid = ?";
			Connection con = MyConnection.connect();
		try{
				PreparedStatement ps = con.prepareStatement(s);
				int a = Integer.parseInt(tap.getText());
				if((bal-a)<0){
					JOptionPane.showMessageDialog(null, "Your balance is Rs "+ bal);
				}
				else{
					paid = paid+a;
					bal = bal-a;
					ps.setInt(1, paid);
					ps.setInt(2, bal);
					ps.setInt(3, rid);
					ps.executeUpdate();
					JOptionPane.showMessageDialog(null, "Payment successful");
				}
				dispose();
				
			}
			catch(SQLException se){
				se.printStackTrace();
			}
		}
		else if(ob == cancel){
			JOptionPane.showMessageDialog(null, "You have to pay for this later because if you don't pay you won't be able to get your report.");
			dispose();
		}
	}
}
