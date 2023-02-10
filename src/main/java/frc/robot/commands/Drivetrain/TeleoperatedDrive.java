// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.Drivetrain;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.commandgroups.TurnToGivenAngle;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.XboxSubsystem;

public class TeleoperatedDrive extends CommandBase {
/*
  DriveSubsystem m_drivesubsystem;
  XboxSubsystem m_xboxSubsystem;
  DoubleSupplier xspeed;
  DoubleSupplier yrotation;
  DoubleSupplier zrotation;

  public TeleoperatedDrive(
  DriveSubsystem m_drivesubsystem,
  XboxSubsystem m_xboxSubsystem,
  DoubleSupplier xspeed,
  DoubleSupplier yrotation,
  DoubleSupplier zrotation
  ) {

  this.m_drivesubsystem = m_drivesubsystem;
  this.xspeed = xspeed;
  this.yrotation = yrotation;
  this.m_xboxSubsystem = m_xboxSubsystem;
  this.zrotation = zrotation;
  addRequirements(m_drivesubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {

  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

    double angle = m_drivesubsystem.GetHeading();
    double neededangle = angle * -1;
    
    //ConfiguratedThrottle = (throttle.getAsDouble() * -1 + 1) / 2;
    // :( m_drivesubsystem.arcadeDrive(xspeed.getAsDouble() *  ConfiguratedThrottle, yrotation.getAsDouble() * ConfiguratedThrottle);
    
    
//if(m_xboxSubsystem.stabilmode == false){
  m_drivesubsystem.hDrive(xspeed.getAsDouble() *  m_xboxSubsystem.ThrottleValue, 
  yrotation.getAsDouble() * m_xboxSubsystem.ThrottleValue,
  -zrotation.getAsDouble() * m_xboxSubsystem.ThrottleValue);
//}



/* 
if(m_xboxSubsystem.stabilmode == true){

//if(Math.abs(zrotation.getAsDouble()) > 0.09){
//m_drivesubsystem.ResetGyro();
//}

  m_drivesubsystem.hDrive(xspeed.getAsDouble() *  m_xboxSubsystem.ThrottleValue, 
  yrotation.getAsDouble() * m_xboxSubsystem.ThrottleValue,
  -zrotation.getAsDouble() * m_xboxSubsystem.ThrottleValue);


  if(yrotation.getAsDouble() < 0.1 && yrotation.getAsDouble() > -0.1 &&
  xspeed.getAsDouble() > -0.1 && xspeed.getAsDouble() < 0.1){
  new pidAngleTurn(m_drivesubsystem, neededangle);
  m_drivesubsystem.a = neededangle;
  m_drivesubsystem.duzelt = true;

  SmartDashboard.putBoolean("deneme", true);
 }
 
 else{
  m_drivesubsystem.duzelt = false;
  SmartDashboard.putBoolean("deneme", false);
 }
*/
/* 
  SmartDashboard.putNumber("nummber", neededangle);
  SmartDashboard.putNumber("xspeed", xspeed.getAsDouble());
  SmartDashboard.putNumber("yrotation", yrotation.getAsDouble());
  SmartDashboard.putNumber("zrotation", zrotation.getAsDouble());
//}
  }

  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  } */
}


