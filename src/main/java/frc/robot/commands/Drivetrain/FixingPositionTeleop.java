// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.Drivetrain;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.PIDCommand;
import frc.robot.subsystems.XboxSubsystem;
import frc.robot.subsystems.DriveSubsystem;
import java.util.function.DoubleSupplier;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class FixingPositionTeleop extends PIDCommand {

  DriveSubsystem m_drive;
  XboxSubsystem m_xbox;
  static double throttle;

  /** Creates a new FixingPositionTeleop. */
  public FixingPositionTeleop(DriveSubsystem m_drive, DoubleSupplier speedSupplier, XboxSubsystem m_xbox) {
    super(
        new PIDController(0.0012, 0.0001, 0.005),
        () -> m_drive.GetHeading(),
        () -> 0,
        output -> {
          throttle = m_xbox.getThrottleValue();
          m_drive.arcadeDrive(-output, speedSupplier.getAsDouble() * throttle);
        },
        m_drive);
    this.m_drive = m_drive;
    this.m_xbox = m_xbox;
    addRequirements();

  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
