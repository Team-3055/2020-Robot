/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import frc.robot.subsystems.BallIntake;
import edu.wpi.first.wpilibj2.command.CommandBase;


public class OutputBall extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final BallIntake m_subsystem;

  /**
   * Creates a new Ball Release Command.
   *
   * @param subsystem The subsystem used by this command.
   */
  public OutputBall(BallIntake subsystem) {
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
    m_subsystem.IntakeBall(1);

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m.subsystem.IntakeBall(0)
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}