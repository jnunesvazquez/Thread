package ejercicio_6;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Ejercicio_6 extends Thread{
    
    Random rm = new Random();
    
    private static int cuenta;
    private static int extraccion;
    private static int total;
    private boolean avaliable = true;
    private final boolean sr;

    public Ejercicio_6(String str, boolean sr) {
        super(str);
        this.sr = sr;
    }
         
    public synchronized void run(){
        System.out.println("Comienza " + getName());
        if (avaliable == false){
            try {
                System.out.println(getName());
                wait();
            } catch (InterruptedException ex) {}
        }
        avaliable = false;
        int j = 5;
        if (sr == true){
            cuenta = rm.nextInt(100 - 50) + 50;
            j--;
            for (int  i = 0; i < 10; i++){
                int valor = rm.nextInt(10 - 2) + 2;
                System.out.println("Ingreso valorado en " + valor + "€");
                cuenta += valor;
            }
            total += cuenta;
            System.out.println("Ingresos totales = " + cuenta);
        }
        else{
            for (int  i = 0; i < 5; i++){
                int valor2 = rm.nextInt(10 - 2) + 2;
                System.out.println("Extracto valorado en " + valor2 + "€");
                extraccion += valor2;
            }
            total -= extraccion;
            System.out.println("Extractos totales = " + extraccion);
        }
        notify();
    }

    public static void main(String[] args) throws InterruptedException {
        Ejercicio_6 h1 = new Ejercicio_6("Juan", true);
        Ejercicio_6 h2 = new Ejercicio_6("Daniel", false);
        h1.start();
        h2.start();
        sleep(800);
        System.out.println("Operacion = " + total);
    }
}