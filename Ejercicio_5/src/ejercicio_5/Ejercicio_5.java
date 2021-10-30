package ejercicio_5;

public class Ejercicio_5 extends Thread{
    
    public Ejercicio_5(String str){
        super(str);
    }
    
    public void run(){
        System.out.println("Comienza " + getName());
    }

    public static void main(String[] args) throws InterruptedException {
        Ejercicio_5 h1 = new Ejercicio_5("Manuel");
        Ejercicio_5 h2 = new Ejercicio_5("Jose");
        //Ejercicio 1
        h2.start();
        h2.join();
        h1.start();
        //Ejercicio 2
        /*h1.setPriority(MIN_PRIORITY);
        h2.setPriority(MAX_PRIORITY);
        h1.start();
        h2.start();*/
    }
    
}
