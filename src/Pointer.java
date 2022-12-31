import java.awt.AWTException;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Robot;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Pointer implements MouseListener{
	Main main;
	
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
		
	}

}
