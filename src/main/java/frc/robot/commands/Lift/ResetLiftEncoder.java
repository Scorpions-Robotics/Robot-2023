package frc.robot.commands.Lift;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.LiftSubsystem;

public class ResetLiftEncoder extends CommandBase {
  LiftSubsystem m_lift;

  public ResetLiftEncoder(LiftSubsystem m_lift) {
    this.m_lift = m_lift;
  }

  @Override
  public void initialize() {
  }

  @Override
  public void execute() {
    m_lift.reset();
  }

  @Override
  public void end(boolean interrupted) {
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
