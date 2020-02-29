/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Climb;

public class GoToBottom extends CommandBase {


	private final Climb m_elevatorMotor;

	public GoToBottom(Climb elevatorMotor) {
		m_elevatorMotor = elevatorMotor;
		addRequirements(elevatorMotor);
	}

	@Override
	public void initialize() {
		m_elevatorMotor.reelIn();
		m_elevatorMotor.goDown();
	}

	@Override
	public void end(boolean interrupted) {
		m_elevatorMotor.liftStop();
		m_elevatorMotor.reelStop();
	}

	@Override
	public boolean isFinished() {
		return m_elevatorMotor.getEncoder() == 0;
	}
}
