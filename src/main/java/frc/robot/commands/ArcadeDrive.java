package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;

import java.util.function.DoubleSupplier;

public class ArcadeDrive extends CommandBase {
    private final DriveTrain m_driveTrain;
    private final DoubleSupplier m_speed;
    private final DoubleSupplier m_turn;
    public ArcadeDrive(DriveTrain arcadeDrive, DoubleSupplier speed, DoubleSupplier turn){
        m_driveTrain = arcadeDrive;
        m_speed = speed;
        m_turn = turn;
        addRequirements(arcadeDrive);
    }


    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        m_driveTrain.driveTank(m_speed.getAsDouble(),m_turn.getAsDouble());
    }

	// Called once the command ends or is interrupted.
	@Override
	public void end(boolean interrupted) {
		m_driveTrain.driveTank(0, 0);
	}

	// Returns true when the command should end.
	@Override
	public boolean isFinished() {
		return false;
	}
}
