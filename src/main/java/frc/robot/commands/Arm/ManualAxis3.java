package frc.robot.commands.Arm;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ArmSubsystem;

public class ManualAxis3 extends CommandBase {
  ArmSubsystem m_arm;

  public ManualAxis3(ArmSubsystem m_arm) {
    this.m_arm = m_arm;
  }

  @Override
  public void initialize() {
  }

  @Override
  public void execute() {
    m_arm.Axis3MotorOutput(-0.3);
  }

  @Override
  public void end(boolean interrupted) {
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
