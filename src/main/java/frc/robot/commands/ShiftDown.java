package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;

public class ShiftDown extends CommandBase {
    private DriveTrain m_driveTrain;
    public ShiftDown(DriveTrain driveTrain){
        m_driveTrain = driveTrain;
    }
    @Override
    public void initialize(){
        m_driveTrain.shiftDown();
    }
    @Override
    public void end(boolean interrupted){}

    @Override
    public boolean isFinished() {
        return false;
    }
}
