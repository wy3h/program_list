package bounce;

import java.awt.*;
import java.util.*;
import javax.swing.*;

public final class BallComponent extends JPanel
{
	private static final int DEFAULT_WIDTH =450;
	private static final int DEFAULT_HEIGHT= 350;
	
	private java.util.List<Ball> balls = new ArrayList<>();
	
	public void add(Ball b)
	{
		balls.add(b);
	}
	public void paint(Graphics g)
	{
		super.paintComponent(g); // erase background
		Graphics2D g2 = (Graphics2D) g;
		for(Ball b : balls)
		{
			g2.fill(b.getShape());
		}
	}
	
	public Dimension getPreferredSize() { return new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT);}
}
