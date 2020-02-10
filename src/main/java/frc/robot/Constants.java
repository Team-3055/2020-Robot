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
        public static final int kLeftMotor1Port = 4;
        public static final int kLeftMotor2Port = 1;
        public static final int kRightMotor1Port = 3;
        public static final int kRightMotor2Port = 3;
    }
    public static final class OIConstants {
        public static final int kRightControllerPort = 1;
        public static final int kLeftControllerPort = 2;
        public static final int kXboxControllerPort = 3;
        
        //Values of joystick button mapping
        public static final int kJoystickTrigger = 1;
        public static final int kJoystickTop = 2;
    }
    public static final class PNUConstants {
        public static final int kCompressor = 0;
        public static final int kSolenoid1 = 1;
        public static final int kSolenoid2 = 2;
    }

    public static final class MISCMotorConstants {
        public static final int kWheel = 1;
        public static final int kWinch1 = 2;
        public static final int kWinch2 = 2;
        public static final int kWinch3 = 2;
        public static final int kWinch4 = 2;
    }
}