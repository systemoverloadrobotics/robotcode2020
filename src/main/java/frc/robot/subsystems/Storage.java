package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.StorageConstants;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.DigitalInput;

public class Storage extends SubsystemBase {

    public static final DigitalInput ballsInSwitch = new DigitalInput(StorageConstants.BALLS_IN_SWITCH_ID);
    public static final DigitalInput ballsOutSwitch = new DigitalInput(StorageConstants.BALLS_OUT_SWITCH_ID);
    public static final WPI_VictorSPX polycord = new WPI_VictorSPX(StorageCosntants.POLYCORD_MOTOR_ID);
    private DoubleSolenoid m_doubleSolenoid = new DoubleSolenoid(StorageConstants.DOUBLESOLENOID_MODULE_NUM,StorageConstants.DOUBLESOLENOID_FOWARDCHANNEL_ID,StorageConstants.DOUBLESOLENOID_REVERSECHANNEL_ID);

    public Storage() {

    }

    public void runPolycordForward(){
        polycord.set(ControlMode.PercentOutput, POLYCORD_FORWARD_SPEED);
    }

    public void runPolycordBackward(){
        polycord.set(ControlMode.PercentOutput, POLYCORD_BACKWARD_SPEED);

    }

    public void stopPolycord(){
        polycord.set(ControlMode.PercentOutput , StorageConstants.POLYCHORD_STOP);
    }

    public void openDoubleSolenoid(){
        m_doubleSolenoid.set(DoubleSolenoid.Value.kForward);
    }

    public void closeDoubleSolenoid(){m_doubleSolenoid.set(DoubleSolenoid.Value.kReverse);}

}
