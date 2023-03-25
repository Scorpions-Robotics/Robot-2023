package frc.robot.commands.Arm;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.PIDCommand;
import frc.robot.subsystems.ArmSubsystem;

public class Rotate_Axis_2 extends PIDCommand {

  public Rotate_Axis_2(ArmSubsystem m_arm, double degree) {
    super(
        new PIDController(0.0055, 0, 0),
        () -> -m_arm.getOutputAngle_Axis2,
        () -> degree,
        output -> {
          if (degree > m_arm.getOutputAngle_Axis2) {
            m_arm.Axis2MotorOutput((Math.min(-output, 0.25) * 1));
          } else if (m_arm.getOutputAngle_Axis2 > degree) {
            m_arm.Axis2MotorOutput((Math.max(-output, -0.25) * 1));
          }
        });

    getController().setTolerance(5);
  }

  @Override
  public boolean isFinished() {
    return getController().atSetpoint();
    // return false;
  }
}
