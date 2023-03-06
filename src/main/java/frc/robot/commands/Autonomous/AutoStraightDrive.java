package frc.robot.commands.Autonomous;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.PIDCommand;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.Constants.PID;

public class AutoStraightDrive extends PIDCommand {
  DriveSubsystem m_drive;

  public AutoStraightDrive(DriveSubsystem m_drive, double meters, boolean reversed, boolean hDrive) {
    super(
        new PIDController(PID.kP, PID.kI, PID.kD),
        () -> hDrive ? m_drive.getStraightDriveDistance() : m_drive.getHdriveStraightDriveDistance(),
        () -> reversed ? -meters * 100 : meters * 100,
        output -> {
          m_drive.arcadeDrive(0, -output);
          if (hDrive) {
            SmartDashboard.putNumber("meters", m_drive.getStraightDriveDistance());
          } else {
            SmartDashboard.putNumber("meters", m_drive.getHdriveStraightDriveDistance());
          }
          SmartDashboard.putNumber("setpoint", reversed ? -meters * 100 : meters * 100);
        });
    getController().setTolerance(4);
    this.m_drive = m_drive;
  }

  @Override
  public void initialize() {
    m_drive.ResetEncoders();
    m_drive.BrakeMode();
  }

  @Override
  public void end(boolean interrupted) {
    m_drive.StopMotors();
  }

  @Override
  public boolean isFinished() {
    return getController().atSetpoint();
  }
}