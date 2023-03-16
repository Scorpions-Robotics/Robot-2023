package frc.robot.commands.Autonomous;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.PIDCommand;
import frc.robot.subsystems.DriveSubsystem;

public class AutoStraightDrive2 extends PIDCommand {

  public AutoStraightDrive2(DriveSubsystem m_drive, double meters) {
    super(
        new PIDController(0.16, 0, 0),
        () -> m_drive.getStraightDriveDistance(),
        () -> meters * 100,

        output -> {
          m_drive.arcadeDrive(0, output);
        });

    getController().setTolerance(3);
  }

  @Override
  public boolean isFinished() {
    return getController().atSetpoint();
  }
}
