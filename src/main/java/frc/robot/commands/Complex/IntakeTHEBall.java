/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.Complex;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.Climb.GoToBottom;
import frc.robot.commands.Climb.SetHeight;
import frc.robot.commands.Intake.IntakeBall;
import frc.robot.commands.Storage.MoveOffPos1;
import frc.robot.commands.Storage.StorageFromIntake;
import frc.robot.subsystems.Climb;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Storage;

public class IntakeTHEBall extends SequentialCommandGroup {


	public IntakeTHEBall(Intake intakeWheels, Storage storage) {
		addCommands (
				new IntakeBall(intakeWheels),
				new StorageFromIntake(storage),
				new MoveOffPos1(storage)
		);

	}


}

