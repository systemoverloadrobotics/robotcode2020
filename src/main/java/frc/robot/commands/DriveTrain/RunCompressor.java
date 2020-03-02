package frc.robot.commands.DriveTrain;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;

public class RunCompressor extends CommandBase {
    private DriveTrain m_driveTrain;

    public RunCompressor(DriveTrain driveTrain) {
        m_driveTrain = driveTrain;
        addRequirements(driveTrain);
    }

    @Override
    public void execute() {
        m_driveTrain.compressorStart();
    }

    @Override
    public void end(boolean interrupted) {
        m_driveTrain.compressorStop();
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}
