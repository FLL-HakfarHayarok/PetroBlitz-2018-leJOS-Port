package main;

import lejos.hardware.Button;
import robot.RobotRun;
import runs.*;

/**
 * This is the main class for a robot. It includes an on-screen selector that
 * plays each run, and is also able to abort it.
 * @author John
 *
 */
public class RunSelector {

	/**
	 * Private indication of when the program should be stopped
	 */
	private static boolean active = true;
	
	/**
	 * Private indication of which run was selected
	 */
	private static RobotRun selectedRun = null;

	/**
	 * The main method that will be run when the jar is executed on the robot. Loops
	 * until the escape button is help for 2 seconds.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		MAIN_LOOP: while (active) {
			
			//read buttons and act accordingly
			switch (Button.getButtons()) {
			
			//escape - used only to exit program
			case Button.ID_ESCAPE:
				//timer for 2 seconds or until released
				long targetTime = (System.currentTimeMillis() + 2000);
				while (Button.ESCAPE.isDown()) {
					//set active to false if 2 seconds have passed without release
					if (System.currentTimeMillis() - targetTime < 0) {
						active = false;
						break MAIN_LOOP;
					}
				}
				break;
			//up - run 1
			case Button.ID_UP:
				selectedRun = new Run1();
				break;
			//down
			case Button.ID_DOWN:
				break;
			//right
			case Button.ID_RIGHT:
				break;
			//left
			case Button.ID_LEFT:
				break;
			}
			//start selected run
			selectedRun.start();
			//pause this thread until selected run is over
			while (selectedRun.isAlive());
		}
	}
}
