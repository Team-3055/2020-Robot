/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import frc.robot.subsystems.ColorSubsystem;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj.DriverStation;
/**
 * A command that spins the color wheel 3 and a half times.
 */
public class SpinToColor extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final ColorSubsystem m_subsystem;
  private String gameData;
  private boolean ColorSet;
  private String SpinToColor;
  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public SpinToColor(ColorSubsystem subsystem) {
    m_subsystem = subsystem;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(subsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
   
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    this.gameData = DriverStation.getInstance().getGameSpecificMessage();
if(gameData.length() > 0)
{
  switch (gameData.charAt(0))
  {
    case 'B' :
      //Blue case code
      this.SpinToColor = "Red";
      break;
    case 'G' :
      //Green case code
      this.SpinToColor = "Yellow";
      break;
    case 'R' :
      //Red case code
      this.SpinToColor = "Blue";
      break;
    case 'Y' :
      //Yellow case code
      this.SpinToColor = "Green";
      break;
    default :
      //This is corrupt data
      break;
  }
} else {
  //Code for no data received yet
}
    m_subsystem.ColorControl(1);
    String DetectedColor = m_subsystem.getColor();
    if(DetectedColor == SpinToColor){
        this.ColorSet = true;
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_subsystem.ColorControl(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return (this.ColorSet);
  }
}
