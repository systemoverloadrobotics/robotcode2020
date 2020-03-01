package frc.robot.commands.Outtake;

import frc.robot.subsystems.Outtake;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class SeizeFire extends CommandBase {

	private final Outtake m_outtake;

	public SeizeFire(Outtake shoot) {
		m_outtake = shoot;
		addRequirements(shoot);
	}

	@Override
	public void initialize() {
		m_outtake.spinStop();
	}

	@Override
	public boolean isFinished() {
		return true;
	}
}