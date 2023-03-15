package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class LiftSubsystem extends SubsystemBase {

  RelativeEncoder liftEncoder;
  public static CANSparkMax liftMotor = new CANSparkMax(6, MotorType.kBrushless);

  public LiftSubsystem() {
    liftMotor.setIdleMode(IdleMode.kBrake);
  }

  public void forward() {
    liftMotor.set(0.4);
  }

  public void back() {
    liftMotor.set(-0.4);
  }

  public void stop() {
    liftMotor.set(0);
  }

  @Override
  public void periodic() {
    liftEncoder = liftMotor.getEncoder();
  }
}
