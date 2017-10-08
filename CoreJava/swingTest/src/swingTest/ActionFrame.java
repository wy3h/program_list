package swingTest;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ActionFrame extends JFrame
{
	private JPanel buttonPanel;
	private static final int DEAFUALT_WIDTH = 300;
	private static final int DEAFUALT_HEIGHT = 200;
	
	public ActionFrame()
	{
		setSize(DEAFUALT_WIDTH, DEAFUALT_HEIGHT);
		buttonPanel = new JPanel();
		
		// define action 
		Action yellowAction = new ColorAction("Yellow",Color.YELLOW);
		Action blueAction = new ColorAction("Blue", Color.BLUE);
		Action redAction = new ColorAction("Red", Color.RED);
		
		// add buttons for these actioin 
		buttonPanel.add(new JButton(yellowAction));
		buttonPanel.add(new JButton(blueAction));
		buttonPanel.add(new JButton(redAction));
		
		// add panel to frame
		add(buttonPanel);
		
		// associate the Y, B, and R keys with names
		InputMap imap = buttonPanel.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
		imap.put(KeyStroke.getKeyStroke("ctrl Y"), "panel.yellow");
		imap.put(KeyStroke.getKeyStroke("ctrl B"), "panel.blue");
		imap.put(KeyStroke.getKeyStroke("ctrl R"), "panel.red");
		
		// associate the name with action
		ActionMap amap = buttonPanel.getActionMap();
		amap.put("panel.yellow", yellowAction);
		amap.put("panel.blue", blueAction);
		amap.put("panel.red", redAction);
	}
	public class ColorAction extends AbstractAction
	{
		public ColorAction(String name, Color c)
		{
			putValue(Action.NAME, name);
			putValue(Action.SHORT_DESCRIPTION, "Set panel color to " + name.toLowerCase());
			putValue("color", c);
		}
		
		public void actionPerformed(ActionEvent event)
		{
			Color c = (Color) getValue("color");
			buttonPanel.setBackground(c);
		}
	}
	public static void main(String[] args)
	{
		EventQueue.invokeLater(() ->
		{
			JFrame frame = new ActionFrame();
			frame.setTitle("ActtionFrame");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setVisible(true);
		});
	}
}
