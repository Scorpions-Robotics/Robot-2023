// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.Arm;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ArmSubsystem;

public class ResetAxis1Encoder extends CommandBase {
  /** Creates a new ResetAxis1Encoder. */
  ArmSubsystem m_arm;
  public ResetAxis1Encoder(ArmSubsystem m_arm) {
    this.m_arm = m_arm;
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {

}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_arm.Axis1EncoderReset();
    m_arm.resetGetOutputAngle();
    
    m_arm.Axis2EncoderReset();
    m_arm.resetAxis2GetOutputAngle(); 
    
    m_arm.Axis3EncoderReset();
    m_arm.resetAxis3GetOutputAngle();  
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return true;
  }
}