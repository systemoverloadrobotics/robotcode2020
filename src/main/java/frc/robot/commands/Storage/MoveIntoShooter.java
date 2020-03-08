/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.Storage;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Storage;


public class MoveIntoShooter extends CommandBase {

	private final Storage m_storage;

	public MoveIntoShooter(Storage storage) {
		m_storage = storage;
		addRequirements(storage);
	}

	@Override
	public void execute() { //once
		m_storage.moveIn();
	}

	@Override
	public boolean isFinished() {
		return true;
	}
}
