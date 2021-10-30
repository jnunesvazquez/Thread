package ejercicio_6;

import java.util.Random;

public class Extraccion extends Thread{
    
    Random rm = new Random();
    
    private static int extraccion;
    
    public Extraccion(String str) {
        super(str);
    }
    
    public void run(){
        System.out.println("Comienza " + getName());
        if (avaliable == false){
            try {
                wait();
            } catch (InterruptedException ex) {}
        }
        avaliable = false;
        cuenta = rm.nextInt(100 - 50) + 50;
        for (int  i = 0; i < 10; i++){
            int valor = rm.nextInt(10 - 2) + 2;
            System.out.println("Ingreso valorado en " + valor + "€");
            cuenta += valor;
        }
        System.out.println("Ingresos totales = " + cuenta);
        
        System.out.println("Comienza " + getName());
        extraccion = 0;
        for (int  i = 0; i < 5; i++){
            int valor = rm.nextInt(10 - 2) + 2;
            System.out.println("Extracto valorado en " + valor + "€");
            extraccion += valor;
        }
        System.out.println("Extractos totales = " + extraccion);
    }

    public static int getExtraccion() {
        return extraccion;
    }
}