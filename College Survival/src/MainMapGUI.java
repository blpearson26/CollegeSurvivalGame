
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.text.DecimalFormat;


public class MainMapGUI extends JFrame{

	private ImageIcon mainMapImage, commonsImage, startImage, endScreen, winScreen;

	private JPanel mapPanel, mainPanel, startPanel, commonsPanel, endPanel, winPanel;
	
	private JLabel mapLabel, startImgLabel, commonsImgLabel, endLabel, winLabel;
	
	private JButton startButton, helpButton, commonsButton, gymButton, dormsButton, backButton;
	private JButton classroomsButton, libraryButton, cafeteriaButton, deskButton, loungeButton;
	
	private JTextArea turnDisplay, statusDisplay, commonsTurnDisplay, commonsStatusDisplay; 
	private int finalHealth, finalGPA;
	CardLayout cl = new CardLayout();
	
	private Player p;
	private DisplayBuilder d;
	private ButtonBuilder b;
	
	MainMapGUI() {
		p = new Player();
		d = new DisplayBuilder(p);
		
		buildStatusIndicators();
		buildPanels();
		
		try {
			setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("studentIcon.png")));
			}catch(Exception e){
				JOptionPane.showMessageDialog(startPanel, "Error retrieving file 'studentIcon.png'.", "Error!", JOptionPane.WARNING_MESSAGE);
			}
		
				
		setTitle("Freshman Survival");
		setLayout(new BorderLayout());
		add(mainPanel, BorderLayout.CENTER);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setResizable(false);
		pack();

	}
	
	private void buttonHandler()
	{
		b = new ButtonBuilder(this, p, cl, mainPanel);
		
		startButton = b.getStartButton();
		startImgLabel.add(startButton);
		
		helpButton = b.getHelpButton();
		startImgLabel.add(helpButton);
		
		commonsButton = b.getCommonsButton();
		mapLabel.add(commonsButton);
		
		gymButton = b.getGymButton();
		mapLabel.add(gymButton);
		
		dormsButton = b.getDormButton();		
		mapLabel.add(dormsButton);
		
		classroomsButton = b.getClassroomsButton();
		mapLabel.add(classroomsButton);
		
		libraryButton = b.getLibraryButton();	
		mapLabel.add(libraryButton);
		
		cafeteriaButton = b.getCafeteriaButton();		
		commonsImgLabel.add(cafeteriaButton);
		
		deskButton = b.getDeskButton();
		commonsImgLabel.add(deskButton);
		
		loungeButton = b.getLoungeButton();
		commonsImgLabel.add(loungeButton);
		
		backButton = b.getBackButton();
		commonsImgLabel.add(backButton);
		
		commonsImgLabel.addKeyListener(p);
	}
	
	public void buildStatusIndicators()
	{
		turnDisplay = d.getTurnDisplay();
		commonsTurnDisplay = d.getCommonsTurnDisplay();
		statusDisplay = d.getStatusDisplay();
		commonsStatusDisplay = d.getCommonsStatusDisplay();
	
		
	}
	public void buildPanels() 
	{
		
		mainPanel = new JPanel(new BorderLayout());
		mapPanel = new JPanel();
		commonsPanel = new JPanel();
		startPanel = new JPanel();
		endPanel = new JPanel();
		winPanel = new JPanel();
		p = new Player();
				
		try {
		commonsImage = new ImageIcon(getClass().getResource("commonsMap.jpg"));
		}catch(Exception e){
			JOptionPane.showMessageDialog(mainPanel, "Error retrieving file 'commonsMap.jpg'.", "Error!", JOptionPane.WARNING_MESSAGE);
		}
		
		commonsImgLabel = new JLabel(commonsImage);
		commonsImgLabel.add(commonsTurnDisplay);
		commonsImgLabel.add(commonsStatusDisplay);
		commonsPanel.add(commonsImgLabel);
		
		
		try {
			endScreen = new ImageIcon(getClass().getResource("endScreen.png"));
			}catch(Exception e){
				JOptionPane.showMessageDialog(startPanel, "Error retrieving file 'endScreen.png'.", "Error!", JOptionPane.WARNING_MESSAGE);
			}
		
		endLabel = new JLabel(endScreen);
	
		endPanel.add(endLabel);
		
		
		try {
			winScreen = new ImageIcon(getClass().getResource("winScreen.jpg"));
			}catch(Exception e){
				JOptionPane.showMessageDialog(startPanel, "Error retrieving file 'winScreen.jpg'.", "Error!", JOptionPane.WARNING_MESSAGE);
			}
		
		winLabel = new JLabel(winScreen);
		
		
		winPanel.add(winLabel);
		
		
		try {
			startImage = new ImageIcon(getClass().getResource("StartScreen.jpg"));
			}catch(Exception e){
				JOptionPane.showMessageDialog(startPanel, "Error retrieving file 'StartScreen.jpg'.", "Error!", JOptionPane.WARNING_MESSAGE);
			}
		
		startImgLabel = new JLabel(startImage);
		startPanel.add(startImgLabel);
		
				
		try {
			mainMapImage = new ImageIcon(getClass().getResource("Campus.jpg"));
			}catch(Exception e){
				JOptionPane.showMessageDialog(mainPanel, "Error retrieving file 'Campus.jpg'.", "Error!", JOptionPane.WARNING_MESSAGE);
			}
		
		mapLabel = new JLabel(mainMapImage);
		mapLabel.add(turnDisplay);
		mapLabel.add(statusDisplay);
		mapPanel.add(mapLabel);
		
			
		buttonHandler();
		
		mainPanel.setLayout(cl);
		mainPanel.add(mapPanel, "campus");//meat of the CardLayout
		mainPanel.add(commonsPanel, "commons");
		mainPanel.add(endPanel, "endScreen");
		mainPanel.add(winPanel, "winScreen");
		mainPanel.add(startPanel, "startScreen");
		mainPanel.addKeyListener(p);
		mainPanel.setFocusable(true);
		cl.show(mainPanel, "startScreen");
	}
	
	public void showEndScreen()
	{
		DecimalFormat df = new DecimalFormat("#.00");
		
		JTextArea finalHealthText = new JTextArea("" + p.getHealth());
		finalHealthText.setLocation(320, 160);
		finalHealthText.setSize(350, 25);	
		finalHealthText.setOpaque(false);
		finalHealthText.setForeground(Color.WHITE);
		finalHealthText.setFont(new Font("Comic Sans", Font.BOLD, 20));
		finalHealthText.setEditable(false);
		
		JTextArea finalGPAText = new JTextArea("" + df.format(p.getGPA()));
		finalGPAText.setLocation(500, 160);
		finalGPAText.setSize(350, 25);	
		finalGPAText.setOpaque(false);
		finalGPAText.setForeground(Color.WHITE);
		finalGPAText.setFont(new Font("Comic Sans", Font.BOLD, 20));
		finalGPAText.setEditable(false);
		
		
		if(p.getHealth() >= 5 && p.getGPA() >= 2.0) {
			winLabel.add(finalHealthText);
			winLabel.add(finalGPAText);
			cl.setVgap(110);
			cl.show(mainPanel, "winScreen");
		}else {
			endLabel.add(finalHealthText);
			endLabel.add(finalGPAText);
			cl.setVgap(110);
			cl.show(mainPanel, "endScreen");
		}
	}
	public void replaceDisplayText()
	{
		int turnDisplayLength = turnDisplay.getText().length();
		int statusDisplayLength = statusDisplay.getText().length();
		turnDisplay.replaceRange(Game.getTurnNum().substring(0, turnDisplayLength), 0, turnDisplayLength);
		commonsTurnDisplay.replaceRange(Game.getTurnNum().substring(0, turnDisplayLength), 0, turnDisplayLength );
		statusDisplay.replaceRange(p.statusToString().substring(0, statusDisplayLength), 0, statusDisplayLength );
		commonsStatusDisplay.replaceRange(p.statusToString().substring(0, statusDisplayLength), 0, statusDisplayLength);
	}
}
