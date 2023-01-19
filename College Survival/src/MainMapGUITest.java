import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;

//sut = subject under test

class MainMapGUITest {

	@Test
	void testGUI() {
		MainMapGUI gui = new MainMapGUI();
		assertNotNull(gui);
	}
	@Test
	void buttonHandlerTest()
	{
			
	}

	@Test
	void mainMapDormsButtonTest() throws AWTException {
		MainMapGUI gui = new MainMapGUI();
		Robot sut = new Robot();
		sut.mouseMove(240, 450);
		sut.mousePress(InputEvent.BUTTON1_MASK);
		try {Thread.sleep(250);}catch(InterruptedException e) {}
		sut.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
	}
	
	@Test
	void mainMapGymButtonTest() throws AWTException {
		MainMapGUI gui = new MainMapGUI();
		Robot sut = new Robot();
		sut.mouseMove(510, 450);
		sut.mousePress(InputEvent.BUTTON1_MASK);
		try {Thread.sleep(250);}catch(InterruptedException e) {}
		sut.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
	}
	
	@Test
	void mainMapCommonsButtonTest() throws AWTException {
		MainMapGUI gui = new MainMapGUI();
		Robot sut = new Robot();
		sut.mouseMove(425, 310);
		sut.mousePress(InputEvent.BUTTON1_MASK);
		try {Thread.sleep(250);}catch(InterruptedException e) {}
		sut.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
	}
	
	@Test
	void mainMapClassroomsButtonTest() throws AWTException {
		MainMapGUI gui = new MainMapGUI();
		Robot sut = new Robot();
		sut.mouseMove(170, 220);
		sut.mousePress(InputEvent.BUTTON1_MASK);
		try {Thread.sleep(250);}catch(InterruptedException e) {}
		sut.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
	}
	
	@Test
	void mainMapLibraryButtonTest() throws AWTException {
		MainMapGUI gui = new MainMapGUI();
		Robot sut = new Robot();
		sut.mouseMove(110, 300);
		sut.mousePress(InputEvent.BUTTON1_MASK);
		try {Thread.sleep(250);}catch(InterruptedException e) {}
		sut.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
	}

	@Test
	void commonsMapCafeteriaButtonTest() throws AWTException {
		MainMapGUI gui = new MainMapGUI();
		Robot sut = new Robot();
		sut.mouseMove(425, 310);
		sut.mousePress(InputEvent.BUTTON1_MASK);
		try {Thread.sleep(250);}catch(InterruptedException e) {}
		sut.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		sut.mouseMove(685, 175);
		sut.mousePress(InputEvent.BUTTON1_MASK);
		try {Thread.sleep(250);}catch(InterruptedException e) {}
		sut.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);		
	}
	
	@Test
	void commonsMapDeskButtonTest() throws AWTException {
		MainMapGUI gui = new MainMapGUI();
		Robot sut = new Robot();
		sut.mouseMove(425, 310);
		sut.mousePress(InputEvent.BUTTON1_MASK);
		try {Thread.sleep(250);}catch(InterruptedException e) {}
		sut.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		sut.mouseMove(315, 300);
		sut.mousePress(InputEvent.BUTTON1_MASK);
		try {Thread.sleep(250);}catch(InterruptedException e) {}
		sut.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);		
	}
	
	@Test
	void commonsMapLoungeButtonTest() throws AWTException {
		MainMapGUI gui = new MainMapGUI();
		Robot sut = new Robot();
		sut.mouseMove(425, 310);
		sut.mousePress(InputEvent.BUTTON1_MASK);
		try {Thread.sleep(250);}catch(InterruptedException e) {}
		sut.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		sut.mouseMove(0, 175);
		sut.mousePress(InputEvent.BUTTON1_MASK);
		try {Thread.sleep(250);}catch(InterruptedException e) {}
		sut.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);		
	}

	@Test
	void commonsMapBackButtonTest() throws AWTException {
		MainMapGUI gui = new MainMapGUI();
		Robot sut = new Robot();
		sut.mouseMove(425, 310);
		sut.mousePress(InputEvent.BUTTON1_MASK);
		try {Thread.sleep(250);}catch(InterruptedException e) {}
		sut.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		sut.mouseMove(700, 400);
		sut.mousePress(InputEvent.BUTTON1_MASK);
		try {Thread.sleep(250);}catch(InterruptedException e) {}
		sut.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);		
	}
}
