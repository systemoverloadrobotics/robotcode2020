package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;
import frc.robot.subsystems.DriveTrain;
public class ArcadeDrive extends CommandBase {

    private final DriveTrain m_driveTrain;
    private final boolean m_shiftButton;
    public ArcadeDrive(DriveTrain arcadeDrive, boolean shiftButton){
        m_driveTrain = arcadeDrive;
        m_shiftButton = shiftButton;
        addRequirements(arcadeDrive);
    }


    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        double m_speed = Robot.m_joyStick.getRawAxis(0);
        double m_turn = Robot.m_joyStick.getRawAxis(1);
        m_driveTrain.drive(m_speed,m_turn);
        if(m_shiftButton){
            m_driveTrain.shiftUp();
        }
        else{
            m_driveTrain.shiftDown();
        }
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
