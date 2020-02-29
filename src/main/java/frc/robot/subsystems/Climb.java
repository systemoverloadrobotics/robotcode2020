package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.ClimbConstants;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;

public class Climb extends SubsystemBase {

    private WPI_TalonSRX elevatorMotor = new WPI_TalonSRX(ClimbConstants.CLIMB_ELEVATOR_ID);
    private WPI_VictorSPX winchMotor = new WPI_VictorSPX(ClimbConstants.CLIMB_WINCH_ID);


    public Climb() {
        elevatorMotor.configFactoryDefault();
        winchMotor.configFactoryDefault();
        elevatorMotor.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative);
    }

    public void goUp() {
        elevatorMotor.set(ClimbConstants.ELEVATOR_POWER_CONSTANT);
    }

    public void goDown() {
        elevatorMotor.set(-ClimbConstants.ELEVATOR_POWER_CONSTANT);
    }

    public void liftStop() { elevatorMotor.stopMotor(); }

    public void getEncoder() { elevatorMotor.getSelectedSensorVelocity(); }

    public void reelIn() { winchMotor.set(ClimbConstants.WINCH_POWER_CONSTANT); }

    public void reelOut() {
        winchMotor.set(ClimbConstants.REVERSE_WINCH_POWER_CONSTANT);
    }

    public void reelStop() { winchMotor.stopMotor(); }

}
