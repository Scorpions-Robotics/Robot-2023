package frc.robot.commandgroups;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.Arm.ArmModeChanger3;
import frc.robot.commands.Lift.PidLiftCommand;
import frc.robot.subsystems.ArmSubsystem;
import frc.robot.subsystems.LiftSubsystem;
import frc.robot.subsystems.XboxSubsystem;

public class level3 extends SequentialCommandGroup {

  public level3(ArmSubsystem m_arm, LiftSubsystem m_lift, XboxSubsystem m_xbox) {
    addCommands(
        new PidLiftCommand(m_lift, () -> 400)
            .alongWith(new ArmModeChanger3(m_arm, -18, -130, 0)));
  }
}
