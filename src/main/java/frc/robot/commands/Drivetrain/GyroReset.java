package frc.robot.commands.Drivetrain;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveSubsystem;
public class GyroReset extends CommandBase {

  DriveSubsystem m_drive;

  public GyroReset(DriveSubsystem m_drive) {
    this.m_drive = m_drive;
  }

  @Override
  public void initialize() {
    m_drive.ResetGyro();
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
