import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;

/** 
 * GUI for Stego Project for Cyber-security
 */
public class StegoGUI extends JFrame implements ActionListener
{
	//instance variables which are the components
	private JPanel top, bottom, middle;
	private JButton selectBMP, hideButton, recoverButton;
	private JTextField keyField, messageField;
	private JLabel keyLabel, messageLabel;
	
	private String filePath;
	
	private Steg steg;
	
	private boolean isPlainTxt;
	
	/**
	 * The constructor adds all the components to the frame
	 */
	public StegoGUI()
	{
		this.setSize(300,150);
		this.setLocation(100,100);
		this.setTitle("Stego GUI");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.layoutComponents();
		
		
	}
	
	/**
	 * Helper method to add components to the frame
	 */
	public void layoutComponents()
	{
		//top panel 
		top = new JPanel();
		top.setBackground(Color.white);
		keyLabel = new JLabel("BMP File : ");
		top.add(keyLabel);
		selectBMP = new JButton("Select BMP Image File");
		selectBMP.addActionListener(this);
		top.add(selectBMP);
		this.add(top,BorderLayout.NORTH);
		
		//middle panel 
		middle = new JPanel();
		middle.setBackground(Color.white);
		messageLabel = new JLabel("Message: ");
		middle.add(messageLabel);
		messageField = new JTextField(10);
		middle.add(messageField);
		this.add(middle,BorderLayout.CENTER);
		
		//bottom panel 
		
		bottom = new JPanel();
		bottom.setBackground(Color.white);

		//buttons
		hideButton = new JButton("Hide Text");
		hideButton.addActionListener(this);
		bottom.add(hideButton);
		recoverButton = new JButton("Extract Text");
		recoverButton.addActionListener(this);
		bottom.add(recoverButton);
		//add the top panel
		this.add(bottom,BorderLayout.SOUTH);
	}
	
	/**
	 * Listen for and react to button press events
	 * (use helper methods below)
	 * @param e the event
	 */
	public void actionPerformed(ActionEvent e)
	{

		Object whoWasClicked = e.getSource(); //Pointer for easy reference
		steg = new Steg();
											
		boolean processingRight = false;
		
		if (whoWasClicked == selectBMP) {
			JFileChooser chooser = new JFileChooser();
			int result = chooser.showOpenDialog(null);
			if (result == JFileChooser.APPROVE_OPTION)
			{
				File cover_file = chooser.getSelectedFile();
				System.out.println(cover_file);
			
			filePath = cover_file.getPath();
			System.out.println(filePath);
		
			}
		}
			
			
		if (whoWasClicked == hideButton){
			// Hide the String Text ;-)
			String textToEncode = messageField.getText();
			System.out.println(textToEncode);
			steg.hideString(textToEncode, filePath);
		}
		
		
		
		
		
	}

}
