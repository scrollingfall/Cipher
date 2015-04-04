//*/
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
/*/
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
	private JTextField user=new JTextField("Enter Username Here");
	private JTextField msg=new JTextField("Enter Message Here");
	private JTextArea msgs=new JTextArea();
	private boolean usershowprompt=true;
	private boolean msgshowprompt=true;
	private JComboBox selectuser=new JComboBox(backend.getUsers().toArray());
	public FrontEnd()
	{
		//Defining Components
		frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		frame.setLocation(300,100);
		frame.setSize(400,400);	
		addmsgbutton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				frame.setContentPane(addmsg);
				frame.revalidate();
				frame.repaint();
			}
		});
		getmsgbutton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				frame.setContentPane(getmsg);
				frame.revalidate();
				frame.repaint();
			}
		});
		user.addFocusListener(new FocusListener(){
			public void focusGained(FocusEvent e) {
				if(usershowprompt)
					user.setText("");
			}
			public void focusLost(FocusEvent e) {
				if(usershowprompt)
					user.setText("Enter Username Here");
			}
		});
		msg.addFocusListener(new FocusListener(){
			public void focusGained(FocusEvent e) {
				if(msgshowprompt)
					msg.setText("");
			}
			public void focusLost(FocusEvent e) {
				if(msgshowprompt)
					msg.setText("Enter Message Here");
			}
		});
		user.addKeyListener(new KeyListener(){
			public void keyPressed(KeyEvent arg0) {

			}
			public void keyReleased(KeyEvent arg0) {

			}
			public void keyTyped(KeyEvent arg0) {
				usershowprompt=false;
			}
		});
		msg.addKeyListener(new KeyListener(){
			public void keyPressed(KeyEvent arg0) {

			}
			public void keyReleased(KeyEvent arg0) {

			}
			public void keyTyped(KeyEvent arg0) {
				msgshowprompt=false;
			}
		});
		submit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				frame.setContentPane(main);
				try {
					if(!user.getText().isEmpty()&&!msg.getText().isEmpty()&&!usershowprompt&&!msgshowprompt)
					{
						backend.addMessage(user.getText(), msg.getText());
						if(!backend.getUsers().contains(user.getText()))
						{
							selectuser.addItem(user.getText());
						}
						user.setText("Enter Username Here");
						msg.setText("Enter Message Here");
					}
					else
					{
						JOptionPane.showMessageDialog(frame,"Invalid Username/Message: No Message Added");
					}
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				usershowprompt=true;
				msgshowprompt=true;
				frame.revalidate();
				frame.repaint();
			}
		});
		selectuser.setEditable(false);
		selectuser.setSelectedItem(null);
		selectuser.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				if (selectuser.getSelectedItem()!=null) 
				{
					String s=(String)selectuser.getSelectedItem();
					if(backend.getUsers().contains(s))
					{
						ArrayList<String> tempmsgs = backend.getMessages((String)selectuser.getItemAt(selectuser.getSelectedIndex()));
						msgs.setText("");
						for (String x : tempmsgs) {
							msgs.append(x + "\n");
						}
						frame.revalidate();
						frame.repaint();
					}
					else
					{
						msgs.setText("Invalid Username");
					}
				}
			}
		});	
		msgs.setEditable(false);
		back.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				frame.setContentPane(main);
				selectuser.setSelectedItem(null);
				msgs.setText("");
				frame.revalidate();
				frame.repaint();
			}
		});
		
		//Creating the Layout of the Frame
		main.setLayout(new GridLayout(2,1));
		main.add(addmsgbutton);
		main.add(getmsgbutton);
		
		addmsg.setLayout(new GridLayout(4,1));
		addmsg.add(new Label("Enter a username and a message"));
		addmsg.add(user);
		addmsg.add(msg);
		addmsg.add(submit);	
		
		getmsg.setLayout(new GridLayout(4,1));
		getmsg.add(new JLabel("Select An User"));
		getmsg.add(selectuser);
		getmsg.add(msgs);
		getmsg.add(back);

		frame.setContentPane(main);
		frame.setVisible(true);
	}
} 
//*/