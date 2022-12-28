import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.image.BufferedImage;
import java.awt.image.DataBuffer;
import java.awt.image.DataBufferInt;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class browserbot extends Thread {

	public Rectangle rectangle;

	
	public browserbot(int x, int y, int width, int height) {
		
		rectangle = new Rectangle(x, y, width, height);
		
	}
	
	public void run() {
		try {
			Robot robot = new Robot();
			
			robot.delay(1500);
			
			BufferedImage image = robot.createScreenCapture(rectangle);
			ImageIO.write(image, "png", new File("c:/important/screen.png"));
			
			long endTime = System.currentTimeMillis()+61000; //61 seconds
			boolean forever = false;
			while (forever || endTime >= System.currentTimeMillis()) {
				BufferedImage img= robot.createScreenCapture(rectangle);
				WritableRaster r = img.getRaster();
				DataBuffer db = r.getDataBuffer();
				DataBufferInt dbi = (DataBufferInt)db;
				int [] data = dbi.getData();
				
				for (int x_scale=0; x_scale < rectangle.width; x_scale += 10) {
					for (int y_scale = 0; y_scale< rectangle.height; y_scale += 10) {
						int rgb = data[x_scale+rectangle.width  * y_scale];
						
						if (rgb == -9157853 ||
									rgb == -10537187 ||
									rgb == -10143201 ||
									rgb == -8764124 ||
									rgb == -8172243 ||
									rgb == -8763348 ||
									rgb == -8829660 ||
									rgb == -6983395 ||
									rgb == -5866468 ||
									rgb == -8172499 ||
									rgb == -5866468 ||
									rgb == -4288472 ||
									rgb == -4025041 ||
									rgb == -4682714 ||
									rgb == -6983653 ||
									rgb == -9354197
									)
						
						
						
						{
							robot.mouseMove(rectangle.x + x_scale, rectangle.y + y_scale);
							robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
							robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
						}
						
					}
					
				}
				
				}
			
			/*
			robot.mouseMove(300, 350);
			robot.delay(1500);
			robot.mouseMove(1300, 350);
			robot.delay(1500);
			robot.mouseMove(1300, 950);
			robot.delay(1500);
			robot.mouseMove(300, 950);
			*/
			
		} catch (AWTException | IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		
		new browserbot(300,350,1000,600).start();
		
	}
	
}
