/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.ConditionalCommand;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.StartEndCommand;
import frc.robot.CONSTANTS.CONTROLS.JOYSTICK;
import frc.robot.CONSTANTS.CONTROLS.ARCADE;
import frc.robot.commands.ComplexAuto;
import frc.robot.commands.DriveTrain.*;
import frc.robot.commands.Intake.*;
import frc.robot.commands.Outtake.*;
import frc.robot.commands.StorageBallChecker;
import frc.robot.subsystems.*;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;


public class RobotContainer {

    // Controllers
    private final Joystick joystick = new Joystick(JOYSTICK.PORT);
    private final Joystick arcade = new Joystick(ARCADE.PORT);

    // Subsystems
    private final Climb m_climb = new Climb();
    private final Intake m_intake = new Intake();
    private final Outtake m_outtake = new Outtake();
    private final Storage m_storage = new Storage();
    private final DriveTrain m_driveTrain = new DriveTrain();
    private final CompressorSubsystem m_compressorSub = new CompressorSubsystem();

    // Commands
    private final ArcadeDrive m_arcadeDrive = new ArcadeDrive(
            m_driveTrain,
            () -> joystick.getY(),
            () -> joystick.getX(),
            () -> joystick.getRawButtonPressed(JOYSTICK.TRIGGER), // TODO: WHY ARE WE GETTING 2 TRIGGERS FOR ONE ACTION??????
            () -> joystick.getRawButtonReleased(JOYSTICK.TRIGGER)
    );

    private final SetableFire m_setableFire = new SetableFire(
            m_outtake,
            () -> arcade.getRawButtonPressed(ARCADE.R1),
            () -> arcade.getRawButtonPressed(ARCADE.L1)
    );

    private final ThrottleSpeed m_throttleSpeed = new ThrottleSpeed(
            m_outtake,
            () -> joystick.getRawAxis(JOYSTICK.THROTTLE)
    );

    private final StorageBallChecker m_storageBallChecker = new StorageBallChecker(m_storage);
    private final SeizeFire m_seizeFire = new SeizeFire(m_outtake);
    private final ExtendIntake m_extendIntake = new ExtendIntake(m_intake);
    private final RetractIntake m_retractIntake = new RetractIntake(m_intake);
    //    private final Fire m_fire = new Fire(m_outtake, 1); // TODO: rpm should be adjustable
    private final EjectIntake m_ejectIntake = new EjectIntake(m_intake);
    private final AlignDrive m_alignDrive = new AlignDrive(m_driveTrain);
    private final MoveDistance m_moveDistance = new MoveDistance(m_driveTrain, 10);

    private final ComplexAuto m_complexAuto = new ComplexAuto(m_driveTrain, m_outtake, m_storage);

    // Inline Commands
    private final Command m_startCompressor = new InstantCommand(m_compressorSub::startCompressor, m_compressorSub); // TODO: CHECK IF ITS "InstantCommand ... InstantCommand" or "Command ... InstantCommand"
    private final InstantCommand m_stopCompressor = new InstantCommand(m_compressorSub::stopCompressor, m_compressorSub);

    private final InstantCommand m_storageIn = new InstantCommand(m_storage::moveIn, m_storage);
    private final InstantCommand m_storageOut = new InstantCommand(m_storage::moveOut, m_storage);
    private final InstantCommand m_storageStop = new InstantCommand(m_storage::moveStop, m_storage);

    private final InstantCommand m_climbUp = new InstantCommand(m_climb::goUp, m_climb);
    private final InstantCommand m_climbDown = new InstantCommand(m_climb::goDown, m_climb);
    private final InstantCommand m_climbStop = new InstantCommand(m_climb::liftStop, m_climb);

    private final ConditionalCommand m_intakeCheck = new ConditionalCommand( // TODO: Check if this works
            new InstantCommand(m_intake::spinStop, m_intake),
            m_extendIntake,
            m_storage::getPos0);

    private final Command m_basicDriveDistance = new StartEndCommand (  // TODO: Check if this works
            () -> m_driveTrain.driveArcade(.5, 0),
            () -> m_driveTrain.driveArcade(0, 0),
            m_driveTrain)
            .beforeStarting(m_driveTrain::shiftDown)
            .beforeStarting(m_driveTrain::resetEncoders)
            .withInterrupt(() -> m_driveTrain.getLeftEncoder() >= 10); // TODO: THIS WILL MOVE THE ROBOT 10 FORWARD

