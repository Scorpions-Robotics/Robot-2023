// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.Drivetrain;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveSubsystem;

public class ChargeStationBalance extends CommandBase {

DriveSubsystem m_drive;
Double Error;
Double Pitch;
Double Output;

  public ChargeStationBalance(DriveSubsystem m_drive) {
  this.m_drive = m_drive;

}

  @Override
  public void initialize() {
    m_drive.BrakeMode();
  }

  @Override
  public void execute() {

  Pitch = m_drive.GetPitch();
  Error = 0 - Pitch;
  Output = -Math.min(Error, 1);

  if (Math.abs(Output) > 0.4) {
    Output = Math.copySign(0.4, Output);
  }

  if (Math.abs(Pitch) >= 6 && Math.abs(Pitch) <= 10 ) {
    Output = Math.copySign(0.3, Output);
  }

  if (Math.abs(Pitch) >= 4 && Math.abs(Pitch) <= 5) {
    Output = Math.copySign(0.2, Output);
  }
  
  if (Math.abs(Pitch) <= 3) {
  Output = Math.copySign(0, Output);
  }

  m_drive.RunSpeed(Output, false);
  }

  @Override
  public void end(boolean interrupted) {
    m_drive.stopNbreak();
  }

  @Override
  public boolean isFinished() {
    return Math.abs(Error) <= 3;
  }
}
