package frc.robot.commands.DriveTrain;

import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj2.command.PIDCommand;
import frc.robot.subsystems.DriveTrain;

public class MoveDistance extends PIDCommand {
    public MoveDistance(DriveTrain driveTrain, double distance) {
        super(
                new PIDController(1, 0, 0),
                // Close loop on heading
                driveTrain::getLeftEncoder,
                // Set reference to target
                distance,
                // Pipe output to move robot
                output -> driveTrain.driveArcade(output, 0),
                // Require the drive
                driveTrain);

        getController().setTolerance(0.1, 0.1);
    }

    @Override
    public void initialize() {
        super.initialize();
    }

    @Override
    public void end(boolean interrupted) {
    }

    @Override
    public boolean isFinished() {
        return getController().atSetpoint();
    }
}
