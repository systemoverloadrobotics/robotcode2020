package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.DoubleSolenoid;


public class Storage extends SubsystemBase {

    private DoubleSolenoid m_doubleSolenoid = new DoubleSolenoid(3,0,1);

    public Storage() {

    }

    public void runPolycordForward(){

    }

    public void runPolycordBackward(){

    }

    public boolean[] ballPositions(){

        return new boolean[1]; //placeholder for the return type
    }

    public void runDoubleSolenoid(){
        m_doubleSolenoid.set(DoubleSolenoid.Value.kForward);
    }
    
}
