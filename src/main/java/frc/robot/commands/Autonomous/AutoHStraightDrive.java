package frc.robot.commands.Autonomous;

import java.util.function.DoubleSupplier;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.PIDCommand;
import frc.robot.subsystems.DriveSubsystem;

public class AutoHStraightDrive extends PIDCommand {

  public AutoHStraightDrive(DriveSubsystem m_drive, double meters, DoubleSupplier gyro) {
    super(
        new PIDController(0.16, 0, 0),
        () -> m_drive.getHdriveStraightDriveDistance(),
        () -> meters * 100,
        output -> {
          double Y = output * 0.9;
          double hDriveFront = Y - gyro.getAsDouble() * 0.02;
          double hDriveBack = Y + gyro.getAsDouble() * 0.02;
          m_drive.RunTogether(0, 0, -hDriveFront, -hDriveBack);
        });

    getController().setTolerance(3);
  }

  @Override
  public boolean isFinished() {
    return getController().atSetpoint();
  }
}
