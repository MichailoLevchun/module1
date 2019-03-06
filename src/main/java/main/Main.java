package main;

import java.util.concurrent.atomic.AtomicInteger;

public class Main {

    public static void main(String[] args) {
//        Double object = new Double("2.4");
//        int a = object.intValue();
//        byte b = object.byteValue();
//        float d = object.floatValue();
//        double c = object.doubleValue();
//
//        System.out.println("a =" + a);
//
//        System.out.println("b =" + b);
//        System.out.println("c =" + c);
//        System.out.println("d =" + d);
//
//        System.out.println(a + b + c + d );


        A aa = new A();

        AtomicInteger a = new AtomicInteger(6);

        int b = 4;
        System.out.println("---------------Started values-----------------------");
        System.out.println("a = "  + a);
        System.out.println("b = "  + b);

//        aa.gfgh();
        System.out.println("--------------------------------------");
        aa.ddd(a,b);
        System.out.println("--------------------------------------");
        aa.gfgh(a,b);
        System.out.println("----------------------------------------");
        aa.ddd(a,b);

        System.out.println("---------------Finished values values-----------------------");
        System.out.println("a = "  + a);
        System.out.println("b = "  + b);
    }
}
