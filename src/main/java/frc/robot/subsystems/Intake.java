package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.InvertType;
import frc.robot.CONSTANTS;
import frc.robot.CONSTANTS.INTAKE;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import com.ctre.phoenix.motorcontrol.ControlMode;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DigitalInput;

public class Intake extends SubsystemBase {

	public DoubleSolenoid arms = new DoubleSolenoid(CONSTANTS.PCM_ID, INTAKE.FORWARD_CHANNEL_ID, INTAKE.REVERSE_CHANNEL_ID);
	public WPI_VictorSPX master = new WPI_VictorSPX(INTAKE.INTAKE_ID);

	public Intake() {
		master.configFactoryDefault();
	}

	public void extend() {
		arms.set(DoubleSolenoid.Value.kForward);
	}

	public void retract() {
		arms.set(DoubleSolenoid.Value.kReverse);
	}

	/*public boolean getPos0() {
		System.out.println("Position 0: " + input.get());
		return input.get();
	}
*/
	public void spinIn() {
		master.set(ControlMode.PercentOutput, INTAKE.INWARD);
	}

	public void spinOut() {
		master.set(ControlMode.PercentOutput, INTAKE.OUTWARD);
	}

	public void spinStop() {
		master.stopMotor();
	}

}