package frc.robot.commandgroups.Autonomous;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.commandgroups.idlefromup;
import frc.robot.commandgroups.second;
import frc.robot.commands.Autonomous.AutoStraightDrive2;
import frc.robot.commands.Drivetrain.pidChargeStation;
import frc.robot.commands.Gripper.GripperCommand;
import frc.robot.subsystems.ArmSubsystem;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.GripperSubsystem;
import frc.robot.subsystems.LiftSubsystem;

public class blue4 extends SequentialCommandGroup {
  public blue4(DriveSubsystem m_drive, ArmSubsystem m_arm, LiftSubsystem m_lift, GripperSubsystem m_grip) {

    addCommands(

        new second(m_arm, m_lift)
            .alongWith(
                new WaitCommand(2)
                    .andThen(new GripperCommand(-0.3, m_grip).withTimeout(3)))
            .withTimeout(3)
            .andThen(new idlefromup(m_arm, m_lift)
                .alongWith(
                    new GripperCommand(0, m_grip).withTimeout(4)
                        .andThen(new InstantCommand(() -> m_drive.stopfixed()))
                        .andThen(new AutoStraightDrive2(m_drive, -1)
                            .andThen(new pidChargeStation(m_drive)))))

    );
  }
}
