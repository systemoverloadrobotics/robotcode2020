package frc.robot.commands.DriveTrain;

import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj2.command.PIDCommand;
import frc.robot.subsystems.DriveTrain;

public class AlignDrive extends PIDCommand {

    public AlignDrive(DriveTrain driveTrain) {
        super(
                new PIDController(1, 0, 0),
                // Close loop on heading
                driveTrain::getLimelightX,
                // Set reference to target
                0,
                // Pipe output to move robot
                output -> driveTrain.driveArcade(0, output),
                // Require the drive
                driveTrain);

        getController().setTolerance(0.1, 0.1);
    }

    @Override
    public void initialize() {
        super.initialize();
    }

    @Override
    public boolean isFinished() {
        return getController().atSetpoint();
    }
}
