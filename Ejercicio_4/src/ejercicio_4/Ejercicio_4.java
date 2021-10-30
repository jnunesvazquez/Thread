package ejercicio_4;

import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Ejercicio_4 extends Thread{

    public static void main(String[] args) throws InterruptedException {
        Hilo1 h1 = new Hilo1("Pepe");
        Hilo2 h2 = new Hilo2("Luisa");
        Hilo3 h3 = new Hilo3("Javier");
        h1.start();
        h2.start();
        h3.start();
    }
}