    public RobotContainer() {
        //Default Commands
        m_driveTrain.setDefaultCommand(m_arcadeDrive);

        //Configure the button bindings
        configureButtonBindings();
    }

    private void configureButtonBindings() {

        // --Driver--

        // Compressor
        new JoystickButton(joystick, JOYSTICK.SIDE.BUTTON_7)
                .whenHeld(m_startCompressor)
                .whenReleased(m_stopCompressor);

        // Intake
        new JoystickButton(joystick, JOYSTICK.SIDE.BUTTON_9) // TODO: Test new intake / storage method
                .whenHeld(m_intakeCheck.alongWith(m_storageBallChecker))
                .whenReleased(m_retractIntake.alongWith(m_storageStop));

        // Align
        new JoystickButton(joystick, JOYSTICK.SIDE.BUTTON_11) // TODO: TEST ALIGNMENT PID AND DO I NEED TO SET DRIVE TO 0 ONCE IM ALIGNED
                .whileHeld(m_alignDrive);

        // Eject
        new JoystickButton(joystick, JOYSTICK.SIDE.BUTTON_8)
                .whenHeld(m_ejectIntake.alongWith(m_storageOut))
                .whenReleased(m_retractIntake.alongWith(m_storageStop));


        // --Operator--

        // Climb Up
        new JoystickButton(arcade, ARCADE.A)
                .whenHeld(m_climbUp)
                .whenReleased(m_climbStop);

        // Climb Down
        new JoystickButton(arcade, ARCADE.B)
                .whenHeld(m_climbDown)
                .whenReleased(m_climbStop);

        // Shoot
        new JoystickButton(arcade, ARCADE.TOP_LEFT) // TODO: CHECK TO SEE IF VALUE FROM m_driveTrain IS CORRECTLY PASSED FIRE
                .whileHeld(new Fire(m_outtake, m_driveTrain::getLimelightArea).andThen(m_storageIn)) // TODO: CHECK THAT RPM HITS SET POINT(TARGET VELOCITY) BEFORE m_storageIn IS SCHEDULED
                .whenReleased(m_seizeFire.alongWith(m_storageStop));


        // --Test Auto Code From Button--

        // Basic Drive Distance
        new JoystickButton(joystick, 0) // TODO: ASSIGN BUTTON
                .whenPressed(m_basicDriveDistance);

        // PID Drive Distance
        new JoystickButton(joystick, 0) // TODO: ASSIGN BUTTON
                .whenPressed(m_moveDistance);

        // Complex Auto
        new JoystickButton(joystick, 0) // TODO: ASSIGN BUTTON
                .whenPressed(m_complexAuto);


        // --Defcon Buttons--

        // Raw Intake
        new JoystickButton(arcade, 0) // TODO: ASSIGN BUTTON
                .whenHeld(m_extendIntake)
                .whenReleased(m_retractIntake);

        // Raw Storage In
        new JoystickButton(arcade, 0) // TODO: ASSIGN BUTTON
                .whenHeld(m_storageIn)
                .whenReleased(m_storageStop);

        //Raw Storage Out
        new JoystickButton(arcade, 0) // TODO: ASSIGN BUTTON
                .whenHeld(m_storageOut)
                .whenReleased(m_storageStop);

        //Raw Fire at Max Power
        new JoystickButton(arcade, 0) // TODO: ASSIGN BUTTON
                .whenHeld(new InstantCommand(() -> m_outtake.shoot(0), m_outtake))
                .whenReleased(m_seizeFire);

        //Raw Fire Velocity Adjuster
        new JoystickButton(arcade, 0) // TODO: ASSIGN BUTTON
                .whenHeld(m_setableFire)
                .whenReleased(m_seizeFire);

        // Raw Joystick Shooter Throttle for Speed
        new JoystickButton(joystick, 0) // TODO: ASSIGN BUTTON
                .whenHeld(m_throttleSpeed)
                .whenReleased(m_seizeFire);
    }

	public Command getAutonomousCommand() { // TODO: CHECK TO SEE IF AUTO FIRES OF THIS COMMAND
		return m_complexAuto;
	}
}