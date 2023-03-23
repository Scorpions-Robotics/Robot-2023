package frc.robot.commands.LED;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.RunCommand;
import frc.robot.subsystems.LEDSubsystem;
import edu.wpi.first.wpilibj.util.Color;

public class LEDCommand extends SequentialCommandGroup {
    LEDSubsystem m_led;
    Color sRed = Color.kRed;
    Color sYellow = Color.kYellow;
    Color sWhite = Color.kWhite;

    public LEDCommand(LEDSubsystem m_led) {
        this.m_led = m_led;
        addCommands(
                new RunCommand(() -> m_led.DividThreeColorMode(sRed, sYellow, sWhite), m_led).withTimeout(0.05),
                new RunCommand(() -> m_led.DividThreeColorMode(sYellow, sWhite, sRed), m_led).withTimeout(0.05),
                new RunCommand(() -> m_led.DividThreeColorMode(sWhite, sRed, sYellow), m_led).withTimeout(0.05));
    }
}