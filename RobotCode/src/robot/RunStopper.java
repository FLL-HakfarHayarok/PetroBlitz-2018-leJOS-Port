package robot;

import lejos.hardware.Button;

/**
 * A thread that will stop a given run when the escape button is pressed
 * @author John
 *
 */
public class RunStopper extends Thread implements Runnable{

	/**
	 * The run that this stopper will stop
	 */
	private RobotRun target;
	
	/**
	 * Constructor for a run stopper
	 * @param run Target run for this stopper
	 */
	public RunStopper(RobotRun run) {
		this.target = run;
	}
	
	/**
	 * Run method for this thread, stops if the target thread isn't running or after it interrupts it.
	 * If the interrupt fails for any reason it will retry 500ms later and the movementis interrupted
	 * anyway.
	 */
	@Override
	public void run() {
		//loops as long as target is running
		while(target.isAlive()) {
			//when escape is pressed, interrupt target and stop motors immediately
			if(Button.ESCAPE.isDown()) {
				while(Button.ESCAPE.isDown());
				try {
				target.interrupt();
				Thread.sleep(500);
				RobotStructure.stopAllMotors();
				}catch (Exception e) {}
			}
		}
		
	}

}
