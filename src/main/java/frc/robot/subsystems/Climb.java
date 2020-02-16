package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.ClimbConstants;

public class Climb extends SubsystemBase {

    private WPI_TalonSRX elevatorMotor = new WPI_TalonSRX(ClimbConstants.CLIMB_ELEVATOR_ID);
    private WPI_TalonSRX winchMotor = new WPI_TalonSRX(ClimbConstants.CLIMB_WINCH_ID);

    public Climb() {
        elevatorMotor.configFactoryDefault();
        winchMotor.configFactoryDefault();
    }

    public void goUp() {
        elevatorMotor.set(ClimbConstants.ELEVATOR_POWER_CONSTANT);
    }

    public void goDown() {
        elevatorMotor.set(-ClimbConstants.ELEVATOR_POWER_CONSTANT);
    }

    public void spinWinchForward() {
        winchMotor.set(ClimbConstants.WINCH_POWER_CONSTANT);
    }

    public void spinWinchBackward() {
        winchMotor.set(ClimbConstants.REVERSE_WINCH_POWER_CONSTANT);
    }

    public void stall() {
        winchMotor.stopMotor();
    }
}
