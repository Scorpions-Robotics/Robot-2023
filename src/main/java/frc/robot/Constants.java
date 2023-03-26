package frc.robot;

import edu.wpi.first.math.geometry.Rotation3d;
import edu.wpi.first.math.geometry.Transform3d;
import edu.wpi.first.math.geometry.Translation3d;
import edu.wpi.first.math.util.Units;

public final class Constants {

  public static class Joysticks {
    // bunu değiştir-----------------------
    public static int xbox_port = 0;
    public static int port2 = 1;
    // ----------------------------------
  }

  public static class liftValue {
    public static final double level1 = 50;
    public static final double level2 = 200;
    public static final double level3 = 300;
  }

  public static class CAN {

    // bunları değiştir-----------------------
    public static final int kRightLeaderID = 7;
    public static final int kRightFollowerID = 14;
    public static final int kLeftLeaderID = 12;
    public static final int kLeftFollowerID = 8;

    public static final int kMiddle1 = 5;
    public static final int kMiddle2 = 2;

    public static final int kGripper = 3;
    // --------------------------------------

    public static final int kArmDown = 6;
    public static final int kArmMiddle = 9;
    public static final int kArmUp = 10;
    public static final int kLiftMotor = 12;
  }

  public static class LED {
    public static final int kLEDCount = 60;
    public static final int kLEDPWM = 8;
  }

  public static class ENCODERS {
    public static final int kLeftDriveEncoderChannelA = 0;
    public static final int kLeftDriveEncoderChannelB = 1;

    public static final int kRightDriveEncoderChannelA = 2;
    public static final int kRightDriveEncoderChannelB = 3;

    public static final int kMiddle1DriveEncoderChannelA = 7;
    public static final int kMiddle1DriveEncoderChannelB = 6;

    public static final int kMiddle2DriveEncoderChannelA = 5;
    public static final int kMiddle2DriveEncoderChannelB = 4;
  }

  public static class Arm {
    public static final int kRotateMotor = 2;
  }

  public static class PID {
    public static final double kP = 0.0165;
    public static final double kI = 0;
    public static final double kD = 0;

    public static final int POSITION_TOLERANCE = 0;
    public static final int VELOCITY_TOLERANCE = 0;
  }

  public static class ODOMETRY {
    public static final double kRamseteB = 2.0;
    public static final double kRamseteZeta = 0.7;
    public static final double kTrackwidthMeters = 0.56;
    public static final double kMaxSpeedMetersPerSecond = 3;

    // 3
    public static final double kMaxAccelerationMetersPerSecondSquared = 1;

    // -odometry-------------------------------------------------------------
    // public static final double kP = 0; // 0.98212;
    // public static final double kS = 0.56711;
    // public static final double kV = 0.75556;
    // public static final double kA = 0.14701;
    // ---------------------------------------------------------------
  }

  public static class VisionConstants {
    public static final String CameraName = "AprilTagCamera";
    public static final double CameraHeight = 0.845;
    public static final double TargetHeight = 0.56;
    public static final double CameraPitchRadians = Units.degreesToRadians(0.0);
    public static final Transform3d robotToCam =
        new Transform3d(new Translation3d(0.51, 0.0, 0.845), new Rotation3d(0, 0, 0));
  }

  public static class invert {
    // bunları da değiştir------------------------------------------------
    public static final boolean rightleaderinvert = true;
    public static final boolean leftleaderinvert = false;
    public static final boolean rightrearinvert = true;
    public static final boolean leftrearinvert = false;

    public static final boolean middle1 = true;
    public static final boolean middle2 = false;
    // ----------------------------------------------------------------
    public static final boolean rightencoderreversedirection = true;
    public static final boolean leftencoderreversedirection = false;

    public static final boolean rightgroupinvert = true;
    public static final boolean leftgroupinvert = false;

    public static final boolean hdriveencoder = false;
    public static final boolean hdriveencoder2 = true;

    public static final boolean gyroinvert = true;
    public static final boolean gripperinvert = false;
  }
}
