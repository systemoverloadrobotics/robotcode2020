package frc.robot.commands;

import frc.robot.subsystems.Outtake;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class SeizeFire extends CommandBase {

    private final Outtake m_outtake;

    public SeizeFire(Outtake shoot) {
        m_outtake = shoot;
        addRequirements(shoot);
    }

    @Override
    public void initialize{
        m_outtake.spinStop(0);
    }

    @Override
    public void execute() {
    }

    @Override
    public void end(boolean interrupted) {
        m_shoot.stopShoot();
    }

    @Override
    public boolean isFinished(){
        return true;
    }

}