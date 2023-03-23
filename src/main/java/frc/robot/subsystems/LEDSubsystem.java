package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class LEDSubsystem extends SubsystemBase {
  // AddressableLED m_led = new AddressableLED(Constants.LED.kLEDPWM);
  // AddressableLEDBuffer m_ledBuffer = new
  // AddressableLEDBuffer(Constants.LED.kLEDCount);

  // public String current_mode;

  // public int m_rainbowFirstPixelHue = 0;

  // public enum Side {
  // LEFT,
  // RIGHT
  // }

  // public LEDSubsystem() {
  // m_led.setLength(m_ledBuffer.getLength());
  // m_led.setData(m_ledBuffer);
  // m_led.start();
  // }

  // public void setAll(Color color) {
  // for (var i = 0; i < m_ledBuffer.getLength(); i++) {
  // m_ledBuffer.setLED(i, color);
  // }
  // m_led.setData(m_ledBuffer);
  // }

  // public void setOneSide(Side side, Color color) {
  // for (var i = 0; i < m_ledBuffer.getLength(); i++) {
  // if (side == Side.LEFT) {
  // if (i < m_ledBuffer.getLength() / 2) {
  // m_ledBuffer.setLED(i, color);
  // continue;
  // }
  // } else {
  // if (i >= m_ledBuffer.getLength() / 2) {
  // m_ledBuffer.setLED(i, color);
  // continue;
  // }
  // }
  // m_ledBuffer.setLED(i, Color.kBlack);
  // }
  // m_led.setData(m_ledBuffer);
  // }

  // public void setOne(int index, Color color) {
  // turnOff();
  // m_ledBuffer.setLED(index, color);
  // m_led.setData(m_ledBuffer);
  // }

  // public void rainbow() {
  // // For every pixel
  // for (var i = 0; i < m_ledBuffer.getLength(); i++) {
  // // Calculate the hue - hue is easier for rainbows because the color
  // // shape is a circle so only o ne value needs to precess
  // final var hue = (m_rainbowFirstPixelHue + (i * 180 /
  // m_ledBuffer.getLength())) % 180;
  // // Set the value
  // m_ledBuffer.setHSV(i, hue, 255, 128);
  // }
  // // Increase by to make the rainbow "move"
  // m_rainbowFirstPixelHue += 3;
  // // Check bounds
  // m_rainbowFirstPixelHue %= 180;
  // m_led.setData(m_ledBuffer);
  // }

  // public void collision(int index, Color color1, Color color2) {
  // for (var i = 0; i < m_ledBuffer.getLength(); i++) {
  // if (i == index || i == (m_ledBuffer.getLength() - 1) - index) {
  // m_ledBuffer.setLED(i, color1);
  // m_ledBuffer.setLED((m_ledBuffer.getLength() - 1) - index, color2);
  // continue;
  // }
  // m_ledBuffer.setLED(i, Color.kBlack);
  // }
  // m_led.setData(m_ledBuffer);
  // }

  // public void turnOff() {
  // setAll(Color.kBlack);
  // }

  // @Override
  // public void periodic() {
  // // m_led.setData(m_ledBuffer);
  // }
}
