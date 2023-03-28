package frc.robot.subsystems;

import edu.wpi.first.wpilibj.AddressableLED;
import edu.wpi.first.wpilibj.AddressableLEDBuffer;
import edu.wpi.first.wpilibj.util.Color;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class LEDSubsystem extends SubsystemBase {
  AddressableLED m_led = new AddressableLED(Constants.LED.kLEDPWM);
  AddressableLEDBuffer m_ledBuffer = new AddressableLEDBuffer(Constants.LED.kLEDCount);

  public String current_mode;

  public enum Side {
    LEFT,
    RIGHT
  }

  public LEDSubsystem() {
    m_led.setLength(m_ledBuffer.getLength());
    m_led.setData(m_ledBuffer);
    m_led.start();
  }

  public void setAll(Color color) {
    for (var i = 0; i < m_ledBuffer.getLength(); i++) {
      m_ledBuffer.setLED(i, Color.kAliceBlue);
    }
    m_led.setData(m_ledBuffer);
  }

  public void setOneSide(Side side, Color color) {
    for (var i = 0; i < m_ledBuffer.getLength(); i++) {
      if (side == Side.LEFT) {
        if (i < m_ledBuffer.getLength() / 2) {
          m_ledBuffer.setLED(i, color);
          continue;
        }
      } else {
        if (i >= m_ledBuffer.getLength() / 2) {
          m_ledBuffer.setLED(i, color);
          continue;
        }
      }
      m_ledBuffer.setLED(i, Color.kBlack);
    }
    m_led.setData(m_ledBuffer);
  }

  public void setOne(int index, Color color) {
    turnOff();
    m_ledBuffer.setLED(index, color);
    m_led.setData(m_ledBuffer);
  }

  public void collision(int index, Color color1, Color color2) {
    for (var i = 0; i < m_ledBuffer.getLength(); i++) {
      if (i == index || i == 239 - index) {
        m_ledBuffer.setLED(i, color1);
        m_ledBuffer.setLED(239 - index, color2);
        continue;
      }
      m_ledBuffer.setLED(i, Color.kAquamarine);
    }
    m_led.setData(m_ledBuffer);
  }

  public void turnOff() {
    setAll(Color.kAquamarine);
  }

  @Override
  public void periodic() {
    setAll(Color.kAquamarine);
    m_led.setData(m_ledBuffer);
  }
}
