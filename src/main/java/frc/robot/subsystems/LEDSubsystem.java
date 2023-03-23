package frc.robot.subsystems;

import java.util.*;
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
      m_ledBuffer.setLED(i, color);
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
      if (i == index || i == 11 - index) {
        m_ledBuffer.setLED(i, color1);
        m_ledBuffer.setLED(11 - index, color2);
        continue;
      }
      m_ledBuffer.setLED(i, Color.kBlack);
    }
    m_led.setData(m_ledBuffer);
  }

  public void turnOff() {
    setAll(Color.kBlack);
  }

  public void ThreeColorMode(Color color1, Color color2, Color color3) {
    List<Color> list = new ArrayList<Color>();
    list.add(color1);
    list.add(color2);
    list.add(color3);
    int repet = (m_ledBuffer.getLength() + 1) / 3;
    for (int j = 0; j < 3; j++) {
      for (int i = 0; i < repet; i++) {
        m_ledBuffer.setLED(3 * i, list.get((j) % 3));
        m_ledBuffer.setLED(3 * i + 1, list.get((j + 1) % 3));
        m_ledBuffer.setLED(3 * i + 2, list.get((j + 2) % 3));
      }
    }
  }

  public void DividThreeColorMode(Color color1, Color color2, Color color3) {
    List<Color> list = new ArrayList<Color>();
    list.add(color1);
    list.add(color2);
    list.add(color3);
    int repet = (m_ledBuffer.getLength() + 1) / 3;
    for (int i = 0; i < repet; i++) {
      m_ledBuffer.setLED(3 * i, color1);
      m_ledBuffer.setLED(3 * i + 1, color2);
      m_ledBuffer.setLED(3 * i + 2, color3);
    }
  }

  public void DividColor(Color color, int index, int divid) {
    int repet = (m_ledBuffer.getLength() + 1) / divid;
    for (int i = 0; i < repet; i++) {
      m_ledBuffer.setLED(3 * i + index, color);
    }
  }

  @Override
  public void periodic() {
    m_led.setData(m_ledBuffer);
  }
}