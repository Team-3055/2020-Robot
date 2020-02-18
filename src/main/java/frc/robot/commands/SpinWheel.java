/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import frc.robot.subsystems.ColorSubsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
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
  private boolean colorHasChanged;
  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public SpinWheel(ColorSubsystem subsystem) {
    m_subsystem = subsystem;
    this.halfSpinCount = 0;
    this.startingColor = m_subsystem.getColor();
    this.currentColor = m_subsystem.getColor();
    this.colorHasChanged = false;
    
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(subsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    this.halfSpinCount = 0;
    this.startingColor = m_subsystem.getColor();
    this.currentColor = m_subsystem.getColor();
    this.colorHasChanged = false;
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    
      this.currentColor = m_subsystem.getColor();
      if (this.currentColor != this.startingColor){
        this.colorHasChanged = true;
      }
      if ((this.currentColor == this.startingColor) && this.colorHasChanged){
        this.colorHasChanged = false;
        this.halfSpinCount++;
      }
      m_subsystem.ColorControl(1);
      SmartDashboard.putNumber("Half Spin Count", this.halfSpinCount);
    
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_subsystem.ColorControl(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return (this.halfSpinCount >= 7);
  }
}
