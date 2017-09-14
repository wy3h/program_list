package swingTest;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class CalculatorFrame extends JFrame
{
	public CalculatorFrame()
	{
		add(new CalculatorPanel());
		pack();
	}
	
	public static void main(String[] args)
	{
		EventQueue.invokeLater(() ->
		{
			CalculatorFrame frame = new CalculatorFrame();
			frame.setTitle("Calculator");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setVisible(true);
		});
	}
}
