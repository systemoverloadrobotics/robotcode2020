/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.Intake;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Intake;


public class EjectIntake extends CommandBase {

	private final Intake m_intake;

	public EjectIntake(Intake intake) {
		m_intake = intake;
		addRequirements(intake);
	}

	@Override
	public void initialize() {
		m_intake.extend();
		m_intake.spinOut();
	}

	@Override
	public boolean isFinished() {
		return true;
	}
}
