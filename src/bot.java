import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.IOException;

public class bot {
	
	//clipboard for copying and pasting
	public static void clip(String text) {
		StringSelection stringSelection = new StringSelection(text);
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		clipboard.setContents(stringSelection, stringSelection);
	}
	
	
	public static void main(String[] args) throws IOException, AWTException {
	Robot robot = new Robot();
	
	//used to open any program on our computer.
	Runtime runtime = Runtime.getRuntime();
	
	
	//Copy&paste
	String [] text = new String[10];
	text[0] = "c:";
	text[1] = "clear";
	text[2] = "mkdir c:/important";
	text[3] = "wget \"http://clipart-library.com/images/kiMKobxKT.jpg\" -outfile \"c:/important/wc.jpg\"";
	text[4] = "exit";
	text[5] ="c:\\important";
	
	text[6] = "https://www.youtube.com/watch?v=8mkofgRW1II&t=69s";
	
	
	
	
	//Desktop and Wait
	robot.delay(2000);
	
	
	/*
	//Powershell
	robot.keyPress(KeyEvent.VK_WINDOWS);
	robot.keyPress(KeyEvent.VK_X);
	robot.keyRelease(KeyEvent.VK_WINDOWS);
	robot.keyRelease(KeyEvent.VK_X);
	
	robot.delay(500);
	
	robot.keyPress(KeyEvent.VK_I);
	robot.keyRelease(KeyEvent.VK_I);
	
	//Loop for copying and pasting
	
	for (int i = 0; i < 4; i++) {
		robot.delay(600);
		clip(text[i]);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}
		//open the directory to the picture
		robot.delay(1000);
		robot.keyPress(KeyEvent.VK_WINDOWS);
		robot.keyRelease(KeyEvent.VK_WINDOWS);
		
		robot.delay(800);
		clip(text[5]);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
		
		robot.delay(500);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		
		//select picture
		robot.delay(800);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_A);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_A);
	
		robot.delay(800);
		robot.keyPress(KeyEvent.VK_CONTEXT_MENU);
		robot.keyRelease(KeyEvent.VK_CONTEXT_MENU);
		
		robot.delay(800);
		for (int i = 0; i < 5; i++) {
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyRelease(KeyEvent.VK_DOWN);
		}
		
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		
		//close
		robot.delay(800);
		robot.keyPress(KeyEvent.VK_ALT);
		robot.keyPress(KeyEvent.VK_F4);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_F4);
	*/
	/*
	runtime.exec("mspaint.exe");
	robot.delay(10000);
	int xstart = 1000;
	int ystart = 1000;
	
	robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
	for (int k = 0; k < 200; k++) {
		int l = (int)(Math.random()*1000) + 150;
		int m = (int)(Math.random()*1000) + 150;
		robot.mouseMove(l, m);
		robot.delay(10);
	}
	
	robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
	
	robot.mouseMove(xstart, ystart);
	robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
	
	for (int k = 0; k < 100; k++) {
		robot.delay(10);
		robot.mouseMove(xstart+50, ystart-30);
		
		for (int j = 0; j< 100; j++) {
			robot.mouseMove(xstart++, ystart++);
		}
	}
	robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
	*/
	//browser opening
	runtime.exec("C:\\Program Files\\Mozilla Firefox\\firefox.exe");
	
	robot.delay(1000);
	
	robot.keyPress(KeyEvent.VK_WINDOWS);
	robot.keyPress(KeyEvent.VK_UP);
	robot.keyRelease(KeyEvent.VK_WINDOWS);
	robot.keyRelease(KeyEvent.VK_UP);
	
	//address bar
	
	robot.delay(800);
	clip(text[6]);
	robot.keyPress(KeyEvent.VK_CONTROL);
	robot.keyPress(KeyEvent.VK_V);
	robot.keyRelease(KeyEvent.VK_CONTROL);
	robot.keyRelease(KeyEvent.VK_V);
	
	//enter
	robot.delay(1000);
	robot.keyPress(KeyEvent.VK_ENTER);
	robot.keyRelease(KeyEvent.VK_ENTER);
	
	robot.delay(1000);
	
	for (int i = 0;  i < 10; i++) {

	robot.keyPress(KeyEvent.VK_SPACE);
	robot.keyRelease(KeyEvent.VK_SPACE);
	robot.delay(100);
	robot.keyPress(KeyEvent.VK_0);
	robot.keyRelease(KeyEvent.VK_0);
	}
	
}
}