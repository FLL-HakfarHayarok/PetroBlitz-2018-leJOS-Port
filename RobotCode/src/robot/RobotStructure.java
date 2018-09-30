package robot;

import lejos.hardware.ev3.LocalEV3;
import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.motor.EV3MediumRegulatedMotor;
import lejos.hardware.motor.UnregulatedMotor;
import lejos.hardware.port.SensorPort;
import lejos.hardware.port.TachoMotorPort;
import lejos.hardware.sensor.EV3ColorSensor;
import lejos.hardware.sensor.EV3GyroSensor;

/**
 * This is a class which maps out the hardware connected to the robot
 * for use by other classes. All port and hardware changes should be
 * altered in this class and any calls to motors or sensors should
 * directly reference this class.
 * @author John
 *
 */
public class RobotStructure {
	
	/**
	 * Get ports
	 */
	public static final TachoMotorPort portA = LocalEV3.get().getPort("A").open(TachoMotorPort.class);
	public static final TachoMotorPort portB = LocalEV3.get().getPort("B").open(TachoMotorPort.class);
	public static final TachoMotorPort portC = LocalEV3.get().getPort("C").open(TachoMotorPort.class);
	public static final TachoMotorPort portD = LocalEV3.get().getPort("D").open(TachoMotorPort.class);
	
	/**
	 * Motor connections map
	 */
	public static final EV3LargeRegulatedMotor rightMotorReg = new EV3LargeRegulatedMotor(portC);
	public static final EV3LargeRegulatedMotor leftMotorReg = new EV3LargeRegulatedMotor(portB);
	public static final EV3MediumRegulatedMotor armMotor1Reg = new EV3MediumRegulatedMotor(portA);
	public static final EV3MediumRegulatedMotor armMotor2Reg = new EV3MediumRegulatedMotor(portD);

	/**
	 * Unregulated motors
	 */
	public static final UnregulatedMotor rightMotorUnreg = new UnregulatedMotor(portC);
	public static final UnregulatedMotor leftMotorUnreg = new UnregulatedMotor(portB);
	public static final UnregulatedMotor armMotorUnreg = new UnregulatedMotor(portA);
	public static final UnregulatedMotor armMotor2Unreg = new UnregulatedMotor(portD);
	
	/**
	 * Sensor connections map
	 */
	public static final EV3GyroSensor sensor1 = new EV3GyroSensor(SensorPort.S1);
	public static final EV3ColorSensor sensor2 = new EV3ColorSensor(SensorPort.S2);
	public static final EV3ColorSensor sensor3 = new EV3ColorSensor(SensorPort.S3);
	public static final EV3ColorSensor sensor4 = new EV3ColorSensor(SensorPort.S4);
	
	/**
	 * Stops all robot motors
	 */
	public static void stopAllMotors() {
		leftMotorReg.stop(true);
		rightMotorReg.stop(true);
		armMotor1Reg.stop(true);
		armMotor2Reg.stop(true);
	}
	

}
