package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import frc.robot.Constants.OuttakeConstants;

public class Outtake extends SubsystemBase {
    private WPI_TalonSRX shootMotor = new WPI_TalonSRX(OuttakeConstants.OUTTAKE_WHEELS_ID);

    public Outtake() {
        shootMotor.configFactoryDefault();
    }

    public void shoot (double distance) {
        double speed = distance;
        shootMotor.set(ControlMode.PercentOutput, speed);
    }

    public void stopShoot () {
        shootMotor.stopMotor();
    }
}