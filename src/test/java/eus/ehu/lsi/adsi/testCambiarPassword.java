package eus.ehu.lsi.adsi;

import static org.junit.Assert.*;

import org.junit.Test;

import com.zetcode.Juego;

import com.zetcode.enviarCorreo;
public class testCambiarPassword {

    
    @Test
    public void testCambiarPassword(){


        // Caso 1 No ha introducido nueva contraseña y pulsa aceptar
        Juego.getMiJuego().registrarJugador("prueba@gmail.com", "paco", "paco");
        assertEquals("error",Juego.getMiJuego().cambiarPassword("paco",""));




        // Caso 2 Ha introducido nueva contraseña y pulsa cambiar


        //  NO SE PUEDE MOSTRAR PERO NO CAMBIA NADA SIGUE MANTENIENDO LA ANTERIOR

        // Caso 3 Ha introducido nueva contraseña y pulsa salir
        assertEquals("correcto",Juego.getMiJuego().cambiarPassword("paco","NUEVACONTRA"));

        















        //Caso 1 no ha introducido algun dato
        //añadimos el jugador
        Juego.getMiJuego().registrarJugador("prueba@gmail.com", "paco", "paco");
            //Caso 1.1 No ha introducido el correo
            assertEquals("error",Juego.getMiJuego().recuperarPassword("", "paco"));
            //Caso 1.1 No ha introducido el usuario
            assertEquals("error",Juego.getMiJuego().recuperarPassword("fa@gmail.com", ""));
            //Caso 1.1 No ha introducido ni correo ni usuario
            assertEquals("error",Juego.getMiJuego().recuperarPassword("", ""));

            //Caso 1.1 No existe el correo utilizado
            assertEquals("error",Juego.getMiJuego().recuperarPassword("cewf", "paco"));

            //Caso 1.1 No existe el usuario utilizado
            assertEquals("error",Juego.getMiJuego().recuperarPassword("prueba@gmail.com", "vercdse"));

            //Caso 1.1 No existe ni correo ni usuario
            assertEquals("error",Juego.getMiJuego().recuperarPassword("retuyhe@gmail.com", "vercdse"));

            //Caso 2 no ha introducido algun dato del mensaje()
             assertEquals("correcto",Juego.getMiJuego().recuperarPassword("prueba@gmail.com", "paco"));
             assertEquals("error",enviarCorreo.enviarCorreo("", "Prueba","Esto es una prueba"));
             assertEquals("error",enviarCorreo.enviarCorreo("", "Prueba",""));
             assertEquals("error",enviarCorreo.enviarCorreo("", "",""));
           
             //Caso3 TODO FUNCIONA BIEN
            assertEquals("correcto",enviarCorreo.enviarCorreo("prueba@gmail.com", "Prueba","Esto es una prueba"));
           

    }

    
}
