package swingTest;

import java.awt.EventQueue;

import javax.swing.*;

/**
 * A frame contain a panel for testing mouse operation.
 */
public class MouseFrame extends JFrame
{
	public MouseFrame()
	{
		add(new MouseComponent());
		pack();
	}
	
	public static void main(String[] args)
	{
		EventQueue.invokeLater(() ->
		{
			JFrame frame = new MouseFrame();
			frame.setTitle("MouseFrame");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setVisible(true);
		});
	}
}
