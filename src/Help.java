import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Help extends Frame 
{
	JPanel pane1,pane2;
	JLabel lb1;
	JTextArea txtArea;

	public Help()
	{
		super("Help - Stock Management System");
		lb1=new JLabel("Contact Administration");
		txtArea=new JTextArea("DashrathInfotech@StockManagementSystem");	
		
		pane1=new JPanel();
		pane1.add(lb1);

		pane2=new JPanel();
		pane2.add(txtArea);

		
	}
	
	

}	