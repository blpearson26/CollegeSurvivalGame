import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Player implements KeyListener {

	private double gpa;
	private int health;
	private int checkTurn;
	public ArrayList<String> inventory = new ArrayList<String>(1);
	
	MainMapGUI m;

	public Player() {
		
		gpa = 2.00;
		health = 4;
		checkTurn = 1;
	}
	
	public double getGPA() {
		return this.gpa;
	}
	
	public int getHealth() {
		return this.health;
	}
	
	public void adjustGPA(double gpaAdjustment) {
		if ((gpa + gpaAdjustment) <= 0) {
			gpa = 0;
		} else if((gpa + gpaAdjustment) >= 4) {
			gpa = 4;
		} else {
			gpa = gpa + gpaAdjustment;
		}
	}
	
	public void adjustHealth(int healthAdjustment) {
		if ((health + healthAdjustment) <= 0) {
			health = 0;
		} else if((health + healthAdjustment) >= 9) {
			health = 9;
		} else {
			health = health + healthAdjustment;
		}
	}
	
	public void addInventoryItem(String itemToAdd) {
		this.inventory.add(itemToAdd);
	}

	public void printInventory() {
		String fullInventory = "";
		if (inventory.isEmpty()) {
			JOptionPane.showMessageDialog(null,
			        "Your inventory is empty!", "Inventory", JOptionPane.ERROR_MESSAGE);
		} else {
			for (int i = 0; i < inventory.size(); i++) {
				fullInventory = fullInventory + inventory.get(i) + "\n";
			}
			JOptionPane.showMessageDialog(null,
			        fullInventory, "Inventory", JOptionPane.DEFAULT_OPTION);
		}
	}
	public String statusToString()
	{
		String status = "|  Health: " + this.health + "  | GPA: " + this.gpa + " ";
		return status;
	}
	
	//Included to test efficacy of ArrayList structure
	public String returnInventoryAsString() {
		String inventoryString = "";
		
		if (inventory.isEmpty()) {
			inventoryString = inventoryString + "Your inventory is empty";
			System.out.println("Your inventory is empty");
		} else {
			for (int i = 0; i < inventory.size(); i++) {
				inventoryString = inventoryString + inventory.get(i) + "\n";
			}
		}
		
		return inventoryString;
	}
	
	public void checkHealthAndGPA() {//decrements GPA if health is low and week changes

        if(getHealth() < 4 && checkTurn != Game.getWeekNum()) {
            adjustGPA(-0.25);
            checkTurn = Game.getWeekNum();
        }
    }
	
	@Override
	public void keyTyped(KeyEvent e) {
				
	}

	@Override
	public void keyPressed(KeyEvent e) {//output to console shows if key is firing
		int key = e.getKeyCode();
		System.out.println("Key Pressed: " + e.getKeyCode());
		if(key == KeyEvent.VK_I) {
			System.out.println("'I' pressed. Opening inventory!");
			printInventory();
		} else {
			System.out.println("This key does nothing!");
		}
				
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
	}	
}
