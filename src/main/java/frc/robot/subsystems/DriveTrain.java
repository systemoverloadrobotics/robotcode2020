package frc.robot.subsystems;

import com.revrobotics.EncoderType;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.Compressor;
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
    private CANSparkMax rightMaster = new CANSparkMax(DRIVE.RIGHT_MASTER_ID, MotorType.kBrushless);
    private CANSparkMax rightFollower1 = new CANSparkMax(DRIVE.RIGHT_FOLLOWER_1_ID, MotorType.kBrushless);
    private CANSparkMax rightFollower2 = new CANSparkMax(DRIVE.RIGHT_FOLLOWER_2_ID, MotorType.kBrushless);
    private CANSparkMax leftMaster = new CANSparkMax(DRIVE.LEFT_MASTER_ID, MotorType.kBrushless);
    private CANSparkMax leftFollower1 = new CANSparkMax(DRIVE.LEFT_FOLLOWER_1_ID, MotorType.kBrushless);
    private CANSparkMax leftFollower2 = new CANSparkMax(DRIVE.LEFT_FOLLOWER_2_ID, MotorType.kBrushless);

    NetworkTable limelight = NetworkTableInstance.getDefault().getTable("limelight");
    NetworkTableEntry tx = limelight.getEntry("tx");
    NetworkTableEntry ty = limelight.getEntry("ty");
    NetworkTableEntry ta = limelight.getEntry("ta");
    //NetworkTableEntry piper = limelight.getEntry("getpipe").getDouble(0);


    private CANEncoder leftMasterEncoder = new CANEncoder(leftMaster, EncoderType.kQuadrature, 4069);
    private CANEncoder rightMasterEncoder = new CANEncoder(rightMaster, EncoderType.kQuadrature, 4069);

    private DoubleSolenoid shifter = new DoubleSolenoid(CONSTANTS.PCM_ID, DRIVE.DOUBLESOLENOID_FOWARDCHANNEL_ID, DRIVE.DOUBLESOLENOID_REVERSECHANNEL_ID);
    private Compressor m_compressor = new Compressor(3);

    private SpeedControllerGroup rightGroup = new SpeedControllerGroup(rightMaster, rightFollower1, rightFollower2);
    private SpeedControllerGroup leftGroup = new SpeedControllerGroup(leftMaster, leftFollower1);

    public DifferentialDrive robotDrive = new DifferentialDrive(leftGroup, rightGroup);

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

    public void compressorStart() {
        m_compressor.start();
    }

    public void compressorStop() {
        m_compressor.stop();
    }

    public double getYaw() {
        double x;
        return x = tx.getDouble(0.0);
    }

    public double getDistance() {
        double y;
        return y = ty.getDouble(0.0);
    }

    public double getLeftMasterEncoderValue() {
        return leftMasterEncoder.getPosition();
    }

    public double getRightMasterEncoderValue() {
        return leftMasterEncoder.getPosition();
    }

    public void driveTank(double leftSpeed, double rightSpeed) {
        robotDrive.tankDrive(leftSpeed * DRIVE.SPEED_MULTIPLIER, rightSpeed * DRIVE.SPEED_MULTIPLIER);
    }

    public void driveArcade(double speed, double turn) {
        //incase we need arcade drive
        robotDrive.arcadeDrive(speed * DRIVE.SPEED_MULTIPLIER, turn * DRIVE.TURN_MULTIPLIER);
    }
}