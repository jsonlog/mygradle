package com.util;

import java.util.Arrays;
import java.util.Date;
import java.util.Random;

public class hello {
    public static void main(String[] args) {
        System.out.println("Hello, it's: "); System.out.println(new Date());
        //static
        System.out.println("staticClass-------------------------");
        System.out.println(staticClass.format("2018-01-31 11:22"));

        //object
        System.out.println("objectClass-------------------------");





        // random();
        // arrayassign();
        // movebit();


        
//
//        try {
//            Thread.currentThread().sleep(5 * 1000);
//        } catch(InterruptedException e) {}
    }
    static void random(){
        for (int i = 0; i < 3; i++) {
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
    static void arrayassign(){
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
        System.out.println(">>右移:");
        int i = -128;
        System.out.println(Integer.toBinaryString(i).replace("111111111111111111111111","")+"**"+i);
        i = -128 >> 1; //-64
        System.out.println(Integer.toBinaryString(i).replace("111111111111111111111111","")+"**"+i+"****");
        i = -127;
        System.out.println(Integer.toBinaryString(i).replace("111111111111111111111111","")+"**"+i);
        i = -127 >> 1; //-64
        System.out.println(Integer.toBinaryString(i).replace("111111111111111111111111","")+"**"+i+"****");
        i = 0;
        System.out.println(Integer.toBinaryString(i).replace("111111111111111111111111","")+"**"+i);
        i = 0 >> 1; //0
        System.out.println(Integer.toBinaryString(i).replace("111111111111111111111111","")+"**"+i+"****");
        i = -1;
        System.out.println(Integer.toBinaryString(i).replace("111111111111111111111111","")+"**"+i);
        i = -1 >> 1; //-1
        System.out.println(Integer.toBinaryString(i).replace("111111111111111111111111","")+"**"+i+"****");
        i = 1;
        System.out.println("0000000"+Integer.toBinaryString(i).replace("111111111111111111111111","")+"**"+i);
        i = 1 >> 1; //0
        System.out.println("0000000"+Integer.toBinaryString(i).replace("111111111111111111111111","")+"**"+i+"****");
        i = 127;
        System.out.println("0"+Integer.toBinaryString(i).replace("111111111111111111111111","")+"**"+i);
        i = 127 >> 1; //-63
        System.out.println("00"+Integer.toBinaryString(i).replace("111111111111111111111111","")+"**"+i+"****");

        System.out.println("<<左移:");
        i = -128;
        System.out.println(Integer.toBinaryString(i).replace("111111111111111111111111","")+"**"+i);
        i = -128 << 1; //-256
        System.out.println(Integer.toBinaryString(i).replace("111111111111111111111111","")+"**"+i+"****");
        i = -127;
        System.out.println(Integer.toBinaryString(i).replace("111111111111111111111111","")+"**"+i);
        i = -127 << 1; //-254
        System.out.println(Integer.toBinaryString(i).replace("111111111111111111111111","")+"**"+i+"****");
        i = 0;
        System.out.println(Integer.toBinaryString(i).replace("111111111111111111111111","")+"**"+i);
        i = 0 << 1; //0
        System.out.println(Integer.toBinaryString(i).replace("111111111111111111111111","")+"**"+i+"****");
        i = -1;
        System.out.println(Integer.toBinaryString(i).replace("111111111111111111111111","")+"**"+i);
        i = -1 << 1; //-2
        System.out.println(Integer.toBinaryString(i).replace("111111111111111111111111","")+"**"+i+"****");
        i = 1;
        System.out.println("0000000"+Integer.toBinaryString(i).replace("111111111111111111111111","")+"**"+i);
        i = 1 << 1; //2
        System.out.println("000000"+Integer.toBinaryString(i).replace("111111111111111111111111","")+"**"+i+"****");
        i = 127;
        System.out.println("0"+Integer.toBinaryString(i).replace("111111111111111111111111","")+"**"+i);
        i = 127 << 1; //254
        System.out.println(Integer.toBinaryString(i).replace("111111111111111111111111","")+"**"+i+"****");
    }
}
