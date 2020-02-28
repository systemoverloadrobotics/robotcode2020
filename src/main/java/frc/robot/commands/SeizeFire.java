package frc.robot.commands;

import frc.robot.Constants.OuttakeConstants;
import frc.robot.subsystems.Outtake;

private final Outtake m_outtake;

public class SeizeFire extends CommandBase {

    public void initialize{
        m_outtake.spinStop();
    }

    @Override
    public void isFinished(){
        return true;
    }
    @Override
}