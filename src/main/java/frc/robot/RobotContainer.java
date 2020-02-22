/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.ArcadeDrive;
import frc.robot.commands.OpenAndCloseDoor;
import frc.robot.subsystems.*;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.commands.Shoots10;
import edu.wpi.first.wpilibj.Joystick;
import frc.robot.Constants.*;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
    // The robot's subsystems and commands are defined here...
    private final DriveTrain m_driveTrain = new DriveTrain();
    private final Intake m_intake = new Intake();
    private final Storage m_storage = new Storage();
    private final Climb m_climb = new Climb();


    //controllers
    private final Joystick m_joyStick = new Joystick(ButtonConstants.JOYSTICK_PORT);

    //commands
    private final Outtake m_outtake = new Outtake();
    private final Shoots10 m_shoots10 = new Shoots10(m_outtake);
    private final ArcadeDrive m_arcadeDrive = new ArcadeDrive(m_driveTrain, m_joyStick.getY(), m_joyStick.getX());
    private final Shoots10 changeSpeed = new Shoots10(m_outtake);
    private final OpenAndCloseDoor m_openAndCloseDoor = new OpenAndCloseDoor(m_storage);


    /**
     * The container for the robot.  Contains subsystems, OI devices, and commands.
     */
    public RobotContainer() {
        //setting default commands
        m_driveTrain.setDefaultCommand(m_arcadeDrive);

        // Configure the button bindings
        configureButtonBindings();
    }

    /**
     * Use this method to define your button->command mappings.  Buttons can be created by
     * instantiating a {@link GenericHID} or one of its subclasses ({@link
     * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
     * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
     */
    private void configureButtonBindings() {

        final JoystickButton shoots10 = new JoystickButton(m_joyStick, ButtonConstants.SHOOT_BUTTON);
        shoots10.whenPressed(m_shoots10);
        //final JoystickButton speedChanger = new
        final JoystickButton changeSpeed90 = new JoystickButton(m_joyStick, ButtonConstants.CHANGE_SPEED);
        //changeSpeed.whenPressed()


        final JoystickButton openAndCloseDoor = new JoystickButton(m_joyStick, ButtonConstants.OPEN_DOOR);
        openAndCloseDoor.whenPressed(m_openAndCloseDoor);
    }


    /**
     * Use this to pass the autonomous command to the main {@link Robot} class.
     *
     * @return the command to run in autonomous
     */

}
