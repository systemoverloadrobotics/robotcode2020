/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.Outtake;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Outtake;

import java.util.function.DoubleSupplier;

public class Fire extends CommandBase {

    private final Outtake m_outtake;

    DoubleSupplier m_distance;
    double velocity;

    public Fire(Outtake outtake, DoubleSupplier distance) { // TODO: CHECK THE DoubleSupplier IS CORRECT
        m_outtake = outtake;
        m_distance = distance;
        addRequirements(outtake);
    }

    @Override
    public void initialize() {
        velocity = m_distance.getAsDouble(); // TODO: MATH FOR DISTANCE IN X UNIT TO VELOCITY
        m_outtake.shoot(velocity);
    }

    @Override
    public boolean isFinished() {
        return m_outtake.getEncoder() == velocity;
    }
}