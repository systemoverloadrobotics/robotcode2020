package frc.robot.commands.Complex;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;

public class ReadyToFire extends ParallelCommandGroup {

    public ReadyToFire (Command align, Command moveToChamber, Command warmUpMotor){
        addCommands(align, moveToChamber, warmUpMotor);
    }

}
