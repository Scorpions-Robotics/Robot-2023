// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.Joystick;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.XboxSubsystem;

public class Throttle extends CommandBase {
boolean mode;
XboxSubsystem m_xboxSubsystem;
  public Throttle(boolean mode, XboxSubsystem m_xboxSubsystem) {
this.mode = mode;
this.m_xboxSubsystem = m_xboxSubsystem;

  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    if(mode == true){

      m_xboxSubsystem.modeincrease();
    }
    else{
      m_xboxSubsystem.modedecrease();

    }

  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {


  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
