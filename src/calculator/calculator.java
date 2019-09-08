package calculator;

import java.awt.EventQueue;

import javax.swing.JFrame;


public class calculator {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable()
		{
			public void run() {
				mainframe frame =new mainframe();
				frame.setTitle("计算器");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});
	}
}
