package frc.robot.subsystems;

import frc.robot.Constants.IntakeConstants;
import com.ctre.phoenix.motorcontrol.ControlMode;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import frc.robot.Constants.IntakeConstants;

public class Intake extends SubsystemBase {


    public static final WPI_VictorSPX intakeMotor = new WPI_VictorSPX(IntakeConstants.INTAKE_WHEELS_ID);
    public static final WPI_VictorSPX intakeBarMotor = new WPI_VictorSPX(IntakeConstants.INTAKE_BAR_MOTOR_ID);
    public DoubleSolenoid test = new DoubleSoleniod(IntakeConstants.PCM_ID, IntakeConstants.FORWARD_CHANNEL, IntakeConstants.REVERSE_CHANNEL);
    public IntakeMotor = new IntakeMotor(IntakeConstants.FIRST_MOTOR_CONTROLLER_ID, IntakeMotor.SECOND_MOTOR_CONTROLLER_ID, IntakeMotor.INWARD, IntakeMotor.OUTWARD, IntakeMotor.STOP);
    public DigitalInput input = new DigitalInput(0);


    public Intake(){
    }

    public void extend() {
        test.set(DoubleSolenoid.Value.kforward);
    }

    public void retract() {
        test.set(DoubleSolenoid.Value.kreverse);
    }

    public void getPosition() {
        input.get(DigitalInput);
    }

    public void spinIn(){
        test.set(IntakeMotor.Value.inward);
    }

    public void spinOut() {
        test.set(IntakeMotor.Value.outward);
    }

    public void stop(){
        test.set(IntakeMotor.Value.stop);
    }

}