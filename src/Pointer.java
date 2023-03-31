import java.awt.AWTException;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Robot;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class Pointer implements MouseListener, MouseMotionListener, Runnable{
	Main main;
	
	int FPS = 60;
	
	Thread botThread;
	
	int mouseMovements = 0;
	int previousXLocation [] = new int [100000];
	int previousYLocation [] = new int [100000];
	Robot robot;
	
	
	public Pointer(Main main) {
		this.main = main;
		
	}
	
	public Point pointerLocation;
	
	
	
	public double getX = MouseInfo.getPointerInfo().getLocation().getX();
	public double getY = MouseInfo.getPointerInfo().getLocation().getY();
	
	
	public int clickedX, clickedY;
	
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
		/*
		pointerLocation = MouseInfo.getPointerInfo().getLocation();
		this.clickedX = (int)pointerLocation.getLocation().getX();
		this.clickedY = (int)pointerLocation.getLocation().getY();
		
		mouseMovements++;
		if (mouseMovements < 100000) {
			previousXLocation[mouseMovements] = this.clickedX;
			previousYLocation[mouseMovements] = this.clickedY;
			
		}
		
		while (mouseMovements > 100000) {
			for (int i = 0; i< 100000; i++) {
			robot = new Robot();
		
			robot.mouseMove(previousXLocation[i], previousYLocation[i]);
			}
		
		}
		
		
				System.out.println("X:" + this.clickedX + " Y:" + this.clickedY);
		*/
	}

	@Override
	public void run() {
		//this should run in the program so that way there is a cap on the number of coordinates being captured and put into the array since 100,000 is far too much.

		double drawInterval = 1000000000/FPS;
		double delta = 0;
		long lastTime = System.nanoTime();
		long currentTime;
		long timer = 0;
		int drawCount = 0;
		
		while (botThread != null) {
			currentTime = System.nanoTime();
			
			delta += (currentTime - lastTime)/drawInterval;
			timer += (currentTime - lastTime);
			lastTime = currentTime;
			
			if (delta >= 1) {
				delta--;
				drawCount++;
			}
			
			if (timer >= 1000000000) {
				System.out.println("FPS: " + drawCount);
				drawCount = 0;
				timer = 0;
			}
			
		}
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		e.getX();
		e.getY();
		
	}

}
