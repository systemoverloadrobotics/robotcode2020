package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;

public class ArcadeDrive extends CommandBase {

	private final DriveTrain m_driveTrain;
	private final double m_speed;
	private final double m_turn;

	public ArcadeDrive(DriveTrain arcadeDrive, double speed, double turn) {
		m_driveTrain = arcadeDrive;
		m_speed = speed;
		m_turn = turn;
		addRequirements(arcadeDrive);
	}

	// Called every time the scheduler runs while the command is scheduled.
	@Override
	public void execute() {
		m_driveTrain.drive(m_speed, m_turn);
	}

	// Called once the command ends or is interrupted.
	@Override
	public void end(boolean interrupted) {
		m_driveTrain.drive(0, 0);
	}

	// Returns true when the command should end.
	@Override
	public boolean isFinished() {
		return false;
	}
}
