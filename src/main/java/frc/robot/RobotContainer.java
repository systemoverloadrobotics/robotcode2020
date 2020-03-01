/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.*;
import frc.robot.subsystems.*;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants.Controls;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

import java.util.function.DoubleSupplier;

public class RobotContainer {

  // The robot's subsystems and commands are defined here...
  private final DriveTrain m_driveTrain = new DriveTrain();
  private final Intake m_intake = new Intake();
  private final Storage m_storage = new Storage();
  private final Climb m_climb = new Climb();
  private final Autonomous autonomous = new Autonomous();
    private final Outtake m_outtake = new Outtake();

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
    private final Park m_park = new Park(100 /** any distance you want*/,m_driveTrain);
    private final Fire m_fire = new Fire(m_outtake, 5000); //TODO: After the first argument a second may follow, this will be some sort of number, you can put any number in for now
    private final GoToBottom m_goToBottom = new GoToBottom(m_climb); //TODO: The first argument will always be the subsystem
    private final IntakeBall m_intakeBall = new IntakeBall(m_intake);
    private final MoveBackToPos1 m_moveBackToPos1 = new MoveBackToPos1(m_storage);
    private final MoveIntoShooter m_moveIntoShooter = new MoveIntoShooter(m_storage);
    private final MoveOffPos1 m_moveOffPos1 = new MoveOffPos1(m_storage);
    private final MoveToChamber m_moveToChamber = new MoveToChamber(m_storage);
    private final SeizeFire m_seizeFire = new SeizeFire(m_outtake);
    private final SetHeight m_setHeight = new SetHeight(m_climb, 10); //TODO: change height to appropriate value
    private final StopOuttake m_stopOuttake = new StopOuttake(m_outtake);
    private final StorageFromIntake m_storageFromIntake = new StorageFromIntake(m_storage);



    /**
   * The container for the robot.  Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    //setting default commands
      m_driveTrain.setDefaultCommand(m_tankDrive);
    //Configure the button bindings
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings.  Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    final JoystickButton shift = new JoystickButton(right_joystick,Controls.BUTTON_2);
    shift.whenHeld(m_shiftUp);
    shift.whenReleased(m_shiftDown);
    final JoystickButton park = new JoystickButton(right_joystick,Controls.BUTTON_3);
    park.whenHeld(m_park);
    final JoystickButton compressorOn = new JoystickButton(right_joystick, Controls.BUTTON_11);
    compressorOn.whenHeld(m_runCompressor);
    final JoystickButton fire = new JoystickButton(right_joystick, Controls.TRIGGER); //TODO: Name the button after the command excluding the m_
      fire.whenPressed(m_fire);
  }


  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return null;
  }
}
