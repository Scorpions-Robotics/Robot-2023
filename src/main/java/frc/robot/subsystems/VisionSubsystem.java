// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.apriltag.AprilTagFieldLayout;
import edu.wpi.first.apriltag.AprilTagFields;
import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Pose3d;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.geometry.Rotation3d;
import edu.wpi.first.math.geometry.Transform3d;
import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.math.util.Units;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.VisionConstants;
import java.io.IOException;
import java.lang.annotation.Target;
import java.util.Locale;
import java.util.Optional;

import org.photonvision.EstimatedRobotPose;
import org.photonvision.PhotonCamera;
import org.photonvision.PhotonPoseEstimator;
import org.photonvision.PhotonPoseEstimator.PoseStrategy;
import org.photonvision.PhotonUtils;
import org.photonvision.targeting.PhotonPipelineResult;
import org.photonvision.targeting.PhotonTrackedTarget;

public class VisionSubsystem extends SubsystemBase {
  private PhotonCamera m_camera;
  private PhotonPoseEstimator m_estimator;
  public PhotonPipelineResult result;
  public AprilTagFieldLayout fieldlayout;
  public Optional<EstimatedRobotPose> pose;
  private Pose2d initialpose = new Pose2d(new Translation2d(0, 0), new Rotation2d(0.0));

  public VisionSubsystem() {
    try {
      fieldlayout = AprilTagFields.k2023ChargedUp.loadAprilTagLayoutField();
      m_camera = new PhotonCamera(VisionConstants.CameraName);
      m_estimator = new PhotonPoseEstimator(fieldlayout, PoseStrategy.MULTI_TAG_PNP,
          m_camera, VisionConstants.robotToCam);
      m_estimator.setMultiTagFallbackStrategy(PoseStrategy.AVERAGE_BEST_TARGETS);
    } catch (IOException e) {
      e.printStackTrace();
    }

    pose = getEstimatedGlobalPose(initialpose);
  }

  @Override
  public void periodic() {
    if (hasTargets()) {
      pose = getEstimatedGlobalPose(pose.get().estimatedPose.toPose2d());
      SmartDashboard.putString("zart", pose.get().estimatedPose.toPose2d().toString());

    } else {
      SmartDashboard.putBoolean("Target", hasTargets());
    }
  }

  public Optional<EstimatedRobotPose> getEstimatedGlobalPose(Pose2d prevEstimatedRobotPose) {
    m_estimator.setReferencePose(prevEstimatedRobotPose);
    return m_estimator.update();
  }

  public boolean hasTargets() {
    return result.hasTargets();
  }
}
