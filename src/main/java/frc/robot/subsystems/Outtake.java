package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import frc.robot.CONSTANTS.OUTTAKE;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;


public class Outtake extends SubsystemBase {
	private WPI_TalonSRX shootMotor = new WPI_TalonSRX(OUTTAKE.OUTTAKE_WHEELS_ID);

	public Outtake() {
		shootMotor.configFactoryDefault();
		shootMotor.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative);

	}

	public void shoot(double rpm) {
		shootMotor.set(ControlMode.PercentOutput, rpm);
	}

	public void spinStop() {
		shootMotor.stopMotor();
	}

	public double getEncoder() {
		System.out.println("Outtake Encoder: " + shootMotor.getSelectedSensorVelocity());
		return shootMotor.getSelectedSensorVelocity();
	}

}