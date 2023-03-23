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
public class resetall extends SequentialCommandGroup {
  /** Creates a new resetall. */
  public resetall(ArmSubsystem m_arm, LiftSubsystem m_lift) {

    addCommands(
        new InstantCommand(() -> m_arm.resetAxis2GetOutputAngle())
            .alongWith(new InstantCommand(() -> m_arm.resetAxis3GetOutputAngle()))
            .alongWith(new InstantCommand(() -> m_arm.resetGetOutputAngle()))
            .alongWith(new InstantCommand(() -> m_arm.Axis3EncoderReset()))
            .alongWith(new InstantCommand(() -> m_arm.Axis2EncoderReset()))
            .alongWith(new InstantCommand(() -> m_arm.Axis1EncoderReset()))
            .alongWith(new InstantCommand(() -> m_lift.reset())));
  }
}
