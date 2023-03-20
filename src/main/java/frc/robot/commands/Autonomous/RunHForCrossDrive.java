package frc.robot.commands.Autonomous;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.PIDCommand;
import frc.robot.subsystems.DriveSubsystem;

public class RunHForCrossDrive extends PIDCommand {

  public RunHForCrossDrive(DriveSubsystem m_drive, double meters) {
    super(
        new PIDController(0.16, 0, 0),
        () -> m_drive.getHdriveStraightDriveDistance(),
        () -> meters * 100,
        output -> {
          double Y = output * 0.9;
          double hDriveFront = Y - m_drive.GetHeading() * 0.02;
          double hDriveBack = Y + m_drive.GetHeading() * 0.02;
          // -ler değişecek
          m_drive.RunRightLeftForCrossDrive(-hDriveFront, -hDriveBack);
        });

    getController().setTolerance(3);
  }

  @Override
  public boolean isFinished() {
    return getController().atSetpoint();
  }
}
