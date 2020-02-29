package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;

public class Park extends CommandBase {
    private DriveTrain m_driveTrain;
    public Park(DriveTrain driveTrain){
        m_driveTrain = driveTrain;
        addRequirements(m_driveTrain);
    }
    private PracticePID pid = new PracticePID(100,m_driveTrain);
    @Override
    public void initialize(){

    }
    @Override
    public void execute(){
        pid.schedule();
    }
    @Override
    public void end(boolean interrupted){}

    @Override
    public boolean isFinished() {
        return false;
    }
}
