package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Storage;
import javax.swing.Timer;

public class OpenAndCloseDoor extends CommandBase {

    private Storage m_storage = new Storage();
    private Timer stopwatch = new Timer(3,actionEvent -> execute());
    public OpenAndCloseDoor(Storage storage){

        addRequirements(storage);
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize(){
        stopwatch.start();
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        m_storage.runDoubleSolenoid();
    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {

    }

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        return false;
    }
}
