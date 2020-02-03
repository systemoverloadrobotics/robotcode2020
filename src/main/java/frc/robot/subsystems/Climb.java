package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.LimitSwitchNormal;
import com.ctre.phoenix.motorcontrol.RemoteLimitSwitchSource;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.ClimbConstants;

public class Climb extends SubsystemBase {

    public WPI_TalonSRX elevatorMotor = new WPI_TalonSRX(ClimbConstants.CLIMB_ELEVATOR_ID);
    public WPI_TalonSRX winchMotor = new WPI_TalonSRX(ClimbConstants.CLIMB_WINCH_ID);

    public Climb() {
        elevatorMotor.configForwardLimitSwitchSource(RemoteLimitSwitchSource.RemoteTalonSRX, LimitSwitchNormal.NormallyOpen,ClimbConstants.CLIMB_ELEVATOR_ID,0);
        elevatorMotor.configReverseLimitSwitchSource(RemoteLimitSwitchSource.RemoteTalonSRX, LimitSwitchNormal.NormallyClosed,ClimbConstants.CLIMB_ELEVATOR_ID,0);

        winchMotor.configForwardLimitSwitchSource(RemoteLimitSwitchSource.RemoteTalonSRX, LimitSwitchNormal.NormallyOpen,ClimbConstants.CLIMB_WINCH_ID,0);

        elevatorMotor.configFactoryDefault();
        winchMotor.configFactoryDefault();
    }

    public void goUp() {
        if(elevatorMotor.isFwdLimitSwitchClosed() != 1){
            elevatorMotor.set(0.3);
        }
    }

    public void goDown() {
        if(elevatorMotor.isRevLimitSwitchClosed() != 1){
            elevatorMotor.set(-0.3);
        }
    }

    public void spinWinchForward() {
        winchMotor.set(0.3);
    }

    public void spinWinchBackward() {
        winchMotor.set(0.3);
    }

    public void stall() {
        winchMotor.stopMotor();
    }
}
