package frc.robot;

import edu.wpi.first.wpilibj.AddressableLED;
import edu.wpi.first.wpilibj.AddressableLEDBuffer;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;

public class Robot extends TimedRobot {
  private Command m_autonomousCommand;
  private static RobotContainer m_robotContainer;
  public static SendableChooser<Integer> auto_chooser = new SendableChooser<>();
  public AddressableLED m_led;
  public AddressableLEDBuffer m_ledBuffer;
  public int m_rainbowFirstPixelHue = 60;

  public void rainbow() {
    // For every pixel
    for (var i = 0; i < m_ledBuffer.getLength(); i++) {
      // Calculate the hue - hue is easier for rainbows because the color
      // shape is a circle so only one value needs to precess
      final var hue = (m_rainbowFirstPixelHue + (i * 180 / m_ledBuffer.getLength())) % 180;
      // Set the value
      m_ledBuffer.setHSV(i, hue, 255, 128);
    }
    // Increase by to make the rainbow "move"
    m_rainbowFirstPixelHue += 3;
    // Check bounds
    m_rainbowFirstPixelHue %= 180;
  }

  @Override
  public void robotInit() {
    auto_chooser.setDefaultOption("otonom31", 1);
    auto_chooser.addOption("otonom31", 1);
    auto_chooser.addOption("otonom36", 2);

    // PWM port 9
    // Must be a PWM header, not MXP or DIO
    m_led = new AddressableLED(9);

    // Reuse buffer
    // Default to a length of 60, start empty output
    // Length is expensive to set, so only set it once, then just update data
    m_ledBuffer = new AddressableLEDBuffer(240);
    m_led.setLength(m_ledBuffer.getLength());

    // Set the data
    m_led.setData(m_ledBuffer);
    m_led.start();

    SmartDashboard.putData(auto_chooser);

    m_robotContainer = new RobotContainer();
    // m_robotContainer.m_drive.BrakeMode();
  }

  @Override
  public void robotPeriodic() {
    CommandScheduler.getInstance().run();
    rainbow();
    m_led.setData(m_ledBuffer);
  }

  @Override
  public void disabledInit() {
    // m_robotContainer.m_arm.Axis1MotorStop();
    m_robotContainer.m_lift.coastmode();
    m_robotContainer.m_arm.Axis2MotorCoastMode();
    m_robotContainer.m_arm.Axis1MotorCoastMode();

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
    // robotContainer.m_lift.brakemod();
    // m_robotContainer.m_arm.Axis1MotorBreakMode();
    // m_robotContainer.m_arm.Axis2MotorBreakMode();
    // m_robotContainer.m_arm.Axis3MotorBreakMode();

    // schedule the autonomous command (example)
    if (m_autonomousCommand != null) {
      m_autonomousCommand.schedule();
    }
    m_robotContainer.m_lift.reset();
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
    m_robotContainer.m_lift.brakemod();
    // m_robotContainer.m_lift.reset();
    // m_robotContainer.m_drive.ResetGyro();
    if (m_autonomousCommand != null) {
      m_autonomousCommand.cancel();
    }
    m_robotContainer.m_arm.Axis2MotorBreakMode();
    m_robotContainer.m_arm.Axis1MotorBreakMode();
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
