package frc.robot.commands.Arm;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.PIDCommand;
import frc.robot.subsystems.ArmSubsystem;
import java.util.function.DoubleSupplier;

public class Rotate_Axis_3 extends PIDCommand {

  public Rotate_Axis_3(ArmSubsystem m_arm, DoubleSupplier degree) {
    super(
        new PIDController(0.00415, 0, 0),
        // 0.01, 0.0025, 0
        () -> -m_arm.getOutputAngle_Axis3,
        () -> degree.getAsDouble(),
        output -> {
          if (degree.getAsDouble() > m_arm.getOutputAngle_Axis3) {
            m_arm.Axis3MotorOutput(Math.max(-output, -0.25));
          } else if (m_arm.getOutputAngle_Axis3 > degree.getAsDouble()) {
            m_arm.Axis3MotorOutput(Math.min(-output, 0.25));
          }
        });
  }

  @Override
  public boolean isFinished() {
    // return getController().atSetpoint();
    /*
     * Double setpoint = getController().getSetpoint();
     * if (Math.abs(RobotContainer.m_arm.getOutputAngle_Axis3) > Math.abs(setpoint)
     * - 2.5
     * && Math.abs(RobotContainer.m_arm.getOutputAngle_Axis3) < Math.abs(setpoint) +
     * 2.5) {
     *
     * return true;
     * } else {
     *
     * return false;
     * }
     *
     * // return false;
     *
     */
    return false;
  }
}
