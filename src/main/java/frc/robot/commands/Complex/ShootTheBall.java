package frc.robot.commands.Complex;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

public class ShootTheBall extends SequentialCommandGroup {

    public ShootTheBall (Command readyToFire, Command moveToShooter, Command ceaseFire, double rpm){
        addCommands(readyToFire, moveToShooter, ceaseFire);
    }

}

