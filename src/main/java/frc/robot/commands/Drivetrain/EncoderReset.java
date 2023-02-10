// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.Drivetrain;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveSubsystem;

public class EncoderReset extends CommandBase {
  DriveSubsystem m_drive;
  public EncoderReset(DriveSubsystem m_drive) {
    this.m_drive = m_drive;
  }

  @Override
  public void initialize() {
    //m_drive.ResetEncoders();
  }

  @Override
  public void execute() {}

  @Override
  public void end(boolean interrupted) {}

  @Override
  public boolean isFinished() {
    return false;
  }
}
