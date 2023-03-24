package frc.robot.commands.Arm;

import edu.wpi.first.math.controller.ProfiledPIDController;
import edu.wpi.first.math.trajectory.TrapezoidProfile;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ArmSubsystem;

public class ArmModeChanger3 extends CommandBase {
  ArmSubsystem m_arm;
  double motor1output;
  double motor2output;
  double motor3output;

  double axis1;
  double axis2;
  double axis3;

  ProfiledPIDController controller = new ProfiledPIDController(0.045, 0, 0,
      new TrapezoidProfile.Constraints(5, 10));
  ProfiledPIDController controller2 = new ProfiledPIDController(0.0055, 0, 0,
      new TrapezoidProfile.Constraints(5, 10));
  ProfiledPIDController controller3 = new ProfiledPIDController(0.065, 0, 0,
      new TrapezoidProfile.Constraints(5, 10));

  public ArmModeChanger3(ArmSubsystem m_arm, double axis1, double axis2, double axis3) {
    this.m_arm = m_arm;

    this.axis1 = axis1;
    this.axis2 = axis2;
    this.axis3 = axis3;

    m_arm.Axis1MotorBreakMode();
    m_arm.Axis2MotorBreakMode();
    m_arm.Axis3MotorBreakMode();

    addRequirements(m_arm);
  }

  @Override
  public void initialize() {
  }

  @Override
  public void execute() {

    controller.setGoal(axis1);
    controller2.setGoal(axis2);
    controller3.setGoal(axis3);

    controller.setTolerance(3);
    controller2.setTolerance(3);
    controller3.setTolerance(3);

    motor1output = controller.calculate(-m_arm.getOutputAngle2);
    motor2output = controller2.calculate(-m_arm.getOutputAngle_Axis2);
    motor3output = controller3.calculate(-m_arm.getOutputAngle_Axis3);

    SmartDashboard.putNumber("axis3value1234", motor3output);

    if (axis1 + 5 > -m_arm.getOutputAngle2) {
      m_arm.Axis1MotorOutput(Math.max(-motor1output, -0.25));
    } else if (-m_arm.getOutputAngle2 > axis1 + 5) {
      m_arm.Axis1MotorOutput(Math.min(-motor1output, 0.25));
    }

    if (axis2 > m_arm.getOutputAngle_Axis2) {
      m_arm.Axis2MotorOutput((Math.min(-motor2output, 0.20) * 1.6));
    } else if (m_arm.getOutputAngle_Axis2 > axis2) {
      m_arm.Axis2MotorOutput((Math.max(-motor2output, -0.20) * 1.6));
    }

    if (axis3 > m_arm.getOutputAngle_Axis3) {
      m_arm.Axis3MotorOutput(Math.max(-motor3output, -0.25));

    } else if (m_arm.getOutputAngle_Axis3 > axis3) {
      m_arm.Axis3MotorOutput(Math.min(-motor3output, 0.25));
    }
  }

  @Override
  public void end(boolean interrupted) {
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
