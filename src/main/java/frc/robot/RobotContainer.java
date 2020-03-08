/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj2.command.ConditionalCommand;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.CONSTANTS.CONTROLS;
import frc.robot.commands.Climb.*;
import frc.robot.commands.Complex.*;
import frc.robot.commands.DriveTrain.*;
import frc.robot.commands.Intake.*;
import frc.robot.commands.Outtake.*;
import frc.robot.commands.Storage.*;
import frc.robot.subsystems.*;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;


public class RobotContainer {

	// Controllers
	private final Joystick right_joystick = new Joystick(CONTROLS.RIGHT_JOYSTICK_PORT);
	private final Joystick left_joystick = new Joystick(CONTROLS.LEFT_JOYSTICK_PORT);
	private final Joystick arcade_joystick = new Joystick(CONTROLS.ARCADE_JOYSTICK_PORT);

	// Subsystems
	private final Climb m_climb = new Climb();
	private final Intake m_intake = new Intake();
	private final Outtake m_outtake = new Outtake();
	private final Storage m_storage = new Storage();
	private final CompressorSubsystem m_compressorSub = new CompressorSubsystem();
	private final DriveTrain m_driveTrain = new DriveTrain(
			() -> left_joystick.getRawButtonPressed(CONTROLS.TRIGGER)
	);

	// Compressor


	// Commands
	private final TankDrive m_tankDrive = new TankDrive(m_driveTrain,
			() -> left_joystick.getY(),
			() -> right_joystick.getY(),
			() -> right_joystick.getRawButtonPressed(CONTROLS.TRIGGER));
	private final StorageBallChecker m_storageBallChecker = new StorageBallChecker(m_storage);
	private final Fire m_fire = new Fire(m_outtake,
			() -> arcade_joystick.getRawButtonPressed(1),
			() -> arcade_joystick.getRawButtonPressed(2),
			() -> arcade_joystick.getRawButtonPressed(3),
			() -> arcade_joystick.getRawButtonPressed(4));
	private final SeizeFire m_seizeFire = new SeizeFire(m_outtake);
	private final MoveIntoShooter m_moveIntoShooter = new MoveIntoShooter(m_storage);
	private final ExtendIntake m_extendIntake = new ExtendIntake(m_intake);
	private final RetractIntake m_retractIntake = new RetractIntake(m_intake);

	public RobotContainer() {
		//Default Commands
		m_driveTrain.setDefaultCommand(m_tankDrive);
		m_outtake.setDefaultCommand(m_fire);
		//m_storage.setDefaultCommand(m_storageBallChecker);


		//Configure the button bindings
		configureButtonBindings();
	}

	private void configureButtonBindings() {

		// Right Joystick
		final JoystickButton compressorOn = new JoystickButton(left_joystick, CONTROLS.BUTTON_9);

		// Left Joystick
        final JoystickButton shoot = new JoystickButton(left_joystick, CONTROLS.TRIGGER);
//        final JoystickButton eject = new JoystickButton(left_joystick, 12);

		// Arcade Joystick
        final JoystickButton intake = new JoystickButton(left_joystick, CONTROLS.BUTTON_8);

		shoot.whenHeld(m_fire.alongWith(new InstantCommand(m_storage::moveIn, m_storage))).whenReleased(m_seizeFire.alongWith(new InstantCommand(m_storage::moveStop)));

		// Button Actions
        intake.whenHeld(m_extendIntake.alongWith(m_storageBallChecker)).whenReleased(m_retractIntake.alongWith(new InstantCommand(m_storage::moveStop, m_storage)));
        compressorOn.whenPressed(new InstantCommand(m_compressorSub::startCompressor)).whenReleased(new InstantCommand(m_compressorSub::stopCompressor));
//		eject.whenPressed(new InstantCommand(m_storage::moveOut).alongWith(new ConditionalCommand(m_extendIntake, null, m_storage::getPos0)));
	}

//	public Command getAutonomousCommand() {
//		return ...;
//	}
}
