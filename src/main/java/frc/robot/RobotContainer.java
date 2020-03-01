/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import frc.robot.commands.Climb.GoToBottom;
import frc.robot.commands.Climb.SetHeight;
import frc.robot.commands.DriveTrain.*;
import frc.robot.commands.Intake.IntakeBall;
import frc.robot.commands.Outtake.Fire;
import frc.robot.commands.Outtake.SeizeFire;
import frc.robot.commands.Storage.*;
import frc.robot.subsystems.*;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants.Controls;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

public class RobotContainer {

	// The robot's subsystems and commands are defined here...
	private final Climb m_climb = new Climb();
	private final DriveTrain m_driveTrain = new DriveTrain();
	private final Intake m_intake = new Intake();
	private final Outtake m_outtake = new Outtake();
	private final Storage m_storage = new Storage();

	//controllers
	private final Joystick right_joystick = new Joystick(Controls.RIGHT_JOYSTICK_PORT);
	private final Joystick left_joystick = new Joystick(Controls.LEFT_JOYSTICK_PORT);


	//commands
	private final ArcadeDrive m_arcadeDrive = new ArcadeDrive(m_driveTrain,
			() -> left_joystick.getY(),
			() -> right_joystick.getY());

	private final TankDrive m_tankDrive = new TankDrive(m_driveTrain,
			() -> left_joystick.getY(),
			() -> right_joystick.getY());
	private final ShiftUp m_shiftUp = new ShiftUp(m_driveTrain);
	private final ShiftDown m_shiftDown = new ShiftDown(m_driveTrain);
	private final RunCompressor m_runCompressor = new RunCompressor(m_driveTrain);
	private final Park m_park = new Park(m_driveTrain, 100 /** any distance you want*/); //TODO: This should not be taking any input besides subsystem
	private final Fire m_fire = new Fire(m_outtake, 5000);
	private final GoToBottom m_goToBottom = new GoToBottom(m_climb);
	private final IntakeBall m_intakeBall = new IntakeBall(m_intake);
	private final MoveBackToPos1 m_moveBackToPos1 = new MoveBackToPos1(m_storage);
	private final MoveIntoShooter m_moveIntoShooter = new MoveIntoShooter(m_storage);
	private final MoveOffPos1 m_moveOffPos1 = new MoveOffPos1(m_storage);
	private final MoveToChamber m_moveToChamber = new MoveToChamber(m_storage);
	private final SeizeFire m_seizeFire = new SeizeFire(m_outtake);
	private final SetHeight m_setHeight = new SetHeight(m_climb, 10); //TODO: change height to appropriate value
	private final StorageFromIntake m_storageFromIntake = new StorageFromIntake(m_storage);

	public RobotContainer() {
		//setting default commands
		m_driveTrain.setDefaultCommand(m_tankDrive);
		//Configure the button bindings
		configureButtonBindings();
	}

	private void configureButtonBindings() {
		final JoystickButton shift = new JoystickButton(right_joystick, Controls.BUTTON_2);
		shift.whenHeld(m_shiftUp);
		shift.whenReleased(m_shiftDown);
		final JoystickButton park = new JoystickButton(right_joystick, Controls.BUTTON_3);
		park.whenHeld(m_park);
		final JoystickButton compressorOn = new JoystickButton(right_joystick, Controls.BUTTON_11);
		compressorOn.whenHeld(m_runCompressor);
		final JoystickButton fire = new JoystickButton(right_joystick, Controls.TRIGGER); //TODO: Name the button after the command excluding the m_
		fire.whenPressed(m_fire);
	}

	public Command getAutonomousCommand() {
		// An ExampleCommand will run in autonomous
		return null;
	}
}
