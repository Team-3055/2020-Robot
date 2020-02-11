/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import frc.robot.subsystems.ColorSubsystem;
import edu.wpi.first.wpilibj2.command.CommandBase;

/**
 * A command that spins the color wheel 3 and a half times.
 */
public class SpinWheel extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final ColorSubsystem m_subsystem;
  private int halfSpinCount;
  private String startingColor;
  private String currentColor;
  private int seenColor;
  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public SpinWheel(ColorSubsystem subsystem) {
    m_subsystem = subsystem;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(subsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    int halfSpinCount = 0;
    String startingColor = m_subsystem.colorString;
    String currentColor = m_subsystem.colorString;
    int seenColor = 0;
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    while (halfSpinCount < 7) {
      currentColor = m_subsystem.colorString;
      if (currentColor != startingColor){
        seenColor = 1;
      }
      if ((currentColor == startingColor) && seenColor == 1){
        seenColor = 0;
        halfSpinCount++;
      }
      m_subsystem.ColorControl(1);
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
    return false;
  }
}
