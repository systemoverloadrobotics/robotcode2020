package frc.robot.subsystems;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.CANSparkMax;
import edu.wpi.first.wpilibj.Joystick;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import frc.robot.Constants.DriveConstants;


public class DriveTrain extends SubsystemBase {
    private CANSparkMax RIGHT_MASTER_ID = new CANSparkMax(DriveConstants.RIGHT_MASTER_ID, MotorType.kBrushless);
    private CANSparkMax RIGHT_FOLLOWER_1_ID = new CANSparkMax(DriveConstants.RIGHT_FOLLOWER_1_ID, MotorType.kBrushless);
    private CANSparkMax RIGHT_FOLLOWER_2_ID = new CANSparkMax(DriveConstants.RIGHT_FOLLOWER_2_ID, MotorType.kBrushless);
    private CANSparkMax LEFT_MASTER_ID = new CANSparkMax(DriveConstants.LEFT_MASTER_ID, MotorType.kBrushless);
    private CANSparkMax LEFT_FOLLOWER_1_ID = new CANSparkMax(DriveConstants.LEFT_FOLLOWER_1_ID, MotorType.kBrushless);
    private CANSparkMax LEFT_FOLLOWER_2_ID = new CANSparkMax(DriveConstants.LEFT_FOLLOWER_2_ID, MotorType.kBrushless);

    public Joystick flightStick = new Joystick(0);
    //defines the joystick as the flight stick


    private SpeedControllerGroup rightGroup = new SpeedControllerGroup(RIGHT_MASTER_ID, RIGHT_FOLLOWER_1_ID, RIGHT_FOLLOWER_2_ID);
    private SpeedControllerGroup leftGroup = new SpeedControllerGroup(LEFT_MASTER_ID, LEFT_FOLLOWER_1_ID, LEFT_FOLLOWER_2_ID);

    private DifferentialDrive robotDrive = new DifferentialDrive(leftGroup,rightGroup);

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