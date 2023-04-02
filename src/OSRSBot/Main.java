package OSRSBot;
import java.awt.AWTException;

public class Main {

	UI ui = new UI();
	public boolean clicked = false;
	Runner runner = new Runner();
	
	public static void main(String[] args) throws AWTException {
		new Main();
		
		
	}
	
	public Main() throws AWTException {
		
		runner.run();
	}
	
}
