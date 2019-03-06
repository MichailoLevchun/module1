package main;

import java.util.concurrent.atomic.AtomicInteger;

public class A {

    AtomicInteger a = new AtomicInteger(6);

    int b = 4;

    public void gfgh(AtomicInteger a, int b){
        a = new AtomicInteger(10);
        System.out.println("a_1 =" + a);

        b = 8;

        System.out.println("b_1 = " + b);
    }

    public void ddd(AtomicInteger a, int b){
        System.out.println("a_2 =" + a);

        System.out.println("b_2 = " + b);
    }
}
