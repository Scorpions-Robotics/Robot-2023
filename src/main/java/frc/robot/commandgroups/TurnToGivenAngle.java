package frc.robot.commandgroups;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.Drivetrain.GyroReset;
import frc.robot.commands.Drivetrain.pidAngleTurn;
import frc.robot.subsystems.DriveSubsystem;

public class TurnToGivenAngle extends SequentialCommandGroup {

  DriveSubsystem m_drive;
  double angle;

  public TurnToGivenAngle(DriveSubsystem m_drive, double angle) {

    this.m_drive = m_drive;
    this.angle = angle;

    addCommands(

    new GyroReset(m_drive).alongWith(
      new pidAngleTurn(m_drive,angle))
    );

  }
}
