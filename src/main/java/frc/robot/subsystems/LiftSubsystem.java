package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class LiftSubsystem extends SubsystemBase {

  RelativeEncoder LiftEncoder;
  public static CANSparkMax LiftMotor = new CANSparkMax(6, MotorType.kBrushless);

  public LiftSubsystem() {

    LiftMotor.setIdleMode(IdleMode.kBrake);
  }


public void forward(){
LiftMotor.set(0.4);
}

public void back(){
  LiftMotor.set(-0.4);
}


public void stop(){
  LiftMotor.set(0);
}

  @Override
  public void periodic() {

  }
}
