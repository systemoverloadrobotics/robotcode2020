package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;

public class Park extends CommandBase {
    public DriveTrain m_driveTrain;
    public Park(){
        m_driveTrain = new DriveTrain();
        addRequirements();
    }
    @Override
    public void initialize(){
        m_driveTrain.park();
    }
    @Override
    public void end(boolean interrupted){}

    @Override
    public boolean isFinished() {
        return false;
    }
}
