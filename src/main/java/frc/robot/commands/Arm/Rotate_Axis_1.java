// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.Arm;


import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.PIDCommand;
import frc.robot.subsystems.ArmSubsystem;

public class Rotate_Axis_1 extends PIDCommand {

  public Rotate_Axis_1(ArmSubsystem m_arm,double degree) {
    super(
        new PIDController(1, 0, 0),
        // This should return the measurement
        () -> m_arm.GetOutputAngle(),
        // This should return the setpoint (can also be a constant)
        () -> degree,
        // This uses the output
        output -> {


          if(degree > m_arm.GetOutputAngle()){
              m_arm.Axis1MotorOutput(Math.min(-output, -0.20));
          }

          else if(m_arm.GetOutputAngle() > degree){
            m_arm.Axis1MotorOutput(Math.max(output, 0.20));
        }


        });
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
