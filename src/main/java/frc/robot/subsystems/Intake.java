package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import frc.robot.Constants.IntakeConstants;


public class Intake extends SubsystemBase {


    public static final WPI_VictorSPX intakeFlywheels = new WPI_VictorSPX(IntakeConstants.INTAKE_WHEELS_ID);

    public Intake(){
    }

    public void spinIn(){
        intakeFlywheels.set(ControlMode.PercentOutput, .2);
    }

    public void spinOut(){
        intakeFlywheels.set(ControlMode.PercentOutput, -.2);
    }

    public void stop(){
        intakeFlywheels.set(ControlMode.PercentOutput, 0);
    }

}