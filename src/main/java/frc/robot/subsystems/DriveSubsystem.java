package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import com.kauailabs.navx.frc.AHRS;
import com.revrobotics.RelativeEncoder;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.kinematics.DifferentialDriveKinematics;
import edu.wpi.first.math.kinematics.DifferentialDriveOdometry;
import edu.wpi.first.math.kinematics.DifferentialDriveWheelSpeeds;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DriveSubsystem extends SubsystemBase {

  // imu --------------------------------
  AHRS imu = new AHRS(I2C.Port.kOnboard);
  // ------------------------------------
  // Encoder-----------------------------

  private Encoder leftDriveEncoder =
      new Encoder(
          Constants.ENCODERS.kLeftDriveEncoderChannelA,
          Constants.ENCODERS.kLeftDriveEncoderChannelB,
          Constants.invert.leftencoderreversedirection,
          EncodingType.k4X);

  private Encoder rightDriveEncoder =
      new Encoder(
          Constants.ENCODERS.kRightDriveEncoderChannelA,
          Constants.ENCODERS.kRightDriveEncoderChannelB,
          Constants.invert.rightencoderreversedirection,
          EncodingType.k4X);

  private Encoder hDriveEncoder =
      new Encoder(
          Constants.ENCODERS.kMiddle1DriveEncoderChannelA,
          Constants.ENCODERS.kMiddle1DriveEncoderChannelB,
          Constants.invert.hdriveencoder,
          EncodingType.k4X);

  private Encoder hDriveEncoder2 =
      new Encoder(
          Constants.ENCODERS.kMiddle2DriveEncoderChannelA,
          Constants.ENCODERS.kMiddle2DriveEncoderChannelB,
          Constants.invert.hdriveencoder2,
          EncodingType.k4X);

  RelativeEncoder encoder1;
  // ---------------------------------------
  public static boolean duzelt = false;
  public boolean fixed = true;
  // Motor----------------------------------

  private WPI_VictorSPX rightFront = new WPI_VictorSPX(Constants.CAN.kRightLeaderID);
  private WPI_VictorSPX rightRear = new WPI_VictorSPX(Constants.CAN.kRightFollowerID);
  private WPI_VictorSPX leftFront = new WPI_VictorSPX(Constants.CAN.kLeftLeaderID);
  private WPI_VictorSPX leftRear = new WPI_VictorSPX(Constants.CAN.kLeftFollowerID);

  private WPI_VictorSPX middle1 = new WPI_VictorSPX(Constants.CAN.kMiddle1);
  private WPI_VictorSPX middle2 = new WPI_VictorSPX(Constants.CAN.kMiddle2);

  // ---------------------------------------

  // motorcontrollergroup
  public MotorControllerGroup m_right = new MotorControllerGroup(rightFront, rightRear);
  public MotorControllerGroup m_left = new MotorControllerGroup(leftFront, leftRear);
  public MotorControllerGroup m_middle = new MotorControllerGroup(middle1, middle2);
  // ---------------------------------------

  // DifferentialDriveClass
  private DifferentialDrive drive = new DifferentialDrive(m_right, m_left);
  public DifferentialDriveOdometry odometry;
  public DifferentialDriveKinematics kinematics =
      new DifferentialDriveKinematics(Constants.ODOMETRY.kTrackwidthMeters);
  // ---------------------------------------

  public DriveSubsystem() {

    leftFront.setInverted(Constants.invert.leftleaderinvert);
    rightFront.setInverted(Constants.invert.rightleaderinvert);
    leftRear.setInverted(Constants.invert.leftrearinvert);
    rightRear.setInverted(Constants.invert.rightrearinvert);
    middle1.setInverted(Constants.invert.middle1);
    middle2.setInverted(Constants.invert.middle2);

    leftFront.configOpenloopRamp(0.7, 20);
    rightFront.configOpenloopRamp(0.7, 20);
    leftRear.configOpenloopRamp(0.7, 20);
    rightRear.configOpenloopRamp(0.7, 20);
    middle1.configOpenloopRamp(0.3, 20);
    middle2.configOpenloopRamp(0.3, 20);

    m_right.setInverted(Constants.invert.rightgroupinvert);
    m_left.setInverted(Constants.invert.leftgroupinvert);

    BrakeMode();
    fixed = true;
  }

  public void CoastMode() {
    rightFront.setNeutralMode(NeutralMode.Coast);
    rightRear.setNeutralMode(NeutralMode.Coast);
    leftFront.setNeutralMode(NeutralMode.Coast);
    leftRear.setNeutralMode(NeutralMode.Coast);
  }

  public void BrakeMode() {
    rightFront.setNeutralMode(NeutralMode.Brake);
    rightRear.setNeutralMode(NeutralMode.Brake);
    leftFront.setNeutralMode(NeutralMode.Brake);
    leftRear.setNeutralMode(NeutralMode.Brake);
    middle1.setNeutralMode(NeutralMode.Brake);
    middle2.setNeutralMode(NeutralMode.Brake);
  }

  public double getLeftEncoderDistance() {
    leftDriveEncoder.setDistancePerPulse(1.0 / 20.0 * Math.PI * 6 * (1 / 10.71));
    return leftDriveEncoder.getDistance() * 2.54;
    // return 1;
  }

  public double getRightEncoderDistance() {
    rightDriveEncoder.setDistancePerPulse(1.0 / 20.0 * Math.PI * 6 * (1 / 10.71));
    return rightDriveEncoder.getDistance() * 2.54;
    // return 1;
  }

  public double getRigthHEncoderDistance() {
    hDriveEncoder.setDistancePerPulse(1.0 / 20.0 * Math.PI * 6 * (1 / 10.71));
    return hDriveEncoder.getDistance() * 2.54;
    // return 1;
  }

  public double getLeftHEncoderDistance() {
    hDriveEncoder2.setDistancePerPulse(1.0 / 20.0 * Math.PI * 6 * (1 / 10.71));
    return hDriveEncoder2.getDistance() * 2.54;
    // return 1;
  }

  public double getStraightDriveDistance() {
    return (getLeftEncoderDistance() + getRightEncoderDistance()) / 2;
  }

  public double getHdriveStraightDriveDistance() {
    return (getLeftHEncoderDistance() + getRigthHEncoderDistance()) / 2;
  }

  public void ResetEncoders() {
    leftDriveEncoder.reset();
    rightDriveEncoder.reset();
    hDriveEncoder.reset();
    hDriveEncoder2.reset();
  }

  public void arcadeDrive(double speed, double rotation) {
    drive.arcadeDrive(speed * 1, rotation * -1);
  }

  // acil kontrol
  public DifferentialDriveWheelSpeeds getWheelSpeeds() {
    return new DifferentialDriveWheelSpeeds(1, 1 * -1);
    // leftDriveEncoder.getRate(), rightDriveEncoder.getRate() * -1);
  }

  public void tankDriveVolts(double leftVolts, double rightVolts) {
    rightFront.setVoltage(-rightVolts);
    rightRear.setVoltage(-rightVolts);
    leftRear.setVoltage(-leftVolts);
    leftFront.setVoltage(-leftVolts);
    drive.feed();
  }

  public double GetHeading() {
    // açı
    // return Math.IEEEremainder(imu.getAngle(), 360) * (Constants.invert.gyroinvert
    // ? -1.0 : 1.0);
    return imu.getAngle() * (Constants.invert.gyroinvert ? -1.0 : 1.0);
  }

  public double GetHeadingForFastReturn() {
    // açı
    return -Math.IEEEremainder(imu.getAngle(), 360) * (Constants.invert.gyroinvert ? 1.0 : -1.0);
  }

  public double GetYaw() {
    // sağ-sol etrafında
    return Math.IEEEremainder(imu.getYaw(), 180) * (Constants.invert.gyroinvert ? -1.0 : 1.0);
  }

  public double GetRoll() {
    // sağ-sol yatma
    return Math.IEEEremainder(imu.getRoll(), 180) * (Constants.invert.gyroinvert ? -1.0 : 1.0);
  }

  public double GetPitch() {
    // burun aşağı-burun yukarısı
    return Math.IEEEremainder(imu.getPitch(), 180) * (Constants.invert.gyroinvert ? -1.0 : 1.0);
  }

  public void ResetGyro() {
    imu.reset();
  }

  public void ResetOdometry() {
    ResetEncoders();
    odometry.resetPosition(
        GetHeadingForDifferentialDriveOdometry(),
        getLeftEncoderDistance(),
        getRightEncoderDistance(),
        odometry.getPoseMeters());
  }

  public Rotation2d GetHeadingForDifferentialDriveOdometry() {
    return Rotation2d.fromDegrees(
        Math.IEEEremainder(imu.getAngle(), 360) * (Constants.invert.gyroinvert ? -1.0 : 1.0));
  }

  public void arcadeDrive(Double x, Double y) {
    drive.arcadeDrive(x, y);
  }

  public void gyroDrive(Double x) {
    double gyrovalue = GetHeading();
    if (gyrovalue > 10) {
      gyrovalue = 10;
    } else if (gyrovalue < -10) {
      gyrovalue = -10;
    }
    double xvalue = (x * 0.9) + (gyrovalue * 0.005);
    double yvalue = (x * 0.9) - (gyrovalue * 0.005);
  }

  public void RunSpeed(double speed, double rot) {
    /*
     * rightFront.set(speed);
     * rightRear.set(speed);
     * leftRear.set(-speed);
     * leftFront.set(-speed);
     */
    // m_right.set(-speed);
    // m_left.set(speed);

    drive.arcadeDrive(rot, speed);
  }

  public void rotate(double speed) {
    // m_right.set(speed);
    // m_left.set(speed);
    drive.tankDrive(speed, speed);
  }

  public void RunMiddle(double speed) {
    m_middle.set(-speed);
  }

  public void hDrive(Double x, Double y, Double z) {

    RunSpeed(y, z);
    RunMiddle(x);

    if (y > -0.05 && y < 0.05) {

      if (z > -0.05 && z < 0.05) {
        leftFront.configOpenloopRamp(0, 20);
        rightFront.configOpenloopRamp(0, 20);
        leftRear.configOpenloopRamp(0, 20);
        rightRear.configOpenloopRamp(0, 20);
      } else if (z < -0.05 || z > 0.05) {
        leftFront.configOpenloopRamp(0.7, 20);
        rightFront.configOpenloopRamp(0.7, 20);
        leftRear.configOpenloopRamp(0.7, 20);
        rightRear.configOpenloopRamp(0.7, 20);
      }

    } else if (y < -0.05 || y > 0.05) { // Limits ramp either way
      SmartDashboard.putNumber("ramp rate", 0);
      leftFront.configOpenloopRamp(0.7, 20);
      rightFront.configOpenloopRamp(0.7, 20);
      leftRear.configOpenloopRamp(0.7, 20);
      rightRear.configOpenloopRamp(0.7, 20);
    }
  }

  public void GetArmEncoderValue() {
    // encoder1 = armmotor1.getEncoder(SparkMaxRelativeEncoder.Type.kQuadrature,
    // 42);
  }

  public void RunRightSideVolts(double volts) {
    m_right.setVoltage(volts);
  }

  public void RunLeftSideVolts(double volts) {
    m_left.setVoltage(volts);
  }

  public void RunVolts(double volts) {
    RunRightSideVolts(volts);
    RunLeftSideVolts(volts);
  }

  public void RunRightSideSpeed(double speed) {
    m_right.set(speed);
  }

  public void RunTogether(double right, double left, double hDriveFront, double hDriveBack) {
    // m_right.set(right);
    // m_left.set(left);
    drive.tankDrive(left, right);
    middle1.set(hDriveFront);
    middle2.set(hDriveBack);
  }

  public void RunStraightForCrossDrive(double right, double left) {
    drive.tankDrive(left, right);
  }

  public void RunRightLeftForCrossDrive(double hDriveFront, double hDriveBack) {
    middle1.set(hDriveFront);
    middle2.set(hDriveBack);
  }

  public void RunLeftSideSpeed(double speed) {
    m_left.set(speed);
  }

  public void fixer() {
    fixed = true;
  }

  public void StopRightSide() {
    m_right.set(0);
  }

  public void StopLeftSide() {
    m_left.setVoltage(0);
  }

  public void StopMotors() {
    StopRightSide();
    StopLeftSide();
  }

  public void stopHmotors() {

    m_middle.set(0);
  }

  public void runHRightMotor(double speed) {
    middle1.set(speed);
  }

  public void runHLeftMotor(double speed) {
    middle2.set(speed);
  }

  public void stopNbreak() {
    StopMotors();
    CoastMode();
  }

  public void motor1() {

    rightFront.set(1);
  }

  public void motor2() {

    rightRear.set(1);
  }

  public void motor3() {

    leftFront.set(1);
  }

  public void motor4() {

    leftRear.set(1);
  }

  public void motor5() {

    middle1.set(1);
  }

  public void motor6() {

    middle2.set(1);
  }

  @Override
  public void periodic() {

    // odometry.update(GetHeadingForDifferentialDriveOdometry(),
    // getRightEncoderDistance(),
    // getLeftEncoderDistance());

    SmartDashboard.putNumber("pitch", imu.getPitch());
    SmartDashboard.putNumber("heading", GetHeading());
  }
}
