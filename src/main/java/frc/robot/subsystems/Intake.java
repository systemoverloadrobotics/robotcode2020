package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import frc.robot.Constants.IntakeConstants;


public class Intake extends SubsystemBase {


    public static final WPI_VictorSPX intakeMotor = new WPI_VictorSPX(IntakeConstants.INTAKE_WHEELS_ID);

    public Intake(){
    }

    public void spinIn(){
        intakeMotor.set(ControlMode.PercentOutput, IntakeConstants.INTAKE_FLYWHEELS_FORWARD_POWER);
    }

    public void spinOut(){
        intakeMotor.set(ControlMode.PercentOutput, IntakeConstants.INTAKE_FLYWHEELS_REVERSE_POWER);
    }

    public void stop(){
        intakeMotor.set(ControlMode.PercentOutput, IntakeConstants.INTAKE_STOP);
    }

}