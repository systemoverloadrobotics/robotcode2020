/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Storage;


public class IntakeBall extends CommandBase {

  private final Intake in;

  public IntakeBall(Intake intakeWheels) {
    in = intakeWheels;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(intakeWheels);
  }

  // Called when the command is initially scheduled.
  public void initialize() { //once
    in.spinIn();
    in.extend();
  }

  // Called every time the scheduler runs while the command is scheduled.
  public void execute() {

  }

  // Called once the command ends or is interrupted.
  public void end(boolean interrupted) {
    in.retract();
    in.stop();
  }

  // Returns true when the command should end.
  public boolean isFinished() {
    return in.getPosition();
  }
}
