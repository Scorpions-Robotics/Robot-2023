package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class XboxSubsystem extends SubsystemBase {
  public double ThrottleValue = 1;

  public double liftValue = 0;

  public double axis1Value = 0;
  public double axis2Value = 0;
  public double axis3Value = 0;

  public int mode;
  public boolean stabilmode = true;

  public XboxSubsystem() {
  }

  public void mode1() {
    ThrottleValue = 0.20;
  }

  public void mode2() {
    ThrottleValue = 0.40;
  }

  public void mode3() {
    ThrottleValue = 0.60;
  }

  public void mode4() {
    ThrottleValue = 0.80;
  }

  public void mode5() {
    ThrottleValue = 1;
  }

  public void turnonstabilmode() {

    stabilmode = true;
  }

  public void turnoffstabilmode() {

    stabilmode = false;
  }

  public void changestabilmode() {

    if (stabilmode) {
      stabilmode = false;
    } else {
      stabilmode = true;
    }
  }

  public void modeincrease() {
    if (ThrottleValue == 0.20) {
      mode2();
    } else if (ThrottleValue == 0.40) {
      mode3();
    } else if (ThrottleValue == 0.60) {
      mode4();
    } else if (ThrottleValue == 0.80) {
      mode5();
    } else if (ThrottleValue == 1) {
      ThrottleValue = 1;
    }
  }

  public void modedecrease() {

    if (ThrottleValue == 1) {
      mode4();
    } else if (ThrottleValue == 0.80) {
      mode3();
    } else if (ThrottleValue == 0.60) {
      mode2();
    } else if (ThrottleValue == 0.40) {
      mode1();
    } else if (ThrottleValue == 0.20) {
      ThrottleValue = 0.20;
    }
  }

  public void modeLift1() {
    liftValue = Constants.liftValue.level1;
  }

  public void modeLift2() {
    liftValue = Constants.liftValue.level2;
  }

  public void modeLift3() {
    liftValue = Constants.liftValue.level3;
  }

  public double getLiftValue() {
    return liftValue;
  }

  public double getAxis1Value() {
    return axis1Value;
  }

  public double getAxis2Value() {
    return axis2Value;
  }

  public double getAxis3Value() {
    return axis3Value;
  }

  public void changeAxisValue(int mode) {
    if (mode == 1) {
      axis1Value = 0;
      axis2Value = 0;
      axis3Value = 0;

    } else if (mode == 2) {
      axis1Value = 20;
      axis2Value = 20;
      axis3Value = 20;

    } else if (mode == 3) {
      axis1Value = 30;
      axis2Value = 30;
      axis3Value = 30;

    } else if (mode == 4) {
      axis1Value = 50;
      axis2Value = 50;
      axis3Value = 50;
    }
  }

  @Override
  public void periodic() {
  }
}
