package frc.robot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.commands.Drivetrain.TeleoperatedDrive;
import frc.robot.subsystems.DriveSubsystem;

public class RobotContainer {

DriveSubsystem m_drive;
Joystick joy = new Joystick(Constants.controller.controller);

  public RobotContainer() {
    m_drive.setDefaultCommand(
       new TeleoperatedDrive(
      m_drive,
       () -> joy.getX(),
       () -> joy.getY(),
       () -> joy.getThrottle()));
    configureBindings();
  }

  private void configureBindings() {


  }

  public Command getAutonomousCommand() {
    return null;
  }
}
