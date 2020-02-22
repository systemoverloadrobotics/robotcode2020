/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;


/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants.  This class should not be used for any other purpose.  All constants should be
 * declared globally (i.e. public static).  Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
    public static final class DriveConstants {
        public static final int RIGHT_MASTER_ID = 4;
        public static final int RIGHT_FOLLOWER_1_ID = 5;
        public static final int RIGHT_FOLLOWER_2_ID = 6;
        public static final int LEFT_MASTER_ID = 7;
        public static final int LEFT_FOLLOWER_1_ID = 8;
        public static final int LEFT_FOLLOWER_2_ID = 9;
        public static final double SPEED_MULTIPLIER = 0.6;
        public static final double TURN_MULTIPLIER = 0.3;
    }
    public static final class ButtonConstants{
        public static final int SHOOT_BUTTON = 5; //TBD
        public static final int JOYSTICK_PORT = 0;
        public static final int OPEN_DOOR = 6;

    }
    public static final class IntakeConstants {
        public static final int INTAKE_BAR_MOTOR_ID = 10;
        public static final int INTAKE_WHEELS_ID = 11;
        public static final double INTAKE_FLYWHEELS_FORWARD_POWER = 0.3;
        public static final double INTAKE_FLYWHEELS_REVERSE_POWER = -0.3;
        public static final int INTAKE_STOP = 0;
    }
    public static final class StorageConstants {
        public static final int POLYCORD_MOTOR_ID = 12;
        public static final int STORAGE_GATE_ID = 13;
        public static final int SUPER_SOLENOID_TIME = 3;
        public static final int BALLS_IN_SWITCH_ID = 17;
        public static final double POLYCHORD_FORWARD_POWER = 0.2;
        public static final double POLYCHORD_REVERSE_POWER = -0.2;
        public static final int POLYCHORD_STOP = 0;
        public static final int DOUBLESOLENOID_MODULE_NUM = 3;
        public static final int DOUBLESOLENOID_FOWARDCHANNEL_ID = 0;
        public static final int DOUBLESOLENOID_REVERSECHANNEL_ID = 1;
        public static final int BALLS_IN_SWITCH_ID = 17;
        public static final int BALLS_OUT_SWITCH_ID = 18;
        public static final int POLYCORD_FORWARD_SPEED = .2;
        public static final int POLYCORD_BACKWARD_SPEED = .2;
    }
    public static final class OuttakeConstants {
        public static final int OUTTAKE_WHEELS_ID = 14;
    }
    public static final class ClimbConstants {
        public static final int CLIMB_WINCH_ID = 15;
        public static final int CLIMB_ELEVATOR_ID = 16;
        public static final double ELEVATOR_POWER_CONSTANT = 0.3;
        public static final double WINCH_POWER_CONSTANT = 0.3;
        public static final double REVERSE_WINCH_POWER_CONSTANT = -0.3;
    }
    public static final class VisionConstants {
        //Actual numbers needed upon assembly
        public static final double LIMELIGHT_ANGLE_FROM_HORIZONTAL = 60.; //In degrees
        public static final double LIMELIGHT_HEIGHT_FROM_GROUND = 3.5;
        public static final double HEIGHT_OF_TOP_TARGET = 81.25; //From bottom of horizontal strip to carpet in inches
        public static final double HEIGHT_FOR_CALCULATION = HEIGHT_OF_TOP_TARGET - LIMELIGHT_HEIGHT_FROM_GROUND;
    }

}
