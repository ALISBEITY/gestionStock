import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

class FrameMain extends JFrame implements ActionListener
{
	
	Connection con;
	ResultSet rs;
	Statement st;
	String url="jdbc:odbc:stock";
	boolean b=false;
	
	JMenuBar jb;
	JMenuItem edt1,edt2,edt3,ut1,ut2,ut3,del1,del2,del3;
	JMenu file,addmnu,edtmnu,delmnu;
	JPanel pane1;
	JDesktopPane dsk;
	public FrameMain()
	{
	
		dsk=new JDesktopPane();

		jb=new JMenuBar();
		file=new JMenu("File");
		
		addmnu=new JMenu("Add");
		delmnu=new JMenu("Delete");
		edtmnu=new JMenu("Edit");

		ut1=new JMenuItem("Unit-1");
		ut1.addActionListener(this);
		ut2=new JMenuItem("Unit-2");
		ut2.addActionListener(this);
		ut3=new JMenuItem("Unit-3");
		ut3.addActionListener(this);	

				
		edt1=new JMenuItem("Unit-1");
		edt1.addActionListener(this);
		edt2=new JMenuItem("Unit-2");
		edt2.addActionListener(this);
		edt3=new JMenuItem("Unit-3");
		edt3.addActionListener(this);	
	

		del1=new JMenuItem("Unit-1");
		del1.addActionListener(this);
		del2=new JMenuItem("Unit-2");
		del2.addActionListener(this);
		del3=new JMenuItem("Unit-3");
		del3.addActionListener(this);

		

		addmnu.add(ut1);
		addmnu.add(ut2);
		addmnu.add(ut3);

		edtmnu.add(edt1);
		edtmnu.add(edt2);
		edtmnu.add(edt3);

		delmnu.add(del1);
		delmnu.add(del2);
		delmnu.add(del3);

		

		file.add(addmnu);
		file.add(edtmnu);
		file.add(delmnu);

		jb.add(file);
		
		
		pane1=new JPanel();
		pane1.setLayout(new BorderLayout());
		
		pane1.add(jb);



		setJMenuBar(jb);
		dsk.setBackground(Color.GRAY);

		try
		{		
			makeConn();
		}
		catch(Exception se){}

		getContentPane().add(pane1,BorderLayout.PAGE_START);	
		getContentPane().add(dsk,BorderLayout.CENTER);

		//setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent we)
			{
				System.exit(0);
			}
		});
	}
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==ut1)
		{
			unit1 u1=new unit1(this);
			dsk.add(u1);
		}
		if(ae.getSource()==ut2)
		{
			unit2 u2=new unit2(this);
			dsk.add(u2);
		}
		if(ae.getSource()==ut3)
		{
			unit3 u3=new unit3(this);
			dsk.add(u3);
		}
		if(ae.getSource()==edt1)
		{
			EditUnit1 ed1=new EditUnit1(this);
			dsk.add(ed1);
		}
		if(ae.getSource()==edt2)
		{
			EditUnit2 ed2=new EditUnit2(this);
			dsk.add(ed2);
		}
		if(ae.getSource()==edt3)
		{
			EditUnit3 ed3=new EditUnit3(this);
			dsk.add(ed3);
		}
		

		if(ae.getSource()==del1)
		{
			DeleteUnit1 d1=new DeleteUnit1(this);
			dsk.add(d1);
		}
		if(ae.getSource()==del2)
		{
			DeleteUnit2 d2=new DeleteUnit2(this);
			dsk.add(d2);
		}
		if(ae.getSource()==del3)
		{
			DeleteUnit3 d3=new DeleteUnit3(this);
			dsk.add(d3);
		}
		
		
		
	}
	public void makeConn()throws SQLException,ClassNotFoundException
	{
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		con=DriverManager.getConnection(url);
		st=con.createStatement();
	}
}
