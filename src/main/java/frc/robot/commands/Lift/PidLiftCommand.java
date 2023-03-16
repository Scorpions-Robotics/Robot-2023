package frc.robot.commands.Lift;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.PIDCommand;
import frc.robot.subsystems.LiftSubsystem;

public class PidLiftCommand extends PIDCommand {

  public PidLiftCommand(LiftSubsystem m_lift, double position) {
    super(
        new PIDController(0.016, 0, 0),
        () -> m_lift.getEditedEncoderOutput(),
        () -> position,
        output -> {
          if (m_lift.getEditedEncoderOutput() > position) {
            m_lift.setMotor(Math.max(-output, -0.4));
          } else if (position > m_lift.getEditedEncoderOutput()) {
            m_lift.setMotor(Math.min(output, 0.4));
          }
        });
    getController().setTolerance(3);
  }

  @Override
  public boolean isFinished() {
    return getController().atSetpoint();
  }
}
