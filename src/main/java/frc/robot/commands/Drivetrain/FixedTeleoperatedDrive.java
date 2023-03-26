package frc.robot.commands.Drivetrain;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.XboxSubsystem;
import java.util.function.DoubleSupplier;

public class FixedTeleoperatedDrive extends CommandBase {

  DriveSubsystem m_drivesubsystem;
  XboxSubsystem m_xboxSubsystem;
  DoubleSupplier xspeed;
  DoubleSupplier yrotation;
  DoubleSupplier zrotation;
  DoubleSupplier heading;
  public double hDriveFront;
  public double hDriveBack;
  public double X;
  public double Y;
  public double gyrovalue;

  public FixedTeleoperatedDrive(
      DriveSubsystem m_drivesubsystem,
      XboxSubsystem m_xboxSubsystem,
      DoubleSupplier xspeed,
      DoubleSupplier yrotation,
      DoubleSupplier zrotation) {

    this.m_drivesubsystem = m_drivesubsystem;
    this.xspeed = xspeed;
    this.yrotation = yrotation;
    this.m_xboxSubsystem = m_xboxSubsystem;
    this.zrotation = zrotation;
    addRequirements(m_drivesubsystem);
  }

  @Override
  public void initialize() {}

  @Override
  public void execute() {
    if (m_drivesubsystem.fixed) {

      if (Math.abs(m_drivesubsystem.GetHeading()) < 180) {
        gyrovalue = m_drivesubsystem.GetHeading();

      } else if (Math.abs(m_drivesubsystem.GetHeading()) > 180) {
        gyrovalue = m_drivesubsystem.GetHeadingForFastReturn();
      }

      if (gyrovalue > 10) {
        gyrovalue = 10;
      } else if (gyrovalue < -10) {
        gyrovalue = -10;
      }

      X = -(xspeed.getAsDouble() * m_xboxSubsystem.ThrottleValue) * 0.9;
      double rightSpeed = X + gyrovalue * 0.02;
      double leftSpeed = X - gyrovalue * 0.02;
      Y = (yrotation.getAsDouble() * m_xboxSubsystem.ThrottleValue) * 0.9;
      hDriveFront = Y - gyrovalue * 0.04;
      hDriveBack = Y + gyrovalue * 0.04;
      SmartDashboard.putNumber("rightSS", rightSpeed);
      SmartDashboard.putNumber("leftSS", leftSpeed);
      SmartDashboard.putNumber("hDriveFSS", hDriveFront);
      SmartDashboard.putNumber("hDriveBSS", hDriveBack);

      if (Math.abs(zrotation.getAsDouble()) > 0.015) {
        m_drivesubsystem.fixed = false;
      }
      m_drivesubsystem.RunTogether(
          rightSpeed + zrotation.getAsDouble(),
          -leftSpeed + zrotation.getAsDouble(),
          hDriveFront,
          hDriveBack);
    }

    if (!m_drivesubsystem.fixed) {

      m_drivesubsystem.hDrive(
          -yrotation.getAsDouble() * m_xboxSubsystem.ThrottleValue,
          -xspeed.getAsDouble() * m_xboxSubsystem.ThrottleValue,
          zrotation.getAsDouble() * m_xboxSubsystem.ThrottleValue);
    }

    SmartDashboard.putBoolean("fixed?", m_drivesubsystem.fixed);

    // if (X > 0.1) {
    // m_drivesubsystem.RunTogether(-rightSpeed, leftSpeed);
    // // m_drivesubsystem.hDrive(X, Y, (zrotation.getAsDouble() *
    // // m_xboxSubsystem.ThrottleValue));
    // } else if (X < -0.1) {
    // m_drivesubsystem.RunTogether(-rightSpeed, leftSpeed);
    // // m_drivesubsystem.hDrive(X, Y, (zrotation.getAsDouble() *
    // // m_xboxSubsystem.ThrottleValue));
    // } else if (X > 0.1) {
    // m_drivesubsystem.RunTogether(-rightSpeed, leftSpeed);
    // // m_drivesubsystem.hDrive(X, Y, (zrotation.getAsDouble() *
    // // m_xboxSubsystem.ThrottleValue));
    // } else if (Y > 0.1) {
    // m_drivesubsystem.RunTogether(-rightSpeed, leftSpeed);
    // // m_drivesubsystem.hDrive(X, Y, (zrotation.getAsDouble() *
    // // m_xboxSubsystem.ThrottleValue));
    // } else if (Y < -0.1) {
    // m_drivesubsystem.RunTogether(-rightSpeed, -leftSpeed);
    // // m_drivesubsystem.hDrive(X, Y, (zrotation.getAsDouble() *
    // // m_xboxSubsystem.ThrottleValue));
    // }

    SmartDashboard.putNumber("XDegeri", X);
    SmartDashboard.putNumber("YDegeri", Y);
    // ConfiguratedThrottle = (throttle.getAsDouble() * -1 + 1) / 2;
    // :( m_drivesubsystem.arcadeDrive(xspeed.getAsDouble() * ConfiguratedThrottle,
    // yrotation.getAsDouble() * ConfiguratedThrottle);

    // if(m_xboxSubsystem.stabilmode == false){

    // m_drivesubsystem.hDrive(
    // xspeed.getAsDouble() * m_xboxSubsystem.ThrottleValue,
    // -yrotation.getAsDouble() * m_xboxSubsystem.ThrottleValue,
    // zrotation.getAsDouble() * m_xboxSubsystem.ThrottleValue);

    // }

    /*
     * if(m_xboxSubsystem.stabilmode == true){
     *
     * //if(Math.abs(zrotation.getAsDouble()) > 0.09){
     * //m_drivesubsystem.ResetGyro();
     * //}
     *
     * m_drivesubsystem.hDrive(xspeed.getAsDouble() * m_xboxSubsystem.ThrottleValue,
     * yrotation.getAsDouble() * m_xboxSubsystem.ThrottleValue,
     * -zrotation.getAsDouble() * m_xboxSubsystem.ThrottleValue);
     *
     *
     * if(yrotation.getAsDouble() < 0.1 && yrotation.getAsDouble() > -0.1 &&
     * xspeed.getAsDouble() > -0.1 && xspeed.getAsDouble() < 0.1){
     * new pidAngleTurn(m_drivesubsystem, neededangle);
     * m_drivesubsystem.a = neededangle;
     * m_drivesubsystem.duzelt = true;
     *
     * SmartDashboard.putBoolean("deneme", true);
     * }
     *
     * else{
     * m_drivesubsystem.duzelt = false;
     * SmartDashboard.putBoolean("deneme", false);
     * }
     */

    SmartDashboard.putNumber("nummber", m_drivesubsystem.GetHeading());
    SmartDashboard.putNumber("xspeed", xspeed.getAsDouble());
    SmartDashboard.putNumber("yrotation", yrotation.getAsDouble());
    SmartDashboard.putNumber("zrotation", zrotation.getAsDouble());
    // }
  }

  @Override
  public void end(boolean interrupted) {}

  @Override
  public boolean isFinished() {
    return false;
  }
}
