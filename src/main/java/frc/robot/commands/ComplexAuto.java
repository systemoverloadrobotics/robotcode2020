/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.DriveTrain.AlignDrive;
import frc.robot.commands.DriveTrain.MoveDistance;
import frc.robot.commands.Outtake.Fire;
import frc.robot.commands.Outtake.SeizeFire;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Outtake;
import frc.robot.subsystems.Storage;

public class ComplexAuto extends SequentialCommandGroup { // TODO: MOVES X DISTANCE, ALIGNS, THEN RUNS FIRE UNTIL TARGET VELOCITY IS HIT, ONCE TRUE RUN STORAGE FOR 10 SECONDS THEN STOP BOTH OUTTAKE AND STORAGE


    public ComplexAuto(DriveTrain driveTrain, Outtake outtake, Storage storage) {
        addCommands(
                new MoveDistance(driveTrain, 10),
                new AlignDrive(driveTrain),
                new Fire(outtake, driveTrain::getLimelightArea),
                new InstantCommand(storage::moveIn, storage).withTimeout(10)
                        .andThen(new InstantCommand(storage::moveIn, storage)
                                .alongWith(new SeizeFire(outtake)))
        );

    }


}

