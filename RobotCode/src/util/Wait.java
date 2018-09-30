package util;

import lejos.hardware.sensor.EV3TouchSensor;
import lejos.robotics.SampleProvider;

/**
 * Alternative to mindstorms wait blocks for sensors.
 * Motors are natively supported by lejos using motor.rotate() and similar
 * methods. However, sensors are not.
 * @author John
 *
 */
public class Wait {

	/**
	 * Wait for a touch sensor to be pressed. Gets a sensor instance.
	 * @param sensor
	 */
	public void waitForPress(EV3TouchSensor sensor) {
		touchSensorWait(sensor, true);
	}

	/**
	 * Wait for a touch sensor to be pressed. Gets a sensor instance.
	 * @param sensor
	 */
	public void waitForRelease(EV3TouchSensor sensor) {
		touchSensorWait(sensor, false);
	}

	/**
	 * Wait for a touch sensor to be pressed or released. Gets target state
	 * and a sensor object.
	 * @param sensor
	 * @param state Whether the sensor should be pressed or not
	 */
	private void touchSensorWait(EV3TouchSensor sensor, boolean state) {
		//create sample provider for sensor
		SampleProvider sample = sensor.getTouchMode();
		
		//init variables
		boolean waiting = false;
		float[] value = new float[0];
		
		//while, stops with interrupt and when condition is net
		while (!waiting && !Thread.currentThread().isInterrupted()) {
			sample.fetchSample(value, 0);
			if (state && value[0] == 1) {
				waiting = true;
			} else if (!state && value[0] == 0) {
				waiting = true;
			}
		}
	}
}
