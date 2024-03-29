package frc.robot.commands.Autonomous;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.PIDCommand;
import frc.robot.subsystems.DriveSubsystem;

public class AutoStraightDrive2 extends PIDCommand {

  public AutoStraightDrive2(DriveSubsystem m_drive, double meters) {
    super(
        new PIDController(1, 0, 0),
        () -> m_drive.getStraightDriveDistance(),
        () -> meters * 100,
        output -> {
          double X = -output * 0.9;
          double rightSpeed = X + m_drive.GetHeading() * 0.01;
          double leftSpeed = X - m_drive.GetHeading() * 0.01;
          // -ler degisecek
          m_drive.RunTogether(-Math.min(output, 1), -Math.max(-output, -1), 0.0, 0.0);

          SmartDashboard.putNumber("asd", meters * 100);
          SmartDashboard.putNumber("asad", m_drive.getStraightDriveDistance());
        });

    getController().setTolerance(3);
    addRequirements(m_drive);
  }

  @Override
  public boolean isFinished() {
    return getController().atSetpoint();
  }
}
