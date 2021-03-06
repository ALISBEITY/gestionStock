import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.Date;

class EditUnit2 extends JInternalFrame implements ActionListener
{
	Connection con;
	ResultSet rs;
	Statement st;
	String url="jdbc:odbc:stock"; 
	String sTxtId,sTxtProd,sTxtPno,sTxtPs,sTxtQty,sTxtTqty,sTxtAswork,sTxtDt,sTxtDdt;
	String qry;
	String selType;
	JPanel pane0,pane1,pane2;
	JComboBox cmb1;
	JButton btnfirst,btnnext,btnprev,btnlast,btnupdate;
	JTextField txtId,txtProd,txtPno,txtPs,txtQty,txtTqty,txtAswork,txtDt,txtDdt;
	JLabel lbl1,lbl2,lbl4,lbl5,lbl6,lbl7,lbl8,lbl9,lbl10;
	String unit;
	public EditUnit2(JFrame parent)
	{
		super("Edit Unit-2",true,true);
	
		unit="Unit-2";
	
		setSize(450,500);
		setVisible(true);					

		pane0=new JPanel();
		pane1=new JPanel();
		pane2=new JPanel();


		lbl1=new JLabel("Product ID: ");
		lbl2=new JLabel("Product Name: ");
		lbl4=new JLabel("Pattern No: ");
		lbl5=new JLabel("No. of Pattern Selected: ");
		lbl6=new JLabel("Quantity: ");
		lbl7=new JLabel("Total Quantity: ");
		lbl8=new JLabel("Name of Assigned Work: ");
		lbl9=new JLabel("Date: ");
		lbl10=new JLabel("Due Date: ");

		cmb1=new JComboBox();
		cmb1.addItem("MS-40");
		cmb1.addItem("MS-60");
		cmb1.addActionListener(this);
		
		txtId=new JTextField(13);
		txtProd=new JTextField(8);
		txtPno=new JTextField(8);
		txtPs=new JTextField(8);
		txtQty=new JTextField(8);
		txtTqty=new JTextField(8);
		txtAswork=new JTextField(8);
		txtDt=new JTextField(8);
		txtDdt=new JTextField(8);


		pane0.add(lbl1);	
		pane0.add(cmb1);
		pane0.add(txtId);

		pane1.add(lbl2);
		pane1.add(txtProd);
		pane1.add(lbl4);
		pane1.add(txtPno);
		pane1.add(lbl5);
		pane1.add(txtPs);
		pane1.add(lbl6);
		pane1.add(txtQty);
		pane1.add(lbl7);		
		pane1.add(txtTqty);
		pane1.add(lbl8);
		pane1.add(txtAswork);
		pane1.add(lbl9);
		pane1.add(txtDt);
		pane1.add(lbl10);
		pane1.add(txtDdt);

	
		btnfirst=new JButton("First");
		btnfirst.addActionListener(this);
		
		btnnext=new JButton("Next");
		btnnext.addActionListener(this);

		btnprev=new JButton("Previous");
		btnprev.addActionListener(this);

		btnlast=new JButton("Last");
		btnlast.addActionListener(this);
		
		btnupdate=new JButton("Update");
		btnupdate.addActionListener(this);

		

		pane2.add(btnfirst);
		pane2.add(btnnext);
		pane2.add(btnprev);
		pane2.add(btnlast);
		pane2.add(btnupdate);

		getContentPane().setLayout(new FlowLayout());
		pane0.setLayout(new FlowLayout());
		pane1.setLayout(new GridLayout(12,12));
		pane2.setLayout(new FlowLayout());

		getContentPane().add(pane0);
		getContentPane().add(pane1);	
		getContentPane().add(pane2);
		selType=(String)cmb1.getSelectedItem();
		try
		{			
			makeConn();	
			
		}
		catch(Exception e){}

	}
	
