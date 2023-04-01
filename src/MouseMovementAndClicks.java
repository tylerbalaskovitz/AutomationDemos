import java.awt.MouseInfo;

public class MouseMovementAndClicks {
	
	public boolean leftMouseClicked = false;
	public boolean rightMouseClicked = false;
	public int movementX;
	public int movementY;
	
	public MouseMovementAndClicks() {
		leftMouseClicked = false;
		rightMouseClicked = false;
		movementX = (int)MouseInfo.getPointerInfo().getLocation().getX();
		movementY = (int)MouseInfo.getPointerInfo().getLocation().getY();
	}
	
	public boolean isLeftMouseClicked() {
		return leftMouseClicked;
	}
	public void setLeftMouseClicked(boolean mouseClicked) {
		this.leftMouseClicked = mouseClicked;
	}
	public int getMovementX() {
		return movementX;
	}
	public void setMovementX(int movementX) {
		this.movementX = movementX;
	}
	public boolean isRightMouseClicked() {
		return rightMouseClicked;
	}
	public void setRightMouseClicked(boolean rightMouseClicked) {
		this.rightMouseClicked = rightMouseClicked;
	}
	public int getMovementY() {
		return movementY;
	}
	public void setMovementY(int movementY) {
		this.movementY = movementY;
	}

}
