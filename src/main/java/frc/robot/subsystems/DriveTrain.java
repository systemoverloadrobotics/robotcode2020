package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import frc.robot.Constants;

public class DriveTrain extends SubsystemBase {
    private CANSparkMax rightMotorCont = new CANSparkMax(1, MotorType.kBrushless);
    private CANSparkMax rightMotor1 = new CANSparkMax(1, MotorType.kBrushless);
    private CANSparkMax rightMotor2 = new CANSparkMax(1, MotorType.kBrushless);
    private CANSparkMax leftMotorCont = new CANSparkMax(1, MotorType.kBrushless);
    private CANSparkMax leftMotor1 = new CANSparkMax(1, MotorType.kBrushless);
    private CANSparkMax leftMotor2 = new CANSparkMax(1, MotorType.kBrushless);


    public DriveTrain() {

    }

    public void moveForward() {

    }

    public void moveBackward() {

    }

    public void turnLeft() {

    }

    public void turnRight() {

    }

    public void park() {

    }
}