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
