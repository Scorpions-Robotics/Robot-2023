package frc.robot.commands.Autonomous;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.DriveSubsystem;

public class HStraightDrive extends CommandBase {
  private final DriveSubsystem m_drive;

  private final PIDController pidControllerLeft =
      new PIDController(Constants.PID.kP, Constants.PID.kI, Constants.PID.kD);

  private final PIDController pidControllerRight =
      new PIDController(Constants.PID.kP, Constants.PID.kI, Constants.PID.kD);

  private final double POSITION_TOLERANCE = Constants.PID.POSITION_TOLERANCE;
  private final double VELOCITY_TOLERANCE = Constants.PID.VELOCITY_TOLERANCE;

  public HStraightDrive(DriveSubsystem m_drive, double meters) {

    this.m_drive = m_drive;
    addRequirements(m_drive);

    pidControllerLeft.setTolerance(POSITION_TOLERANCE, VELOCITY_TOLERANCE);
    pidControllerLeft.setSetpoint(meters);

    pidControllerRight.setTolerance(POSITION_TOLERANCE, VELOCITY_TOLERANCE);
    pidControllerRight.setSetpoint(meters);
  }

  @Override
  public void initialize() {}

  @Override
  public void execute() {
    double pidResultLeft = pidControllerLeft.calculate(m_drive.getLeftHEncoderDistance());
    double pidResultRight = pidControllerRight.calculate(m_drive.getRigthHEncoderDistance());

    m_drive.runHRightMotor(pidResultRight);
    m_drive.runHLeftMotor(pidResultLeft);
  }

  @Override
  public void end(boolean interrupted) {
    m_drive.stopHmotors();
  }

  @Override
  public boolean isFinished() {
    return pidControllerLeft.atSetpoint() && pidControllerRight.atSetpoint();
  }
}
