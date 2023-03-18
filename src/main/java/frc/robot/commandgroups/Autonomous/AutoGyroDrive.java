// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commandgroups.Autonomous;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.Autonomous.AutoHStraightDrive;
import frc.robot.commands.Autonomous.AutoStraightDrive2;
import frc.robot.subsystems.DriveSubsystem;

public class AutoGyroDrive extends SequentialCommandGroup {
  public AutoGyroDrive(DriveSubsystem m_drive, double x, double y) {

    addCommands(
        new AutoHStraightDrive(m_drive, y, () -> m_drive.GetHeading())
            .andThen(new AutoStraightDrive2(m_drive, x, () -> m_drive.GetHeading())));
  }
}
