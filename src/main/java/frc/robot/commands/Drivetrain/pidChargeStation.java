package frc.robot.commands.Drivetrain;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.PIDCommand;
import frc.robot.subsystems.DriveSubsystem;

public class pidChargeStation extends PIDCommand {
    public pidChargeStation(DriveSubsystem m_drive) {
        super(
                new PIDController(0.08, 0, 0),
                () -> m_drive.GetRoll(),
                () -> 0,

                output -> {
                    if (m_drive.GetRoll() > 2) {
                        m_drive.RunTogether(output, -output, 0.0, 0.0);
                        // outputtaki "-"leri gözden geçir!
                    } else if (m_drive.GetRoll() < -2) {
                        m_drive.RunTogether(output, -output, 0.0, 0.0);
                        // outputtaki "-"leri gözden geçir!
                    }

                });
        getController().setTolerance(3);
    }

    @Override
    public boolean isFinished() {
        return getController().atSetpoint();
    }

}