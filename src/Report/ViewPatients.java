package Report;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class ViewPatients {

	final JDialog dialog = new JDialog();
	int cnt,c,r;
	String [] columns;
	String [][] data;
	public ViewPatients() {
		String s = "select * from patientdetails";
		columns = new String[]{"Registration ID","Patient Name","Father Name","Age",
				"Gender","Mobile No.","Address","Paid Amount","Due Amount","Tests"};
		Connection cc = MyConnection.connect();
		try{
			PreparedStatement ps = cc.prepareStatement(s);
			ResultSet rs = ps.executeQuery();
			rs.last();
			cnt = rs.getRow();
			rs.beforeFirst();
			data = new String[cnt][10];
			while(rs.next()){
				data[r][c] = String.valueOf(rs.getInt("rid"));
				++c;
				data[r][c] = rs.getString("pname");
				++c;
				data[r][c] = rs.getString("fname");
				++c;
				data[r][c] = String.valueOf(rs.getInt("age"));
				++c;
				data[r][c] = rs.getString("gender");
				++c;
				data[r][c] = rs.getString("cno");
				++c;
				data[r][c] = rs.getString("address");
				++c;
				data[r][c] = String.valueOf(rs.getInt("paid"));
				++c;
				data[r][c] = String.valueOf(rs.getInt("due"));
				++c;
				data[r][c] = rs.getString("tests");
				c = 0;
				++r;
			}
			JTable table = new JTable(data,columns);
			table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			JScrollPane jsp = new JScrollPane(table,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
			table.setEnabled(false);
			JButton back = new JButton("Close");
			dialog.setLayout(null);
			dialog.setModal(true);
			dialog.setSize(500,400);
			back.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					dialog.dispose();
					
				}
			});
			back.setBounds(10,10,80,30);
			jsp.setBounds(10,60,400,300);
			dialog.add(back);
			dialog.add(jsp);
			dialog.setVisible(true);
		}
		catch(SQLException se){
			se.printStackTrace();
		}
		
	}

}
