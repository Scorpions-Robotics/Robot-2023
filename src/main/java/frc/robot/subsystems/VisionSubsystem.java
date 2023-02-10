// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import org.photonvision.PhotonCamera;
import org.photonvision.targeting.PhotonPipelineResult;
import org.photonvision.PhotonUtils;
import frc.robot.Constants.VisionConstants;
import edu.wpi.first.math.util.Units;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class VisionSubsystem extends SubsystemBase {
  private PhotonCamera m_camera;
  private PhotonPipelineResult result;

  public VisionSubsystem() {
    m_camera = new PhotonCamera(VisionConstants.CameraName);
  }

  @Override
  public void periodic() {
    result = m_camera.getLatestResult();
  }

  public double getTargetYaw() {
    return result.getBestTarget().getYaw();
  }

  public double getDistance() {
    return PhotonUtils.calculateDistanceToTargetMeters(
        VisionConstants.CameraHeight,
        VisionConstants.TargetHeight,
        VisionConstants.CameraPitchRadians,
        Units.degreesToRadians(result.getBestTarget().getPitch()));
  }

  public boolean hasTargets() {
    return result.hasTargets();
  }
}
