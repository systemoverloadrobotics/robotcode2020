package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSPX;
import frc.robot.Constants.OuttakeConstants;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;


public class Outtake extends SubsystemBase {
    private WPI_TalonSPX shootMotor = new WPI_TalonSPX(OuttakeConstants.OUTTAKE_WHEELS_ID);

    public Outtake() {
        shootMotor.configFactoryDefault();
        shootMotor.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative);

    }

    public void shoot (double rpm) {
        shootMotor.set(ControlMode.PercentOutput, rpm);
    }

    public void stopShoot () {
        shootMotor.stopMotor();
    }

    public double getEncoder () {
        return shootMotor.getSelectedSensorVelocity();
    }

}