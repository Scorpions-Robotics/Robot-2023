package frc.robot.commands.Joystick;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.XboxSubsystem;

public class Throttle extends CommandBase {
  boolean mode;
  XboxSubsystem m_xboxSubsystem;

  public Throttle(boolean mode, XboxSubsystem m_xboxSubsystem) {
    this.mode = mode;
    this.m_xboxSubsystem = m_xboxSubsystem;
  }

  @Override
  public void initialize() {
    if (mode == true) {

      m_xboxSubsystem.modeincrease();
    } else {
      m_xboxSubsystem.modedecrease();
    }
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
