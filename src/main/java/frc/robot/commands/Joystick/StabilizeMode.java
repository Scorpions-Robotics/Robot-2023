package frc.robot.commands.Joystick;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.XboxSubsystem;

public class StabilizeMode extends CommandBase {
  Boolean mode;
  XboxSubsystem m_xboxsubsystem;
  DriveSubsystem m_drive;
  public StabilizeMode(Boolean mode,XboxSubsystem m_xboxsubsystem, DriveSubsystem m_drive) {
    this.mode = mode;
    this.m_xboxsubsystem = m_xboxsubsystem;
    this.m_drive = m_drive;
  }

  @Override
  public void initialize() {
    if(mode){
      m_xboxsubsystem.turnonstabilmode();
      m_drive.ResetEncoders();
    }
    else{
      m_xboxsubsystem.turnoffstabilmode();
    }
  }

  @Override
  public void execute() {

  }

  @Override
  public void end(boolean interrupted) {}

  @Override
  public boolean isFinished() {
    return false;
  }
}
