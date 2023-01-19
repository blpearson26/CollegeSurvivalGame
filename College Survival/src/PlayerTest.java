import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.junit.jupiter.api.Test;

//sut = subject under test

public class PlayerTest {

	@Test
	void testStudentConstruction() {
		Player sut = new Player();
		assert sut.getGPA() == 2.0;
		assert sut.getHealth() == 5;
	}
	
	@Test
	void testPositiveSettingStudentGPA() {
		Player sut = new Player();
		sut.adjustGPA(0.45);
		assert sut.getGPA() == 2.45;
	}
	
	@Test
	void testNegativeSettingStudentGPA() {
		Player sut = new Player();
		sut.adjustGPA(-1.5);
		assert sut.getGPA() == 0.5;
	}	
	
	@Test
	void testPositiveSettingStudentHealth() {
		Player sut = new Player();
		sut.adjustHealth(1);
		assert sut.getHealth() == 6;
	}
	
	@Test
	void testNegativeSettingStudentHealth() {
		Player sut = new Player();
		sut.adjustHealth(-2);
		assert sut.getHealth() == 3;
	}
	
	@Test
	void testAddingItemsToInventory() {
		Player sut = new Player();
		sut.addInventoryItem("Book");
		assertEquals(sut.inventory.get(0), "Book");
	}
	
	@Test
	void testRemovingItemFromMiddleOfInventory() {
		Player sut = new Player();
		sut.addInventoryItem("Book");
		sut.addInventoryItem("ID card");
		sut.addInventoryItem("Meal card");
		sut.inventory.remove("Tablet");
		assertEquals(sut.inventory.get(0), "Book");
		assertEquals(sut.inventory.get(2), "Meal card");
	}
	
	@Test
	void testPrintInventoryThatIsEmpty() {
		Player sut = new Player();
		assertEquals(sut.returnInventoryAsString(), "Your inventory is empty");
	}
	
	@Test
	void testPrintInventoryWithOneItem() {
		Player sut = new Player();
		assertEquals(sut.returnInventoryAsString(), "Your inventory is empty");
	}
	
	@Test
	void testPrintInventoryWithMultipleItems() {
		Player sut = new Player();
		sut.inventory.add("Book");
		sut.inventory.add("ID card");
		sut.inventory.add("Meal card");
		assertEquals(sut.returnInventoryAsString(), "Book\nID card\nMeal card\n");
	}
	
}
