package frc.robot.subsystems;

import com.revrobotics.EncoderType;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import frc.robot.CONSTANTS;
import frc.robot.CONSTANTS.DRIVE;
import com.revrobotics.CANEncoder;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;


public class DriveTrain extends SubsystemBase {

    private NetworkTable limelight = NetworkTableInstance.getDefault().getTable("limelight");
    private NetworkTableEntry validTarget = limelight.getEntry("tv");
    private NetworkTableEntry x = limelight.getEntry("tx");
    private NetworkTableEntry y = limelight.getEntry("ty");
    private NetworkTableEntry area = limelight.getEntry("ta");

    private DoubleSolenoid shifter = new DoubleSolenoid(CONSTANTS.PCM_ID, DRIVE.FORWARD_CHANNEL_ID, DRIVE.REVERSE_CHANNEL_ID);

    private CANSparkMax rightMaster = new CANSparkMax(DRIVE.RIGHT_MASTER_ID, MotorType.kBrushless);
    private CANSparkMax rightFollower1 = new CANSparkMax(DRIVE.RIGHT_FOLLOWER_1_ID, MotorType.kBrushless);
    private CANSparkMax rightFollower2 = new CANSparkMax(DRIVE.RIGHT_FOLLOWER_2_ID, MotorType.kBrushless);
    private CANSparkMax leftMaster = new CANSparkMax(DRIVE.LEFT_MASTER_ID, MotorType.kBrushless);
    private CANSparkMax leftFollower1 = new CANSparkMax(DRIVE.LEFT_FOLLOWER_1_ID, MotorType.kBrushless);
    private CANSparkMax leftFollower2 = new CANSparkMax(DRIVE.LEFT_FOLLOWER_2_ID, MotorType.kBrushless);

    private SpeedControllerGroup rightGroup = new SpeedControllerGroup(rightMaster, rightFollower1, rightFollower2);
    private SpeedControllerGroup leftGroup = new SpeedControllerGroup(leftMaster, leftFollower1, leftFollower2);

    public DifferentialDrive robotDrive = new DifferentialDrive(leftGroup, rightGroup);

    private CANEncoder leftMasterEncoder = new CANEncoder(leftMaster, EncoderType.kQuadrature, 4069);
    private CANEncoder rightMasterEncoder = new CANEncoder(rightMaster, EncoderType.kQuadrature, 4069);

    public DriveTrain() {
        rightMaster.restoreFactoryDefaults();
        rightFollower1.restoreFactoryDefaults();
        rightFollower2.restoreFactoryDefaults();
        leftMaster.restoreFactoryDefaults();
        leftFollower1.restoreFactoryDefaults();
        leftFollower2.restoreFactoryDefaults();
    }


    public void shiftUp() {
        shifter.set(Value.kForward);
    }

    public void shiftDown() {
        shifter.set(Value.kReverse);
    }

    public double getLeftEncoder() {
        return leftMasterEncoder.getPosition();
    }

    public double getRightEncoder() {
        return rightMasterEncoder.getPosition();
    }

    public void resetEncoders() {
        rightMasterEncoder.setPosition(0);
        leftMasterEncoder.setPosition(0);
    }

    public double getLimelightValidTarget() {
        return validTarget.getDouble(0);
    }

    public double getLimelightX() {
        return x.getDouble(0);
    }

    public double getLimelightY() {
        return y.getDouble(0);
    }

    public double getLimelightArea() {
        return area.getDouble(0);
    }

    public void driveArcade(double speed, double turn) {
        robotDrive.arcadeDrive(speed * DRIVE.SPEED_MULTIPLIER, turn * DRIVE.TURN_MULTIPLIER);
    }

    public void driveTank(double leftSpeed, double rightSpeed) {
        robotDrive.tankDrive(leftSpeed * DRIVE.SPEED_MULTIPLIER, rightSpeed * DRIVE.SPEED_MULTIPLIER);
    }
}