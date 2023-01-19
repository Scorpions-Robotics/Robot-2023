// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class XboxSubsystem extends SubsystemBase {
public double ThrottleValue = 1;
public int mode;

public XboxSubsystem() {}

  public void mode1(){
  ThrottleValue = 0.20;
  }

  public void mode2(){
    ThrottleValue = 0.40;
  }

  public void mode3(){
  ThrottleValue = 0.60;
  }

  public void mode4(){
    ThrottleValue = 0.80;
  }

  public void mode5(){
ThrottleValue = 1;
  }


public void modeincrease(){
if(ThrottleValue == 0.20){
mode2();
}

else if(ThrottleValue == 0.40){
  mode3(); 
  }

  else if(ThrottleValue == 0.60){
  mode4(); 
  }

  else if(ThrottleValue == 0.80){
  mode5(); 
  }

  else if(ThrottleValue == 1){
  ThrottleValue = 1;
  }
}

public void modedecrease(){

  if(ThrottleValue == 1){
    mode4();
    }

    else if(ThrottleValue == 0.80){
      mode3(); 
      }

      else if(ThrottleValue == 0.60){
        mode2();
        }

        else if(ThrottleValue == 0.40){
          mode1();
          }
          
     else if(ThrottleValue == 0.20){
      ThrottleValue = 0.20;
      }
}
  
  @Override
  public void periodic() {

  }
}
