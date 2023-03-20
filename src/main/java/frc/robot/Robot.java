package frc.robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;

public class Robot extends TimedRobot {
  private Command m_autonomousCommand;

  private RobotContainer m_robotContainer;

  @Override
  public void robotInit() {
    // Instantiate our RobotContainer. This will perform all our button bindings,
    // and put our
    // autonomous chooser on the dashboard.
    for (int i = 0; i < 6; i++) {
      if (DriverStation.getJoystickIsXbox(i)) {
        Constants.Joysticks.xbox_port = i;
      }
      if (DriverStation.getJoystickName(i) == "Arduino") {
        Constants.Joysticks.panel_port = i;
      }
    }
    m_robotContainer = new RobotContainer();
    // m_robotContainer.m_drive.BrakeMode();
  }

  @Override
  public void robotPeriodic() {
    CommandScheduler.getInstance().run();
  }

  @Override
  public void disabledInit() {
    // m_robotContainer.m_arm.Axis1MotorStop();

  }

  @Override
  public void disabledPeriodic() {}

  /** This autonomous runs the autonomous command selected by your {@link RobotContainer} class. */
  @Override
  public void autonomousInit() {
    m_robotContainer.m_drive.ResetGyro();
    m_autonomousCommand = m_robotContainer.getAutonomousCommand();

    // schedule the autonomous command (example)
    if (m_autonomousCommand != null) {
      m_autonomousCommand.schedule();
    }
  }

  @Override
  public void autonomousPeriodic() {}

  @Override
  public void teleopInit() {

    for (int i = 0; i < 6; i++) {
      if (DriverStation.getJoystickIsXbox(i)) {
        Constants.Joysticks.xbox_port = i;
      }
      if (DriverStation.getJoystickName(i) == "Arduino") {
        Constants.Joysticks.panel_port = i;
      }
    }

    m_robotContainer.m_lift.reset();
    m_robotContainer.m_drive.ResetGyro();
    if (m_autonomousCommand != null) {
      m_autonomousCommand.cancel();
    }
  }

  @Override
  public void teleopPeriodic() {}

  @Override
  public void testInit() {
    CommandScheduler.getInstance().cancelAll();
  }

  @Override
  public void testPeriodic() {}

  @Override
  public void simulationInit() {}

  @Override
  public void simulationPeriodic() {}
}
