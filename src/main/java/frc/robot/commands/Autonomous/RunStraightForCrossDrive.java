package frc.robot.commands.Autonomous;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.PIDCommand;
import frc.robot.subsystems.DriveSubsystem;

public class RunStraightForCrossDrive extends PIDCommand {

  public RunStraightForCrossDrive(DriveSubsystem m_drive, double meters) {
    super(
        new PIDController(0.16, 0, 0),
        () -> m_drive.getStraightDriveDistance(),
        () -> meters * 100,
        output -> {
          double X = -output * 0.9;
          double rightSpeed = X + m_drive.GetHeading() * 0.01;
          double leftSpeed = X - m_drive.GetHeading() * 0.01;
          // -ler degisecek
          m_drive.RunStraightForCrossDrive(rightSpeed, leftSpeed);
        });

    getController().setTolerance(3);
  }

  @Override
  public boolean isFinished() {
    return getController().atSetpoint();
  }
}
