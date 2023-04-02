package OSRSBot;
import java.awt.AWTException;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.JFrame;

public class Pointer extends JFrame implements MouseListener, MouseMotionListener, KeyListener{
	Main main;
	
	/*Use an ArrayList and the size of the ArrayList is used within the loop as a way to allow for mouse movements to 
	resize dynamically based on however long the player wants to bot. 
	*/
	
	
	//use this to create a method that clears the array list when true so that way new values can be stored within the
	//the arrayList for multiple uses throughout using the application. 
	public boolean currentlyBotting = false;
	public boolean recordingMouse = false;
	Thread botThread;
	ArrayList <MouseMovementAndClicks> mmacArrayList = new ArrayList<>();	
	
	MouseMovementAndClicks mmac = new MouseMovementAndClicks();
	
	Robot robot;
	
	public Point pointerLocation;
	public double getX = MouseInfo.getPointerInfo().getLocation().getX();
	public double getY = MouseInfo.getPointerInfo().getLocation().getY();
	
	public int mouseMovementX, mouseMovementY;
	
	
	
	
	public Pointer(){
		startRobot();
		addKeyListener(this);
		addMouseListener(this);
		addMouseMotionListener(this);
	}
	
	public void startRobot() {
		try {
			robot = new Robot();
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//This resets the arraylist when the player is not botting
	public void resetArrayList(boolean currentlyBotting) {
		
		if (currentlyBotting == false) {
			mmacArrayList.clear();
		}
		
	}

	
	
	@Override
	public void mouseClicked(MouseEvent e) {
		switch (e.getID()) {
		case InputEvent.BUTTON1_DOWN_MASK:mmac.setLeftMouseClicked(true); break;
		case InputEvent.BUTTON3_DOWN_MASK:mmac.setRightMouseClicked(true); break;
		}
		
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		switch (e.getID()) {
		case InputEvent.BUTTON1_DOWN_MASK:mmac.setLeftMouseClicked(false); break;
		case InputEvent.BUTTON3_DOWN_MASK:mmac.setRightMouseClicked(false); break;
		}
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public void gatherMouseInformation() {
		while (recordingMouse == true) {
			pointerLocation = MouseInfo.getPointerInfo().getLocation();
			this.mouseMovementX = (int)pointerLocation.getLocation().getX();
			this.mouseMovementY = (int)pointerLocation.getLocation().getY();
			
			//first the coordinates have to be gathered from the ArrayList, and after they are gathered,
			//then the mouse click events will happen. 
			mmac = new MouseMovementAndClicks();
			
			
			
			mmac.setMovementX(mouseMovementX);
			mmac.setMovementY(mouseMovementY);
			System.out.println("X:" + this.mouseMovementX + " Y:" + this.mouseMovementY);
			mmacArrayList.add(mmac);
			}
		
	}
	
	public void automateMouseBehavior() throws AWTException {
		
		while (currentlyBotting == true) {
			for (int i = 0; i < mmacArrayList.size(); i++) {
			
				//moves the mouse based on the current ArrayList value that was captured. 
			robot.mouseMove(mmacArrayList.get(i).getMovementX(), mmacArrayList.get(i).getMovementY());
			if (mmacArrayList.get(i).leftMouseClicked == true) {
				robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
			}
			if (mmacArrayList.get(i).rightMouseClicked == true) {
				robot.mousePress(InputEvent.BUTTON3_DOWN_MASK);
			}
			}
		
		}
		
		
				
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		
		
	}




	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	//Three keys are listened too, R for record, S for start, and ESCape to quit
	
	@Override
	public void keyPressed(KeyEvent e) {
		switch(e.getKeyCode()) {
			case KeyEvent.VK_R: currentlyBotting = false; recordingMouse = true; gatherMouseInformation();break;
			case KeyEvent.VK_S: currentlyBotting = true; recordingMouse = false; try {
				automateMouseBehavior();
			} catch (AWTException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} break;
			case KeyEvent.VK_ESCAPE: currentlyBotting = false; recordingMouse = false; resetArrayList(currentlyBotting);break;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
