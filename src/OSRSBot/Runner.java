package OSRSBot;
import javax.swing.JFrame;

public class Runner extends JFrame implements Runnable{
	private Thread bottingThread;
	private Pointer pointer;
	
	public int FPS_SET = 60;
	
	public Runner() {
		pointer = new Pointer();
		this.requestFocus();
		startBottingLoop();
	}

	public void startBottingLoop() {
		bottingThread = new Thread(this);
		bottingThread.start();
	}
	
	@Override
	public void run() {
		double timePerFrame = 1000000000.0/FPS_SET;
		long lastFrame = System.nanoTime();
		long now = System.nanoTime();
		int frames = 0;
		long lastCheck = System.currentTimeMillis();

			
			
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
