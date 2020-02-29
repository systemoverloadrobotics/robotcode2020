package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.DriveTrain;

public class TankDrive extends CommandBase {
    DriveTrain m_driveTrain;
    public TankDrive(DriveTrain tankDrive){
        m_driveTrain = tankDrive;
    }

    @Override
    public void initialize(){}

    @Override
    public void execute(){
        double m_leftSpeed = RobotContainer.left_joystick.getY();
        double m_rightSpeed = RobotContainer.right_joystick.getY();


        m_driveTrain.driveTank(m_leftSpeed, m_rightSpeed);
    }

    @Override
    public void end(boolean interrupted){m_driveTrain.driveTank(0,0);}

    @Override
    public boolean isFinished(){return false;}

}
