/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.Intake;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Intake;


public class RetractIntake extends CommandBase {

	private final Intake m_intake;

	public RetractIntake(Intake intakeWheels) {
		m_intake = intakeWheels;
		addRequirements(intakeWheels);
	}

	public void initialize() {
		m_intake.retract();
		m_intake.spinStop();
	}



	public boolean isFinished() {
		return true;
	}
}
