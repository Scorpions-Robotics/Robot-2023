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
  public static CANSparkMax LiftMotor = new CANSparkMax(Constants.CAN.kLiftMotor, MotorType.kBrushless);
  public boolean yukari = false;
  public boolean yukari2 = true;

  public double axiss1 = -200;

  public LiftSubsystem() {
    LiftMotor.setIdleMode(IdleMode.kBrake);
    LiftEncoder = LiftMotor.getEncoder();
    LiftMotor.setOpenLoopRampRate(1);
  }

  public void brakemod() {
    LiftMotor.setIdleMode(IdleMode.kBrake);
  }

  public double getRawEncoderOutput() {
    return LiftEncoder.getPosition() * -1;
  }

  public void coastmode() {
    LiftMotor.setIdleMode(IdleMode.kCoast);
  }

  public double getEditedEncoderOutput() {
    return LiftEncoder.getPosition() * -10;
  }

  public void reset() {
    LiftEncoder.setPosition(0);
  }

  public void alert() {
    SmartDashboard.putString("Uyarı", "BENGİSU ELİNE KOLUNA HAKİM OL AMK");
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
    if (option > 0.2) {
      LiftMotor.set(0.2);
    } else if (option < -0.4) {
      LiftMotor.set(-0.4);
    } else {
      LiftMotor.set(option);
    }

    if (Math.abs(option) > 0.5) {
      LiftMotor.setOpenLoopRampRate(1);
    } else {
      LiftMotor.setOpenLoopRampRate(0);
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
    SmartDashboard.putNumber("Lift data", getRawEncoderOutput());
    LiftEncoder = LiftMotor.getEncoder();

    if (getEditedEncoderOutput() > -120) {
      yukari = true;
    } else {
      yukari = false;
    }

    if (getEditedEncoderOutput() > -120) {
      yukari = true;
    } else {
      yukari = false;
    }

    if (getEditedEncoderOutput() > -140 && getEditedEncoderOutput() < -130) {
      yukari2 = true;
    } else {
      yukari2 = false;
    }

    SmartDashboard.putBoolean("asaadadd", yukari);
  }
}
