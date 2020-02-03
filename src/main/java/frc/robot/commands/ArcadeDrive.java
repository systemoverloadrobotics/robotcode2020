package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;
import frc.robot.Constants.DriveConstants;

public class ArcadeDrive extends CommandBase {

    private final DriveTrain m_driveTrain;
    private final Joystick m_flightStick;
    public ArcadeDrive(DriveTrain arcadeDrive, Joystick flightStick){
        m_driveTrain = arcadeDrive;
        m_flightStick = flightStick;
        addRequirements(arcadeDrive);
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() { //once

    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        m_driveTrain.move(m_flightStick.getY()*DriveConstants.SPEED_MILTIPLIER, m_flightStick.getX()*DriveConstants.TURN_MUlTIPLIER);
    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
        m_driveTrain.move(0,0);
    }

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        return false;
    }
}
