//package frc.robot.subsystems;
//
//import edu.wpi.first.wpilibj2.command.SubsystemBase;
//import edu.wpi.first.wpilibj.DigitalInput;
//
//public class Storage extends SubsystemBase {
//
//    public static final DigitalInput ballsInSwitch = new DigitalInput(StorageConstants.BALLS_IN_SWITCH_ID);
//    public static final WPI_VictorSPX polycord = new WPI_VictorSPX(StorageCosntants.POLYCORD_MOTOR_ID);
//
//    public Storage() {
//
//    }
//
//    public void runPolycordForward(){
//        intakeFlywheels.set(ControlMode.PercentOutput, .2);
//    }
//
//    public void runPolycordBackward(){
//        intakeFlywheels.set(ControlMode.PercentOutput, -.2);
//    }
//
//    public void stopPolycord(){
//        intakeFlywheels.set(ControlMode.PercentOutput, 0);
//    }
//
//    private boolean loadingIncomingBalls(){
//        if (!ballsInSwitch.get()) {
//            runPolycordForward();
//            return true;
//        }
//        stopPolycord();
//        return false;
//    }
//
//}
