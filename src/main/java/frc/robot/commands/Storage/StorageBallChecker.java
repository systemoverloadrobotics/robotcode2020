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

    public StorageBallChecker(Storage ballStorage) {
        store = ballStorage;
        // Use addRequirements() here to declare subsystem dependencies.
        addRequirements(ballStorage);
    }

    @Override
    public void execute() {
        if (store.getPos5() || (store.getPos1() && !store.getPos0())) {
            System.out.println("STOP" + store.getPos0() + " | " + store.getPos1() + " | " + store.getPos5());
            store.moveStop();
        } else {
            System.out.println("IN" + store.getPos0() + " | " + store.getPos1() + " | " + store.getPos5());
            store.moveIn();
        }

//            if (!store.getPos5()) {
//                if (store.getPos0()) {
//                    store.moveIn();
//                } else if (store.getPos1() && store.getPos0()) {
//                    store.moveIn();
//                } else if (store.getPos1() && !store.getPos0()) {
//                    store.moveStop();
//                } else {
//                    store.moveStop();
//                }
//            } else {
//                store.moveStop();
//            }
        }

//    @Override
//    public boolean isFinished() {
//        return true;
//    }
}