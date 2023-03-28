package frc.robot.commandgroups;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.Arm.ArmModeChanger3;
import frc.robot.commands.Lift.PidLiftCommand;
import frc.robot.subsystems.ArmSubsystem;
import frc.robot.subsystems.LiftSubsystem;

public class grabthecone2 extends SequentialCommandGroup {

  public grabthecone2(ArmSubsystem m_arm, LiftSubsystem m_lift) {
    addCommands(
        // new Rotate_Axis_1(m_arm, -160)
        // .andThen(new PidLiftCommand(m_lift, () -> -140))
        // .withTimeout(2.5)
        // .andThen(
        new ArmModeChanger3(m_arm, -63, -7, 0)
            .alongWith()
            .alongWith(new PidLiftCommand(m_lift, () -> -170)));
  }
}
