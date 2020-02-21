package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.ScheduleCommand;
import frc.robot.RobotContainer;
import frc.robot.subsystems.DriveTrain;
public class ArcadeDrive extends CommandBase {

    private final DriveTrain m_driveTrain;
    public ArcadeDrive(DriveTrain arcadeDrive){
        m_driveTrain = arcadeDrive;
        addRequirements(arcadeDrive);
    }


    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        double m_speed = RobotContainer.m_joyStick.getRawAxis(0);
        double m_turn = RobotContainer.m_joyStick.getRawAxis(1);
        m_driveTrain.drive(m_speed,m_turn);
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
