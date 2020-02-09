package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.StorageConstants;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.DigitalInput;

public class Storage extends SubsystemBase {

    public static final DigitalInput ballsInSwitch = new DigitalInput(StorageConstants.BALLS_IN_SWITCH_ID);
    public static final WPI_VictorSPX polycord = new WPI_VictorSPX(StorageConstants.POLYCORD_MOTOR_ID);
    private DoubleSolenoid m_doubleSolenoid = new DoubleSolenoid(3,0,1);


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

    private boolean loadingIncomingBalls(){
        if (!ballsInSwitch.get()) {
            runPolycordForward();
            return true;
        }
        stopPolycord();
        return false;
    }

    public void openDoubleSolenoid(){
        m_doubleSolenoid.set(DoubleSolenoid.Value.kForward);
    }

    public void closeDoubleSolenoid(){m_doubleSolenoid.set(DoubleSolenoid.Value.kForward);}
    
}
