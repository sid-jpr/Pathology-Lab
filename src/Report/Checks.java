package Report;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

public class Checks {
	
	static boolean checkID(int rid){
		boolean found = false;
		Connection con = MyConnection.connect();
		try{
			PreparedStatement ps = con.prepareStatement("select rid from patientdetails where rid = ?");
			ps.setInt(1, rid);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				found = true;
			}
			else{
				JOptionPane.showMessageDialog(null, "Registration ID not found");
			}
		}
		catch(SQLException se){
			se.printStackTrace();
		}
		return found;
	}
}
