
public class MouseMovementAndClicks {
	
	public boolean mouseClicked = false;
	public int movementX;
	public int movementY;
	public long duration;
	
	public boolean isMouseClicked() {
		return mouseClicked;
	}
	public void setMouseClicked(boolean mouseClicked) {
		this.mouseClicked = mouseClicked;
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
	public long getDuration() {
		return duration;
	}
	public void setDuration(long duration) {
		this.duration = duration;
	}

}
