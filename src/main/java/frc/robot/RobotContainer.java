/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import frc.robot.Constants.Controls;
import frc.robot.commands.*;
import frc.robot.subsystems.*;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

public class RobotContainer {
	// The robot's subsystems and commands are defined here...
	private final DriveTrain m_driveTrain = new DriveTrain();
	private final Climb m_climb = new Climb();
	private final Intake m_intake = new Intake();
	private final Outtake m_outtake = new Outtake();
	private final Storage m_storage = new Storage();

	//controllers
	private final Joystick right_joystick = new Joystick(Controls.RIGHT_JOYSTICK_PORT);
	private final Joystick left_joystick = new Joystick(Controls.LEFT_JOYSTICK_PORT);

	//commands
	//private final ArcadeDrive m_arcadeDrive = new ArcadeDrive(m_driveTrain, m_joystick.getY(), m_joystick.getX());
	private final Fire m_fire = new Fire(m_outtake, 5000); //TODO: After the first argument a second may follow, this will be some sort of number, you can put any number in for now
	private final GoToBottom m_goToBottom = new GoToBottom(m_climb); //TODO: The first argument will always be the subsystem
	private final IntakeBall m_intakeBall = new IntakeBall(m_intake);
	private final MoveBackToPos1 m_moveBackToPos1 = new MoveBackToPos1(m_storage);
	private final MoveOffPos1 m_moveOffPos1 = new MoveOffPos1(m_storage);
	private final MoveToChamber m_moveToChamber = new MoveToChamber(m_storage);
	private final SeizeFire m_seizeFire = new SeizeFire(m_outtake);
	private final SetHeight m_setHeight = new SetHeight(m_climb, 10); //TODO: change height to appropriate value
	private final StopOuttake m_stopOuttake = new StopOuttake(m_outtake);
	private final StorageFromIntake m_storageFromIntake = new StorageFromIntake(m_storage);


	public RobotContainer() {
		//setting default commands
		//m_driveTrain.setDefaultCommand(m_arcadeDrive);

		final JoystickButton fire = new JoystickButton(right_joystick, Controls.TRIGGER); //TODO: Name the button after the command excluding the m_
		fire.whenPressed(m_fire);
	}
}
