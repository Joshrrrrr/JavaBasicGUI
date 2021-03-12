package com.test.GUESSGUI;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GuessGUI extends JFrame implements ActionListener{
	int rand=101;
	int guess=1;
	JButton button1,button2;
	JPanel panel;
	JPanel panel2;
	JPanel panel3;
	JLabel label;
	JTextField text;
	GuessGUI (String title){
		super(title);
		setSize(300,300);
		setLayout(new FlowLayout());
		button1=new JButton("Generate the random number");
		button1.addActionListener(this);
		button1.setToolTipText("Generate the random number");
		button2=new JButton("Check your guess");
		button2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				if (getRand()!=101){
					String grabText = text.getText();
					Integer getGuess = Integer.valueOf(getGuess());
					setGuess(1);
					try{
						if(Integer.parseInt(grabText)> getRand()){
							JOptionPane.showMessageDialog(text, "Your guess of "+grabText+" is too high");
						}else if(Integer.parseInt(grabText)<getRand()){
							JOptionPane.showMessageDialog(text, "Your guess of "+grabText+" is too low");
						}else if(Integer.parseInt(grabText)==getRand()){
							JOptionPane.showMessageDialog(text,"Correct you got the answer in "+(getGuess)+" guesses");
						}
					}catch (NumberFormatException a) {
						JOptionPane.showMessageDialog(text, "Bad input");
					}
					}else JOptionPane.showMessageDialog(text, "Generate number first");
				}
		});
				
		button2.setToolTipText("Check your guess");
		label=new JLabel("Then make a guess..");
		label.setToolTipText("label");
		text=new JTextField("Enter your guess");
		panel=new JPanel(new FlowLayout());
		panel2=new JPanel(new FlowLayout());
		panel3=new JPanel(new FlowLayout());
		panel.add(button1);
		panel2.add(label);
		panel2.add(text);
		panel3.add(button2);
		add(panel);
		add(panel2);
		add(panel3);
		setVisible(true);
	}
	
	public int getRand() {
		return rand;
	}


	public void setRand(int rand) {
		this.rand = rand;
	}
	public int getGuess() {
		return guess;
	}

	public void setGuess(int guess) {
		if(guess==0){
			this.guess=1;
		}
		this.guess+=guess;
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Random random = new Random();
		setRand(random.nextInt(101));
		setGuess(0);
		System.out.println(getRand());
	}
	
}