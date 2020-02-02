package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import frc.robot.Constants.DriveConstants;

public class DriveTrain extends SubsystemBase {
    private CANSparkMax RIGHT_MASTER = new CANSparkMax(DriveConstants.RIGHT_MASTER_ID, MotorType.kBrushless);
    private CANSparkMax RIGHT_FOLLOWER_1 = new CANSparkMax(DriveConstants.RIGHT_FOLLOWER_1_ID, MotorType.kBrushless);
    private CANSparkMax RIGHT_FOLLOWER_2 = new CANSparkMax(DriveConstants.RIGHT_FOLLOWER_2_ID, MotorType.kBrushless);
    private CANSparkMax LEFT_MASTER = new CANSparkMax(DriveConstants.LEFT_MASTER_ID, MotorType.kBrushless);
    private CANSparkMax LEFT_FOLLOWER_1 = new CANSparkMax(DriveConstants.LEFT_FOLLOWER_1_ID, MotorType.kBrushless);
    private CANSparkMax LEFT_FOLLOWER_2 = new CANSparkMax(DriveConstants.LEFT_FOLLOWER_2_ID, MotorType.kBrushless);


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