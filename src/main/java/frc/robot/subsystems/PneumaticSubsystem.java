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
import edu.wpi.first.wpilibj.DoubleSolenoid;
import frc.robot.Constants;

public class PneumaticSubsystem extends SubsystemBase {
  /**
   * Creates a new ExampleSubsystem.
   */ 
    private final Compressor c = new Compressor(Constants.PNUConstants.kCompressor);
    private final Solenoid s1 = new Solenoid(Constants.PNUConstants.kSolenoid1);
    private final Solenoid s2 = new Solenoid(Constants.PNUConstants.kSolenoid2);

/*   public PneumaticSubsystem() {
  }
 */
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
