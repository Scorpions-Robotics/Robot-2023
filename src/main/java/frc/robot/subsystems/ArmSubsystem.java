package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ArmSubsystem extends SubsystemBase {

  public static CANSparkMax Axis1Motor = new CANSparkMax(6, MotorType.kBrushless);
  public static RelativeEncoder Axis1Encoder;

  public ArmSubsystem() {

  }
  
  @Override
  public void periodic() {
    Axis1Encoder = Axis1Motor.getEncoder();
    SmartDashboard.putNumber("axis1 motor encoder", Axis1Angle());
    SmartDashboard.putNumber("axis1 motor encoder edited", GetOutputAngle());

  }

public static double Axis1Angle(){
return Axis1Encoder.getPosition();
}


/*public double MapAxis1Encoder(){
  double Gearbox = 1/100;
  return Axis1Angle() * Gearbox;
  }
*/

public double GetOutputAngle(){
  //return (Axis1Angle() * 180) / 1800;
  return Axis1Angle() * 2;
  //1800 değişecek
}

public double AngleToTick(double angle){
  return (Axis1Angle() * 180) / 1800;
  //1800 değişecek
}

public void Axis1MotorOutput(double value){
Axis1Motor.set(value);
}

public static void Axis1MotorBreakMode(){
  Axis1Motor.setIdleMode(IdleMode.kBrake);
  }

  public void Axis1EncoderReset(){
    Axis1Encoder.setPosition(0);
    }

 public static void Axis1MotorStop(){
  Axis1Motor.set(0);
  }

}
