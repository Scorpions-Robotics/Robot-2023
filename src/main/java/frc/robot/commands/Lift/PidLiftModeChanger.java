package frc.robot.commands.Lift;

import java.util.function.DoubleSupplier;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.networktables.DoubleSubscriber;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.PIDCommand;
import frc.robot.subsystems.LiftSubsystem;
import frc.robot.subsystems.XboxSubsystem;

public class PidLiftTest extends PIDCommand {

  public boolean stop;

  public PidLiftTest(LiftSubsystem m_lift, XboxSubsystem m_xbox, boolean stop) {
    super(
        new PIDController(0.056, 0, 0),
        () -> m_lift.getEditedEncoderOutput(),
        () -> m_xbox.getLiftValue(),
        output -> {
          m_lift.pidSetMotor(output * -0.7);
          SmartDashboard.putNumber("liftEncoder", m_lift.getEditedEncoderOutput());
          SmartDashboard.putNumber("liftEncoder", m_xbox.getLiftValue());
        });
    getController().setTolerance(3);
    this.stop = stop;
  }

  @Override
  public boolean isFinished() {
    return stop;
    // return getController().atSetpoint();
  }
}
