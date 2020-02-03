package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;
import frc.robot.Constants.DriveConstants;

public class ArcadeDrive extends CommandBase {

    private final DriveTrain m_driveTrain;
    private final double speed;
    private final double turn;
    public ArcadeDrive(DriveTrain arcadeDrive, double Speed, double Turn){
        m_driveTrain = arcadeDrive;
        speed = Speed;
        turn = Turn;
        addRequirements(arcadeDrive);
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        m_driveTrain.drive(speed,turn);
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
