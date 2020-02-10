/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;


import frc.robot.Constants.MISCMotorConstants;;

public class MiscSubsystem extends SubsystemBase {
  public final WPI_TalonSRX ColorWheel = new WPI_TalonSRX(MISCMotorConstants.kWheel);
  public final SpeedControllerGroup WinchRight = new SpeedControllerGroup(
                                                      new WPI_TalonSRX(MISCMotorConstants.kWinch1) , 
                                                      new WPI_TalonSRX(MISCMotorConstants.kWinch2));
  public final SpeedControllerGroup WinchLeft = new SpeedControllerGroup(
                                                        new WPI_TalonSRX(MISCMotorConstants.kWinch3) , 
                                                        new WPI_TalonSRX(MISCMotorConstants.kWinch4));

  /**
   * Creates a new ExampleSubsystem.
   */
  public MiscSubsystem() {

  }

  /**
   * Creates a new ColorWheel Control.
   *
   * @param speed The speed the controller must be set at. Value between -1 and 1
   */
  public void ColorControl(float speed) {
      ColorWheel.set(speed)
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
