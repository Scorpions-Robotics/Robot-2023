package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commandgroups.TurnToGivenAngle;
import frc.robot.commands.Autonomous.AutoStraightDrive;
//import frc.robot.commandgroups.Autonomous.ArmMovement1;
//import frc.robot.commands.Arm.ResetAxis1Encoder;
//import frc.robot.commands.Arm.Rotate_Axis_1;
//import frc.robot.commands.Arm.Rotate_Axis_2;
//import frc.robot.commands.Arm.Rotate_Axis_3;
import frc.robot.commands.Drivetrain.EncoderReset;
import frc.robot.commands.Drivetrain.GyroReset;
import frc.robot.commands.Drivetrain.TeleoperatedDrive;
import frc.robot.commands.Drivetrain.pidAngleTurn;
import frc.robot.commands.Drivetrain.trycommand;
import frc.robot.commands.Joystick.StabilizeMode;
import frc.robot.commands.Joystick.Throttle;
import frc.robot.commands.Lift.ManualLift;
//import frc.robot.subsystems.ArmSubsystem;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.LiftSubsystem;
import frc.robot.subsystems.XboxSubsystem;
import frc.robot.subsystems.VisionSubsystem;

public class RobotContainer {

  XboxSubsystem m_xboxSubsystem = new XboxSubsystem();
  public static DriveSubsystem m_drive = new DriveSubsystem();
  public LiftSubsystem m_lift = new LiftSubsystem();
  // public static VisionSubsystem m_vision = new VisionSubsystem();

  // public static ArmSubsystem m_arm = new ArmSubsystem();

  Joystick joy = new Joystick(Constants.controller.controller);
  JoystickButton button1 = new JoystickButton(joy, 1);
  JoystickButton button2 = new JoystickButton(joy, 2);
  JoystickButton button3 = new JoystickButton(joy, 3);
  JoystickButton button4 = new JoystickButton(joy, 4);
  JoystickButton button5 = new JoystickButton(joy, 5);
  JoystickButton button6 = new JoystickButton(joy, 6);
  JoystickButton button7 = new JoystickButton(joy, 7);
  JoystickButton button8 = new JoystickButton(joy, 8);
  JoystickButton button9 = new JoystickButton(joy, 9);
  JoystickButton button10 = new JoystickButton(joy, 10);

  public RobotContainer() {

    m_drive.setDefaultCommand(
        new TeleoperatedDrive(
            m_drive,
            m_xboxSubsystem,
            () -> joy.getRawAxis(4),
            () -> joy.getRawAxis(5),
            () -> joy.getRawAxis(0)));
    configureBindings();
  }

  private void configureBindings() {
    // button1.whileTrue(new ChargeStationBalance(m_drive));
    /*
     * button1.onTrue(new Rotate_Axis_1(m_arm,120));
     * button2.onTrue(new ResetAxis1Encoder(m_arm));
     * button3.onTrue(new InstantCommand(() -> m_arm.Axis1MotorCoastMode()));
     * button3.onFalse(new InstantCommand(() -> m_arm.Axis1MotorBreakMode()));
     * button4.onTrue(new InstantCommand(() -> m_arm.Axis2MotorCoastMode()));
     * button4.onFalse(new InstantCommand(() -> m_arm.Axis2MotorBreakMode()));
     * button5.onFalse(new InstantCommand(() -> m_arm.Axis3MotorBreakMode()));
     * button5.onTrue(new InstantCommand(() -> m_arm.Axis3MotorCoastMode()));
     * button6.onTrue(new Rotate_Axis_3(m_arm,-180));
     * button7.onTrue(new ArmMovement1(m_arm));
     */
    // button2.whileTrue(new pidAngleTurn(m_drive,90));
    // button4.whileTrue(new InstantCommand(() -> m_drive.ResetGyro()));
    // button2.whileTrue(new TurnToGivenAngle(m_drive,-90));
    // button3.whileTrue(new GyroReset(m_drive));
    // button4.whileTrue(new TurnToGivenAngle(m_drive,90));
    // button6.whileTrue(new EncoderReset(m_drive));
    // button10.whileTrue(new AutoStraightDrive(m_drive, 1,true , false));
    // button10.whileTrue(new TryLift(m_lift, true));
    button5.whileTrue(new ManualLift(m_lift, true));
    button6.whileTrue(new ManualLift(m_lift, false));
    button5.whileFalse(new InstantCommand(() -> m_lift.stop()));
    button6.whileFalse(new InstantCommand(() -> m_lift.stop()));
    // button9.whileTrue(new
    // pidAngleTurn(m_drive,m_drive.GetHeadingForFastReturn()));
    button7.whileTrue(new Throttle(false, m_xboxSubsystem));
    button8.whileTrue(new Throttle(true, m_xboxSubsystem));
    // button9.whileTrue(new RotateAxis1(m_arm));
    // button10.whileTrue(new StabilizeMode(true,m_xboxSubsystem,m_drive));
  }

  public Command getAutonomousCommand() {
    return null;
  }
}
