package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;

public class ArcadeDrive extends CommandBase {

    private final DriveTrain m_driveTrain;

    public ArcadeDrive(DriveTrain arcadeDrive){
        m_driveTrain = arcadeDrive;

        addRequirements(arcadeDrive);
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() { //once

    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {

    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {

    }

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        return true;
    }
}
