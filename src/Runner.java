public class Runner implements Runnable{
	public Thread bottingThread;
	
	public int FPS_SET = 60;
	
	public Runner() {
		bottingThread = new Thread();
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
