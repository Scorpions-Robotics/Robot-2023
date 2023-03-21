package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;

public class Robot extends TimedRobot {
  private Command m_autonomousCommand;
  private RobotContainer m_robotContainer;
  public static SendableChooser<Integer> auto_chooser = new SendableChooser<>();

  @Override
  public void robotInit() {
    auto_chooser.setDefaultOption("otonom31", 1);
    auto_chooser.addOption("otonom31", 1);
    auto_chooser.addOption("otonom36", 2);

    SmartDashboard.putData(auto_chooser);

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
  public void disabledPeriodic() {
  }

  /**
   * This autonomous runs the autonomous command selected by your
   * {@link RobotContainer} class.
   */
  @Override
  public void autonomousInit() {
    m_robotContainer.m_drive.ResetGyro();
    m_robotContainer.m_drive.ResetEncoders();
    m_robotContainer.m_arm.Axis1EncoderReset();
    m_robotContainer.m_arm.Axis2EncoderReset();
    m_robotContainer.m_arm.Axis3EncoderReset();
    m_robotContainer.m_lift.reset();
    m_robotContainer.m_lift.brakemod();
    m_robotContainer.m_arm.Axis1MotorBreakMode();
    m_robotContainer.m_arm.Axis2MotorBreakMode();
    m_robotContainer.m_arm.Axis3MotorBreakMode();

    // schedule the autonomous command (example)
    if (m_autonomousCommand != null) {
      m_autonomousCommand.schedule();
    }
    RobotContainer.m_lift.reset();
    m_autonomousCommand = m_robotContainer.getAutonomousCommand(auto_chooser.getSelected());

  }

  @Override
  public void autonomousPeriodic() {
  }

  @Override
  public void teleopInit() {

    // for (int i = 0; i < 6; i++) {
    // if (DriverStation.getJoystickIsXbox(i)) {
    // Constants.Joysticks.xbox_port = i;
    // }
    // if (DriverStation.getJoystickName(i) == "Arduino") {
    // Constants.Joysticks.panel_port = i;
    // }
    // }

    // m_robotContainer.m_lift.reset();
    // m_robotContainer.m_drive.ResetGyro();
    if (m_autonomousCommand != null) {
      m_autonomousCommand.cancel();
    }
  }

  @Override
  public void teleopPeriodic() {
  }

  @Override
  public void testInit() {
    CommandScheduler.getInstance().cancelAll();
  }

  @Override
  public void testPeriodic() {
  }

  @Override
  public void simulationInit() {
  }

  @Override
  public void simulationPeriodic() {
  }
}
