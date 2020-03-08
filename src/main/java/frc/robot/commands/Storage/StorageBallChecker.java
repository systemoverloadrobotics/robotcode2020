/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.Storage;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Storage;

import java.util.function.BooleanSupplier;


public class StorageBallChecker extends CommandBase {

    private final Storage store;
    private final BooleanSupplier m_reverse;

    public StorageBallChecker(Storage ballStorage, BooleanSupplier reverse) {
        store = ballStorage;
        m_reverse = reverse;
        // Use addRequirements() here to declare subsystem dependencies.
        addRequirements(ballStorage);
    }

    // Called when the command is initially scheduled.
    public void initialize() { //once

    }

    // Called every time the scheduler runs while the command is scheduled.
    public void execute() {
    /*if(store.getPos0()) {
        store.moveIn();
    }

     */
        if (m_reverse.getAsBoolean()) {
            store.moveOut();
        } else if (!m_reverse.getAsBoolean()) {
            if (!store.getPos5()) {
                if (store.getPos0()) {
                    store.moveIn();
                } else if (store.getPos1() && store.getPos0()) {
                    store.moveIn();
                } else if (store.getPos1() && !store.getPos0()) {
                    store.moveStop();
                }
            else{
                store.moveStop();
                }
            }
        } else {
            store.moveStop();
        }

    }

    // Called once the command ends or is interrupted.
    public void end(boolean interrupted) {
        //store.moveStop();
    }

    // Returns true when the command should end.
    public boolean isFinished() {
        return false;
    }
}
