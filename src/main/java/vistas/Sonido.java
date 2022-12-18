package vistas;
import java.io.IOException;
import java.util.Objects;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;


public class Sonido {
    private static Sonido miSonido;
    private Clip clip;
    private AudioInputStream audioInputStream;

    public void reproducirSondoEnLoop(String nombreSonido) {
        if(!Objects.isNull(clip)){
            clip.stop();
        }
        try {
            audioInputStream = AudioSystem.getAudioInputStream(getClass().getResource(nombreSonido));
            clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.loop(Clip.LOOP_CONTINUOUSLY);
            //  Thread.sleep(3600000);
        } catch(UnsupportedAudioFileException | IOException | LineUnavailableException  ex) {
            ex.printStackTrace();
            System.out.println("Error al reproducir el sonido.");
        }
    }

    private Sonido() {
    }

    public static Sonido getMiSonido(){
        if (miSonido==null) {
            miSonido= new Sonido();
        }
        return miSonido;
    }
    
    public void detenerSonido() {
    	//para parar el sonido cuando acabe el juego y no te desquicie
    	clip.stop();
    }
}
