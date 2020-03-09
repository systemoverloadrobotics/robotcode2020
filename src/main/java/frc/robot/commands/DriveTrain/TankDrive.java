package frc.robot.commands.DriveTrain;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;

import java.util.function.BooleanSupplier;
import java.util.function.DoubleSupplier;

public class TankDrive extends CommandBase {
    DriveTrain m_driveTrain;
    DoubleSupplier m_leftSpeed;
    DoubleSupplier m_rightSpeed;
    BooleanSupplier m_shiftUp;
    BooleanSupplier m_shiftDown;

    public TankDrive(DriveTrain driveTrain, DoubleSupplier leftSpeed, DoubleSupplier rightSpeed, BooleanSupplier shiftDown, BooleanSupplier shiftUp) {
        m_driveTrain = driveTrain;
        m_leftSpeed = leftSpeed;
        m_rightSpeed = rightSpeed;
        m_shiftDown = shiftDown;
        m_shiftUp = shiftUp;
        addRequirements(driveTrain);
    }

    @Override
    public void execute() {
        m_driveTrain.driveTank(m_leftSpeed.getAsDouble(), m_rightSpeed.getAsDouble());

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
