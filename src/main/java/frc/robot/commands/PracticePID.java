package frc.robot.commands;


import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj2.command.PIDCommand;

import frc.robot.subsystems.DriveTrain;

/**
 * A command that will turn the robot to the specified angle.
 */
public class PracticePID extends PIDCommand {
    /**
     * Turns to robot to the specified angle.
     *
     *        targetAngleDegrees The angle to turn to
     * @param drive              The drive subsystem to use
     */
    public PracticePID(double distance, DriveTrain drive) {
        super(
                new PIDController(1, 1, 1),
                // Close loop on heading
                drive::getLeftMasterEncoderValue,
                // Set reference to target
                distance,
                // Pipe output to move robot
                output -> drive.robotDrive.arcadeDrive(output,0),
                // Require the drive
                drive);

        // Set the controller to be continuous (because it is an angle controller)
        getController().enableContinuousInput(-180, 180);
        // Set the controller tolerance - the delta tolerance ensures the robot is stationary at the
        // setpoint before it is considered as having reached the reference
        getController()
                .setTolerance(0.1, 0.1);
    }

    @Override
    public boolean isFinished() {
        // End when the controller is at the reference.
        return getController().atSetpoint();
    }
}

