// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class VisionSubsystem extends SubsystemBase {

  NetworkTableInstance inst = NetworkTableInstance.create();
  NetworkTable table = inst.getTable("ScorpionsVision");
  NetworkTableEntry cone_degree = table.getEntry("cone");

  public VisionSubsystem() {
    inst.startServer("networktables.json", "", 1735);
  }

  public double getCone() {
    return Double.valueOf(cone_degree.getString("0"));
  }

  @Override
  public void periodic() {
    SmartDashboard.putNumber("coneangle", getCone());
    // This method will be called once per scheduler run
  }
}
