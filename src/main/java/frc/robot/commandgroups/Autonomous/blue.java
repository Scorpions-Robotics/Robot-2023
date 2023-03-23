package frc.robot.commandgroups.Autonomous;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.Arm.Rotate_Axis_2;
import frc.robot.commands.Lift.PidLiftCommand;
import frc.robot.subsystems.ArmSubsystem;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.LiftSubsystem;

public class blue extends SequentialCommandGroup {
  public blue(LiftSubsystem m_lift, ArmSubsystem m_arm, DriveSubsystem m_drive) {

    addCommands(
        new PidLiftCommand(m_lift, () -> 500)
            .alongWith(new Rotate_Axis_2(m_arm, -150))
            .withTimeout(3)
            .andThen(new Rotate_Axis_2(m_arm, 0))
            .withTimeout(5)
            .andThen(new PidLiftCommand(m_lift, () -> 0)));
  }
}
