package frc.robot.commandgroups;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.Arm.ArmModeChanger3;
import frc.robot.commands.Arm.Rotate_Axis_1;
import frc.robot.commands.Lift.PidLiftCommand;
import frc.robot.subsystems.ArmSubsystem;
import frc.robot.subsystems.LiftSubsystem;

public class grapthecone extends SequentialCommandGroup {

  public grapthecone(ArmSubsystem m_arm, LiftSubsystem m_lift) {
    addCommands(
        // new Rotate_Axis_1(m_arm, -100)
        // .andThen(new PidLiftCommand(m_lift, () -> -125))
        // .withTimeout(2.5)
        // .andThen(
        new ArmModeChanger3(m_arm, -115, -80, 0)
            .alongWith(new PidLiftCommand(m_lift, () -> -100)));
  }
}
