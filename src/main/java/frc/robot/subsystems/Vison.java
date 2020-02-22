package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.VisionConstants;


public class Vision extends SubsystemBase {

    public static final NetworkTable limelight = NetworkTableInstance.getDefault().getTable("limelight");
    public static final NetworkTableEntry ty = limelight.getEntry("ty");

    public Vision(){
    }

    public double getDistanceFromTarget(){
        double a1 = Math.toRadians(VisionConstants.LIMELIGHT_ANGLE_FROM_HORIZONTAL);
        double y = ty.getDouble(0.0);
        double a2 = Math.toRadians(y);
        return (VisionConstants.HEIGHT_FOR_CALCULAITON) / Math.tan(a1 + a2);
    }

}