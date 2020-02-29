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
    private final Joystick m_joystick = new Joystick(ButtonConstants.JOYSTICK_PORT);

    //commands
    private final Outtake m_outtake = new Outtake();
    private final Shoots10 m_shoots10 = new Shoots10(m_outtake);
    private final ArcadeDrive m_arcadeDrive = new ArcadeDrive(m_driveTrain, m_joystick.getY(), m_joystick.getX());
    private final Shoots10 changeSpeed = new Shoots10(m_outtake);
    private final OpenAndCloseDoor m_openAndCloseDoor = new OpenAndCloseDoor(m_storage);

    public RobotContainer() {
        //setting default commands
        m_driveTrain.setDefaultCommand(m_arcadeDrive);

        final JoystickButton shoots10 = new JoystickButton(m_joystick, ButtonConstants.SHOOT_BUTTON);
        shoots10.whenPressed(m_shoots10);
        //final JoystickButton speedChanger = new
        final JoystickButton changeSpeed90 = new JoystickButton(m_joystick, ButtonConstants.CHANGE_SPEED);
        //changeSpeed.whenPressed()


        final JoystickButton openAndCloseDoor = new JoystickButton(m_joystick, ButtonConstants.OPEN_DOOR);
        openAndCloseDoor.whenPressed(m_openAndCloseDoor);
    }
}
