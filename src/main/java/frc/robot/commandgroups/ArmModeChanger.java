package frc.robot.commandgroups;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.Arm.Rotate_Axis_1;
import frc.robot.commands.Arm.Rotate_Axis_2;
import frc.robot.commands.Arm.Rotate_Axis_3;
import frc.robot.subsystems.ArmSubsystem;
import frc.robot.subsystems.XboxSubsystem;

public class ArmModeChanger extends SequentialCommandGroup {

  public ArmModeChanger(ArmSubsystem m_arm, XboxSubsystem m_xbox) {

    addCommands(
        new Rotate_Axis_2(m_arm, m_xbox.axis2Value)
            .alongWith(new Rotate_Axis_1(m_arm, m_xbox.axis1Value))
            .alongWith(new Rotate_Axis_3(m_arm, m_xbox.axis3Value)));
    addRequirements(m_arm);
  }
}
