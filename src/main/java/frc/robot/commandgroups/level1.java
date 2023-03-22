package frc.robot.commandgroups;

import org.ejml.sparse.csc.linsol.qr.LinearSolverQrLeftLooking_DSCC;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.Arm.ArmModeChanger3;
import frc.robot.commands.Lift.PidLiftCommand;
import frc.robot.commands.Lift.PidLiftModeChanger;
import frc.robot.subsystems.ArmSubsystem;
import frc.robot.subsystems.LiftSubsystem;
import frc.robot.subsystems.XboxSubsystem;

public class level1 extends SequentialCommandGroup {

  public level1(ArmSubsystem m_arm, LiftSubsystem m_lift, XboxSubsystem m_xbox) {
    addCommands(
        new PidLiftCommand(m_lift, () -> -150)
            .alongWith(
                new ArmModeChanger3(m_arm, -190, -110, 0)));
  }
}
