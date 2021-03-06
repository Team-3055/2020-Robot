/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.Solenoid;
//import edu.wpi.first.wpilibj.DoubleSolenoid;
import frc.robot.Constants;

public class PneumaticSubsystem extends SubsystemBase {
  /**
   * Creates a new ExampleSubsystem.
   */ 

  //Declared varibles for Pneumatics
    private final Compressor c = new Compressor(Constants.PNUConstants.kCompressor);
  
    private final Solenoid s2 = new Solenoid(Constants.PNUConstants.kSolenoid2);
    private final Solenoid s3 = new Solenoid(Constants.PNUConstants.kSolenoid3);
   

  //Boolean=true false, when calling RobotLift(boolean true/false) in code, 
  //it will drop to here and open/close accordingly
    public void RobotLift(boolean lift) {
      s2.set(lift);
      s3.set(lift);
    }

   public PneumaticSubsystem() {
     this.c.start();
  }
 
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
