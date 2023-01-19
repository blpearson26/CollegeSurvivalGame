import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ButtonBuilder {
	
	private JButton startButton, helpButton, commonsButton, gymButton, dormsButton, backButton;
	private JButton classroomsButton, libraryButton, cafeteriaButton, deskButton, loungeButton;
	private Player p;
	private CardLayout cl;
	private JPanel mainPanel;
	private MainMapGUI gui;
	
	public ButtonBuilder(MainMapGUI gui, Player p, CardLayout cl, JPanel mainPanel)
	{
		this.p = p;
		this.cl = cl;
		this.mainPanel = mainPanel;
		this.gui = gui;
		
		buildButtons();
	}
	public JButton getStartButton()
	{
		return this.startButton;
	}
	public JButton getHelpButton()
	{
		return this.helpButton;
	}
	public JButton getCommonsButton()
	{
		return this.commonsButton;
	}
	public JButton getGymButton()
	{
		return this.gymButton;
	}
	public JButton getDormButton()
	{
		return this.dormsButton;
	}
	public JButton getClassroomsButton()
	{
		return this.classroomsButton;
	}
	public JButton getLibraryButton()
	{
		return this.libraryButton;
	}
	public JButton getCafeteriaButton()
	{
		return this.cafeteriaButton;
	}
	public JButton getDeskButton()
	{
		return this.deskButton;
	}
	public JButton getLoungeButton()
	{
		return this.loungeButton;
	}
	public JButton getBackButton()
	{
		return this.backButton;
	}
	private void buildButtons()
	{
		startButton = new JButton("");
		startButton.addActionListener(
				new ActionListener()
				{
					public void actionPerformed(ActionEvent e)//Start Button Action
					{
						cl.show(mainPanel, "campus");
					}
				});
		startButton.setSize(165, 78);
		startButton.setLocation(174, 349);
		startButton.setOpaque(false);
		startButton.setContentAreaFilled(false);
		startButton.setBorderPainted(true);
		
		helpButton = new JButton("");
		helpButton.addActionListener(
				new ActionListener()
				{
					public void actionPerformed(ActionEvent e)//Help Button Action
					{
						JOptionPane.showMessageDialog(mainPanel,
						        "How To Play:\n\n" 
						        		+ "1) Watch your GPA, you can't graduate with less than a 2.0\n"
						        		+ "2) Watch your Health, low health will negatively impact your studies\n"
						        		+ "3) You will get 8 weeks with 5 clickable actions per week\n"
						        		+ "4) Press 'i' to pull up your inventory while you're exploring\n"
										+ "5) An extra credit question will appear every other week in the classroom. Careful, you could lose GPA!\n\n"
						        		+ "Will you make it to graduation? Or get caught up in the college life?\n\n", "HELP", JOptionPane.PLAIN_MESSAGE);
					}
				});
		helpButton.setSize(165, 78);
		helpButton.setLocation(351, 349);
		helpButton.setOpaque(false);
		helpButton.setContentAreaFilled(false);
		helpButton.setBorderPainted(true);
		
		commonsButton = new JButton("");
		commonsButton.addActionListener(
				new ActionListener()
				{
					public void actionPerformed(ActionEvent e)//Commons Button Action
					{
						cl.setVgap(110);
						cl.show(mainPanel, "commons");
						//cl.setVgap(0);//no touchy
					}
				});
		commonsButton.setFocusable(false);
		commonsButton.setSize(110, 100);
		commonsButton.setLocation(455, 340);
		commonsButton.setOpaque(false);
		commonsButton.setContentAreaFilled(false);
		commonsButton.setBorderPainted(false);
		
		gymButton = new JButton("");
		gymButton.addActionListener(
				new ActionListener()
				{
					public void actionPerformed(ActionEvent e)//Gym Button Action
					{
						Random rand = new Random();
						int randomNumber = rand.nextInt(20);
						
						if (randomNumber <= 3) {
							JOptionPane.showMessageDialog(mainPanel,
							        "You go to the Gym and\n"
							        		+ "work out for 8 hours.\n"
							        		+ "What an animal!", "LOCATION : Gym", JOptionPane.INFORMATION_MESSAGE);
							p.adjustHealth(2);
							p.adjustGPA(-0.5);
						} else if (randomNumber >= 4 && randomNumber <= 10) {
							JOptionPane.showMessageDialog(mainPanel,
							        "You go to the Gym and\n"
							        		+ "work up a good lather!\n", "LOCATION : Gym", JOptionPane.INFORMATION_MESSAGE);
							p.adjustHealth(1);
						} else if (randomNumber >= 11 && randomNumber <= 16) {
							JOptionPane.showMessageDialog(mainPanel,
							        "You meet some friends at the Gym\n"
							        		+ "and play a game of horse.\n", "LOCATION : Gym", JOptionPane.INFORMATION_MESSAGE);			
						} else if (randomNumber >= 17 && randomNumber <= 18) {
							JOptionPane.showMessageDialog(mainPanel,
									"You go to the Gym.\n"
											+ "You are so tired that your form is terrible.\n"
											+ "You pull an abdominal!", "LOCATION : Gym", JOptionPane.INFORMATION_MESSAGE);				
							p.adjustHealth(-1);
						} else {
							JOptionPane.showMessageDialog(mainPanel,
							        "You go to the Gym and\n"
							        		+ "end up meeting someone in your class.\n"
							        		+ "You work out and talk about tomorrow's exam.\n"
							        		+ "GPA & Health are increased!", "LOCATION : Gym", JOptionPane.INFORMATION_MESSAGE);
							p.adjustGPA(0.25);
							p.adjustHealth(1);
						}						
						
				
						Game.incrActionNum();
						p.checkHealthAndGPA();
						gui.replaceDisplayText();
					}
				});
		gymButton.setFocusable(false);
		gymButton.setSize(110, 100);
		gymButton.setLocation(540, 480);
		gymButton.setOpaque(false);
		gymButton.setContentAreaFilled(false);
		gymButton.setBorderPainted(false);	
		
		dormsButton = new JButton("");
		dormsButton.addActionListener(
				new ActionListener()
				{
					public void actionPerformed(ActionEvent e) //Dorms Button Action
					{
						if (!p.inventory.contains("Dorm key"))
						{
							JOptionPane.showMessageDialog(mainPanel,
									"You visit the Dorms, but cannot get in.\n"
											+ "You need to get your dorm key from the Front Desk\n"
											+ "before you can enter.", "LOCATION : Dorms", JOptionPane.INFORMATION_MESSAGE);
						} else {
							JOptionPane.showMessageDialog(mainPanel,
						        "Welcome to the Dorms.\n", "LOCATION : Dorms", JOptionPane.INFORMATION_MESSAGE);
						}
							if (p.inventory.contains("Empty Beer Can"))
							{
								JOptionPane.showMessageDialog(mainPanel,
										"Hall Monitor: I see you have something...                  \n" 
												+ "                      ...that is not permmIITTEEEDDD!!!!\n\n" 
												+ "'the hall monitor has found your beer can'\n"
												+ "               (health -1)", "LOCATION : Dorms", JOptionPane.INFORMATION_MESSAGE);
								p.inventory.remove("Empty Beer Can");
								p.adjustHealth(-1);
							}
						Game.incrActionNum();
						p.checkHealthAndGPA();
						gui.replaceDisplayText();
						}
				});
		dormsButton.setFocusable(false);
		dormsButton.setSize(280, 180);
		dormsButton.setLocation(250, 480);
		dormsButton.setOpaque(false);
		dormsButton.setContentAreaFilled(false);
		dormsButton.setBorderPainted(false);
		
		classroomsButton = new JButton("");
		classroomsButton.addActionListener(
				new ActionListener()
				{
					public void actionPerformed(ActionEvent e) //Classroom Button Action
					{
						if(Game.getWeekNum() == 2 && Game.getActionNum() == 5)
						{
							String userInput = JOptionPane.showInputDialog(mainPanel,
									"EXTRA CREDIT\nWhat is the capital of Florida?\n" +
									"	1) Tallahassee\n" + //correct answer
									"	2) Orlando\n" +
									"	3) Miami\n" +
									"	4) Tampa", "Enter your answer here");
									int i = Integer.parseInt(userInput);
									if(i == 1 )
									{
										JOptionPane.showMessageDialog(mainPanel, "Tallahassee is correct! Your GPA has increased.", "EXTRA CREDIT", JOptionPane.INFORMATION_MESSAGE);
										p.adjustGPA(.20);
									}
									else if(i == 2)
									{
									 	JOptionPane.showMessageDialog(mainPanel, "Orlando is incorrect!\n The answer was Tallahassee. Your GPA has decreased.", "EXTRA CREDIT", JOptionPane.INFORMATION_MESSAGE);
									 	p.adjustGPA(-.40);
									}
									else if(i == 3)
									{
									 	JOptionPane.showMessageDialog(mainPanel, "Miami is incorrect!\n The answer was Tallahassee. Your GPA has decreased.", "EXTRA CREDIT", JOptionPane.INFORMATION_MESSAGE);
									 	p.adjustGPA(-.40);
									}
									else if(i == 4)
									{
									 	JOptionPane.showMessageDialog(mainPanel, "Tampa is incorrect!\n The answer was Tallahassee. Your GPA has decreased.", "EXTRA CREDIT", JOptionPane.INFORMATION_MESSAGE);
									 	p.adjustGPA(-.40);
									}
								
						}
						if(Game.getWeekNum() == 4 && Game.getActionNum() == 5)
						{
							String userInput = JOptionPane.showInputDialog(mainPanel,
									"EXTRA CREDIT\nMark Twain\'s beloved characters Tom Sawyer and Huckleberry Finn reside in which state?\n" +
									"	1) Alabama\n" +
									"	2) Missouri\n" + //correct answer
									"	3) Mississippi\n" +
									"	4) Tennessee", "Enter your answer here");
									int i = Integer.parseInt(userInput);
									if(i == 1 )
									{
										JOptionPane.showMessageDialog(mainPanel, "Alabama is incorrect!\n The answer was Missouri. Your GPA has decreased.", "EXTRA CREDIT", JOptionPane.INFORMATION_MESSAGE);
										p.adjustGPA(-.40);
									}
									else if(i == 2)
									{
									 	JOptionPane.showMessageDialog(mainPanel, "Missouri is correct!\n Your GPA has increased.", "EXTRA CREDIT", JOptionPane.INFORMATION_MESSAGE);
									 	p.adjustGPA(.20);
									}
									else if(i == 3)
									{
									 	JOptionPane.showMessageDialog(mainPanel, "Mississippi is incorrect!\n The answer was Missouri. Your GPA has decreased.", "EXTRA CREDIT", JOptionPane.INFORMATION_MESSAGE);
									 	p.adjustGPA(-.40);
									}
									else if(i == 4)
									{
									 	JOptionPane.showMessageDialog(mainPanel, "Tennessee is incorrect!\n The answer was Missouri. Your GPA has decreased.", "EXTRA CREDIT", JOptionPane.INFORMATION_MESSAGE);
									 	p.adjustGPA(-.40);
									}
							
						}
						if(Game.getWeekNum() == 6 && Game.getActionNum() == 5)
						{
							String userInput = JOptionPane.showInputDialog(mainPanel,
									"EXTRA CREDIT\nWhat is three-fifths of 100?\n" +
									"	1) 3\n" +
									"	2) 5\n" + 
									"	3) 20\n" +
									"	4) 60", "Enter your answer here");
									int i = Integer.parseInt(userInput);
									if(i == 1 )
									{
										JOptionPane.showMessageDialog(mainPanel, "3 is incorrect!\n The answer was 60. Your GPA has decreased.", "EXTRA CREDIT", JOptionPane.INFORMATION_MESSAGE);
										p.adjustGPA(-.40);
									}
									else if(i == 2)
									{
									 	JOptionPane.showMessageDialog(mainPanel, "5 is incorrect!\n The answer was 60. Your GPA has decreased.", "EXTRA CREDIT", JOptionPane.INFORMATION_MESSAGE);
									 	p.adjustGPA(-.40);
									}
									else if(i == 3)
									{
									 	JOptionPane.showMessageDialog(mainPanel, "20 is incorrect!\n The answer was 60. Your GPA has decreased.", "EXTRA CREDIT", JOptionPane.INFORMATION_MESSAGE);
									 	p.adjustGPA(-.40);
									}
									else if(i == 4)
									{
									 	JOptionPane.showMessageDialog(mainPanel, "60 is correct!\n Your GPA has increased.", "EXTRA CREDIT", JOptionPane.INFORMATION_MESSAGE);
									 	p.adjustGPA(.20);
									}
							
						}
						if(Game.getWeekNum() == 8 && Game.getActionNum() == 5)
						{
							String userInput = JOptionPane.showInputDialog(mainPanel,
									"EXTRA CREDIT\nWhat is the main cause of seasons on Earth?\n" +
									"	1) The speed that the Earth rotates around the sun.\n" +
									"	2) The distance between the Earth and sun.\n" + 
									"	3) The tilt of the Earth's axis in relation to the sun.\n" +
									"	4) Changes in the amount of energy coming from the sun.", "Enter your answer here");
									int i = Integer.parseInt(userInput);
									if(i == 1 )
									{
										JOptionPane.showMessageDialog(mainPanel, "The speed that the Earth rotates around the sun is incorrect!\n The answer was the tilt of the Earth's axis in relation to the sun. Your GPA has decreased.", "EXTRA CREDIT", JOptionPane.INFORMATION_MESSAGE);
										p.adjustGPA(-.40);
									}
									else if(i == 2)
									{
									 	JOptionPane.showMessageDialog(mainPanel, "The distance between the Earth and sun is incorrect!\n The answer was the tilt of the Earth's axis in relation to the sun. Your GPA has decreased.", "EXTRA CREDIT", JOptionPane.INFORMATION_MESSAGE);
									 	p.adjustGPA(-.40);
									}
									else if(i == 3)
									{
									 	JOptionPane.showMessageDialog(mainPanel, "The tilt of the Earth's axis in relation to the sun is correct!\n Your GPA has increased.", "EXTRA CREDIT", JOptionPane.INFORMATION_MESSAGE);
									 	p.adjustGPA(.20);
									}
									else if(i == 4)
									{
									 	JOptionPane.showMessageDialog(mainPanel, "Changes in the amount of energy coming from the sun is incorrect!\n The answer was the tilt of the Earth's axis in relation to the sun. Your GPA has decreased.", "EXTRA CREDIT", JOptionPane.INFORMATION_MESSAGE);
									 	p.adjustGPA(-.40);
									}
						}
						else if(Game.getActionNum() < 5 && Game.getWeekNum() != 2 || Game.getWeekNum() != 4 || Game.getWeekNum() != 6 || Game.getWeekNum() != 8)
						{
							JOptionPane.showMessageDialog(mainPanel,
							"Welcome to the Classroom\n" + "Education Increased!", "LOCATION : Classroom", JOptionPane.INFORMATION_MESSAGE);
							p.adjustGPA(0.10);
	
						}
						Game.incrActionNum();
						p.checkHealthAndGPA();
						gui.replaceDisplayText();
					}
				}
			);
		classroomsButton.setFocusable(false);
		classroomsButton.setSize(170, 80);
		classroomsButton.setLocation(190, 240);
		classroomsButton.setOpaque(false);
		classroomsButton.setContentAreaFilled(false);
		classroomsButton.setBorderPainted(false);
		
		libraryButton = new JButton("");
		libraryButton.addActionListener(
				new ActionListener()
				{
					public void actionPerformed(ActionEvent e)//Library Button Action
					{
						Random rand = new Random();
						int randomNumber = rand.nextInt(20);
						
						if (randomNumber <= 3) {
							JOptionPane.showMessageDialog(mainPanel,
							        "You visit the Library and\n"
							        		+ "get some solid studying done.\n"
							        		+ "This should help your GPA!", "LOCATION : Library", JOptionPane.INFORMATION_MESSAGE);
							p.adjustGPA(0.25);
						} else if (randomNumber >= 4 && randomNumber <= 10) {
							JOptionPane.showMessageDialog(mainPanel,
							        "You visit the Library and\n"
							        		+ "get caught up in your classes.\n"
							        		+ "You are ready for classes tomorrow!", "LOCATION : Library", JOptionPane.INFORMATION_MESSAGE);
							p.adjustGPA(0.1);
						} else if (randomNumber >= 11 && randomNumber <= 16) {
							JOptionPane.showMessageDialog(mainPanel,
							        "You meet some friends at the Library.\n"
							        		+ "Unfortunately, you don't get any studying done.\n", "LOCATION : Library", JOptionPane.INFORMATION_MESSAGE);			
						} else if (randomNumber >= 17 && randomNumber <= 18) {
							JOptionPane.showMessageDialog(mainPanel,
									"You drag yourself to the Library\n"
											+ "You are so tired that you fall asleep.\n"
											+ "You feel great!", "LOCATION : Library", JOptionPane.INFORMATION_MESSAGE);				
							p.adjustHealth(1);
						} else {
							JOptionPane.showMessageDialog(mainPanel,
							        "You get distracted at the Library and\n"
							        		+ "end up talking to a hottie.\n"
							        		+ "You end up talking all night!\n"
							        		+ "GPA & Health are decreased!", "LOCATION : Library", JOptionPane.INFORMATION_MESSAGE);
							p.adjustGPA(-0.25);
							p.adjustHealth(-1);
						}
							
						Game.incrActionNum();
						p.checkHealthAndGPA();
						gui.replaceDisplayText();
						
					}
				});
		libraryButton.setFocusable(false);
		libraryButton.setSize(155, 135);
		libraryButton.setLocation(110, 320);
		libraryButton.setOpaque(false);
		libraryButton.setContentAreaFilled(false);
		libraryButton.setBorderPainted(false);
		
		cafeteriaButton = new JButton("");
		cafeteriaButton.addActionListener(
				new ActionListener()
				{
					public void actionPerformed(ActionEvent e)//Cafeteria Button Action
					{
						if (!p.inventory.contains("Meal card"))
						{
							JOptionPane.showMessageDialog(mainPanel,
									"You visit the Cafeteria.\n"
											+ "You need to get your meal card from the Front Desk\n"
											+ "before you can eat.", "LOCATION : Cafeteria", JOptionPane.INFORMATION_MESSAGE);
						} else {
							Random rand = new Random();
							int randomNumber = rand.nextInt(20);
						
							if (randomNumber <= 3) {
								JOptionPane.showMessageDialog(mainPanel,
										"You visit the Cafeteria and\n"
												+ "eat a good, hot meal.\n"
												+ "Delicious!", "LOCATION : Cafeteria", JOptionPane.INFORMATION_MESSAGE);
								p.adjustHealth(2);
							} else if (randomNumber >= 4 && randomNumber <= 12) {
								JOptionPane.showMessageDialog(mainPanel,
										"You visit the Cafeteria and\n"
												+ "grab a sandwich.\n"
												+ "You feel full!", "LOCATION : Cafeteria", JOptionPane.INFORMATION_MESSAGE);
								p.adjustHealth(1);
							} else if (randomNumber >= 13 && randomNumber <= 17) {
								JOptionPane.showMessageDialog(mainPanel,
										"You dash by the Cafeteria and\n"
												+ "grab a bag of chips and a cookie.\n"
												+ "You're hungry again in an hour.\n", "LOCATION : Cafeteria", JOptionPane.INFORMATION_MESSAGE);			
							} else if (randomNumber == 18) {
								JOptionPane.showMessageDialog(mainPanel,
										"You visit the Cafeteria\n"
												+ "and slip on a banana peel,\n"
												+ "breaking your wrist!", "LOCATION : Cafeteria", JOptionPane.INFORMATION_MESSAGE);				
								p.adjustHealth(-1);
							} else {
								JOptionPane.showMessageDialog(mainPanel,
										"You visit the Cafeteria and\n"
												+ "order chicken.\n"
												+ "It is a little pink, but you eat it anyway.\n"
												+ "You are up all night running to the bathroom!", "LOCATION : Cafeteria", JOptionPane.INFORMATION_MESSAGE);
								p.adjustGPA(-0.25);
								p.adjustHealth(-2);
							}
						}
						
						Game.incrActionNum();
						p.checkHealthAndGPA();
						gui.replaceDisplayText();
						cl.setVgap(110);
					}
				});
		cafeteriaButton.setFocusable(false);
		cafeteriaButton.setSize(100, 100);
		cafeteriaButton.setLocation(685, 175);
		cafeteriaButton.setOpaque(false);
		cafeteriaButton.setContentAreaFilled(false);
		cafeteriaButton.setBorderPainted(false);
		
		deskButton = new JButton("");
		deskButton.addActionListener(
				new ActionListener()
				{
					public void actionPerformed(ActionEvent e)//FrontDesk Button Action
					{
						JOptionPane.showMessageDialog(mainPanel,
						        "Welcome to the Front Desk\n" + "You collect your dorm key and your meal card!", "LOCATION : Front Desk", JOptionPane.INFORMATION_MESSAGE);
						Game.incrActionNum();
						p.checkHealthAndGPA();
						gui.replaceDisplayText();
						cl.setVgap(110);
						
						if (!p.inventory.contains("Meal card"))
						{
							p.addInventoryItem("Meal card");
						}
						
						if (!p.inventory.contains("Dorm key"))
						{
							p.addInventoryItem("Dorm key");
						}
					}
				});
		deskButton.setFocusable(false);
		deskButton.setSize(150, 150);
		deskButton.setLocation(315, 300);
		deskButton.setOpaque(false);
		deskButton.setContentAreaFilled(false);
		deskButton.setBorderPainted(false);
		
		loungeButton = new JButton("");
		loungeButton.addActionListener(
				new ActionListener()
				{
					public void actionPerformed(ActionEvent e)//Lounge Button Action
					{
						JOptionPane.showMessageDialog(mainPanel,
						        "Welcome to the Lounge 'freshie'\n" 
						        + "Be careful around those darn hall monitors", "LOCATION : Lounge", JOptionPane.INFORMATION_MESSAGE);
						Game.incrActionNum();
						p.checkHealthAndGPA();
						gui.replaceDisplayText();
						cl.setVgap(110);
						if (!p.inventory.contains("Empty Beer Can"))
						{
							p.addInventoryItem("Empty Beer Can");
						}
					}
				});
		loungeButton.setFocusable(false);
		loungeButton.setSize(100, 100);
		loungeButton.setLocation(0, 175);
		loungeButton.setOpaque(false);
		loungeButton.setContentAreaFilled(false);
		loungeButton.setBorderPainted(false);
		
		backButton = new JButton("BACK");
		backButton.addActionListener(
				new ActionListener()
				{
					public void actionPerformed(ActionEvent e)//Back Button Action
					{
						cl.setVgap(0);
						cl.show(mainPanel, "campus");
					}
				});
		backButton.setSize(75, 50);
		backButton.setLocation(700, 400);
	}
}
