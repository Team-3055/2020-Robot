/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import frc.robot.Constants.DriveConstants;

public class DriveSubsystem extends SubsystemBase {
    // The motors on the left side of the drive.
    private final SpeedControllerGroup leftMotors = 
        new SpeedControllerGroup(new WPI_TalonSRX(DriveConstants.kLeftMotor1Port),
                                new WPI_TalonSRX(DriveConstants.kLeftMotor2Port));

    // The motors on the right side of the drive.
    private final SpeedControllerGroup rightMotors = 
        new SpeedControllerGroup(new WPI_TalonSRX(DriveConstants.kRightMotor1Port),
                                new WPI_TalonSRX(DriveConstants.kRightMotor2Port));
   
     // The robot's drive
    private final DifferentialDrive t_drive = new DifferentialDrive(leftMotors, rightMotors);
    
    //public DriveSubsystem() {
    //}
  
    /**
   * Drives the robot using arcade controls.
   *
   * @param fwd the commanded forward movement
   * @param rot the commanded rotation
   */
    public void arcadeDrive(double fwd, double rot) {
      t_drive.arcadeDrive(fwd, rot);
    }
    /**
    * Sets the max output of the drive.  Useful for scaling the drive to drive more slowly.
    *
    * @param maxOutput the maximum output to which the drive will be constrained
    */
    public void setMaxOutput(double maxOutput) {
        t_drive.setMaxOutput(maxOutput);
        }


  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
