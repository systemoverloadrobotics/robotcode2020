package frc.robot.subsystems;

import com.revrobotics.CANSparkMaxLowLevel;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import com.revrobotics.CANSparkMax;
import edu.wpi.first.wpilibj.Joystick;

public class DriveTrain extends SubsystemBase {

    public DriveTrain() {

        Joystick flightStick = new Joystick(0);

        CANSparkMax kingRightMotor = new CANSparkMax(Constants.DriveConstants.RIGHT_MASTER_ID, CANSparkMaxLowLevel.MotorType.kBrushless);
        CANSparkMax slaveRightMotor1 = new CANSparkMax(Constants.DriveConstants.RIGHT_FOLLOWER_1_ID, CANSparkMaxLowLevel.MotorType.kBrushless);
        CANSparkMax slaveRightMotor2 = new CANSparkMax(Constants.DriveConstants.RIGHT_FOLLOWER_2_ID, CANSparkMaxLowLevel.MotorType.kBrushless);
        //right motors on drive train using CANSparkMax motor controllers

        CANSparkMax kingLeftMotor = new CANSparkMax(Constants.DriveConstants.LEFT_MASTER_ID, CANSparkMaxLowLevel.MotorType.kBrushless);
        CANSparkMax slaveLeftMotor1 = new CANSparkMax(Constants.DriveConstants.LEFT_FOLLOWER_1_ID, CANSparkMaxLowLevel.MotorType.kBrushless);
        CANSparkMax slaveLeftMotor2 = new CANSparkMax(Constants.DriveConstants.LEFT_FOLLOWER_2_ID, CANSparkMaxLowLevel.MotorType.kBrushless);
        //left motors on drive using CANSparkMax motor controllers

        slaveLeftMotor1.follow(kingLeftMotor);
        slaveLeftMotor2.follow(kingLeftMotor);
        slaveRightMotor1.follow(kingRightMotor);
        slaveRightMotor2.follow(kingRightMotor);
        //slave motors following king motors. Setting themselves to the same motor speed as their respective king motor


        kingLeftMotor.restoreFactoryDefaults();
        slaveLeftMotor1.restoreFactoryDefaults();
        slaveLeftMotor2.restoreFactoryDefaults();
        kingRightMotor.restoreFactoryDefaults();
        slaveRightMotor1.restoreFactoryDefaults();
        slaveRightMotor2.restoreFactoryDefaults();
        //factory defaults so nothing breaks with the motors

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