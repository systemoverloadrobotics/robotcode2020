package frc.robot.commands;

import frc.robot.Constants.OuttakeConstants;
import frc.robot.subsystems.Outtake;

public class SeizeFire extends CommandBase {

    private Outtake motor;

    public init(){

        motor.spinStop();

    }
    public boolean isFinished(){

        return true;

    }
}