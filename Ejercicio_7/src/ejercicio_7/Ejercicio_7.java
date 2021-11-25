package ejercicio_7;

public class Ejercicio_7 extends Thread{
    
    public static String correo = "";
    public String correo2;
    
    public Ejercicio_7(String str, String correo2) {
        super(str);
        this.correo2 = correo2;
    }
         
    @Override
    public synchronized void run(){
        System.out.println("Comienza " + getName());
        
        while (!correo.isEmpty()){
            try {
                System.out.println(getName() + " esta esperando en la cola");
                wait();
            } catch (InterruptedException ex) {}
        }
        correo = correo2;
        notify();
    }

    public static void main(String[] args) throws InterruptedException {
        Ejercicio_7 h1 = new Ejercicio_7("Luis", "Hola");
        Ejercicio_7 h2 = new Ejercicio_7("Amador", "Adios");
        Ejercicio_7 h3 = new Ejercicio_7("Jose", "Sayonara");
        Salida s1 = new Salida("Leyendo correo");
        Salida s2 = new Salida("Leyendo correo 2");
        Salida s3 = new Salida("Leyendo correo 3");
         h1.start();
         sleep(1000);
         s1.start();
         sleep(1000);
         h2.start();
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
            while (correo.isEmpty()){
                try {
                    System.out.println(getName() + " esta esperando en la cola");
                    wait();
                } catch (InterruptedException ex) {}
            }
            System.out.println(correo);
            correo = "";
            notify();
        }
    }
}