package ejercicio_1;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Ejercicio_1 extends Thread{
    
    public Ejercicio_1(String str){
        super(str);
    }
    
    public void run(){
        for (int i = 0; i < 10; i++){
            System.out.println(i + " " + getName());
        }
        System.out.println("Termina Thread " + getName());
    }
    
    public static void main(String[] args) {
        Ejercicio_1 h1 = new Ejercicio_1("Pepe");
        Ejercicio_1 h2 = new Ejercicio_1("Juan");
        h1.start();
        h2.start();
    }
}