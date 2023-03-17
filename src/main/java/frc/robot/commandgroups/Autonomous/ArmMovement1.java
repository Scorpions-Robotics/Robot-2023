package frc.robot.commandgroups.Autonomous;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.Arm.Rotate_Axis_1;
import frc.robot.commands.Arm.Rotate_Axis_2;
import frc.robot.commands.Arm.Rotate_Axis_3;
import frc.robot.subsystems.ArmSubsystem;

public class ArmMovement1 extends SequentialCommandGroup {
    public ArmMovement1(ArmSubsystem m_arm) {
        addCommands(new Rotate_Axis_1(m_arm, 90)
                .alongWith(new Rotate_Axis_2(m_arm, 45))
                .alongWith(new Rotate_Axis_3(m_arm, 180)));
    }
}
