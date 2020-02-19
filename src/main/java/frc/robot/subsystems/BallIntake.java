/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import edu.wpi.first.wpilibj.Solenoid;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;


public class BallIntake extends SubsystemBase {
  private final WPI_TalonSRX IntakeMotor = new WPI_TalonSRX(Constants.bIntakeConstants.kIntakeMotor);
  private final WPI_TalonSRX BeltMotor1 = new WPI_TalonSRX(Constants.bIntakeConstants.kBeltMotor1);
  private final WPI_TalonSRX LaunchMotor1 = new WPI_TalonSRX(Constants.bIntakeConstants.kLaunchMotor1);
  private final WPI_TalonSRX LaunchMotor2 = new WPI_TalonSRX(Constants.bIntakeConstants.kLaunchMotor2);
  private final Solenoid s1 = new Solenoid(Constants.PNUConstants.kSolenoid1);
  //float (decimal value) value is for the motor controller where 1= 100%  foward, -1 backwards, 0 is off
public void IntakeBall(float speed){
  IntakeMotor.set(speed);
}
 //Boolean=true false, when calling BallRelease(boolean true/false) in code, 
  //it will drop to here and open/close accordingly
public void BallRelease(boolean ball) {
    s1.set(ball);
}
public void BeltBall(float speed){
  BeltMotor1.set(speed);
}
public void LaunchBall(float speed){
  LaunchMotor1.set(speed);
  LaunchMotor2.set(speed);
}

  /**
   * Creates a new ExampleSubsystem.
   */ 

  //Declared varibles for Pneumatics

  //Boolean=true false, when calling BallRelease(boolean true/false) in code, 
  //it will drop to here and open/close accordingly
    // public void BallRelease(boolean ball) {
    //   s1.set(ball);
    // }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
