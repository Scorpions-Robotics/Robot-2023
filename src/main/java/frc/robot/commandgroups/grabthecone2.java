package frc.robot.commandgroups;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.Arm.ArmModeChanger3;
import frc.robot.commands.Lift.PidLiftCommand;
import frc.robot.subsystems.ArmSubsystem;
import frc.robot.subsystems.LiftSubsystem;
import frc.robot.subsystems.XboxSubsystem;

public class grabthecone2 extends SequentialCommandGroup {

  public grabthecone2(ArmSubsystem m_arm, LiftSubsystem m_lift) {
    addCommands(
        new PidLiftCommand(m_lift, () -> -157)
            .alongWith(new ArmModeChanger3(m_arm, -173, -14, -90)));
  }
}
