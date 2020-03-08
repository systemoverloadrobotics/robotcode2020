/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

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
import edu.wpi.first.wpilibj.Compressor;

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
	private final DriveTrain m_driveTrain = new DriveTrain(
			() -> left_joystick.getRawButtonPressed(CONTROLS.TRIGGER)
	);

	// Compressor
	private Compressor m_compressor = new Compressor(CONSTANTS.PCM_ID);

	// Commands
	private final TankDrive m_tankDrive = new TankDrive(m_driveTrain,
			() -> left_joystick.getY(),
			() -> right_joystick.getY(),
			() -> right_joystick.getRawButtonPressed(CONTROLS.TRIGGER));
	private final StorageBallChecker m_storageBallChecker = new StorageBallChecker(m_storage, () -> left_joystick.getRawButton(8));
	private final Fire m_fire = new Fire(m_outtake, .5);
	private final SeizeFire m_seizeFire = new SeizeFire(m_outtake);
	private final MoveIntoShooter m_moveIntoShooter = new MoveIntoShooter(m_storage);

	public RobotContainer() {
		//Default Commands
		m_driveTrain.setDefaultCommand(m_tankDrive);
		m_storage.setDefaultCommand(m_storageBallChecker);


		//Configure the button bindings
		configureButtonBindings();
	}

	private void configureButtonBindings() {

		// Right Joystick
		final JoystickButton compressorOn = new JoystickButton(right_joystick, CONTROLS.BUTTON_11);

		// Left Joystick
        final JoystickButton shoot = new JoystickButton(left_joystick, CONTROLS.TRIGGER);

		// Arcade Joystick

		if (compressorOn.get()) {
			m_compressor.start();
		} else {
			m_compressor.stop();
		}

		shoot.whenHeld(m_fire.alongWith(m_moveIntoShooter)).whenReleased(m_seizeFire.alongWith(new InstantCommand(m_storage::moveStop)));
	}

//	public Command getAutonomousCommand() {
//		return ...;
//	}
}
