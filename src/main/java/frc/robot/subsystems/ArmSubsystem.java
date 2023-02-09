package frc.robot.subsystems;


import com.ctre.phoenix.sensors.CANCoder;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ArmSubsystem extends SubsystemBase {

  public static CANSparkMax Axis1Motor = new CANSparkMax(3, MotorType.kBrushless);
  public static CANCoder Axis1Encoder = new CANCoder(3);

  public ArmSubsystem() {}


public static double Axis1Angle(){
//return Axis1Encoder.getPosition();
return Axis1Encoder.getPosition();
}


public double MapAxis1Encoder(){
  double MapValue = 0;
  return Axis1Angle() * MapValue;
  }


public void Axis1MotorOutput(double value){
Axis1Motor.set(value);
}

public static void Axis1MotorBreakMode(){
  Axis1Motor.setIdleMode(IdleMode.kBrake);
  }

 public static void Axis1MotorStop(){
  Axis1Motor.set(0);
  }


  @Override
  public void periodic() {
    SmartDashboard.putNumber("axis1 motor encoder", Axis1Angle());
  }
}
