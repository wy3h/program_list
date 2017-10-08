package bounceThread;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import bounce.Ball;
import bounce.BallComponent;

public class BounceThread
{
	public static void main(String[] args)
	{
		EventQueue.invokeLater(() ->
		{
			JFrame frame = new BounceFrame();
			frame.setTitle("BounceThread");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setVisible(true);
		});
	}
}

/**
 * The frame with panel and button.
 */
class BounceFrame extends JFrame
{
	private BallComponent comp;
	public static final int STEPS = 1000;
	public static final int DELAY =5;
	
	public BounceFrame()
	{
		comp = new BallComponent();
		add(comp, BorderLayout.CENTER);
		JPanel buttonPanel = new JPanel();
		addButton(buttonPanel, "Start", event -> addBall());
		addButton(buttonPanel, "Close", event -> System.exit(0));
		add(buttonPanel, BorderLayout.SOUTH);
		pack();
	}
	
	/**
	 * Adds a button to a container.
	 * @param c container
	 * @param title title the button
	 * @param listener the action listener for button
	 */
	public void addButton(Container c, String title, ActionListener listener)
	{
		JButton button = new JButton(title);
		c.add(button);
		button.addActionListener(listener);
	}
	
	/**
	 * Adds a bouncing ball to the canvas and starts a thread to make it bounce.
	 */
	public void addBall()
	{
		Ball ball = new Ball();
		comp.add(ball);
		Runnable r = () -> {
			try
			{
				for (int i = 1; i <= STEPS; i++)
				{
					ball.move(comp.getBounds());
					comp.repaint();
					Thread.sleep(DELAY);
				}
			}
			catch(InterruptedException e)
			{
			}
		};
		Thread t = new Thread(r);
		t.start();
	}
}