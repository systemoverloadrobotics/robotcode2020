
/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
/*
package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.WaitCommand;

import frc.robot.subsystems.IntakeSubsystem;

import frc.robot.Constants.IntakeBall;

public class Intake extends WaitCommand {
    private final IntakeSubsystem m_intakeSubsystem;

    public Intake(IntakeSubsystem intakeSubsystem) {
        super(IntakeBall.RUN_TIME_SECONDS);
        m_intakeSubsystem = intakeSubsystem;
        addRequirements(intakeSubsystem);
    }

    @Override
    public void initialize() {
        m_intakeSubsystem.spinIn();
        super.initialize();
    }

    @Override
    public boolean isFinished() {
        return true;
    }

    @Override
    public void end(boolean interrupted) {
        m_intakeSubsystem.spinStop();
    }
}
*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.subsystems.Storage;
import frc.robot.Constants.StorageConstants;

public class OpenAndCloseDoor extends WaitCommand {

    private Storage m_storage;
    public OpenAndCloseDoor(Storage storage){
        super(StorageConstants.SUPER_SOLENOID_TIME);
        m_storage = new Storage();
        addRequirements(storage);
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize(){
        m_storage.openDoubleSolenoid();
    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
        m_storage.closeDoubleSolenoid();
    }

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        return false;
    }
}
