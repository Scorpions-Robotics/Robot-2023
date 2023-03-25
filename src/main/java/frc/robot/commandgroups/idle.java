package frc.robot.commandgroups;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.Arm.ArmModeChanger3;
import frc.robot.commands.Arm.Rotate_Axis_1;
import frc.robot.commands.Arm.Rotate_Axis_2;
import frc.robot.commands.Lift.PidLiftCommand;
import frc.robot.subsystems.ArmSubsystem;
import frc.robot.subsystems.LiftSubsystem;

public class idle extends SequentialCommandGroup {

  public idle(ArmSubsystem m_arm, LiftSubsystem m_lift) {
    addCommands(
        new Rotate_Axis_2(m_arm, m_arm.getIdleAxis2())
            .andThen(new Rotate_Axis_1(m_arm, m_arm.getIdleAxis1()))
            .andThen(new PidLiftCommand(m_lift, () -> -170))
            .alongWith(new ArmModeChanger3(m_arm, -80, -170, 0)));
    // new ArmModeChanger3(m_arm, 0, -170, 0));
  }
}
