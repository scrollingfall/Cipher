/*/
import java.awt.*;

import javax.swing.*;
public class FrontEnd {
	private JFrame myFrame;
	private JButton myButton;
	private JButton myButton2;
	private JPanel myPanel;

public FrontEnd()
{


	myFrame = new JFrame("The Front");
	myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	myFrame.setLocation(300,100);
	Box theBox = Box.createHorizontalBox();
	myFrame.add(theBox);
	myFrame.setPreferredSize(new Dimension(850,600));

	Box BoxLayer2a = Box.createHorizontalBox();
	Box BoxLayer2b = Box.createHorizontalBox();
	theBox.add(BoxLayer2a);
	theBox.createHorizontalStrut(10);
	theBox.add(BoxLayer2b);


	//Layer 2a
	Box BoxLayer2a1 = Box.createHorizontalBox();
	JTextField Ha1 = new JTextField(); 
	JTextField Ha2 = new JTextField(); 
	JTextArea G = new JTextArea();
	myButton = new JButton("Submit");
	JLabel GLabel = new JLabel();
	BoxLayer2a.add(GLabel);
	BoxLayer2a.add(Ha1);
	BoxLayer2a.add(BoxLayer2a1);
	BoxLayer2a1.add(Ha2);
	BoxLayer2a1.add(G);

	//Layer 2b



	JComboBox Users = new JComboBox();
	myButton2 = new JButton("Find");


	myFrame.pack();
	myFrame.setVisible(true);
}}
//*/
//*/
import java.awt.*;

import javax.swing.*;

import java.awt.event.*;
import java.util.*;
public class FrontEnd 
{
	private JFrame frame=new JFrame("Messenger");
	private JPanel main=new JPanel();
	private JPanel getmsg=new JPanel();
	private JPanel addmsg=new JPanel();
	private JButton addmsgbutton=new JButton("Add A Message");
	private JButton getmsgbutton=new JButton("Get Messages");
	private JButton back=new JButton ("Back to Main Screen");
	private JButton submit=new JButton ("Submit Message");
	private BackEnd backend=new BackEnd();
	private JTextField user=new JTextField();
	private JTextField msg=new JTextField();
	private JTextArea msgs=new JTextArea();
	private JComboBox selectuser=new JComboBox(backend.getUsers().toArray());
	public FrontEnd()
	{
		frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		frame.setLocation(300,100);
		frame.setSize(400,400);
		main.setLayout(new GridLayout(2,1));
		addmsg.setLayout(new GridLayout(3,1));
		addmsg.add(user);
		addmsg.add(msg);
		addmsg.add(submit);
		submit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				frame.remove(addmsg);
				try {
					backend.addMessage(user.getText(), msg.getText());
					user.setText("");
					msg.setText("");
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				frame.add(main);
				frame.repaint();
			}
		});
		getmsg.setLayout(new GridLayout(3,1));
		getmsg.add(selectuser);
		getmsg.add(msgs);
		getmsg.add(back);
		addmsgbutton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				frame.remove(main);
				frame.add(addmsg);
				frame.repaint();
			}
		});
		getmsgbutton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				frame.remove(main);
				
				frame.repaint();
			}
		});
		main.add(addmsgbutton);
		main.add(getmsgbutton);
		frame.add(main);
		frame.setVisible(true);
	}
} 
//*/