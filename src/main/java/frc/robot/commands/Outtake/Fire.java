/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.Outtake;

import com.ctre.phoenix.motorcontrol.ControlMode;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Outtake;
import java.util.function.BooleanSupplier;

public class Fire extends CommandBase {

	private final Outtake m_shoot;

	private BooleanSupplier m_fullPower;
	private BooleanSupplier m_lowPower;
	private BooleanSupplier m_changePowerPlus;
	private BooleanSupplier m_changePowerNegative;
	double m_RPM;

	public Fire(Outtake shoot, BooleanSupplier fullPower, BooleanSupplier lowPower, BooleanSupplier changePowerPlus, BooleanSupplier changePowerNegative, double RPM) {
		m_shoot = shoot.getAsBoolean();
		m_fullPower = fullPower.getAsBoolean();
		m_lowPower = lowPower.getAsBoolean();
		m_changePowerPlus = changePowerPlus.getAsBoolean();
		m_changePowerNegative = changePowerNegative.getAsBoolean();
		addRequirements(shoot);

		m_RPM = 0;
	}


	@Override
	public void execute(){
		if (m_fullPower) {
			m_RPM = 1;
			m_shoot.shoot(m_RPM);
		} else if(m_lowPower) {
			m_RPM = 0;
			m_shoot.shoot(m_RPM);
		} else if(m_changePowerPlus) {
			if(m_RPM < 1) {
				m_RPM += 0.05;
				m_shoot.shoot(m_RPM);
			}
		}
		else if(m_changePowerPlus) {
			if(m_RPM >= 0) {
				m_RPM += 0.05;
				m_shoot.shoot(m_RPM);
			}
		}
	}
	@Override
	public boolean isFinished() {
		return false;
	}
}
