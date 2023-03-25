package frc.robot.commandgroups.Autonomous;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.Arm.Rotate_Axis_2;
import frc.robot.commands.Autonomous.AutoStraightDrive2;
import frc.robot.commands.Gripper.GripperCommand;
import frc.robot.commands.Lift.PidLiftCommand;
import frc.robot.subsystems.ArmSubsystem;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.GripperSubsystem;
import frc.robot.subsystems.LiftSubsystem;

public class blue extends SequentialCommandGroup {
  public blue(LiftSubsystem m_lift, ArmSubsystem m_arm, DriveSubsystem m_drive, GripperSubsystem m_grip) {

    addCommands(
        // new InstantCommand(() -> m_drive.startfixed2())
        // .andThen(
        // new AutoStraightDrive2(m_drive, -1)
        new GripperCommand(-0.8, m_grip));
  }
}
