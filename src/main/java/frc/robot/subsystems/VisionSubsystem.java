// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.apriltag.AprilTagFieldLayout;
import edu.wpi.first.apriltag.AprilTagFields;
import edu.wpi.first.math.geometry.Pose3d;
import edu.wpi.first.math.geometry.Rotation3d;
import edu.wpi.first.math.geometry.Transform3d;
import edu.wpi.first.math.util.Units;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.VisionConstants;
import java.io.IOException;
import java.lang.annotation.Target;
import java.util.Locale;
import org.photonvision.PhotonCamera;
import org.photonvision.PhotonPoseEstimator;
import org.photonvision.PhotonPoseEstimator.PoseStrategy;
import org.photonvision.PhotonUtils;
import org.photonvision.RobotPoseEstimator;
import org.photonvision.targeting.PhotonPipelineResult;
import org.photonvision.targeting.PhotonTrackedTarget;

public class VisionSubsystem extends SubsystemBase {
  private PhotonCamera m_camera;
  private PhotonPoseEstimator m_estimator;
  public PhotonPipelineResult result;
  public AprilTagFieldLayout fieldlayout;
  private double yaw;
  private double distance;

  public VisionSubsystem() {
    try {
      fieldlayout = AprilTagFields.k2023ChargedUp.loadAprilTagLayoutField();
    } catch (IOException e) {
    }
    m_camera = new PhotonCamera(VisionConstants.CameraName);
    m_estimator =
        new PhotonPoseEstimator(fieldlayout, PoseStrategy.AVERAGE_BEST_TARGETS,
                                m_camera, VisionConstants.robotToCam);
  }

  @Override
  public void periodic() {
    result = m_camera.getLatestResult();

    if (hasTargets()) {
      // SmartDashboard.putBoolean("Target", hasTargets());
      // SmartDashboard.putNumber("Yaw", getTargetYaw());
      // SmartDashboard.putNumber("Distance", getDistance());
      // SmartDashboard.putString("gimme", gimme());
    } else {
      SmartDashboard.putBoolean("Target", hasTargets());
    }
  }

  public boolean hasTargets() { return result.hasTargets(); }
}
