/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.Outtake;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Outtake;

import java.util.function.BooleanSupplier;
import java.util.function.DoubleSupplier;

public class SetableFire extends CommandBase {

    private final Outtake m_outtake;

    BooleanSupplier m_increase;
    BooleanSupplier m_decrease;
    double velocity = 5000; // TODO: SET TO BASE/MIDDLE VELOCITY

    public SetableFire(Outtake outtake, BooleanSupplier increase, BooleanSupplier decrease) {
        m_outtake = outtake;
        m_increase = increase;
        m_decrease = decrease;
        addRequirements(outtake);
    }

    @Override
    public void execute() {
        if (m_increase.getAsBoolean()) {
            velocity += 100;
        }
        if (m_decrease.getAsBoolean()) {
            velocity -= 100;
        }

        m_outtake.shoot(velocity);
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}