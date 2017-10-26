import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;

public class Soundboard
{
	public Soundboard()
	{
		//Create a new frame
		JFrame F = new JFrame("Soundboard");
        
        //make sure the program exits when the frame closes
        F.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//set the size of the frame
        F.setSize(900, 1000);
		
		//create the Audrey Hepburn button			
		JButton B = makeSoundboardButton("audrey.jpg", "Hepburn.wav");
		
		//create the Martin Luther King Jr. button
		JButton M = makeSoundboardButton("ObamaP.jpg", "ObamaSpeech.wav");
		
		//create a JPanel for the button
		JPanel P = new JPanel();
		
		//add the button to a JPanel
		P.add(B);
        P.add(M);
		
		//add the panel to the content pane of the frame
		F.add(P);
		
		//make sure the JFrame is visible
        F.setVisible(true);
	
}	
	/**
	 * Creates a JButton which displays the specified image and plays the specified sound when it is clicked.
	 * @param imageFile the name of the image to display on the button, including the file extension
	 * @param soundFile the name of the audio clip to play when the button is clicked
	 * @return the JButton
	 **/
	private JButton makeSoundboardButton(String imageFile, String soundFile)
	{
		JButton button;
		try{
			BufferedImage icon = ImageIO.read(new File(imageFile));
			button = new JButton(new ImageIcon(icon));
			button.setBorderPainted(false);
			button.setFocusPainted(false);
			button.setContentAreaFilled(false);
			//add action listener
			button.addActionListener(new SoundboardActionListener(soundFile));
		}
		catch (IOException e) {
			System.out.println(e);
			button = new JButton();
		}
		return button;
	}
}