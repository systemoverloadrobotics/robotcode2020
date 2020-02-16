package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.DigitalInput;

public class Storage extends SubsystemBase {

    public static final DigitalInput ballsInSwitch = new DigitalInput(StorageConstants.BALLS_IN_SWITCH_ID);
    public static final DigitalInput ballsOutSwitch = new DigitalInput(StorageConstants.BALLS_OUT_SWITCH_ID);
    public static final WPI_VictorSPX polycord = new WPI_VictorSPX(StorageCosntants.POLYCORD_MOTOR_ID);

    public Storage() {

    }

    public void runPolycordForward(){
        polycord.set(ControlMode.PercentOutput, POLYCORD_FORWARD_SPEED);
    }

    public void runPolycordBackward(){
        polycord.set(ControlMode.PercentOutput, POLYCORD_BACKWARD_SPEED);
    }

    public void stopPolycord(){
        polycord.set(ControlMode.PercentOutput, 0);
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

}
