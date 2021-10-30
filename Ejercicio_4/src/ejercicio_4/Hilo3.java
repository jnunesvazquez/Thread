package ejercicio_4;

public class Hilo3 extends Thread{
    
    public Hilo3(String str){
        super(str);
    }
    
    public void run(){
        int numero = 0;
        int cantidad = 0;
        while(numero <= 1000){
            if(numero % 10 == 2 || numero % 10 == 3){
                cantidad += numero; 
            }
            numero++;
        }
        System.out.println(getName() + " " + cantidad);
    }
}
