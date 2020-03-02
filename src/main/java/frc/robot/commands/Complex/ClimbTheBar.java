/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.Complex;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.Climb.GoToBottom;
import frc.robot.commands.Climb.SetHeight;
import frc.robot.subsystems.Climb;

public class ClimbTheBar extends SequentialCommandGroup {


	public ClimbTheBar(Climb climb) {
		addCommands (
				new SetHeight(climb, 8.5),
				new GoToBottom(climb)
		);

	}


}

