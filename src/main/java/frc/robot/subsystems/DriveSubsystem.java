// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.kinematics.DifferentialDriveKinematics;
import edu.wpi.first.math.kinematics.DifferentialDriveOdometry;
import edu.wpi.first.math.kinematics.DifferentialDriveWheelSpeeds;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import com.revrobotics.RelativeEncoder;
//import edu.wpi.first.wpilibj.Encoder;
//import edu.wpi.first.wpilibj.SerialPort;
//import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import com.kauailabs.navx.frc.AHRS;

public class DriveSubsystem extends SubsystemBase {
  /** Creates a new DriveSubsystem. */

  // imu --------------------------------
  AHRS imu = new AHRS(I2C.Port.kOnboard);
  // ------------------------------------
  // Encoder-----------------------------

  private Encoder leftDriveEncoder = new Encoder(
      Constants.ENCODERS.kLeftDriveEncoderChannelA,
      Constants.ENCODERS.kLeftDriveEncoderChannelB,
      Constants.invert.leftencoderreversedirection,
      EncodingType.k4X);

  private Encoder rightDriveEncoder = new Encoder(
      Constants.ENCODERS.kRightDriveEncoderChannelA,
      Constants.ENCODERS.kRightDriveEncoderChannelB,
      Constants.invert.rightencoderreversedirection,
      EncodingType.k4X);

  private Encoder hDriveEncoder = new Encoder(
      Constants.ENCODERS.kMiddle1DriveEncoderChannelA,
      Constants.ENCODERS.kMiddle1DriveEncoderChannelB,
      Constants.invert.hdriveencoder,
      EncodingType.k4X);

  private Encoder hDriveEncoder2 = new Encoder(
      Constants.ENCODERS.kMiddle2DriveEncoderChannelA,
      Constants.ENCODERS.kMiddle2DriveEncoderChannelB,
      Constants.invert.hdriveencoder2,
      EncodingType.k4X);

  RelativeEncoder encoder1;
  // ---------------------------------------
  public static Double a;
  public static boolean duzelt = false;

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
  public DifferentialDriveKinematics kinematics = new DifferentialDriveKinematics(Constants.ODOMETRY.kTrackwidthMeters);
  // ---------------------------------------

  public DriveSubsystem() {

    leftFront.setInverted(Constants.invert.leftleaderinvert);
    rightFront.setInverted(Constants.invert.rightleaderinvert);
    leftRear.setInverted(Constants.invert.leftrearinvert);
    rightRear.setInverted(Constants.invert.rightrearinvert);
    middle1.setInverted(Constants.invert.middle1);
    middle2.setInverted(Constants.invert.middle2);

    m_right.setInverted(Constants.invert.rightgroupinvert);
    m_left.setInverted(Constants.invert.leftgroupinvert);

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
    return (getLeftEncoderDistance() + getRightEncoderDistance()) / 2;
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
    return new DifferentialDriveWheelSpeeds(
        1, 1 * -1);
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
    return Math.IEEEremainder(imu.getAngle(), 360) * (Constants.invert.gyroinvert ? -1.0 : 1.0);
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
    odometry.resetPosition(GetHeadingForDifferentialDriveOdometry(),
        getLeftEncoderDistance(),
        getRightEncoderDistance(),
        odometry.getPoseMeters());
  }

  public Rotation2d GetHeadingForDifferentialDriveOdometry() {
    return Rotation2d.fromDegrees(Math.IEEEremainder(imu.getAngle(), 360) * (Constants.invert.gyroinvert ? -1.0 : 1.0));
  }

  public void arcadeDrive(Double x, Double y) {
    drive.arcadeDrive(x, y);
  }

  public void RunSpeed(double speed) {
    m_right.set(-speed);
    m_left.set(speed);
  }

  public void rotate(double speed) {
    m_right.set(speed);
    m_left.set(speed);

  }

  public void RunMiddle(double speed) {
    m_middle.set(-speed);
  }

  public void hDrive(Double x, Double y, Double z) {
    RunSpeed(y);
    RunMiddle(x);
    if (z > 0.1) {
      rotate(z);
    } else if (z < 0.1 && z > -0.1) {
      RunSpeed(y);
    } else if (-0.1 > z) {
      rotate(z);

    }
  }

  public void GetArmEncoderValue() {
    // encoder1 = armmotor1.getEncoder(SparkMaxRelativeEncoder.Type.kQuadrature,
    // 42);
    SmartDashboard.putNumber("arm encoder", encoder1.getPosition());
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

  public void RunLeftSideSpeed(double speed) {
    m_left.set(speed);
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

  public void stopNbreak() {
    StopMotors();
    CoastMode();
  }

  @Override
  public void periodic() {

    // odometry.update(GetHeadingForDifferentialDriveOdometry(),
    // getRightEncoderDistance(),
    // getLeftEncoderDistance());

    SmartDashboard.putBoolean("Connection state", imu.isConnected());
    SmartDashboard.putNumber("pitch", imu.getPitch());
    SmartDashboard.putNumber("heading", GetHeading());

    SmartDashboard.putNumber("leftencoder", getLeftEncoderDistance());
    SmartDashboard.putNumber("rightencoder", getRightEncoderDistance());
    SmartDashboard.putNumber("h1encoder", getRigthHEncoderDistance());
    SmartDashboard.putNumber("h2encoder", getLeftHEncoderDistance());

    SmartDashboard.putNumber("rightfront", rightFront.getMotorOutputVoltage());
    SmartDashboard.putNumber("rightrear", rightRear.getMotorOutputVoltage());
    SmartDashboard.putNumber("leftfront", leftFront.getMotorOutputVoltage());
    SmartDashboard.putNumber("leftrear", leftRear.getMotorOutputVoltage());

  }
}
