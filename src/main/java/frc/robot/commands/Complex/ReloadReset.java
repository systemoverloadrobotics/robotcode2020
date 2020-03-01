package frc.robot.commands.Complex;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

public class ReloadReset extends SequentialCommandGroup {

    public ReloadReset (Command moveBackToPos1, Command moveOffPos1){
        addCommands(moveBackToPos1, moveOffPos1);
    }

}