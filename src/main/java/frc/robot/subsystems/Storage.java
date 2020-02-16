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
        polycord.set(ControlMode.PercentOutput , StorageConstants.POLYCHORD_FORWARD_POWER);
    }

    public void runPolycordBackward(){
        polycord.set(ControlMode.PercentOutput , StorageConstants.POLYCHORD_REVERSE_POWER);
    }

    public void stopPolycord(){
        polycord.set(ControlMode.PercentOutput , StorageConstants.POLYCHORD_STOP);
    }

    /**If the system finished and pulled in the ball return false. While still running return true
     * Runs when drive team presses a button.**/
    public boolean loadIncomingBalls(){
        if (!ballsInSwitch.get()){
            stopPolycord();
            return false;
        }
        runPolycordForward();
        return true;
    }
    /**If the system finished and balls are in position, return false. While still running return true.
     * Runs when drive team presses a button**/
    public boolean moveToOuttake(){
        if (!ballsInSwitch.get()){
            stopPolycord();
            return false;
        }
        runPolycordBackward();
        return true;
    }

    public void openDoubleSolenoid(){
        m_doubleSolenoid.set(DoubleSolenoid.Value.kForward);
    }

    public void closeDoubleSolenoid(){m_doubleSolenoid.set(DoubleSolenoid.Value.kReverse);}
}
