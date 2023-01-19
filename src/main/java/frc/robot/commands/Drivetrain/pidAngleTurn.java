// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.Drivetrain;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.PIDCommand;
import frc.robot.subsystems.DriveSubsystem;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class pidAngleTurn extends PIDCommand {
  /** Creates a new pidAngleTurn. */
  DriveSubsystem m_drive;
  double angle;

  public pidAngleTurn(DriveSubsystem m_drive, double angle) {
    super(
        // The controller that the command will use
        new PIDController(0.012, 0.0005, 0.0040),
        // This should return the measurement
        () -> m_drive.GetHeading(),
        // This should return the setpoint (can also be a constant)
        () -> angle,
        // This uses the output
        output -> {
          // Use the output here
          if (m_drive.GetHeading() > angle) {
            m_drive.arcadeDrive(0, Math.max(-output, -0.30));
          } else {
            m_drive.arcadeDrive(0, Math.min(-output, 0.30));
          }

          SmartDashboard.putNumber("output", -output);
          SmartDashboard.putNumber("angle", angle);
          SmartDashboard.putNumber("heading", m_drive.GetHeading());



        });
    // Use addRequirements() here to declare subsystem dependencies.
    // Configure additional PID options by calling `getController` here.
    this.m_drive = m_drive;
    this.angle = angle;
    addRequirements(m_drive);
  }


  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return getController().atSetpoint();
  }
}
