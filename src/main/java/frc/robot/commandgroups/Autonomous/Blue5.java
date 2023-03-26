// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

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

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class Blue5 extends SequentialCommandGroup {
  /** Creates a new Blue5. */
  public Blue5(
      DriveSubsystem m_drive, ArmSubsystem m_arm, LiftSubsystem m_lift, GripperSubsystem m_grip) {
    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());
    new second(m_arm, m_lift)
        .alongWith(new WaitCommand(2).andThen(new GripperCommand(-0.3, m_grip).withTimeout(3)))
        .withTimeout(3)
        .andThen(
            new idlefromup(m_arm, m_lift)
                .alongWith(
                    new GripperCommand(0, m_grip)
                        .withTimeout(4)
                        .andThen(new InstantCommand(() -> m_drive.stopfixed()))
                        .andThen(
                            new AutoStraightDrive2(m_drive, 1.2)
                                .andThen(new pidChargeStation(m_drive)))));
  }
}
