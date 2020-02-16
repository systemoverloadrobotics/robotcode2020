package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;

public class ArcadeDrive extends CommandBase {

    private final DriveTrain m_driveTrain;
    private final boolean m_shiftbutton;
    public ArcadeDrive(DriveTrain arcadeDrive, boolean shiftButton){
        m_driveTrain = arcadeDrive;
        m_shiftbutton = shiftButton;
        addRequirements(arcadeDrive);
    }


    // Called every time the scheduler runs while the command is scheduled.
    public void execute(double m_speed, double m_turn) {
        m_driveTrain.drive(m_speed,m_turn);
//        if(m_shiftbutton){
//            m_driveTrain.shiftUp();
//        }
//        else{
//            m_driveTrain.shiftDown();
//        }
    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
        m_driveTrain.drive(0,0);
    }

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        return false;
    }
}
