package swingTest;

import java.awt.*;
import javax.swing.*;


public class SimpleFrameTest
{
	public static void main(String[] args)
	{
		EventQueue.invokeLater(() ->
		{
			SimpleFrame frame = new SimpleFrame();
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setVisible(true);
		});
		System.out.println("main() is end");
	}
}

class SimpleFrame extends JFrame
{
	private static final int DEFAULT_WIDTH = 300;
	private static final int DEFAULT_HEIGHT = 200;
	
	public SimpleFrame()
	{
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
	}
}