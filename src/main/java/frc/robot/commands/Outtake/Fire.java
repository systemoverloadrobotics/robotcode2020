/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.Outtake;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Outtake;


public class Fire extends CommandBase {

	private final Outtake m_shoot;
	private final double m_rpm;

	public Fire(Outtake shoot, double rpm) {
		m_shoot = shoot;
		m_rpm = rpm;
		addRequirements(shoot);
	}

	@Override
	public void initialize() {
		m_shoot.shoot(m_rpm);

	}

	@Override
	public void end(boolean interrupted) {
		m_shoot.spinStop();
	}

	@Override
	public boolean isFinished() {
		return m_shoot.getEncoder() == m_rpm;
	}
}
