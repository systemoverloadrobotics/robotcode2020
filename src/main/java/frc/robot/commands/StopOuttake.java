/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Outtake;


public class StopOuttake extends CommandBase {

	private final Outtake m_shoot;

	//private final Outtake m_desiredSpeed;
	public StopOuttake(Outtake shoot) {
		m_shoot = shoot;
		addRequirements(shoot);
	}

	@Override
	public void initialize() { //once
		m_shoot.spinStop();
	}

	@Override
	public boolean isFinished() {
		return true;
	}
}
