package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.revrobotics.RelativeEncoder;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class LiftSubsystem extends SubsystemBase {

  RelativeEncoder LiftEncoder;
  public static CANSparkMax LiftMotor = new CANSparkMax(6, MotorType.kBrushless);

  public LiftSubsystem() {
    LiftMotor.setIdleMode(IdleMode.kBrake);
    LiftEncoder = LiftMotor.getEncoder();
  }

  public double getRawEncoderOutput() {
    return LiftEncoder.getPosition();
  }

  public double getEditedEncoderOutput() {
    return LiftEncoder.getPosition() * 10;
  }

  public void reset() {
    LiftEncoder.setPosition(0);
  }

  public void setMotor(double option) {
    LiftMotor.set(option);
  }

  public void forward() {
    LiftMotor.set(0.4);
  }

  public void back() {
    LiftMotor.set(-0.4);
  }

  public void stop() {
    LiftMotor.set(0);
  }

  @Override
  public void periodic() {
    SmartDashboard.putNumber("nummmmber", getRawEncoderOutput());
    LiftEncoder = LiftMotor.getEncoder();
  }
}
