package frc.robot.commands.Drivetrain;
/*
 * import edu.wpi.first.math.controller.PIDController;
 * import edu.wpi.first.wpilibj2.command.PIDCommand;
 * import frc.robot.subsystems.DriveSubsystem;
 *
 * public class pidChargeStation extends PIDCommand {
 * public pidChargeStation(DriveSubsystem m_drive) {
 * super(
 * new PIDController(1, 0, 0),
 * () -> m_drive.GetPitch(),
 * () -> 0,
 *
 * output -> {
 * if (m_drive.GetPitch() > 0) {
 * m_drive.arcadeDrive(0,Math.min(-output, -0.45));
 * //outputtaki "-"leri gözden geçir!
 * }
 * else if (0 > m_drive.GetPitch()) {
 * m_drive.arcadeDrive(0,Math.max(output, 0.45));
 * }
 *
 * });
 *
 * }
 *
 * @Override
 * public boolean isFinished() {
 * return getController().atSetpoint();
 * }
 *
 * }
 */
