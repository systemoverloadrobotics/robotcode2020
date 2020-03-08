package frc.robot.commands.DriveTrain;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;

import java.util.function.BooleanSupplier;
import java.util.function.DoubleSupplier;

public class ArcadeDrive extends CommandBase {
    private final DriveTrain m_driveTrain;
    private final DoubleSupplier m_speed;
    private final DoubleSupplier m_turn;
    private final BooleanSupplier m_shiftDown;
    private final BooleanSupplier m_shiftUp;

    public ArcadeDrive(DriveTrain driveTrain, DoubleSupplier speed, DoubleSupplier turn, BooleanSupplier shiftDown, BooleanSupplier shiftUp) {
        m_driveTrain = driveTrain;
        m_speed = speed;
        m_turn = turn;
        m_shiftDown = shiftDown;
        m_shiftUp = shiftUp;
        addRequirements(driveTrain);
    }

    @Override
    public void execute() {
        m_driveTrain.driveArcade(m_speed.getAsDouble(), m_turn.getAsDouble());

        if (m_shiftDown.getAsBoolean()) {
            m_driveTrain.shiftDown();
        } else if (m_shiftUp.getAsBoolean()) {
            m_driveTrain.shiftUp();
        }
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
