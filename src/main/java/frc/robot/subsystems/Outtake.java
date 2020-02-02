package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import frc.robot.Constants.OuttakeConstants;

public class Outtake extends SubsystemBase {
    private WPI_VictorSPX shootMotor = new WPI_VictorSPX(OuttakeConstants.OUTTAKE_WHEELS_ID);

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