package ejercicio_2;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Ejercicio_2 extends Thread{
    
    public Ejercicio_2(String str){
        super(str);
    }
    
    public void run(){
        for (int i = 0; i < 5; i++){
            System.out.println(i + " " + getName());
            try {
                sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Ejercicio_2.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        System.out.println("Termina Thread " + getName());
    }
    
    public static void main(String[] args) throws InterruptedException{
        Ejercicio_2 h1 = new Ejercicio_2("Pepe");
        Ejercicio_2 h2 = new Ejercicio_2("Juan");
        Ejercicio_2 h3 = new Ejercicio_2("Raul");
        Ejercicio_2 h4 = new Ejercicio_2("Damian");
        h1.start();
        h1.join();
        h2.start();
        h2.join();
        h3.start();
        h3.join();
        h4.start();
        h4.join();
    }
    
}
