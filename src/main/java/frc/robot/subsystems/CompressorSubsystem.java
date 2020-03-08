package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.Compressor;
import frc.robot.CONSTANTS;

public class CompressorSubsystem extends SubsystemBase {

    private Compressor m_compressor;
    public CompressorSubsystem() {
         m_compressor = new Compressor(CONSTANTS.PCM_ID);
    }

    public void startCompressor(){
        m_compressor.start();
    }

    public void stopCompressor(){
        m_compressor.stop();
    }

}
