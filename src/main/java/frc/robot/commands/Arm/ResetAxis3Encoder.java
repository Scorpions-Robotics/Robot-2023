package frc.robot.commands.Arm;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ArmSubsystem;

public class ResetAxis3Encoder extends CommandBase {
    ArmSubsystem m_arm;

    public ResetAxis3Encoder(ArmSubsystem m_arm) {
        this.m_arm = m_arm;
    }

    @Override
    public void initialize() {
    }

    @Override
    public void execute() {
        m_arm.Axis3EncoderReset();
        m_arm.resetAxis3GetOutputAngle();
    }

    @Override
    public void end(boolean interrupted) {
    }

    @Override
    public boolean isFinished() {
        return true;
    }
}
