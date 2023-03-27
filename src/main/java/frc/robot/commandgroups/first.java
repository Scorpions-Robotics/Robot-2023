package frc.robot.commandgroups;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.Arm.ArmModeChanger3;
import frc.robot.commands.Lift.PidLiftModeChanger;
import frc.robot.subsystems.ArmSubsystem;
import frc.robot.subsystems.LiftSubsystem;

public class first extends SequentialCommandGroup {

  public first(ArmSubsystem m_arm, LiftSubsystem m_lift) {
    addCommands(
        new ArmModeChanger3(m_arm, 0, -135, 0)
            .alongWith(new PidLiftModeChanger(m_lift, () -> 100)));
  }
}
