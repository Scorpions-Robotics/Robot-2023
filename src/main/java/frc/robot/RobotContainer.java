package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.ConditionalCommand;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commandgroups.Autonomous.blue4;
import frc.robot.commandgroups.first;
import frc.robot.commandgroups.grabthecone2;
import frc.robot.commandgroups.grapthecone;
import frc.robot.commandgroups.idlefromdown;
import frc.robot.commandgroups.idlefromup;
import frc.robot.commandgroups.second;
import frc.robot.commands.Arm.Rotate_Axis_3;
import frc.robot.commands.Drivetrain.FixedTeleoperatedDrive;
import frc.robot.commands.Drivetrain.Fixer;
import frc.robot.commands.Gripper.GripperCommand;
import frc.robot.subsystems.ArmSubsystem;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.GripperSubsystem;
import frc.robot.subsystems.LiftSubsystem;
import frc.robot.subsystems.XboxSubsystem;

public class RobotContainer {
  XboxSubsystem m_xboxSubsystem = new XboxSubsystem();
  public static DriveSubsystem m_drive = new DriveSubsystem();
  public static LiftSubsystem m_lift = new LiftSubsystem();
  public static ArmSubsystem m_arm = new ArmSubsystem();
  public GripperSubsystem m_grip = new GripperSubsystem();
  Joystick joy = new Joystick(Constants.Joysticks.xbox_port);
  Joystick joy2 = new Joystick(Constants.Joysticks.port2);
  public static boolean abc;

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

  JoystickButton button1_2 = new JoystickButton(joy2, 1);
  JoystickButton button2_2 = new JoystickButton(joy2, 2);
  JoystickButton button3_2 = new JoystickButton(joy2, 3);
  JoystickButton button4_2 = new JoystickButton(joy2, 4);
  JoystickButton button5_2 = new JoystickButton(joy2, 5);
  JoystickButton button6_2 = new JoystickButton(joy2, 6);
  JoystickButton button7_2 = new JoystickButton(joy2, 7);
  JoystickButton button8_2 = new JoystickButton(joy2, 8);
  JoystickButton button9_2 = new JoystickButton(joy2, 9);
  JoystickButton button10_2 = new JoystickButton(joy2, 10);
  JoystickButton button11_2 = new JoystickButton(joy2, 11);
  JoystickButton button12_2 = new JoystickButton(joy2, 12);

  public RobotContainer() {

    m_drive.setDefaultCommand(
        new FixedTeleoperatedDrive(
            m_drive,
            m_xboxSubsystem,
            () -> -joy.getRawAxis(1),
            () -> joy.getRawAxis(0),
            () -> joy.getRawAxis(4)));
    configureBindings();

    /*
     * new PidLiftModeChanger(
     * m_lift,
     * () -> m_xboxSubsystem.getLiftValue()));
     *
     */
    /*
     * m_arm.setDefaultCommand(new ArmModeChanger2(m_arm,
     * m_xboxSubsystem));
     */
    // m_arm.setDefaultCommand(new Rotate_Axis_3(m_arm, ()-));
  }

