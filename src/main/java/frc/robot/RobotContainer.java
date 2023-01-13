package frc.robot;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.DriveSubsystem;

public class RobotContainer {

DriveSubsystem m_drive;
  public RobotContainer() {

    configureBindings();
  }

  private void configureBindings() {


  }

  public Command getAutonomousCommand() {
    return null;
  }
}
