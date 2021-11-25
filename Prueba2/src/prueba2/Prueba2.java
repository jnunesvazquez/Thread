package prueba2;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Prueba2 extends Thread {
    
    public static int tope = 5;
    static Random rm = new Random();
    static boolean avaliable = true;

    public Prueba2(String str) {
        super(str);
    }
    
    @Override
    public synchronized void run() {
        if (avaliable == false){
            System.out.println(getName() + " esta esperando en la cola");
            try {
                wait();
            } catch (InterruptedException ex) {}
        }
        avaliable = false;
        tope++;
        System.out.println(getName() + " esta en el super");
        System.out.println(tope);
        try {
            sleep(rm.nextInt(1000 - 500) + 500);
        } catch (InterruptedException ex) {}
        avaliable = true;
        notify();
    }
    
    public static void main(String[] args) throws InterruptedException {
       Prueba2 h1 = new Prueba2("Juan");
       Prueba2 h2 = new Prueba2("Brais");
       Prueba2 h3 = new Prueba2("Vilan");
       Salida s1 = new Salida("Javier");
       Salida s2 = new Salida("Jose");
       Salida s3 = new Salida("Lucas");
       h1.start();
       sleep(1000);
       h2.start();
       sleep(1000);
       s1.start();
       sleep(1000);
       s2.start();
       sleep(1000);
       h3.start();
       sleep(1000);
       s3.start();
    }
    
    public static class Salida extends Thread{
        
        public Salida(String str) {
            super(str);
        }
        
        @Override
        public synchronized void run() {
            if (avaliable == false){
                System.out.println(getName() + " esta esperando en la cola");
                try {
                    wait();
                } catch (InterruptedException ex) {}
                System.out.println(getName() + " ha salido de  la  cola");
            }
            avaliable = false;
            tope--;
            System.out.println(getName() + " acabo");
            System.out.println(tope);
            try {
                sleep(rm.nextInt(1000 - 500) + 500);
            } catch (InterruptedException ex) {}
            avaliable = true;
            notify();
        }
    }
}