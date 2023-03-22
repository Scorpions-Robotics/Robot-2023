package frc.robot.commands.Lift;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.PIDCommand;
import frc.robot.subsystems.LiftSubsystem;
import java.util.function.DoubleSupplier;

public class PidLiftCommand extends PIDCommand {

  public boolean stop;

  public PidLiftCommand(LiftSubsystem m_lift, DoubleSupplier position) {
    super(
        new PIDController(0.0567, 0.01, 0),
        () -> m_lift.getEditedEncoderOutput(),
        () -> position.getAsDouble(),
        output -> {
          m_lift.pidSetMotor(output * -0.15);
          SmartDashboard.putNumber("liftEncoder", m_lift.getEditedEncoderOutput());
          SmartDashboard.putNumber("liftEncoder", position.getAsDouble());
        });
    getController().setTolerance(3);

    addRequirements(m_lift);
  }

  @Override
  public boolean isFinished() {
    // return false;
    return getController().atSetpoint();
  }
}
