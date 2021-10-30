package ejercicio_4;

public class Hilo2 extends Thread{
    
    public Hilo2(String str){
        super(str);
    }
    
    public void run(){
        int numero = 0;
        int cantidad = 0;
        while(numero <= 1000){
            if(numero % 2 != 0){
                cantidad += numero; 
            }
            numero++;
        }
        System.out.println(getName() + " " + cantidad);
    }
}
