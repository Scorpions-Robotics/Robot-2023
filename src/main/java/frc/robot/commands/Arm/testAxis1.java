package frc.robot.commands.Arm;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.PIDCommand;
import frc.robot.subsystems.ArmSubsystem;

public class testAxis1 extends PIDCommand {

  public testAxis1(ArmSubsystem m_arm, double degree) {
    super(
        // 0.008, 0.02, 0.0001

        new PIDController(0.0545, 0, 0),
        // 0.001347
        () -> -m_arm.getOutputAngle2,
        () -> degree + 5,
        output -> {
          m_arm.editedAxis1MotorOutput(output * 0.9);
        });
    getController().setTolerance(2);
  }

  @Override
  public boolean isFinished() {
    // return getController().atSetpoint();
    /*
     * Double setpoint = getController().getSetpoint();
     * if (Math.abs(RobotContainer.m_arm.getOutputAngle2) > Math.abs(setpoint) - 2.5
     * && Math.abs(RobotContainer.m_arm.getOutputAngle2) < Math.abs(setpoint) + 2.5)
     * {
     *
     * return true;
     * } else {
     *
     * return false;
     * }
     */
    // return getController().atSetpoint();
    return false;
  }
}
