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
		m_shoot = shoot;
		m_fullPower = fullPower;
		m_lowPower = lowPower;
		m_changePowerPlus = changePowerPlus;
		m_changePowerNegative = changePowerNegative;
		addRequirements(shoot);

		m_RPM = 0;
	}

	@Override
	public void execute(){
		System.out.println("running");
		if (m_fullPower.getAsBoolean()) {
			m_RPM = 1;
			m_shoot.shoot(m_RPM);
			System.out.println("running full power");
		} else if(m_lowPower.getAsBoolean()) {
			m_RPM = 0;
			m_shoot.shoot(m_RPM);
			System.out.println("running low power");
		} else if(m_changePowerPlus.getAsBoolean()) {
			if(m_RPM < 1) {
				m_RPM += 0.05;
				m_shoot.shoot(m_RPM);
				System.out.println("running one up power");
			}
		} else {
			if(m_RPM >= 0) {
				m_RPM += 0.05;
				m_shoot.shoot(m_RPM);
				System.out.println("running one down power");
			}
		}
	}

	@Override
	public void end(boolean interrupted){
		m_shoot.spinStop();
	}

	@Override
	public boolean isFinished() {
		return false;
	}
}
