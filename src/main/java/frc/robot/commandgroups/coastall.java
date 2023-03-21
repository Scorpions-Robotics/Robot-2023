// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commandgroups;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.ArmSubsystem;
import frc.robot.subsystems.LiftSubsystem;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class coastall extends SequentialCommandGroup {
  /** Creates a new coastall. */
  public coastall(ArmSubsystem m_arm, LiftSubsystem m_lift) {

    addCommands(
        new InstantCommand(() -> m_arm.Axis2MotorCoastMode())
            .alongWith(new InstantCommand(() -> m_arm.Axis3MotorCoastMode()))
            .alongWith(new InstantCommand(() -> m_arm.Axis1MotorCoastMode()))
            .alongWith(new InstantCommand(() -> m_lift.coastmode())));
  }
}
