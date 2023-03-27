// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commandgroups;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.Arm.ArmModeChanger3;
import frc.robot.commands.Arm.Rotate_Axis_1;
import frc.robot.commands.Arm.Rotate_Axis_2;
import frc.robot.commands.Lift.PidLiftCommand;
import frc.robot.subsystems.ArmSubsystem;
import frc.robot.subsystems.LiftSubsystem;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class idlefromdown extends SequentialCommandGroup {
  /** Creates a new idlefromdown. */
  public idlefromdown(ArmSubsystem m_arm, LiftSubsystem m_lift) {
    addCommands(
        new ArmModeChanger3(m_arm, -136, -243, 0)
            .withTimeout(2)
            .andThen(new Rotate_Axis_2(m_arm, -210).andThen(new Rotate_Axis_1(m_arm, -68)))
            .andThen(
                new PidLiftCommand(m_lift, () -> -125)
                    .alongWith(new ArmModeChanger3(m_arm, -68, -210, 0))));
  }
}
