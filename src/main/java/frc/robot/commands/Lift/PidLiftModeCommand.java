package frc.robot.commands.Lift;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.LiftSubsystem;

public class PidLiftModeCommand extends CommandBase {

  public PIDController m_controller = new PIDController(1, 0, 0);
  public LiftSubsystem m_lift;
  public double modetopulse;

  public PidLiftModeCommand(LiftSubsystem m_lift, int mode) {
    if (mode == 0) {
      modetopulse = 0;
    } else if (mode == 1) {
      modetopulse = 150;
    } else if (mode == 2) {
      modetopulse = 400;
    } else if (mode == 3) {
      modetopulse = 700;
    }
    m_controller.setTolerance(3);
    m_controller.setSetpoint(modetopulse);
  }

  @Override
  public void initialize() {
  }

  @Override
  public void execute() {
    if (m_controller.getSetpoint() > m_lift.getEditedEncoderOutput()) {
      m_lift.setMotor(Math.min(0.4, m_controller.calculate(m_lift.getEditedEncoderOutput())));
    } else if (m_lift.getEditedEncoderOutput() > m_controller.getSetpoint()) {
      m_lift.setMotor(Math.max(-0.4, -m_controller.calculate(m_lift.getEditedEncoderOutput())));
    }
  }

  @Override
  public void end(boolean interrupted) {
  }

  @Override
  public boolean isFinished() {
    return m_controller.atSetpoint();
  }
}