	public void getData()throws Exception
	{
		
			
	
	//	while(rs.next() && rs.isFirst())
	//	{
			
			sTxtId=rs.getString(1);
			sTxtProd=rs.getString(4);
			sTxtPno=Integer.toString(rs.getInt(5));
			sTxtPs=Integer.toString(rs.getInt(6));
			sTxtQty=Integer.toString(rs.getInt(7));
			sTxtTqty=Integer.toString(rs.getInt(8));
			sTxtAswork=rs.getString(9);
			sTxtDt=rs.getString(10);
			sTxtDdt=rs.getString(11);
		
			txtId.setText(sTxtId);
			txtProd.setText(sTxtProd);
			txtPno.setText(sTxtPno);
			txtPs.setText(sTxtPs);
			txtQty.setText(sTxtQty);
			txtTqty.setText(sTxtTqty);
			txtAswork.setText(sTxtAswork);
			txtDt.setText(sTxtDt);
			txtDdt.setText(sTxtDdt);
	//	}	
	}
		

	
	public void actionPerformed(ActionEvent ae)
	{
		Object obj=ae.getSource();
		if(obj==cmb1)
		{
			try
			{
				makeConn();
				getData();
			}catch(Exception e){}
		}
		else if(obj==btnnext)
		{
			try
			{
				rs.next();
				getData();	
			}
			catch(Exception e){}
		}
		else if(obj==btnprev)
		{
			try
			{
				rs.previous();	
				getData();
			}	
			catch(Exception e){}
		}
		else if(obj==btnfirst)
		{
			try
			{
				rs.first();
				getData();
			}
			catch(Exception e){}
		}
		else if(obj==btnlast)
		{
			try
			{
				rs.last();
				getData();
			}
			catch(Exception e){}
		}
		else if(obj==btnupdate)
		{
			
			String str1="",str2="",str3="",str4="",str5="",str6="",str7="",str8="",str9="";
			
			str1=txtId.getText().trim();
			str2=txtProd.getText().trim();
			str3=txtPno.getText().trim();
			str4=txtPs.getText().trim();
			str5=txtQty.getText().trim();
			str6=txtTqty.getText().trim();	
			str7=txtAswork.getText().trim();
			str8=txtDt.getText().trim();
			str9=txtDdt.getText().trim();


			if(!str1.equals("") && !unit.equals("")&& !str2.equals("")&& !str3.equals("") && !str4.equals("") && !str5.equals("") && !str6.equals("") && !str7.equals("")&& !str8.equals("")&& !str9.equals(""))
			{

				qry="update product set patname='"+txtProd.getText()+"',patno="+txtPno.getText()+",patsel="+txtPs.getText()+",qty="+txtQty.getText()+",totalqty="+txtTqty.getText()+",aswork='"+txtAswork.getText()+"',dat='"+txtDt.getText()+"',duedat='"+txtDdt.getText()+"' where id="+txtId.getText();
				
				try
				{				
					st.executeUpdate(qry);
					JOptionPane.showMessageDialog(null, "Record Updated sucessfully.","WARNING!!",JOptionPane.WARNING_MESSAGE);
				}
				catch(SQLException se)
				{ 
					System.out.print(se.toString());
				}
				clearAll();
				try
				{
					makeConn();
				}
				catch(Exception e){}
			}
			else
			{
				JOptionPane.showMessageDialog((Component)null, "Fields should not be empty!","", JOptionPane.WARNING_MESSAGE);	
			}
		}
		


	}
	public void makeConn()throws SQLException,ClassNotFoundException
	{
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		con=DriverManager.getConnection(url);
		st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
		qry="select * from product where unit='"+unit+"' and idtype='"+selType+"'";
		rs=st.executeQuery(qry);
		selType=(String)cmb1.getSelectedItem();	
		
	}
	void clearAll()
	{
		txtId.setText("");
		txtProd.setText("");
		txtPno.setText("");
		txtPs.setText("");
		txtQty.setText("");
		txtTqty.setText("");
		txtAswork.setText("");
		txtDt.setText("");
		txtDdt.setText("");
	}
}
