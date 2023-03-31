import java.awt.AWTException;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

public class Pointer implements MouseListener, MouseMotionListener, KeyListener, Runnable{
	Main main;
	
	/*Use an ArrayList and the size of the ArrayList is used within the loop as a way to allow for mouse movements to 
	resize dynamically based on however long the player wants to bot. 
	*/
	
	int FPS_SET = 60;
	
	//use this to create a method that clears the array list when true so that way new values can be stored within the
	//the arrayList for multiple uses throughout using the application. 
	public boolean currentlyBotting = false;
	Thread botThread;
	ArrayList <MouseMovementAndClicks> mmacArrayList = new ArrayList<>();	
	int mouseMovements = 0;
	
	MouseMovementAndClicks mmac = new MouseMovementAndClicks();
	
	int previousXLocation [] = new int [100000];
	int previousYLocation [] = new int [100000];
	Robot robot;
	
	public Point pointerLocation;
	public double getX = MouseInfo.getPointerInfo().getLocation().getX();
	public double getY = MouseInfo.getPointerInfo().getLocation().getY();
	
	public int mouseMovementX, mouseMovementY;
	
	
	
	
	public Pointer(Main main) {
		this.main = main;
		
	}
	
	//This resets the arraylist when the player is not botting
	public void resetArrayList(boolean currentlyBotting) {
		
		if (currentlyBotting == false) {
			mmacArrayList.clear();
		}
		
	}

	
	
	@Override
	public void mouseClicked(MouseEvent e) {
		Point m =  e.getPoint();
		System.out.println(m);
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public void mouseCoordinates() throws AWTException {
		pointerLocation = MouseInfo.getPointerInfo().getLocation();
		this.mouseMovementX = (int)pointerLocation.getLocation().getX();
		this.mouseMovementY = (int)pointerLocation.getLocation().getY();
		
		//first the coordinates have to be gathered from the ArrayList, and after they are gathered,
		//then the mouse click events will happen. 
		
		mouseMovements++;
		while (currentlyBotting == true) {
		mmac.setMovementX(mouseMovementX);
		mmac.setMovementY(mouseMovementY);
		
		mmacArrayList.add(mmac);
		}
		
		while (mouseMovements > 100000) {
			for (int i = 0; i< 100000; i++) {
			robot = new Robot();
		
			robot.mouseMove(previousXLocation[i], previousYLocation[i]);
			}
		
		}
		
		
				System.out.println("X:" + this.mouseMovementX + " Y:" + this.mouseMovementY);
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		
		
	}

	@Override
	public void run() {
		//this should run in the program so that way there is a cap on the number of coordinates being captured and put into the array since 100,000 is far too much.

		double timePerFrame = 1000000000.0/FPS_SET;
		long lastFrame = System.nanoTime();
		long now = System.nanoTime();
		int frames = 0;
		long lastCheck = System.currentTimeMillis();
		while(true) {

			now = System.nanoTime();
		if(now - lastFrame >= timePerFrame) {
			lastFrame = now;
			frames++;
		}
		
		if(System.currentTimeMillis() - lastCheck>= 1000) {
			lastCheck = System.currentTimeMillis();
			System.out.println("FPS: " + frames);
			frames = 0;
		}
			
		}

		
	}



	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	//Three keys are listened too, R for record, S for start, and EScape to quit
	
	@Override
	public void keyPressed(KeyEvent e) {
		switch(e.getKeyCode()) {
			case KeyEvent.VK_R: currentlyBotting = true;break;
			case KeyEvent.VK_S: currentlyBotting = true;break;
			case KeyEvent.VK_ESCAPE: currentlyBotting = false;break;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
