package Report;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Choice extends JDialog implements ItemListener,ActionListener {
	private JTextField te,th,thaemo,tm,tM,tcbc;
	private JRadioButton st,cbc;
	private JCheckBox esr,hct,haemo,mch,mcv,rdwcv,rdwsd,wbc,plt,rbc;
	private JButton cont,save;
	private JTextField ttotal,tp,tr,tcv,tsd,tw;
	public static int p;
	int rid;
	String s1;
	ArrayList<String> t = new ArrayList<String>();
	int [] a = null;
	public Choice(int rid) {
		this.rid = rid;
		setTitle("Select Tests");
		getContentPane().setLayout(null);
		
		JLabel lblSelectTestsTo = new JLabel("Select Tests to be Conducted");
		lblSelectTestsTo.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblSelectTestsTo.setBounds(92, 11, 260, 27);
		getContentPane().add(lblSelectTestsTo);
		
		cbc = new JRadioButton("CBC");
	    cbc.setBounds(27, 45, 167, 27);
		getContentPane().add(cbc);
		
		st = new JRadioButton("Selected Tests");
		st.setBounds(27, 75, 167, 27);
		getContentPane().add(st);
		
		esr = new JCheckBox("ESR");
		esr.setBounds(52, 105, 142, 27);
		getContentPane().add(esr);
		
		hct = new JCheckBox("HCT");
		hct.setBounds(52, 135, 142, 27);
		getContentPane().add(hct);
		
		haemo = new JCheckBox("Haemoglobin");
		haemo.setBounds(52, 165, 142, 27);
		getContentPane().add(haemo);
		
		mch = new JCheckBox("MCH");
		mch.setBounds(52, 195, 142, 27);
		getContentPane().add(mch);
		
		mcv = new JCheckBox("MCV");
		mcv.setBounds(52, 227, 142, 27);
		getContentPane().add(mcv);
		
		cont = new JButton("Show Total");
		cont.setFont(new Font("Tahoma", Font.BOLD, 14));
		cont.setBounds(52, 483, 118, 38);
		getContentPane().add(cont);
		
		te = new JTextField();
		te.setBackground(Color.WHITE);
		te.setEditable(false);
		te.setBounds(243, 108, 123, 20);
		getContentPane().add(te);
		te.setColumns(10);
		
		th = new JTextField();
		th.setEditable(false);
		th.setColumns(10);
		th.setBackground(Color.WHITE);
		th.setBounds(243, 138, 123, 20);
		getContentPane().add(th);
		
		thaemo = new JTextField();
		thaemo.setEditable(false);
		thaemo.setColumns(10);
		thaemo.setBackground(Color.WHITE);
		thaemo.setBounds(243, 168, 123, 20);
		getContentPane().add(thaemo);
		
		tm = new JTextField();
		tm.setEditable(false);
		tm.setColumns(10);
		tm.setBackground(Color.WHITE);
		tm.setBounds(243, 198, 123, 20);
		getContentPane().add(tm);
		
		tM = new JTextField();
		tM.setEditable(false);
		tM.setColumns(10);
		tM.setBackground(Color.WHITE);
		tM.setBounds(243, 230, 123, 20);
		getContentPane().add(tM);
		
		tcbc = new JTextField();
		tcbc.setEditable(false);
		tcbc.setColumns(10);
		tcbc.setBackground(Color.WHITE);
		tcbc.setBounds(243, 49, 123, 20);
		getContentPane().add(tcbc);
		
		JLabel total = new JLabel("Total Fees:");
		total.setFont(new Font("Tahoma", Font.BOLD, 14));
		total.setBounds(52, 405, 136, 28);
		getContentPane().add(total);
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(cbc);
		bg.add(st);
		
		ttotal = new JTextField();
		ttotal.setEditable(false);
		ttotal.setColumns(10);
		ttotal.setBackground(Color.WHITE);
		ttotal.setBounds(243, 411, 123, 20);
		getContentPane().add(ttotal);
		
		esr.setEnabled(false);
		te.setEnabled(false);
		hct.setEnabled(false);
		th.setEnabled(false);
		haemo.setEnabled(false);
		thaemo.setEnabled(false);
		mch.setEnabled(false);
		tm.setEnabled(false);
		mcv.setEnabled(false);
		tM.setEnabled(false);
		
		plt = new JCheckBox("PLT");
		plt.setEnabled(false);
		plt.setBounds(52, 257, 142, 27);
		getContentPane().add(plt);
		
		rbc = new JCheckBox("RBC");
		rbc.setEnabled(false);
		rbc.setBounds(52, 287, 142, 27);
		getContentPane().add(rbc);
		
		rdwcv = new JCheckBox("RDW-CV");
		rdwcv.setEnabled(false);
		rdwcv.setBounds(52, 317, 142, 27);
		getContentPane().add(rdwcv);
		
		tp = new JTextField();
		tp.setEnabled(false);
		tp.setEditable(false);
		tp.setColumns(10);
		tp.setBackground(Color.WHITE);
		tp.setBounds(243, 260, 123, 20);
		getContentPane().add(tp);
		
		tr = new JTextField();
		tr.setEnabled(false);
		tr.setEditable(false);
		tr.setColumns(10);
		tr.setBackground(Color.WHITE);
		tr.setBounds(243, 290, 123, 20);
		getContentPane().add(tr);
		
		tcv = new JTextField();
		tcv.setEnabled(false);
		tcv.setEditable(false);
		tcv.setColumns(10);
		tcv.setBackground(Color.WHITE);
		tcv.setBounds(243, 320, 123, 20);
		getContentPane().add(tcv);
		
		tsd = new JTextField();
		tsd.setEnabled(false);
		tsd.setEditable(false);
		tsd.setColumns(10);
		tsd.setBackground(Color.WHITE);
		tsd.setBounds(243, 351, 123, 20);
		getContentPane().add(tsd);
		
		tw = new JTextField();
		tw.setEnabled(false);
		tw.setEditable(false);
		tw.setColumns(10);
		tw.setBackground(Color.WHITE);
		tw.setBounds(243, 382, 123, 20);
		getContentPane().add(tw);
		
		rdwsd = new JCheckBox("RDW-SD");
		rdwsd.setEnabled(false);
		rdwsd.setBounds(52, 347, 142, 27);
		getContentPane().add(rdwsd);
		
		wbc = new JCheckBox("WBC");
		wbc.setEnabled(false);
		wbc.setBounds(52, 377, 142, 27);
		getContentPane().add(wbc);
		
		save = new JButton("Save To Database");
		save.setFont(new Font("Tahoma", Font.BOLD, 14));
		save.setBounds(215, 483, 175, 38);
		getContentPane().add(save);
			
		cont.addActionListener(this);
		save.addActionListener(this);
		st.addItemListener(this);
		cbc.addItemListener(this);
		esr.addItemListener(this);
		hct.addItemListener(this);
		wbc.addItemListener(this);
		rbc.addItemListener(this);
		plt.addItemListener(this);
		haemo.addItemListener(this);
		rdwcv.addItemListener(this);
		rdwsd.addItemListener(this);
		mcv.addItemListener(this);
		mch.addItemListener(this);
		
		setBounds(600,10,500,600);
		setVisible(true);
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		Object ob = e.getSource();
		if(ob == cbc){
			String m = "0";
			ttotal.setText("0");
			esr.setEnabled(false);
			esr.setSelected(false);
			te.setText(m);
			hct.setEnabled(false);
			hct.setSelected(false);
			th.setText(m);
			haemo.setEnabled(false);
			haemo.setSelected(false);
			thaemo.setText(m);
			mch.setEnabled(false);
			mch.setSelected(false);
			tm.setText(m);
			mcv.setEnabled(false);
			mcv.setSelected(false);
			tM.setText(m);
			plt.setEnabled(false);
			plt.setSelected(false);
			tp.setText(m);
			rbc.setEnabled(false);
			rbc.setSelected(false);
			tr.setText(m);
			rdwcv.setEnabled(false);
			rdwcv.setSelected(false);
			tcv.setText(m);
			rdwsd.setEnabled(false);
			rdwsd.setSelected(false);
			tsd.setText(m);
			wbc.setEnabled(false);
			wbc.setSelected(false);
			tw.setText(m);
			tcbc.setText("1000");
			ttotal.setText("1000");
			tcbc.setEnabled(true);
			s1 = "CBC";
			NewRegistration.testdetail.setText("CBC");
		}
		else if(ob == st){
			ttotal.setText("0");
			tcbc.setText("0");
			tcbc.setEnabled(true);
			esr.setEnabled(true);
			te.setEnabled(true);
			hct.setEnabled(true);
			th.setEnabled(true);
			haemo.setEnabled(true);
			thaemo.setEnabled(true);
			mch.setEnabled(true);
			tm.setEnabled(true);
			mcv.setEnabled(true);
			tM.setEnabled(true);
			plt.setEnabled(true);
			tp.setEnabled(true);
			rbc.setEnabled(true);
			tr.setEnabled(true);
			rdwcv.setEnabled(true);
			tcv.setEnabled(true);
			rdwsd.setEnabled(true);
			tsd.setEnabled(true);
			wbc.setEnabled(true);
			tw.setEnabled(true);
			tcbc.setEnabled(false);
			String s = "select amount from tests";
			Connection c = MyConnection.connect();
			try{
				PreparedStatement ps = c.prepareStatement(s);
				ResultSet rs = ps.executeQuery();
				rs.last();
				int x = rs.getRow();
				a = new int[x];
				int i = 0;
				rs.beforeFirst();
				while(rs.next()){
					a[i] = rs.getInt(1);
					i++;
				}
			}
			catch(SQLException se){
				se.printStackTrace();
			}
				esr.addItemListener(new ItemListener() {
					
					@Override
					public void itemStateChanged(ItemEvent arg0) {
						te.setText(String.valueOf(a[1]));
					}
				});
				
				hct.addItemListener(new ItemListener() {
					
					@Override
					public void itemStateChanged(ItemEvent e) {
						th.setText(String.valueOf(a[2]));
					}
				});
				haemo.addItemListener(new ItemListener() {
					
					@Override
					public void itemStateChanged(ItemEvent e) {
						thaemo.setText(String.valueOf(a[3]));
					}
				});
				mch.addItemListener(new ItemListener() {
					
					@Override
					public void itemStateChanged(ItemEvent e) {
						tm.setText(String.valueOf(a[4]));
					}
				});
				mcv.addItemListener(new ItemListener() {
					
					@Override
					public void itemStateChanged(ItemEvent e) {
						tM.setText(String.valueOf(a[5]));
					}
				});
				plt.addItemListener(new ItemListener() {
					
					@Override
					public void itemStateChanged(ItemEvent e) {
						tp.setText(String.valueOf(a[6]));
					}
				});
				rbc.addItemListener(new ItemListener() {
					
					@Override
					public void itemStateChanged(ItemEvent e) {
						tr.setText(String.valueOf(a[7]));
					}
				});
				rdwcv.addItemListener(new ItemListener() {
					
					@Override
					public void itemStateChanged(ItemEvent e) {
						tcv.setText(String.valueOf(a[8]));
					}
				});
				rdwsd.addItemListener(new ItemListener() {
					
					@Override
					public void itemStateChanged(ItemEvent e) {
						tsd.setText(String.valueOf(a[9]));
					}
				});
				wbc.addItemListener(new ItemListener() {
					
					@Override
					public void itemStateChanged(ItemEvent e) {
						tw.setText(String.valueOf(a[10]));
					}
				});
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object ob = e.getSource();
		int y = 0;
		if(ob == cont){
			if(st.isSelected()){
				if(esr.isSelected()){
					t.add("ESR");
					y+=a[1];
				}
				if(hct.isSelected()){
					t.add("HCT");
					y+=a[2];
				}
				if(haemo.isSelected()){
					t.add("Haemoglobin");
					y+=a[3];
				}
				if(mch.isSelected()){
					t.add("MCH");
					y+=a[4];
				}
				if(mcv.isSelected()){
					t.add("MCV");
					y+=a[5];
				}
				if(plt.isSelected()){
					t.add("PLT");
					y+=a[6];
				}
				if(rbc.isSelected()){
					t.add("RBC");
					y+=a[7];
				}
				if(rdwcv.isSelected()){
					t.add("RDW-CV");
					y+=a[8];
				}
				if(rdwsd.isSelected()){
					t.add("RDW-SD");
					y+=a[9];
				}
				if(wbc.isSelected()){
					t.add("WBC");
					y+=a[10];
				}
				ttotal.setText(String.valueOf(y));
				String s = "update patientdetails set total = ? where rid = ?";
				Connection c = MyConnection.connect();
				try{
					PreparedStatement ps = c.prepareStatement(s);
					ps.setInt(1,y);
					ps.setInt(2, rid);
					ps.executeUpdate();
				}
				catch(SQLException se){
					se.printStackTrace();
				}
			} else {
				y = 1000;
				ttotal.setText(String.valueOf(y));
				String s = "update patientdetails set total = ? where rid = ?";
				Connection c = MyConnection.connect();
				try{
					PreparedStatement ps = c.prepareStatement(s);
					ps.setInt(1,y);
					ps.setInt(2, rid);
					ps.executeUpdate();
				}
				catch(SQLException se){
					se.printStackTrace();
				}
			}
		}
		if(ob == save){
			String s = "update patientdetails set tests = ? where rid = ?";
			Connection c = MyConnection.connect();
			StringBuffer sb = new StringBuffer();
			Iterator i = t.iterator();
			int count = 0;
			while(i.hasNext()){
				sb = sb.append(i.next());
				sb = sb.append(",");
				count++;
			}
			if(st.isSelected()){
				if(count > 1){
					s1 = sb.toString().substring(0,sb.length()-1);
					System.out.println(s1);
				} else {
					s1 = sb.toString().substring(0,sb.length());
					System.out.println(s1);
				}
			}
			try{
				PreparedStatement ps = c.prepareStatement(s);
				ps.setString(1,s1);
				ps.setInt(2, rid);
				ps.executeUpdate();
				JOptionPane.showMessageDialog(null, "Tests info added");
				NewRegistration.testdetail.setText(s1);
				dispose();
			}
			catch(SQLException se){
				se.printStackTrace();
			}
			p = Integer.parseInt(ttotal.getText());
			dispose();
		}
	}
	public static int getDue(){
		return p;
	}
}
