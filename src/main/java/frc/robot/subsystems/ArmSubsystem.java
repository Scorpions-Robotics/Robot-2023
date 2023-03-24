package frc.robot.subsystems;

import com.revrobotics.AnalogInput;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.revrobotics.RelativeEncoder;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ArmSubsystem extends SubsystemBase {

  DigitalInput axis2HallSensor = new DigitalInput(9);
  DigitalInput axis3HallSensor = new DigitalInput(8);

  // -------------------------------------
  // AXIS1----------------------------------------------
  public static CANSparkMax Axis1Motor = new CANSparkMax(6, MotorType.kBrushless);
  public static RelativeEncoder Axis1Encoder;
  // ---------------------------------------------------------------------------
  // -------------------------------------
  // AXIS2----------------------------------------------
  public static CANSparkMax Axis2Motor = new CANSparkMax(9, MotorType.kBrushless);
  public static RelativeEncoder Axis2Encoder;
  // ---------------------------------------------------------------------------
  // -------------------------------------
  // AXIS2----------------------------------------------
  public static CANSparkMax Axis3Motor = new CANSparkMax(10, MotorType.kBrushless);
  public static RelativeEncoder Axis3Encoder;
  // ---------------------------------------------------------------------------

  public double getOutputAngle2;
  public double getOutputAngle_Axis2;
  public double getOutputAngle_Axis3;
  public static double b;
  public boolean assagi = true;

  public ArmSubsystem() {
    // Axis1Motor.setIdleMode(IdleMode.kBrake);
    // Axis2Motor.setIdleMode(IdleMode.kBrake);
    // Axis3Motor.setIdleMode(IdleMode.kBrake);
    Axis2Motor.setOpenLoopRampRate(1);
    Axis1Motor.setOpenLoopRampRate(0.3);
    Axis3Motor.setOpenLoopRampRate(0.3);

  }

  public double GetOutputAngle() {
    // return (Axis1Angle() 180) / 1800;
    return Axis1Angle() * 2;
    // 1800 değişeceks
  }

  @Override
  public void periodic() {

    /*
     * if (!axis2HallSensor.get()) {
     * resetAxis2GetOutputAngle();
     * }
     * 
     * if (!axis3HallSensor.get()) {
     * resetAxis3GetOutputAngle();
     * }
     */
    Axis1Encoder = Axis1Motor.getEncoder();
    Axis2Encoder = Axis2Motor.getEncoder();
    Axis3Encoder = Axis3Motor.getEncoder();

    getOutputAngle2 = GetOutputAngle();
    getOutputAngle_Axis2 = GetOutputAxis2();
    getOutputAngle_Axis3 = GetOutputAxis3();

    modevalue3();
    modevalue2();
    modevalue();

    SmartDashboard.putNumber("1. axis", getOutputAngle2);
    SmartDashboard.putNumber("2. axis", getOutputAngle_Axis2);
    SmartDashboard.putNumber("3. axis", getOutputAngle_Axis3);
    SmartDashboard.putBoolean("wthall", axis2HallSensor.get());
  }

  public static double Axis1Angle() {
    return Axis1Encoder.getPosition();
  }

  public double getIdleAxis2() {
    if (assagi) {
      return -210;
    } else {
      return -170;
    }
  }

  public void assagida() {
    assagi = true;
  }

  public void yukarida() {
    assagi = false;
  }

  public static double Axis2Angle() {
    return Axis2Encoder.getPosition();
  }

  public void alert() {
    SmartDashboard.putString("recep", "tayyip");
  }

  public static double Axis3Angle() {
    return Axis3Encoder.getPosition();
  }

  public static double GetOutputAxis2() {
    return Axis2Angle() * 10 / 6;
    // mapleme fonksiyonu
  }

  public static double GetOutputAxis3() {
    return Axis3Angle() * 9.7;
    // mapleme fonksiyonu AXİS3
  }

  public void resetGetOutputAngle() {
    getOutputAngle2 = 0;
  }

  public void resetAxis2GetOutputAngle() {
    getOutputAngle_Axis2 = 0;
    // reset axis 2 angle
  }

  public void resetAxis3GetOutputAngle() {
    getOutputAngle_Axis3 = 0;
    // reset axis 2 angle
  }

  public void Axis1MotorOutput(double value) {
    Axis1Motor.set(value);
  }

  public void editedAxis1MotorOutput(double value) {
    if (value > 0.25) {
      Axis1Motor.set(0.25);
    } else if (value < -0.25) {
      Axis1Motor.set(-0.25);
    } else {
      Axis1Motor.set(value);
    }
  }

  public void Axis2MotorOutput(double value) {
    Axis2Motor.set(value);
  }

  public void Axis3MotorOutput(double value) {
    Axis3Motor.set(value);
  }

  public void Axis1MotorBreakMode() {
    Axis1Motor.setIdleMode(IdleMode.kBrake);
  }

  public void Axis2MotorBreakMode() {
    Axis2Motor.setIdleMode(IdleMode.kBrake);
  }

  public void Axis3MotorBreakMode() {
    Axis3Motor.setIdleMode(IdleMode.kBrake);
  }

  public static void Axis1MotorCoastMode() {
    Axis1Motor.setIdleMode(IdleMode.kCoast);
  }

  public void Axis2MotorCoastMode() {
    Axis2Motor.setIdleMode(IdleMode.kCoast);
  }

  public static void Axis3MotorCoastMode() {
    Axis3Motor.setIdleMode(IdleMode.kCoast);
  }

  public void Axis1EncoderReset() {
    Axis1Encoder.setPosition(0);
  }

  public void Axis2EncoderReset() {
    Axis2Encoder.setPosition(0);
  }

  public void Axis3EncoderReset() {
    Axis3Encoder.setPosition(0);
  }

  public void Axis1MotorStop() {
    Axis1Motor.set(0);
  }

  public void Axis2MotorStop() {
    Axis2Motor.set(0);
  }

  public void Axis3MotorStop() {
    Axis3Motor.set(0);
  }

  public void FreeMode() {
    Axis1MotorStop();
    Axis2MotorStop();
    Axis3MotorStop();
    Axis1MotorCoastMode();
    Axis2MotorCoastMode();
    Axis3MotorCoastMode();
  }

  public void modevalue() {
    if (Axis1Motor.getIdleMode() == IdleMode.kBrake) {
    }

    if (Axis1Motor.getIdleMode() == IdleMode.kCoast) {
    }
  }

  public void modevalue2() {
    if (Axis2Motor.getIdleMode() == IdleMode.kBrake) {
    }

    if (Axis2Motor.getIdleMode() == IdleMode.kCoast) {
    }
  }

  public void modevalue3() {
    if (Axis3Motor.getIdleMode() == IdleMode.kBrake) {
    }

    if (Axis3Motor.getIdleMode() == IdleMode.kCoast) {
    }
  }
}