  private void configureBindings() {
    // button2.whileTrue(new level2(m_arm, m_lift, m_xboxSubsystem));
    button3.whileTrue(new Fixer(m_drive));
    button5.whileTrue(new GripperCommand(-0.4, m_grip));
    button5.whileFalse(new GripperCommand(0, m_grip));
    button6.whileTrue(new GripperCommand(0.8, m_grip));
    button6.whileFalse(new GripperCommand(0, m_grip));

    // //button3.onTrue(new first(m_arm, m_lift));
    button7_2.onTrue(new grabthecone2(m_arm, m_lift));
    button8_2.onTrue(new grapthecone(m_arm, m_lift));
    button9_2.onTrue(new second(m_arm, m_lift));
    button10_2.onTrue(new first(m_arm, m_lift));
    button2_2.onTrue(
        new ConditionalCommand(
            new idlefromup(m_arm, m_lift), new idlefromdown(m_arm, m_lift), () -> m_lift.yukari));

    button3_2.whileTrue(new InstantCommand(() -> m_xboxSubsystem.modeChange(false)));
    button4_2.whileTrue(new InstantCommand(() -> m_xboxSubsystem.modeChange(true)));
    button3_2.onTrue(new Rotate_Axis_3(m_arm, () -> m_xboxSubsystem.getAxis3Value()));
    button4_2.onTrue(new Rotate_Axis_3(m_arm, () -> m_xboxSubsystem.getAxis3Value()));

    // button2.onTrue(new grapthecone(m_arm, m_lift));

    // button4.onTrue(
    // new second(m_arm, m_lift));

    // // button2.whileTrue(new Rotate_Axis_1(m_arm, 10));
    // button7.whileTrue(new GripperCommand(0.7, m_grip));
    // button8.whileTrue(new GripperCommand(-0.375, m_grip));
    // button7.whileFalse(new GripperCommand(0.1, m_grip));
    // button8.whileFalse(new GripperCommand(0.1, m_grip));
    // button5.whileTrue(new resetall(m_arm, m_lift));
    // button1_2.whileTrue(new grabthecone2(m_arm, m_lift));

    // burası çalışıyor ise
    // button1.whileTrue(new ChargeStationBalance(m_drive));
    /*
     * 2.+ ileri 1.+ geri
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
    // button1.whileTrue(new Rotate_Axis_2(m_arm, -20));
    // button2.whileTrue(new InstantCommand(() -> m_arm.Axis2MotorCoastMode()));
    // button2.whileFalse(new InstantCommand(() -> m_arm.Axis%2MotorBreakMode()));
    // button3.whileTrue(new ResetAxis2Encoder(m_arm));
    /*
     * button1.whileTrue(new AutoGyroDrive(m_drive));
     * button2.whileTrue(new Fixer(m_drive));
     * button3.whileTrue(new blue(m_lift, m_arm, m_drive));
     * button4.whileTrue(new coastall(m_arm, m_lift));
     */
    // button10.whileTrue(new Fixer(m_drive));
    // button9.whileTrue(new InstantCommand(() -> m_arm.Axis1MotorOutput(0.05)));
    // button9.whileFalse(new InstantCommand(() -> m_arm.Axis1MotorOutput(0.05)));
    // button9.whileTrue(new
    // pidAngleTurn(m_drive,m_drive.GetHeadingForFastReturn()));
    // button10.whileTrue(new PidLiftTest(m_lift, 350, false));
    // button9.whileTrue(new ResetLiftEncoder(m_lift));
    // button10.whileFalse(new PidLiftTest(m_lift, 0, true));
    // button1.whileTrue(new Rotate)
    // button2.whileTrue(new InstantCommand(() ->
    // m_xboxSubsystem.changeAxisValue(1)));

    // button3.whileTrue(new InstantCommand(() ->
    // m_xboxSubsystem.changeAxisValue(2)));

    // button4.whileTrue(new InstantCommand(() ->
    // m_xboxSubsystem.changeAxisValue(3)));

    // button5.whileTrue(new InstantCommand(() ->
    // m_xboxSubsystem.changeAxisValue(4)));
    // button10.whileTrue(new InstantCommand(() ->
    // m_xboxSubsystem.modeChange(false)));
    // button9.whileTrue(new InstantCommand(() ->
    // m_xboxSubsystem.modeChange(true)));
    // button10.onTrue(new Rotate_Axis_3(m_arm, () ->
    // m_xboxSubsystem.getAxis3Value()));
    // button9.onTrue(new Rotate_Axis_3(m_arm, () ->
    // m_xboxSubsystem.getAxis3Value()));
    // button2_2.whileTrue(new AutoStraightDrive2(m_drive, -1));

    // button1.whileTrue(new ArmModeChanger2(m_arm, m_xboxSubsystem));
    // button7.whileTrue(new Throttle(false, m_xboxSubsystem));
    // button8.whileTrue(new Throttle(true, m_xboxSubsystem));
    // button9.whileTrue(new RotateAxis1(m_arm));
    // button10.whileTrue(new StabilizeMode(true,m_xboxSubsystem,m_drive));
  }

  public Command getAutonomousCommand() {

    // return new blue4(m_drive, m_arm, m_lift, m_grip);
    return new blue4(m_drive, m_arm, m_lift, m_grip);
  }
}
