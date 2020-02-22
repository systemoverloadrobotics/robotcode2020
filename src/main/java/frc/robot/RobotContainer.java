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
import edu.wpi.first.wpilibj.Joystick;
import frc.robot.Constants.*;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj.Compressor;

/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {

  // The robot's subsystems and commands are defined here...
  private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();
  private final DriveTrain m_driveTrain = new DriveTrain();
  private final Intake m_intake = new Intake();
  private final Storage m_storage = new Storage();
  private final Climb m_climb = new Climb();
  private final Autonomous autonomous = new Autonomous();

  //controllers
  public static final Joystick m_joyStick = new Joystick(ButtonConstants.JOYSTICK_PORT);

  //commands
  private final Outtake m_outtake = new Outtake();
  private final Shoots10 m_shoots10 = new Shoots10(m_outtake);
  private final ArcadeDrive m_arcadeDrive = new ArcadeDrive(m_driveTrain);
  private final ShiftUp m_shiftUp = new ShiftUp();
  private final ShiftDown m_shiftDown = new ShiftDown();
  private final ExampleCommand m_autoCommand = new ExampleCommand(m_exampleSubsystem);
  private final OpenAndCloseDoor m_openAndCloseDoor = new OpenAndCloseDoor(m_storage);
  private final RunCompressor m_runCompressor = new RunCompressor(m_driveTrain);



  /**
   * The container for the robot.  Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    //setting default commands
      m_driveTrain.setDefaultCommand(m_arcadeDrive);

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
    final JoystickButton shift = new JoystickButton(m_joyStick,1);
    shift.whenHeld(m_shiftUp);
    shift.whenReleased(m_shiftDown);
    final JoystickButton compressorOn = new JoystickButton(m_joyStick, 11);
    compressorOn.whenHeld(m_runCompressor);
     final JoystickButton shoots10 = new JoystickButton(m_joyStick, ButtonConstants.SHOOT_BUTTON);
     shoots10.whenPressed(m_shoots10);

     final JoystickButton openAndCloseDoor = new JoystickButton(m_joyStick, ButtonConstants.OPEN_DOOR);
     openAndCloseDoor.whenPressed(m_openAndCloseDoor);
  }


  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return m_autoCommand;
  }
}
