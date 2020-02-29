/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Storage;


public class MoveBackToPos1 extends CommandBase {

  private final Storage store;

  public MoveBackToPos1(Storage ballStorage) {
    store = ballStorage;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(ballStorage);
  }

  // Called when the command is initially scheduled.
  public void initialize() { //once
    store.moveOut();
  }

  // Called every time the scheduler runs while the command is scheduled.
  public void execute() {

  }

  // Called once the command ends or is interrupted.
  public void end(boolean interrupted) {
    store.moveStop();
  }

  // Returns true when the command should end.
  public boolean isFinished() {
    return store.getPos1();
  }
}
