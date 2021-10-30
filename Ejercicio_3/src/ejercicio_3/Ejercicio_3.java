package ejercicio_3;

import static java.lang.Thread.sleep;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.DoubleStream;

public class Ejercicio_3 extends Thread{

    private static int maxNumberThreads = 0;
    private Thread h1;
    
    public Ejercicio_3(String str){
        super(str);
    }
    
    @Override
    public void run(){
        System.out.println("Comienza: " + getName());
        if (maxNumberThreads < 5){
           h1 = new Ejercicio_3("Soy " + getName());
           h1.start();
        }
           maxNumberThreads += 1;
           for (int i = 0; i < 10; i++){
                System.out.println("Soy " + getName() + " Contador: " + i);
                try {
                    sleep((long) (Math.random() * (601 - 100) + 100));
                } catch (InterruptedException | NullPointerException ex) {
                    Logger.getLogger(Ejercicio_3.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        try {
            h1.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(Ejercicio_3.class.getName()).log(Level.SEVERE, null, ex);
        }
            System.out.println("Termina Thread " + getName()); 
    }
    
    public static void main(String[] args) throws InterruptedException{
        new Ejercicio_3("Pepe").run();
    }
}
