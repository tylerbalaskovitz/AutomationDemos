
public class MouseMovementAndClicks {
	
	public boolean leftMouseClicked = false;
	public boolean rightMouseClicked = false;
	public int movementX;
	public int movementY;
	
	public boolean isMouseClicked() {
		return leftMouseClicked;
	}
	public void setMouseClicked(boolean mouseClicked) {
		this.leftMouseClicked = mouseClicked;
	}
	public int getMovementX() {
		return movementX;
	}
	public void setMovementX(int movementX) {
		this.movementX = movementX;
	}
	public int getMovementY() {
		return movementY;
	}
	public void setMovementY(int movementY) {
		this.movementY = movementY;
	}

}
