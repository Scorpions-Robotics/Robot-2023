// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.Lift;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.LiftSubsystem;

public class ManualLift extends CommandBase {
  LiftSubsystem m_lift;
  boolean mode;

  public ManualLift(LiftSubsystem m_lift, boolean mode) {
    this.m_lift = m_lift;
    this.mode = mode;
  }

  @Override
  public void initialize() {}

  @Override
  public void execute() {

    if (mode) {
      m_lift.forward();
    } else {
      m_lift.back();
    }
  }

  @Override
  public void end(boolean interrupted) {}

  @Override
  public boolean isFinished() {
    return false;
  }
}
