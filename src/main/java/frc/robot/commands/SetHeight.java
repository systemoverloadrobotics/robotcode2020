/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Climb;
import frc.robot.subsystems.Outtake;

// WHAT ARE WE DOING

public class SetHeight extends CommandBase {


  private final Climb m_elevatorMotor;
  private final double m_height;

  public SetHeight(Climb elevatorMotor, double height) {
    m_elevatorMotor = elevatorMotor;
    m_height = height;
    addRequirements(elevatorMotor);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_elevatorMotor.reelOut();
    m_elevatorMotor.goUp();
  }

    @Override
    public void end ( boolean interrupted){
      m_elevatorMotor.liftStop();
      m_elevatorMotor.reelStop();
    }

    @Override
    public boolean isFinished () {
      return m_elevatorMotor.getEncoder() == m_height;
    }
  }

