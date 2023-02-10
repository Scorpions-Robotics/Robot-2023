// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.Drivetrain;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.PIDCommand;
import frc.robot.RobotContainer;
import frc.robot.subsystems.DriveSubsystem;

//public class pidAngleTurn extends PIDCommand {
/* 
  public pidAngleTurn(DriveSubsystem m_drive, double angle) {
    super(
        new PIDController(0.025, 0.001, 0.005),
        () -> m_drive.GetHeading(),
        () -> angle,

        output -> {

          if (m_drive.GetHeading() > angle) {
            m_drive.arcadeDrive(Math.min(-output, -0.45),0);

            //outputtaki "-"leri gözden geçir!
          } else if(angle > m_drive.GetHeading()) {
            m_drive.arcadeDrive(Math.max(output, 0.3) ,0);
          }
          
          SmartDashboard.putNumber("output", -output);
          SmartDashboard.putNumber("angle", angle);
          SmartDashboard.putNumber("heading", m_drive.GetHeading());
        });
      }
  @Override
  public boolean isFinished() {
*/
    /*Double setpoint = getController().getSetpoint();
    if(RobotContainer.m_drive.GetHeading() > setpoint - 1 && RobotContainer.m_drive.GetHeading() < setpoint + 1){

      return true;
    }else{

      return false;
    }*/

 //return getController().atSetpoint();
 // }
//}
