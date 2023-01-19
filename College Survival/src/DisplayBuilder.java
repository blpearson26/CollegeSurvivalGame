import java.awt.Color;
import java.awt.Font;

import javax.swing.JTextArea;

public class DisplayBuilder {
	
	private JTextArea turnDisplay, commonsTurnDisplay, statusDisplay, commonsStatusDisplay, endScreenHealth, endScreenGPA;
	private Player p;					
	
	public DisplayBuilder(Player p)
	{
		this.p = p;						
		buildStatusIndicators();

	}

	public JTextArea getTurnDisplay()
	{
		return turnDisplay;
	}
	public JTextArea getCommonsTurnDisplay()
	{
		return commonsTurnDisplay;
	}
	public JTextArea getStatusDisplay()
	{
		return statusDisplay;
	}
	public JTextArea getCommonsStatusDisplay()
	{
		return commonsStatusDisplay;
	}
	public JTextArea getHealthDisplay()
	{
		return endScreenHealth;
	}
	public JTextArea getGradesDisplay()
	{
		return endScreenGPA;
	}
	private void buildStatusIndicators() 
	{
		turnDisplay = new JTextArea(" Week 1  |  Actions Left: 5");
		turnDisplay.setLocation(125, 10);
		turnDisplay.setSize(295, 25);	
		turnDisplay.setOpaque(false);
		turnDisplay.setForeground(Color.WHITE);
		turnDisplay.setFont(new Font("Comic Sans", Font.BOLD, 20));
		turnDisplay.setEditable(false);
		
		commonsTurnDisplay = new JTextArea(" Week 1  |  Actions Left: 5");
		commonsTurnDisplay.setLocation(160, 1);
		commonsTurnDisplay.setSize(295, 25);	
		commonsTurnDisplay.setOpaque(false);
		commonsTurnDisplay.setForeground(Color.WHITE);
		commonsTurnDisplay.setFont(new Font("Comic Sans", Font.BOLD, 20));
		commonsTurnDisplay.setEditable(false);
		
		statusDisplay = new JTextArea("" + p.statusToString());		
		statusDisplay.setLocation(380, 10);
		statusDisplay.setSize(350, 25);	
		statusDisplay.setOpaque(false);
		statusDisplay.setForeground(Color.WHITE);
		statusDisplay.setFont(new Font("Comic Sans", Font.BOLD, 20));
		statusDisplay.setEditable(false);
		
		commonsStatusDisplay = new JTextArea("" + p.statusToString());
		commonsStatusDisplay.setLocation(415, 1);
		commonsStatusDisplay.setSize(350, 25);	
		commonsStatusDisplay.setOpaque(false);
		commonsStatusDisplay.setForeground(Color.WHITE);
		commonsStatusDisplay.setFont(new Font("Comic Sans", Font.BOLD, 20));
		commonsStatusDisplay.setEditable(false);
		
	}
	
	
}
