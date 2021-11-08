import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;

public class GuessingGame implements ActionListener{
	// instance variables:
  JTextField userGuess; 
	JButton guessButton;
	JButton playAgainButton;	
	JLabel inputLabel;
	JLabel HintLabel;
	JLabel resultLabel;
  int rNum = 0;
	Random rand;

  // GuessingGame() constructor:
  public GuessingGame() {
		rand = new Random();
		rNum = rand.nextInt(100)+1;
    //set up the frame:
    JFrame frame = new JFrame("Guessing Game");
		frame.setLayout(new FlowLayout());
		frame.setSize(240, 120);  
    // text field with userGuess:
		userGuess = new JTextField(10);
		userGuess.setActionCommand("myTF");
    // Set up buttons:
    guessButton = new JButton("Guess");  // Button as required?
		playAgainButton = new JButton("Play Again");
    // Action listeners:
		userGuess.addActionListener(this);
    guessButton.addActionListener(this);    
    playAgainButton.addActionListener(this);
    // Set up three labels:
		inputLabel = new JLabel("Enter your guess: ");
		HintLabel = new JLabel("");
		resultLabel = new JLabel("");
    // Add everything to frame:
		frame.add(inputLabel);      // Enter guess
    frame.add(userGuess);       // userGuess text field
		frame.add(guessButton);     // Guess button
    frame.add(HintLabel);				// whether too high or low
    frame.add(resultLabel);     // last guess
    frame.add(playAgainButton);	// play again button
    // Make frame visible
		frame.setVisible(true);		
	}

  // ActionPerformed method:
	public void actionPerformed(ActionEvent ae) {
    // if action command equals to "Guess":
		if(ae.getActionCommand().equals("Guess")) {
      int guess = Integer.parseInt(userGuess.getText());
      // if statements comparing guess to original random number:
			if(guess > rNum) {
				HintLabel.setText("Too high!");
			}else if(guess < rNum) {
				HintLabel.setText("Too low!");
			}else {
				HintLabel.setText("You got it!");
			}
      // show 
			resultLabel.setText("last guess was: " + guess);

		} // if action command equals to "Play Again":
    else if(ae.getActionCommand().equals("Play Again")){
			rNum = rand.nextInt(100)+1;
      // Reset three labels to original text
      inputLabel.setText("Enter your guess: ");
			HintLabel.setText("");
			resultLabel.setText("");
      // Reset userGuess to blank String
      userGuess.setText("");

		}  // action command is neither Guess nor Play Again:
    else {
			HintLabel.setText("You pressed Enter. Please press the Guess Button.");
      resultLabel.setText("");
		}
	
  }
	
}	

