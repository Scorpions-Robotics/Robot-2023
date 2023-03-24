package frc.robot.commandgroups;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.Arm.ArmModeChanger3;
import frc.robot.commands.Lift.PidLiftCommand;
import frc.robot.subsystems.ArmSubsystem;
import frc.robot.subsystems.LiftSubsystem;

public class grapthecone extends SequentialCommandGroup {

  public grapthecone(ArmSubsystem m_arm, LiftSubsystem m_lift) {
    addCommands(
        new PidLiftCommand(m_lift, () -> -170)
            .alongWith(new ArmModeChanger3(m_arm, -210, -140, 0)));
  }
}
