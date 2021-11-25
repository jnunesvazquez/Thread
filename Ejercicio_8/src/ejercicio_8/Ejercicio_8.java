package ejercicio_8;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Ejercicio_8 extends Thread{

    public  static boolean ocupado = false;
    public static int pisoActual = 0;
    public static int pisoDestino;
    public static int llamada;
    
    public Ejercicio_8(String str, int llamada, int pisoDestino) {
        super(str);
        this.llamada = llamada;
        this.pisoDestino = pisoDestino;
    }
    
    @Override
    public void run(){
        llamada();
        llegada();
    }
    
    public synchronized void llamada(){
        System.out.println("Esta llamando " + getName());
        while (ocupado){
            try {
                System.out.println(getName() + " esta esperando en la cola");
                wait();
            } catch (InterruptedException ex) {}
        }
        ocupado = true;
        while (pisoActual != llamada){
            if (pisoActual < llamada){
                pisoActual++;
                System.out.println("El ascensor esta en el piso " + pisoActual);
                try {
                    sleep(1000);
                } catch (InterruptedException ex) {}
            }
            if (pisoActual > llamada){
                pisoActual--;
                System.out.println("El ascensor esta en el piso " + pisoActual);
                try {
                    sleep(1000);
                } catch (InterruptedException ex) {}
            }
        }
        System.out.println("El ascensor recoge al pasajero");
    }

    public synchronized void llegada(){
        while (pisoActual != pisoDestino){
                if (pisoActual < pisoDestino){
                    pisoActual++;
                    System.out.println("El ascensor esta en el piso " + pisoActual);
                    try {
                        sleep(1000);
                    } catch (InterruptedException ex) {}
                }
                if (pisoActual > pisoDestino){
                    pisoActual--;
                    System.out.println("El ascensor esta en el piso " + pisoActual);
                    try {
                        sleep(1000);
                    } catch (InterruptedException ex) {}
                }
            }
            System.out.println("El ascensor ha llegado a su destino");
            ocupado = false;
            notify();
    }

    public static void main(String[] args) throws InterruptedException {
        Ejercicio_8 h2 = new Ejercicio_8("Maria", 13, 4);
         h2.start();
         //h2.join();
        Ejercicio_8 h1 = new Ejercicio_8("Luis", 5, 8);
         h1.start();
         
         
    }
}
