/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Outtake;


public class SpeedChanger extends CommandBase {

  private final Outtake  m_outtake;
  //private final Outtake m_desiredSpeed;
  public SpeedChanger(Outtake outtake) {
    m_outtake = outtake;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(outtake);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() { //once
    m_outtake.shoot(10);
  }

  // Called every time the scheduler runs while the command is scheduled.
 // @Override
  public void shootSpeed(double joystickValue){

  }
  public void changeShootSpeed(double shootvalue){
  //take in speed from joystick, i think this is totally wrong IDK!

  }
  @Override
  public void execute() {
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_outtake.spinStop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return true;
  }
}