package frc.robot.commands.Arm;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.PIDCommand;
import frc.robot.RobotContainer;
import frc.robot.subsystems.ArmSubsystem;

public class Rotate_Axis_1 extends PIDCommand {

    public Rotate_Axis_1(ArmSubsystem m_arm, double degree) {
        super(
                // 0.008, 0.02, 0.0001

                new PIDController(0.01, 0, 0),
                // 0.001347
                () -> -m_arm.getOutputAngle2,

                () -> degree + 5,

                output -> {

                    if (degree + 5 > -m_arm.getOutputAngle2) {
                        m_arm.Axis1MotorOutput(Math.max(-output, -0.20));
                        SmartDashboard.putNumber("GetOutputAngle", -m_arm.getOutputAngle2);
                    }

                else if (-m_arm.getOutputAngle2 > degree + 5) {
                        m_arm.Axis1MotorOutput(Math.min(output, 0.20));
                        SmartDashboard.putNumber("GetOutputAngle", -m_arm.getOutputAngle2);
                    }

                });
    }

    @Override
    public boolean isFinished() {
        // return getController().atSetpoint();

        Double setpoint = getController().getSetpoint();
        if (Math.abs(RobotContainer.m_arm.getOutputAngle2) > Math.abs(setpoint) - 2.5
                &&
                Math.abs(RobotContainer.m_arm.getOutputAngle2) < Math.abs(setpoint) + 2.5) {

            return true;
        } else {

            return false;
        }

    }
}
