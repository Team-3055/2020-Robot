/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import frc.robot.subsystems.BallIntake;
import edu.wpi.first.wpilibj2.command.CommandBase;


public class BeltBallDown extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final BallIntake m_subsystem;

  /**
   * Creates a new Ball Release Command.
   *
   * @param subsystem The subsystem used by this command.
   */
  public BeltBallDown(BallIntake subsystem) {
    m_subsystem = subsystem;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(subsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  //BeltBall1 goes into the BallIntake subsytem, finds the BeltBall (the two motors), 
  //and sets them to 1 (fowards)
  @Override
  public void execute() {
    m_subsystem.BeltBall(-1);

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_subsystem.BeltBall(0);
  }

  // Returns true when the command should end.
  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
