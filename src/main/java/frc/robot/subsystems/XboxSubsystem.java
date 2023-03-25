package frc.robot.subsystems;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class XboxSubsystem extends SubsystemBase {
  public double ThrottleValue = 1;

  public double axis3Value;

  public double liftValue = 0;

  public int mode = 1;
  public int mode_axis;

  public boolean stabilmode = true;

  public void modeChange(boolean increase) {
    if (increase) {
      if (mode < 3) {
        mode++;
      }
    } else {
      if (mode > 1) {
        mode--;
      }
    }
    if (mode == 1) {
      axis3Value = 0;
    }
    if (mode == 2) {
      axis3Value = 90;
    }
    if (mode == 3) {
      axis3Value = 180;
    }
    SmartDashboard.putNumber("axis3modu ne la", mode);
    SmartDashboard.putNumber("axis3 degeri ne la", axis3Value);

  }

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

  public double getAxis3Value() {
    return axis3Value;
  }

  @Override
  public void periodic() {
  }
}
