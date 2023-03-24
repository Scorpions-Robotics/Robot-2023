package frc.robot.commandgroups.Autonomous;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.Arm.ArmModeChanger3;
import frc.robot.commands.Autonomous.AutoHStraightDrive;
import frc.robot.commands.Autonomous.AutoStraightDrive2;
import frc.robot.commands.Gripper.GripperCommand;
import frc.robot.commands.Lift.PidLiftCommand;
import frc.robot.subsystems.ArmSubsystem;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.GripperSubsystem;
import frc.robot.subsystems.LiftSubsystem;

public class blue3 extends SequentialCommandGroup {
  public blue3(DriveSubsystem m_drive, ArmSubsystem m_arm, LiftSubsystem m_lift, GripperSubsystem m_grip) {
    addCommands(
        new PidLiftCommand(m_lift, () -> 350)
            .alongWith(new ArmModeChanger3(m_arm, 0, -135, 0))
            .withTimeout(2)
            .andThen(new GripperCommand(.5, m_grip))
            .withTimeout(1)
            .andThen(new InstantCommand(() -> m_grip.push(0))
                .andThen(new PidLiftCommand(m_lift, () -> -7))
                .alongWith(new ArmModeChanger3(m_arm, -20, 0, 0)))
            .alongWith(new AutoStraightDrive2(m_drive, -100))
            .andThen(new AutoHStraightDrive(m_drive, 50))
            .andThen(new AutoStraightDrive2(m_drive, 80)));
  }
}
