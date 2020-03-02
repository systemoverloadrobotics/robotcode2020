package frc.robot.commands.DriveTrain;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.DriveTrain;

import java.util.function.DoubleSupplier;

public class TankDrive extends CommandBase {
	DriveTrain m_driveTrain;
	DoubleSupplier m_leftSpeed;
	DoubleSupplier m_rightSpeed;

	public TankDrive(DriveTrain driveTrain, DoubleSupplier leftSpeed, DoubleSupplier rightSpeed) {
		m_driveTrain = driveTrain;
		m_leftSpeed = leftSpeed;
		m_rightSpeed = rightSpeed;
		addRequirements(driveTrain);
	}

	@Override
	public void execute() {
		m_driveTrain.driveTank(m_leftSpeed.getAsDouble(), m_rightSpeed.getAsDouble());
	}

	@Override
	public void end(boolean interrupted) {
		m_driveTrain.driveTank(0, 0);
	}

	@Override
	public boolean isFinished() {
		return false;
	}
}