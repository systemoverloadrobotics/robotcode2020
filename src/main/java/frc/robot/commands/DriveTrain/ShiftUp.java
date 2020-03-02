package frc.robot.commands.DriveTrain;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;

public class ShiftUp extends CommandBase {
    private DriveTrain m_driveTrain;

    public ShiftUp(DriveTrain driveTrain) {
        m_driveTrain = driveTrain;
        addRequirements(m_driveTrain);
    }

    @Override
    public void initialize() {
        m_driveTrain.shiftUp();
    }

    @Override
    public boolean isFinished() {
        return true;
    }
}
