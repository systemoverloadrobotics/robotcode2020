package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.InvertType;
import frc.robot.Constants;
import frc.robot.Constants.IntakeConstants;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import com.ctre.phoenix.motorcontrol.ControlMode;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DigitalInput;

public class Intake extends SubsystemBase {

	public DoubleSolenoid arms = new DoubleSolenoid(Constants.PCM_ID, IntakeConstants.FORWARD_CHANNEL, IntakeConstants.REVERSE_CHANNEL);
	public WPI_VictorSPX master = new WPI_VictorSPX(IntakeConstants.MASTER_ID);
	public WPI_VictorSPX follower = new WPI_VictorSPX(IntakeConstants.FOLLOWER_ID);
	public DigitalInput input = new DigitalInput(IntakeConstants.INPUT_DIO_PORT_ID);

	public Intake() {
		master.configFactoryDefault();
		follower.configFactoryDefault();
		follower.follow(master);
		follower.setInverted(InvertType.OpposeMaster);
	}

	public void extend() {
		arms.set(DoubleSolenoid.Value.kForward);
	}

	public void retract() {
		arms.set(DoubleSolenoid.Value.kReverse);
	}

	public boolean getPos0() {
		System.out.println("Position 0: " + input.get());
		return input.get();
	}

	public void spinIn() {
		master.set(ControlMode.PercentOutput, IntakeConstants.INWARD);
	}

	public void spinOut() {
		master.set(ControlMode.PercentOutput, IntakeConstants.OUTWARD);
	}

	public void spinStop() {
		master.stopMotor();
	}

}