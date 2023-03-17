package frc.robot.commands.Drivetrain;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveSubsystem;

public class trycommand extends CommandBase {
  DriveSubsystem m_drive;

  public trycommand(DriveSubsystem m_drive) {
    this.m_drive = m_drive;
    addRequirements(m_drive);
  }

  @Override
  public void initialize() {
  }

  @Override
  public void execute() {
    m_drive.motor4();
  }

  @Override
  public void end(boolean interrupted) {
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
