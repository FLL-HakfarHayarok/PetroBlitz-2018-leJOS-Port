package runs;

import lejos.utility.Delay;
import robot.RobotRun;
import robot.RobotStructure;

public class Run1 extends RobotRun{

	public void runInstructions() {
		
		//reset gyro sensor and wait
		Delay.msDelay(500);
		RobotStructure.sensor1.reset();
		Delay.msDelay(200);
		if(Thread.currentThread().isInterrupted()) return;
		
		
		RobotStructure.armMotor1Reg.setSpeed(800);
		RobotStructure.armMotor1Reg.rotate(-800);

		
		
	}
}
