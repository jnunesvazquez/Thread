package parking;

import static java.lang.Thread.sleep;

public class Parking {

    public static void main(String[] args) throws InterruptedException {
        Fio c1 =  new Fio("Juan");
        Fio c2 =  new Fio("Juan2");
        Fio c3 =  new Fio("Juan3");
        Fio c4 =  new Fio("Juan4");
        Fio c5 =  new Fio("Juan5");
        /*c1.start();
        sleep(500);
        c2.start();
        sleep(500);
        c3.start();
        sleep(500);
        c4.start();
        sleep(500);*/
        c1.aparcar();
        sleep(500);
        c2.aparcar();
        sleep(500);
        c3.aparcar();
        sleep(500);
        c4.aparcar();
        sleep(500);
        c1.desaparcar();
        sleep(500);
        c2.desaparcar();
        //sleep(500);
        /*c5.aparcar();
        sleep(500);
        c3.desaparcar();
        sleep(500);
        c4.desaparcar();
        sleep(500);
        c5.desaparcar();*/
    }
}