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

public class ThrottleSpeed extends CommandBase {

    private final Outtake m_outtake;

    DoubleSupplier m_percent;

    public ThrottleSpeed(Outtake outtake, DoubleSupplier percent) {
        m_outtake = outtake;
        m_percent = percent;
        addRequirements(outtake);
    }

    @Override
    public void execute() {
        double speed = (m_percent.getAsDouble() + 1) / 2; // TODO: MAKE SURE RANGE IS CONVERTED TO 0 - 1, MIGHT NEED TO INVERSE, CAN'T REMEMBER IF THROTTLE IS -1 to +1 or +1 to -1
        System.out.println("Throttle Speed" + speed);
        m_outtake.percentShoot(speed);
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}