package parking;

import static java.lang.Thread.sleep;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Fio extends Thread{
    final static int plazas = 3;
    static int cochesAparcados = 0;
    static boolean avaliable = true;
    static Random rm = new Random();
    int delay = rm.nextInt(2000 - 1000) + 1000;
    int espera = 0;

    public Fio(String str) {
        super(str);
    }
    
    @Override
    public synchronized void run(){
        try {
            aparcar();
            desaparcar();
        } catch (InterruptedException ex) {
            Logger.getLogger(Fio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public synchronized void aparcar() throws InterruptedException{
        while (cochesAparcados >= plazas && avaliable == false){
            System.out.println(getName() + " esta esperando en la cola");
            wait();
        }
        avaliable = false;
        System.out.println("El coche de " + getName() + " ha entrado");
        cochesAparcados++;
        System.out.println(cochesAparcados);
    }
    
    public synchronized void desaparcar() throws InterruptedException{
        sleep(delay);
        System.out.println("El coche " + getName() + " ha salido");
        cochesAparcados--;
        System.out.println(cochesAparcados);
        avaliable = true;
        notify();
    }
}
