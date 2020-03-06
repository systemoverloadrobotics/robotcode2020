/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import frc.robot.commands.Complex.ClimbTheBar;
import frc.robot.commands.Climb.GoToBottom;
import frc.robot.commands.Climb.SetHeight;
import frc.robot.commands.DriveTrain.*;
import frc.robot.commands.Intake.ExtendIntake;
import frc.robot.commands.Intake.IntakeBall;
import frc.robot.commands.Intake.RetractIntake;
import frc.robot.commands.Outtake.Fire;
import frc.robot.commands.Outtake.SeizeFire;
import frc.robot.commands.Storage.*;
import frc.robot.subsystems.*;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.CONSTANTS.CONTROLS;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

public class RobotContainer {

    // Controllers
    private final Joystick right_joystick = new Joystick(CONTROLS.RIGHT_JOYSTICK_PORT);
    private final Joystick left_joystick = new Joystick(CONTROLS.LEFT_JOYSTICK_PORT);

    // Subsystems
    private final Climb m_climb = new Climb();
    private final DriveTrain m_driveTrain = new DriveTrain();
    private final Intake m_intake = new Intake();
    private final Outtake m_outtake = new Outtake();
    private final Storage m_storage = new Storage();

    // Commands
    //	private final ArcadeDrive m_arcadeDrive = new ArcadeDrive(m_driveTrain,
    //			() -> left_joystick.getY(),
    //			() -> right_joystick.getY());
    private final TankDrive m_tankDrive = new TankDrive(m_driveTrain,
            () -> left_joystick.getY(),
            () -> right_joystick.getY(),
            () -> right_joystick.getRawButtonPressed(CONTROLS.TRIGGER));
    private final ShiftUp m_shiftUp = new ShiftUp(m_driveTrain);
    private final ShiftDown m_shiftDown = new ShiftDown(m_driveTrain);
    private final RunCompressor m_runCompressor = new RunCompressor(m_driveTrain);
    private final MoveDistance m_moveDistance = new MoveDistance(m_driveTrain, 10000);
    private final Park m_park = new Park(m_driveTrain, 0);
    private final Fire m_fire = new Fire(m_outtake, 5000);
    private final GoToBottom m_goToBottom = new GoToBottom(m_climb);
    private final IntakeBall m_intakeBall = new IntakeBall(m_intake);
    private final MoveBackToPos1 m_moveBackToPos1 = new MoveBackToPos1(m_storage);
    private final MoveIntoShooter m_moveIntoShooter = new MoveIntoShooter(m_storage);
    private final MoveOffPos1 m_moveOffPos1 = new MoveOffPos1(m_storage);
    private final MoveToChamber m_moveToChamber = new MoveToChamber(m_storage);
    private final SeizeFire m_seizeFire = new SeizeFire(m_outtake);
    private final SetHeight m_setHeight = new SetHeight(m_climb, 10);
    private final StorageFromIntake m_storageFromIntake = new StorageFromIntake(m_storage);
    private final ClimbTheBar m_climbTheBar = new ClimbTheBar(m_climb);
    private final ExtendIntake m_extendIntake = new ExtendIntake(m_intake);
    private final RetractIntake m_retractIntake = new RetractIntake(m_intake);
    private final StorageBallChecker m_storageBallChecker = new StorageBallChecker(m_storage);

    public RobotContainer() {
        //Default Commands
        m_driveTrain.setDefaultCommand(m_tankDrive);
        m_storage.setDefaultCommand(m_storageBallChecker);

        //Configure the button bindings
        configureButtonBindings();
    }

    private void configureButtonBindings() {

    	// Right Joystick
        final JoystickButton shift = new JoystickButton(right_joystick, CONTROLS.TRIGGER);
        final JoystickButton moveDistance = new JoystickButton(right_joystick, CONTROLS.BUTTON_4);
        final JoystickButton park = new JoystickButton(right_joystick, CONTROLS.BUTTON_3);
        final JoystickButton compressorOn = new JoystickButton(right_joystick, CONTROLS.BUTTON_11);
        final JoystickButton fire = new JoystickButton(right_joystick, CONTROLS.BUTTON_2);
        final JoystickButton climb = new JoystickButton(right_joystick, CONTROLS.BUTTON_12);
        final JoystickButton goToBottom = new JoystickButton(right_joystick, CONTROLS.BUTTON_10);
        final JoystickButton intakeBall = new JoystickButton(right_joystick, CONTROLS.BUTTON_9);

        // Left Joystick
        final JoystickButton moveBackToPos1 = new JoystickButton(left_joystick, CONTROLS.BUTTON_4);
        final JoystickButton moveIntoShooter = new JoystickButton(left_joystick, CONTROLS.BUTTON_3);
        final JoystickButton moveOffPos1 = new JoystickButton(left_joystick, CONTROLS.BUTTON_9);
        final JoystickButton moveToChamber = new JoystickButton(left_joystick, CONTROLS.BUTTON_10);
        final JoystickButton seizeFire = new JoystickButton(left_joystick, CONTROLS.BUTTON_11);
        final JoystickButton setHeight = new JoystickButton(left_joystick, CONTROLS.BUTTON_12);
        final JoystickButton storageFromIntake = new JoystickButton(left_joystick, CONTROLS.TRIGGER);
        final JoystickButton extendIntake = new JoystickButton(left_joystick, CONTROLS.BUTTON_2);
        final JoystickButton retractIntake = new JoystickButton(left_joystick, CONTROLS.BUTTON_2);


        extendIntake.whenHeld(m_extendIntake);
        retractIntake.whenReleased(m_retractIntake);
        shift.whenHeld(m_shiftUp);
        shift.whenReleased(m_shiftDown);
        moveDistance.whenPressed(m_moveDistance);
        park.whenHeld(m_park);
        compressorOn.whenHeld(m_runCompressor);
        fire.whenPressed(m_fire);
        climb.whenPressed(m_climbTheBar);
        goToBottom.whenPressed(m_goToBottom);
        intakeBall.whenPressed(m_intakeBall);
        moveBackToPos1.whenPressed(m_moveBackToPos1);
        moveIntoShooter.whenPressed(m_moveIntoShooter);
        moveOffPos1.whenPressed(m_moveOffPos1);
        moveToChamber.whenPressed(m_moveToChamber);
        seizeFire.whenHeld(m_seizeFire);
        setHeight.whenPressed(m_setHeight);
        storageFromIntake.whenHeld(m_storageFromIntake);
    }

//	public Command getAutonomousCommand() {
//		return ...;
//	}
}
