package frc.robot.subsystems;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
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



    private SpeedControllerGroup rightGroup = new SpeedControllerGroup(RIGHT_MASTER, RIGHT_FOLLOWER_1, RIGHT_FOLLOWER_2);
    private SpeedControllerGroup leftGroup = new SpeedControllerGroup(LEFT_MASTER, LEFT_FOLLOWER_1, LEFT_FOLLOWER_2);

    private DifferentialDrive robotDrive = new DifferentialDrive(leftGroup,rightGroup);


    public DriveTrain() {
        RIGHT_MASTER.restoreFactoryDefaults();
        RIGHT_FOLLOWER_1.restoreFactoryDefaults();
        RIGHT_FOLLOWER_2.restoreFactoryDefaults();
        LEFT_MASTER.restoreFactoryDefaults();
        LEFT_FOLLOWER_1.restoreFactoryDefaults();
        LEFT_FOLLOWER_2.restoreFactoryDefaults();
    }

    public void move(double speed, double turn){
        robotDrive.arcadeDrive(speed,turn);
    }

    public void park() {

    }
}