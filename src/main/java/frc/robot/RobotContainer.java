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
	private final Joystick m_joystick = new Joystick(CONTROLS.JOYSTICK_PORT);
	private final Joystick arcade_joystick = new Joystick(CONTROLS.ARCADE_JOYSTICK_PORT);

	// Subsystems
	private final Climb m_climb = new Climb();
	private final Intake m_intake = new Intake();
	private final Outtake m_outtake = new Outtake();
	private final Storage m_storage = new Storage();
	private final CompressorSubsystem m_compressorSub = new CompressorSubsystem();
	private final DriveTrain m_driveTrain = new DriveTrain(
			() -> arcade_joystick.getRawButtonPressed(CONTROLS.JOYSTICK.TRIGGER)
	);

	// Compressor


	// Commands
	private final TankDrive m_tankDrive = new TankDrive(m_driveTrain,
			() -> m_joystick.getY(),
			() -> m_joystick.getY(),
			() -> m_joystick.getRawButtonPressed(CONTROLS.JOYSTICK.TRIGGER),
			() -> m_joystick.getRawButtonReleased(CONTROLS.JOYSTICK.TRIGGER));
	private final ArcadeDrive m_arcadeDrive = new ArcadeDrive(m_driveTrain,
			() -> m_joystick.getY(),
			() -> m_joystick.getX(),
			() -> m_joystick.getRawButtonPressed(CONTROLS.JOYSTICK.TRIGGER),
			() -> m_joystick.getRawButtonReleased(CONTROLS.JOYSTICK.TRIGGER));
	private final StorageBallChecker m_storageBallChecker = new StorageBallChecker(m_storage);
	private final Fire m_fire = new Fire(m_outtake,
			() -> arcade_joystick.getRawButtonPressed(3),
			() -> arcade_joystick.getRawButtonPressed(4),
			() -> arcade_joystick.getRawButtonPressed(5),
			() -> arcade_joystick.getRawButtonPressed(6),
			0);
	private final SeizeFire m_seizeFire = new SeizeFire(m_outtake);
	private final MoveIntoShooter m_moveIntoShooter = new MoveIntoShooter(m_storage);
	private final ExtendIntake m_extendIntake = new ExtendIntake(m_intake);
	private final RetractIntake m_retractIntake = new RetractIntake(m_intake);

	public RobotContainer() {
		//Default Commands
		m_driveTrain.setDefaultCommand(m_arcadeDrive);
		//m_outtake.setDefaultCommand(m_fire);
		//m_storage.setDefaultCommand(m_storageBallChecker);


		//Configure the button bindings
		configureButtonBindings();
	}

	private void configureButtonBindings() {

		final JoystickButton climbUp = new JoystickButton(m_joystick, CONTROLS.JOYSTICK.SIDE.BUTTON_12);
		final JoystickButton climbDown = new JoystickButton(m_joystick, CONTROLS.JOYSTICK.SIDE.BUTTON_11);
		final JoystickButton compressorOn = new JoystickButton(m_joystick, CONTROLS.JOYSTICK.SIDE.BUTTON_9);

		// Left Joystick
//        final JoystickButton eject = new JoystickButton(left_joystick, 12);

		// Arcade Joystick
		final JoystickButton moveBeltForward = new JoystickButton(arcade_joystick, CONTROLS.ARCADE.X);
		final JoystickButton moveBeltBackward = new JoystickButton(arcade_joystick, CONTROLS.ARCADE.A);
        final JoystickButton intake = new JoystickButton(arcade_joystick, CONTROLS.JOYSTICK.SIDE.BUTTON_8);
		final JoystickButton shoot = new JoystickButton(arcade_joystick, CONTROLS.ARCADE.Y);

//        JoystickButton button3 = new JoystickButton(arcade_joystick, 3);
//		JoystickButton button4 = new JoystickButton(arcade_joystick, 4);
//		JoystickButton button5 = new JoystickButton(arcade_joystick, 5);
//		JoystickButton button6 = new JoystickButton(arcade_joystick, 6);
//		JoystickButton button1 = new JoystickButton(arcade_joystick, 1);

		shoot.whenHeld(m_fire);
		moveBeltForward.whenHeld(new InstantCommand(m_storage::moveIn, m_storage)).whenReleased(new InstantCommand(m_storage::moveStop));
		moveBeltBackward.whenHeld(new InstantCommand(m_storage::moveOut, m_storage)).whenReleased(new InstantCommand(m_storage::moveStop));


		//shoot.whenHeld(m_fire.alongWith(new InstantCommand(m_storage::moveIn, m_storage))).whenReleased(m_seizeFire.alongWith(new InstantCommand(m_storage::moveStop)));


		// Button Actions
		shoot.whenHeld(m_fire.alongWith(new InstantCommand(m_storage::moveIn, m_storage))).whenReleased(m_seizeFire.alongWith(new InstantCommand(m_storage::moveStop)));
        intake.whenHeld(m_extendIntake.alongWith(m_storageBallChecker)).whenReleased(m_retractIntake.alongWith(new InstantCommand(m_storage::moveStop, m_storage)));
        compressorOn.whenPressed(new InstantCommand(m_compressorSub::startCompressor)).whenReleased(new InstantCommand(m_compressorSub::stopCompressor));
		climbUp.whenHeld(new InstantCommand(m_climb::goUp, m_climb)).whenReleased(new InstantCommand(m_climb::liftStop, m_climb));
		climbDown.whenHeld(new InstantCommand(m_climb::goDown, m_climb)).whenReleased(new InstantCommand(m_climb::liftStop, m_climb));
//		eject.whenPressed(new InstantCommand(m_storage::moveOut).alongWith(new ConditionalCommand(m_extendIntake, null, m_storage::getPos0)));
	}

//	public Command getAutonomousCommand() {
//		return ...;
//	}
}
