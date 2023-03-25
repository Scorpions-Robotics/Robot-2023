// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class GripperSubsystem extends SubsystemBase {
  /** Creates a new GripperSubsystem. */
  private WPI_VictorSPX gripper = new WPI_VictorSPX(Constants.CAN.kGripper);
  public boolean interupt = false;

  public GripperSubsystem() {
    gripper.setInverted(Constants.invert.gripperinvert);
    setBrake();
    gripper.configOpenloopRamp(5.5);
  }

  public void setGripperConfig() {
    gripper.configOpenloopRamp(0.5);
  }

  public void setBrake() {
    gripper.setNeutralMode(NeutralMode.Brake);
  }

  public void setCoast() {
    gripper.setNeutralMode(NeutralMode.Coast);
  }

  public void push(double a) {
    gripper.set(a);
  }

  public void interupt() {
    interupt = true;
  }

  @Override
  public void periodic() {
    double amper = gripper.getMotorOutputVoltage();
    SmartDashboard.putNumber("amperr", amper);
  }
}
