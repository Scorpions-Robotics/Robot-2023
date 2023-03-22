package frc.robot.commandgroups;

import edu.wpi.first.wpilibj2.command.PIDCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.Arm.ArmModeChanger3;
import frc.robot.commands.Lift.PidLiftCommand;
import frc.robot.commands.Lift.PidLiftModeChanger;
import frc.robot.subsystems.ArmSubsystem;
import frc.robot.subsystems.LiftSubsystem;
import frc.robot.subsystems.XboxSubsystem;

public class level2 extends SequentialCommandGroup {

  public level2(ArmSubsystem m_arm, LiftSubsystem m_lift, XboxSubsystem m_xbox) {
    addCommands(
        new PidLiftCommand(m_lift, () -> -110)
            .alongWith(
                new ArmModeChanger3(m_arm, -3.5, -2.5, 0)));
  }
}
