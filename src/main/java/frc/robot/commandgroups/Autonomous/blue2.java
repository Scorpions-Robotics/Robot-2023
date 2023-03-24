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
import frc.robot.subsystems.LiftSubsystem;

public class blue2 extends SequentialCommandGroup {
  public blue2(DriveSubsystem m_drive, ArmSubsystem m_arm, LiftSubsystem m_lift) {
    addCommands(
        new PidLiftCommand(m_lift, () -> 400)
            .alongWith(new ArmModeChanger3(m_arm, -18, -130, 0))
            .withTimeout(2)
            .andThen(
                new PidLiftCommand(m_lift, () -> -110)
                    .alongWith(new ArmModeChanger3(m_arm, -3.5, -2.5, 0))));
  }
}
