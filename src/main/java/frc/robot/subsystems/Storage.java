
package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.CONSTANTS.STORAGE;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.DigitalInput;

public class Storage extends SubsystemBase {

    public static final DigitalInput ballsInSwitch = new DigitalInput(STORAGE.BALLS_IN_SWITCH_ID);
    public static final DigitalInput ballsOutSwitch = new DigitalInput(STORAGE.BALLS_OUT_SWITCH_ID);
    public static final DigitalInput ballsIntakeSwitch = new DigitalInput(STORAGE.BALLS_INTAKE_SWITCH_ID);
    public static final WPI_VictorSPX polycord = new WPI_VictorSPX(STORAGE.POLYCORD_MOTOR_ID);

    public Storage() {
        polycord.configFactoryDefault();
    }

    public void moveIn() {
        polycord.set(ControlMode.PercentOutput, STORAGE.POLYCORD_FORWARD_SPEED);
    }

    public void moveOut() {
        polycord.set(ControlMode.PercentOutput, STORAGE.POLYCORD_BACKWARD_SPEED);
    }

    public void moveStop() {
        polycord.stopMotor();
    }

    public boolean getPos1() {
        System.out.println("Position 1: " + !ballsInSwitch.get());
        return !ballsInSwitch.get();
    }

    public boolean getPos5() {
        System.out.println("Position 5: " + !ballsOutSwitch.get());
        return !ballsOutSwitch.get();
    }

    public boolean getPos0() {
        System.out.println("Position 0: " + !ballsOutSwitch.get());
        return !ballsIntakeSwitch.get();
    }
}
