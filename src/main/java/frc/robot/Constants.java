package frc.robot;

public final class Constants {
  
public static class controller{
//bunu değiştir-----------------------
  public static final int controller = 1;
  //----------------------------------
}
    public static class CAN {

      //bunları değiştir-----------------------
        public static final int kRightLeaderID = 9;
        public static final int kRightFollowerID = 11;
        public static final int kLeftLeaderID = 6;
        public static final int kLeftFollowerID = 10;

        public static final int kMiddle1 = 1;
        public static final int kMiddle2 = 2;
        //--------------------------------------
      }


    public static class ENCODERS {
    public static final int kLeftDriveEncoderChannelA = 4;
    public static final int kLeftDriveEncoderChannelB = 5;

    public static final int kRightDriveEncoderChannelA = 6;
    public static final int kRightDriveEncoderChannelB = 7;
  }


    public static class ODOMETRY {
    public static final double kRamseteB = 2.0;
    public static final double kRamseteZeta = 0.7;
    public static final double kTrackwidthMeters = 0.56;
    public static final double kMaxSpeedMetersPerSecond = 3;

    //3
    public static final double kMaxAccelerationMetersPerSecondSquared = 1;

    //-odometry-------------------------------------------------------------
    public static final double kP = 0; //0.98212;
    public static final double kS = 0.56711;
    public static final double kV = 0.75556;
    public static final double kA = 0.14701;
    //---------------------------------------------------------------
  }

    public static class invert{
      //bunları da değiştir------------------------------------------------
        public static final boolean rightleaderinvert = false;
        public static final boolean leftleaderinvert = false;
        public static final boolean rightrearinvert = true;
        public static final boolean leftrearinvert = true;

        public static final boolean middle1 = true;
        public static final boolean middle2 = true;
      //----------------------------------------------------------------
        public static final boolean rightencoderreversedirection = true;
        public static final boolean leftencoderreversedirection = false;

        public static final boolean rightgroupinvert = true;
        public static final boolean leftgroupinvert = false;

        public static final boolean gyroinvert = true;
    } 



}
