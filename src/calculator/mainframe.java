package calculator;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class mainframe extends JFrame{
    public  int WIDTH;
    public  int HEIGHT;
	private  JPanel panel ,pad;
	public JTextField display;
	private Input input;
	private Compute compute;
	public mainframe () {
		WIDTH=300;
		HEIGHT=300;	
    	setSize(WIDTH,HEIGHT);
    	setResizable(false);
    	display= new JTextField();
    	input =new Input();
    	compute =new Compute();
    	panel =new JPanel();
    	panel.setLayout(new BorderLayout());
    	panel.add(display,BorderLayout.NORTH);
    	
    	pad=new JPanel();
    	pad.setLayout(new GridLayout(4,4));    	
    	addButton("1",input);
    	addButton("2",input);
    	addButton("3",input);
    	addButton("+",input);
    	addButton("-",input);    	
    	addButton("4",input);
    	addButton("5",input);
    	addButton("6",input);    	
    	addButton("*",input);
    	addButton("/",input);    	
    	addButton("7",input);
    	addButton("8",input);
    	addButton("9",input);
    	addButton("sin(",input);   
    	addButton("cos(",input);  
    	addButton(".",input);
    	addButton("0",input);
    	addButton("=",compute);
    	addButton("(",input);  
    	addButton(")",input);  

    	panel.add(pad,BorderLayout.CENTER);
    	add(panel);
	}
	
	private void  addButton(String label,ActionListener lisener) {
	 JButton button = new JButton(label);
	 button.addActionListener(lisener);
	 pad.add(button);
	}
	
	
	private class Input implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent event) {
			String input = event.getActionCommand();
			display.setText(display.getText()+input);
			
		}
	}
	private class Compute implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent event) {
				
				display.setText(String.valueOf(signal.compute(display.getText())));
				
			}
			
			
			
	}
}
