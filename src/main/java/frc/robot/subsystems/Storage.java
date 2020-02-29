
package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.StorageConstants;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.DigitalInput;

public class Storage extends SubsystemBase {

	public static final DigitalInput ballsInSwitch = new DigitalInput(StorageConstants.BALLS_IN_SWITCH_ID);
	public static final DigitalInput ballsOutSwitch = new DigitalInput(StorageConstants.BALLS_OUT_SWITCH_ID);
	public static final WPI_VictorSPX polycord = new WPI_VictorSPX(StorageConstants.POLYCORD_MOTOR_ID);


	public Storage() {
		polycord.configFactoryDefault();
	}

	public void moveIn() {
		polycord.set(ControlMode.PercentOutput, StorageConstants.POLYCORD_FORWARD_SPEED);
	}

	public void moveOut() {
		polycord.set(ControlMode.PercentOutput, StorageConstants.POLYCORD_BACKWARD_SPEED);
	}

	public void moveStop() {
		polycord.stopMotor();
	}

	public boolean getPos1() {
		return ballsInSwitch.get();
	}

	public boolean getPos5() {
		return ballsOutSwitch.get();
	}
}
