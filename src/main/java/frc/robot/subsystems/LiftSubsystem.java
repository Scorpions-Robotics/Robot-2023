package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.revrobotics.RelativeEncoder;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class LiftSubsystem extends SubsystemBase {

  public RelativeEncoder LiftEncoder;
  public static CANSparkMax LiftMotor =
      new CANSparkMax(Constants.CAN.kLiftMotor, MotorType.kBrushless);

  public LiftSubsystem() {
    LiftMotor.setIdleMode(IdleMode.kBrake);
    LiftEncoder = LiftMotor.getEncoder();
  }

  public double getRawEncoderOutput() {
    return LiftEncoder.getPosition() * -1;
  }

  public double getEditedEncoderOutput() {
    return LiftEncoder.getPosition() * -10;
  }

  public void reset() {
    LiftEncoder.setPosition(0);
  }

  public void setMotor(double option) {
    if (option > 0.25) {
      LiftMotor.set(0.25);
    } else if (option < -0.25) {
      LiftMotor.set(-0.25);
    } else {
      LiftMotor.set(option);
    }
  }

  public void pidSetMotor(double option) {
    if (option > 0.25) {
      LiftMotor.set(0.25);
    } else if (option < -0.565) {
      LiftMotor.set(-0.565);
    } else {
      LiftMotor.set(option);
    }
  }

  public void forward() {
    setMotor(0.4);
  }

  public void back() {
    setMotor(-0.4);
  }

  public void stop() {
    LiftMotor.set(0);
  }

  @Override
  public void periodic() {
    SmartDashboard.putNumber("nummmmber", getRawEncoderOutput());
    SmartDashboard.putNumber("edited", getEditedEncoderOutput());
    LiftEncoder = LiftMotor.getEncoder();
  }
}
