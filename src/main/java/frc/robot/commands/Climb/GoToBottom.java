/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.Climb;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Climb;

public class GoToBottom extends CommandBase {


	private final Climb m_climb;

	public GoToBottom(Climb climb) {
		m_climb = climb;
		addRequirements(climb);
	}

	@Override
	public void initialize() {
		m_climb.reelIn();
		m_climb.goDown();
	}

	@Override
	public void end(boolean interrupted) {
		m_climb.liftStop();
		m_climb.reelStop();
	}

	@Override
	public boolean isFinished() {
		return m_climb.getEncoder() == 0;
	}
}

