package frc.robot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.Drivetrain.ChargeStationBalance;
import frc.robot.commands.Drivetrain.TeleoperatedDrive;
import frc.robot.commands.Drivetrain.pidAngleTurn;
import frc.robot.commands.Joystick.Throttle;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.XboxSubsystem;

public class RobotContainer {

XboxSubsystem m_xboxSubsystem = new XboxSubsystem();
DriveSubsystem m_drive = new DriveSubsystem();

Joystick joy = new Joystick(Constants.controller.controller);
JoystickButton button1 = new JoystickButton(joy, 1);
JoystickButton button2 = new JoystickButton(joy, 2);
JoystickButton button3 = new JoystickButton(joy, 3);
JoystickButton button4 = new JoystickButton(joy, 4);
JoystickButton button7 = new JoystickButton(joy, 7);
JoystickButton button8 = new JoystickButton(joy, 8);

  public RobotContainer() {

    m_drive.setDefaultCommand(
       new TeleoperatedDrive(
      m_drive,
      m_xboxSubsystem,
       () -> joy.getRawAxis(0),
       () -> joy.getRawAxis(1)
       ));

    configureBindings();
  }

  private void configureBindings() {

button1.whileTrue(new ChargeStationBalance(m_drive));
button2.whileTrue(new pidAngleTurn(m_drive,90));
button4.whileTrue(new InstantCommand(() -> m_drive.ResetGyro()));

button7.whileTrue(new Throttle(false, m_xboxSubsystem));
button8.whileTrue(new Throttle(true, m_xboxSubsystem));

  }

  public Command getAutonomousCommand() {
    return null;
  }
}
