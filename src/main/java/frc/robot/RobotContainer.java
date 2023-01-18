package frc.robot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.Drivetrain.ChargeStationBalance;
import frc.robot.commands.Drivetrain.TeleoperatedDrive;
import frc.robot.subsystems.DriveSubsystem;

public class RobotContainer {

DriveSubsystem m_drive = new DriveSubsystem();
Joystick joy = new Joystick(Constants.controller.controller);
JoystickButton button1 = new JoystickButton(joy, 1);
  public RobotContainer() {

    m_drive.setDefaultCommand(
       new TeleoperatedDrive(
      m_drive,
       () -> joy.getRawAxis(0),
       () -> joy.getRawAxis(1),
       () -> joy.getThrottle()));

    configureBindings();
  }

  private void configureBindings() {
button1.whileTrue(new ChargeStationBalance(m_drive));

  }

  public Command getAutonomousCommand() {
    return null;
  }
}
