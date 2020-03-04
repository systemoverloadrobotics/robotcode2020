package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.CONSTANTS.CLIMB;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;

public class Climb extends SubsystemBase {

	private WPI_TalonSRX elevatorMotor = new WPI_TalonSRX(CLIMB.ELEVATOR_ID);
	private WPI_VictorSPX winchMotor = new WPI_VictorSPX(CLIMB.WINCH_ID);


	public Climb() {
		elevatorMotor.configFactoryDefault();
		winchMotor.configFactoryDefault();
		elevatorMotor.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative);
	}

	public void goUp() {
		elevatorMotor.set(CLIMB.ELEVATOR_POWER_CONSTANT);
	}

	public void goDown() {
		elevatorMotor.set(CLIMB.REVERSE_ELEVATOR_POWER_CONSTANT);
	}

	public void liftStop() {
		elevatorMotor.stopMotor();
	}

	public double getEncoder() {
		System.out.println("Elevator Encoder: " + elevatorMotor.getSelectedSensorPosition());
		return elevatorMotor.getSelectedSensorPosition();
	}

	public void reelIn() {
		winchMotor.set(CLIMB.WINCH_POWER_CONSTANT);
	}

	public void reelOut() {
		winchMotor.set(CLIMB.REVERSE_WINCH_POWER_CONSTANT);
	}

	public void reelStop() {
		winchMotor.stopMotor();
	}

}
