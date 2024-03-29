// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commandgroups;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.Arm.ArmModeChanger3;
import frc.robot.commands.Lift.PidLiftCommand;
import frc.robot.subsystems.ArmSubsystem;
import frc.robot.subsystems.LiftSubsystem;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class idlefromup extends SequentialCommandGroup {
  /** Creates a new idlefromdown. */
  public idlefromup(ArmSubsystem m_arm, LiftSubsystem m_lift) {
    addCommands(
        new PidLiftCommand(m_lift, () -> -125).alongWith(new ArmModeChanger3(m_arm, -68, -145, 0)));
  }
}
