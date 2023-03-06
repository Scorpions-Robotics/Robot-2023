// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import java.io.IOException;
import java.lang.annotation.Target;
import java.util.Locale;

import org.photonvision.PhotonCamera;
import org.photonvision.PhotonPoseEstimator;
import org.photonvision.RobotPoseEstimator;
import org.photonvision.PhotonPoseEstimator.PoseStrategy;
import org.photonvision.targeting.PhotonPipelineResult;
import org.photonvision.PhotonUtils;
import org.photonvision.targeting.PhotonTrackedTarget;

import frc.robot.Constants.VisionConstants;
import edu.wpi.first.math.geometry.Pose3d;
import edu.wpi.first.math.geometry.Rotation3d;
import edu.wpi.first.math.geometry.Transform3d;
import edu.wpi.first.math.util.Units;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.apriltag.AprilTagFieldLayout;
import edu.wpi.first.apriltag.AprilTagFields;

public class VisionSubsystem extends SubsystemBase {
  private PhotonCamera m_camera;
  private PhotonPoseEstimator m_estimator;
  public PhotonPipelineResult result;
  private double yaw;
  private double distance;
  //public static Pose3d targetpose3d = new Pose3d();
  //public static PhotonTrackedTarget target;

  public VisionSubsystem() {

    AprilTagFieldLayout fieldlayout;
    try{
      fieldlayout = AprilTagFields.k2023ChargedUp.loadAprilTagLayoutField();
    }catch(IOException e){

    }


    m_camera = new PhotonCamera(VisionConstants.CameraName);


    m_estimator = new PhotonPoseEstimator(fieldlayout, PoseStrategy.AVERAGE_BEST_TARGETS, m_camera, VisionConstants.robotToCam);
  }

  @Override
  public void periodic() {

    result = m_camera.getLatestResult();


    if(hasTargets()){
      // SmartDashboard.putBoolean("Target", hasTargets());
      // SmartDashboard.putNumber("Yaw", getTargetYaw());
      // SmartDashboard.putNumber("Distance", getDistance());
      // SmartDashboard.putString("gimme", gimme());
    }
    else{
      SmartDashboard.putBoolean("Target", hasTargets());
    }
    }

  public double getTargetYaw() {
    return result.getBestTarget().getYaw();
  }

public static void yazdir(String a){

  SmartDashboard.putString("vision",a);

}

  // public double getDistance() {
  //   return PhotonUtils.calculateDistanceToTargetMeters(
  //       VisionConstants.CameraHeight,
  //       VisionConstants.TargetHeight,
  //       VisionConstants.CameraPitchRadians,
  //       Units.degreesToRadians(-result.getBestTarget().getPitch()));
  // }

  public boolean hasTargets() {
    return result.hasTargets();
  }

  // public String gimme() {
  //  PhotonTrackedTarget target = result.getBestTarget();
  //  Transform3d targettransform = target.getBestCameraToTarget();


  //  Pose3d targetpose3d = new Pose3d(
  //   targettransform.getY(),
  //   targettransform.getX(),
  //   targettransform.getZ(),
  //   new Rotation3d(0.0,target.getPitch(),target.getYaw()));

  //   String raw = String.format(Locale.US,
  //   "{pose=(x=%.1f,y=%.1f,z=%.1f,pitch=%.1f,yaw=%.1f,skew=%.1f)}",
  //   targetpose3d.getX(),
  //   targetpose3d.getY(),
  //   targetpose3d.getZ(),
  //   target.getPitch(),
  //   target.getYaw(),
  //   target.getSkew()
  //   );

  //   return raw;
  // }

}
