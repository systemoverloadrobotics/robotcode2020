package frc.robot.subsystems;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.CANSparkMax;
import edu.wpi.first.wpilibj.Joystick;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import frc.robot.Constants.DriveConstants;


public class DriveTrain extends SubsystemBase {
    private CANSparkMax RIGHT_MASTER = new CANSparkMax(DriveConstants.RIGHT_MASTER_ID, MotorType.kBrushless);
    private CANSparkMax RIGHT_FOLLOWER_1 = new CANSparkMax(DriveConstants.RIGHT_FOLLOWER_1_ID, MotorType.kBrushless);
    private CANSparkMax RIGHT_FOLLOWER_2 = new CANSparkMax(DriveConstants.RIGHT_FOLLOWER_2_ID, MotorType.kBrushless);
    private CANSparkMax LEFT_MASTER = new CANSparkMax(DriveConstants.LEFT_MASTER_ID, MotorType.kBrushless);
    private CANSparkMax LEFT_FOLLOWER_1 = new CANSparkMax(DriveConstants.LEFT_FOLLOWER_1_ID, MotorType.kBrushless);
    private CANSparkMax LEFT_FOLLOWER_2 = new CANSparkMax(DriveConstants.LEFT_FOLLOWER_2_ID, MotorType.kBrushless);

    public Joystick flightStick = new Joystick(0);
    //defines the joystick as the flight stick

    private SpeedControllerGroup rightGroup = new SpeedControllerGroup(RIGHT_MASTER, RIGHT_FOLLOWER_1, RIGHT_FOLLOWER_2);
    private SpeedControllerGroup leftGroup = new SpeedControllerGroup(LEFT_MASTER, LEFT_FOLLOWER_1, LEFT_FOLLOWER_2);

    private DifferentialDrive robotDrive = new DifferentialDrive(leftGroup,rightGroup);


    public DriveTrain() {

    }

    public void moveForward(double ...speeds) {
        if(speeds.length == 0){
            robotDrive.arcadeDrive(flightStick.getY()*0.6,0);
            //the speed value is between -1 and 1. The value represents percent output of the motor.
        }
        else{
            robotDrive.arcadeDrive(speeds[0],0);
        }

    }

    public void moveBackward(double ...speeds) {
        if(speeds.length == 0){
            robotDrive.arcadeDrive(flightStick.getY()*0.6,0);
            //the speed value is between -1 and 1. The value represents percent output of the motor.
        }
        else{
            robotDrive.arcadeDrive(speeds[0],0);
        }
    }

    public void turnLeft(double speed, double rotation) {
        robotDrive.arcadeDrive(speed,rotation);
    }

    public void turnRight(double speed, double rotation) {
        robotDrive.arcadeDrive(speed, rotation);
    }

    public void park() {

    }
}