/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.XboxController.Button;
import frc.robot.subsystems.BallIntake;
import frc.robot.subsystems.ColorSubsystem;
import frc.robot.subsystems.DriveSubsystem;

import frc.robot.subsystems.MiscSubsystem;
import frc.robot.subsystems.PneumaticSubsystem;
import frc.robot.commands.BeltBallUp;
import frc.robot.commands.DownWinch;
import frc.robot.commands.IntakeBall;
import frc.robot.commands.LaunchBall;
import frc.robot.commands.RobotLift;
import frc.robot.commands.RunWinch;
import frc.robot.commands.SpinToColor;
import frc.robot.commands.SpinWheel;
import frc.robot.commands.StopWinch;
import frc.robot.commands.WheelLeft;
import frc.robot.commands.WheelRight;
import frc.robot.commands.WheelStop;
//import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import frc.robot.commands.TankDrive;
import edu.wpi.first.wpilibj2.command.Command;
//import frc.robot.commands.DefaultDrive;


//import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


//import frc.robot.commands.TankDrive;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;



import edu.wpi.first.wpilibj.Joystick;

/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final DriveSubsystem m_robotDrive = new DriveSubsystem();
  private final ColorSubsystem m_colorSensor = new ColorSubsystem();
  private final MiscSubsystem m_miscSubsystem = new MiscSubsystem();
  private final BallIntake m_intake = new BallIntake();
  private final PneumaticSubsystem m_pnu = new PneumaticSubsystem();
  //private final ExampleCommand m_autoCommand = new ExampleCommand(m_exampleSubsystem);
  Joystick m_driverRController = new Joystick(Constants.OIConstants.kRightControllerPort);
  Joystick m_driverLController = new Joystick(Constants.OIConstants.kLeftControllerPort);
  XboxController m_driver2Controller = new XboxController(Constants.OIConstants.kXboxControllerPort);
  
  
  
  /**
   * The container for the robot.  Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();

  
  // Configure default commands
    // Set the default drive command to split-stick arcade drive
    m_robotDrive.setDefaultCommand(
        // A split-stick arcade command, with forward/backward controlled by the left
        // hand, and turning controlled by the right.
        new TankDrive(
            m_robotDrive,
            () -> (m_driverRController.getRawAxis(1)*-1),
            () -> m_driverRController.getRawAxis(0)));
  }

  /**
   * Use this method to define your button->command mappings.  Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    //Sets the drive to run at half speed when either trigger is pressed
    new JoystickButton(m_driverRController, Constants.OIConstants.kJoystickTrigger)
        .whenPressed(() -> m_robotDrive.setMaxOutput(0.5))
        .whenReleased(() -> m_robotDrive.setMaxOutput(1));
    
    new JoystickButton(m_driverLController, Constants.OIConstants.kJoystickTrigger)
        .whenPressed(() -> m_robotDrive.setMaxOutput(0.5))
        .whenReleased(() -> m_robotDrive.setMaxOutput(1));
      
    new JoystickButton(m_driver2Controller, Button.kX.value).whenPressed(new SpinWheel(m_colorSensor));
    
    new JoystickButton(m_driver2Controller, Button.kBumperLeft.value)
        .whenPressed(new WheelLeft(m_colorSensor))
        .whenReleased(new WheelStop(m_colorSensor));
    
    new JoystickButton(m_driver2Controller, Button.kBumperRight.value)
        .whenPressed(new WheelRight(m_colorSensor))
        .whenReleased(new WheelStop(m_colorSensor));
    
    new JoystickButton(m_driver2Controller, Button.kBack.value).whenPressed(new SpinToColor(m_colorSensor));
    
    new JoystickButton(m_driver2Controller, Button.kBumperLeft.value)
        .whenPressed(new RunWinch(m_miscSubsystem))
        .whenReleased(new StopWinch(m_miscSubsystem));
    
    new JoystickButton(m_driver2Controller, Button.kBumperRight.value)
        .whenPressed(new DownWinch(m_miscSubsystem))
        .whenReleased(new StopWinch(m_miscSubsystem));
    
    new JoystickButton(m_driver2Controller, Button.kA.value).toggleWhenPressed(new IntakeBall(m_intake));
    
    new JoystickButton(m_driver2Controller, Button.kB.value).toggleWhenPressed(new BeltBallUp(m_intake));
    
    new JoystickButton(m_driver2Controller, Button.kY.value)
        .whenPressed(new LaunchBall(m_intake).withTimeout(5));

    new JoystickButton(m_driver2Controller, Button.kStart.value)
        .toggleWhenPressed(new RobotLift(m_pnu));
        
        
  }


  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return null;
  }
}
