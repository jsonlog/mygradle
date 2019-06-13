package com.util;

import java.util.Arrays;
import java.util.Date;
import java.util.Random;

public class hello {
    public static void main(String[] args) {
        System.out.println("Hello, it's: "); System.out.println(new Date());
//        System.out.println("test");





        random();
//        array();
//        movebit();
//
//        try {
//            Thread.currentThread().sleep(5 * 1000);
//        } catch(InterruptedException e) {}
    }
    static void random(){
        for (int i = 0; i < 10; i++) {
            Random rand = new Random(47);//no change
            Random rand2 = new Random(47);//equals to rand
            Random rand3 = new Random();
            System.out.println("j2-j3-j-k-p--");
            int j2 = rand2.nextInt(20);
            System.out.println(j2);
            int j3 = rand3.nextInt(25-6+1)+6;//6->25
            System.out.println(j3);
            int j = rand.nextInt(20);
            int k = rand.nextInt(20);
            int p = rand.nextInt(20);
            System.out.println(j);
//            System.out.println(rand2.nextInt(20));
            System.out.println(k);
            System.out.println(p);
            /*
            j2-j3-j-k-p--
            18
            *
            18
            15
            13
             */
        }
    }
    static void array(){
        int[] a1 = { 1, 2, 3, 4, 5 };
        int[] a2;
        a2 = a1;
        for(int i = 0; i < a2.length; i++)
            a2[i]++;
        for(int i = 0; i < a1.length; i++)
            System.out.println(
                    "a1[" + i + "] = " + a1[i]);
//        System.out.println(Arrays.deepToString(a1));
    }
    static void movebit(){
        int i = -128 >> 1;
        System.out.println(""+i);
        i = -127 >> 1;
        System.out.println(""+i);
        i = 0 >> 1;
        System.out.println(""+i);
        i = -1 >> 1;
        System.out.println(""+i);
        i = 1 >> 1;
        System.out.println(""+i);
        i = 127 >> 1;
        System.out.println(""+i);

        i = -128 << 1;
        System.out.println(""+i);
        i = -127 << 1;
        System.out.println(""+i);
        i = 0 << 1;
        System.out.println(""+i);
        i = -1 << 1;
        System.out.println(""+i);
        i = 1 << 1;
        System.out.println(""+i);
        i = 127 << 1;
        System.out.println(""+i);
    }
}
