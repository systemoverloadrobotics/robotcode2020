package frc.robot.commands.DriveTrain;

import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj2.command.PIDCommand;
import frc.robot.subsystems.DriveTrain;

public class MoveDistance extends PIDCommand {
    public MoveDistance(DriveTrain driveTrain, double distance) {
        super(
                new PIDController(1, 0, 0),
                // Close loop on heading
                driveTrain::getLeftMasterEncoderValue,
                // Set reference to target
                distance,
                // Pipe output to move robot
                output -> driveTrain.driveTank(output, output),
                // Require the drive
                driveTrain);

        // Set the controller to be continuous (because it is an angle controller)
        getController().enableContinuousInput(-180, 180);
        // Set the controller tolerance - the delta tolerance ensures the robot is stationary at the
        // setpoint before it is considered as having reached the reference
        getController()
                .setTolerance(0.1, 0.1);
    }

    @Override
    public void initialize() {
        super.initialize();
    }


    @Override
    public void execute() {
        System.out.print(m_useOutput);
    }

    @Override
    public void end(boolean interrupted) {
    }

    @Override
    public boolean isFinished() {
        return true;
    }
}
