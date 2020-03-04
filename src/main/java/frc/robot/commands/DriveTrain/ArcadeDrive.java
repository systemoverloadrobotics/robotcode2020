package frc.robot.commands.DriveTrain;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;

import java.util.function.DoubleSupplier;

public class ArcadeDrive extends CommandBase {
    private final DriveTrain m_driveTrain;
    private final DoubleSupplier m_speed;
    private final DoubleSupplier m_turn;

    public ArcadeDrive(DriveTrain driveTrain, DoubleSupplier speed, DoubleSupplier turn) {
        m_driveTrain = driveTrain;
        m_speed = speed;
        m_turn = turn;
        addRequirements(driveTrain);
    }

    @Override
    public void execute() {
        m_driveTrain.driveTank(m_speed.getAsDouble(), m_turn.getAsDouble());
    }

    @Override
    public void end(boolean interrupted) {
        m_driveTrain.driveTank(0, 0);
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}
