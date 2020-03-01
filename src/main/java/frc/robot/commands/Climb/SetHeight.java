/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.Climb;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Climb;
import frc.robot.subsystems.Outtake;

public class SetHeight extends CommandBase {


	private final Climb m_climb;
	private final double m_height;

	public SetHeight(Climb climb, double height) {
		m_climb = climb;
		m_height = height;
		addRequirements(climb);
	}

	@Override
	public void initialize() {
		m_climb.reelOut();
		m_climb.goUp();
	}

	@Override
	public void end(boolean interrupted) {
		m_climb.liftStop();
		m_climb.reelStop();
	}

	@Override
	public boolean isFinished() {
		return m_climb.getEncoder() == m_height;
	}
}

