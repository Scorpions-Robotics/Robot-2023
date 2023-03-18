package frc.robot.commands.Autonomous;

import java.util.function.DoubleSupplier;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.PIDCommand;
import frc.robot.subsystems.DriveSubsystem;

public class AutoStraightDrive2 extends PIDCommand {

  public AutoStraightDrive2(DriveSubsystem m_drive, double meters, DoubleSupplier gyro) {
    super(
        new PIDController(0.16, 0, 0),
        () -> m_drive.getStraightDriveDistance(),
        () -> meters * 100,
        output -> {
          double X = -output * 0.9;
          double rightSpeed = X + gyro.getAsDouble() * 0.01;
          double leftSpeed = X - gyro.getAsDouble() * 0.01;
          m_drive.RunTogether(rightSpeed, leftSpeed,
              0.0, 0.0);
        });

    getController().setTolerance(3);
  }

  @Override
  public boolean isFinished() {
    return getController().atSetpoint();
  }
}
