package com.util;

import java.util.Arrays;
import java.util.Date;
import java.util.Formatter;
import java.util.Random;
import java.util.*;

public class hello {
    public static void main(String[] args) {
        String password = "eIW0Dnk69454e6nSwuspv9DmS201tQ0D";
        String encode = Base64.getEncoder().encodeToString(password.getBytes());
        System.out.println(encode);
        System.out.println(new String(Base64.getDecoder().decode(encode)));
        System.out.print("Hello, it's: "); System.out.println(new Date());
        //common
        common();

        //static
        // Caldate.main(args);
        // filecode();
        // System.out.println(staticClass.getEncoding("锟斤拷锟"));
        // System.out.println(staticClass.toUTF8("中国"));
        // MDtable.main(null);
        // System.out.println("staticClass-------------------------");
        // System.out.println(staticClass.format("2018-01-31 11:22"));

        //object
        // hello objecthello = new hello();
        // objectClass objectclass = new objectClass();
        // System.out.println("objectClass-------------------------");



        // random();
        // arrayassign();
        // movebit();
        // System.out.println(Integer.toBinaryString(12390));



//
//        try {
//            Thread.currentThread().sleep(5 * 1000);
//        } catch(InterruptedException e) {}
        System.out.println();
    }
    static void filecode(){
        try{
            String s = "你好";

            // 编码
            byte[] utf = s.getBytes("utf-8");
            byte[] gbk = s.getBytes("gbk");

            System.out.println("utf-8编码：" + Arrays.toString(utf)); // [-28, -67, -96, -27, -91, -67] 6个字节
            System.out.println("gbk编码：" + Arrays.toString(gbk)); // [-60, -29, -70, -61]<span style="white-space:pre">
                                                                // </span>4个字节

            // 解码
            String s1 = new String(utf, "utf-8"); // 你好
            String s2 = new String(utf, "gbk");// gbk解码：浣犲ソ gbk用2个字节解码，所以会多一个字符
            String s3 = new String(gbk, "utf-8");// gbk用utf-8解码：??? <span style="white-space:pre"> </span>utf-8解码需要6个字节

            System.out.println("--------------------");
            System.out.println("utf-8解码：" + s1);
            System.out.println("gbk解码：" + s2);
            System.out.println("gbk用utf-8解码：" + s3);
            System.out.println("---------------------");

            System.out.println("用utf-8编码回去");

            s3 = new String(s3.getBytes("utf-8"), "gbk"); // 锟斤拷锟? gbk用utf-8解码后无法编回去

            System.out.println(s3);
        }catch(Exception e){}
    }
    static void common(){
        boolean myboolbean = true;
        System.out.format("%b%n",myboolbean);
        char mychar = 'x';
        System.out.format("%c%c%d\n",mychar,98,(int)mychar);              
        String mystring="lov23next234dn3423javaee";
        System.out.println(Character.isLetter(mystring.charAt(3)));

        char mychararray[] = mystring.toCharArray();
        System.out.println(mychararray);
        mystring = String.valueOf(mychararray);
        System.out.println(mystring.length());
        String[] myarrayfromString = mystring.split(",");
        String mystringfromarray = String.join(",",myarrayfromString);

        StringJoiner sj = new StringJoiner(":", "[", "]");
        sj.add("George").add("Sally").add("Fred");
        String desiredString = sj.toString();

        StringBuffer roleNames = new StringBuffer(); 
        roleNames.append("test");
        roleNames.toString();
        
        // int myshort = Short.MIN_VALUE;
        // System.out.format("Short.MIN_VALUE%d Short.MAX_VALUE%d octal:%o hexadecimal:%x%n",myshort,Short.MAX_VALUE,127,127);
        // System.out.println(Integer.toBinaryString(myshort).replaceAll("1111111111111111",""));
        // System.out.println("0"+Integer.toBinaryString(Short.MAX_VALUE));
        // int myint = Integer.MIN_VALUE;
        // System.out.format("Integer.MIN_VALUE%d Integer.MAX_VALUE%d%n",myint,Integer.MAX_VALUE);
        // System.out.println(Integer.toBinaryString(myint));
        // System.out.println("0"+Integer.toBinaryString(Integer.MAX_VALUE));
        // Long mylong = Long.MAX_VALUE;
        // System.out.println("Long.MIN_VALUE"+Long.MIN_VALUE+" Integer.MAX_VALUE"+mylong);
        // System.out.println(Long.toBinaryString(Long.MIN_VALUE));
        // System.out.println("0"+Long.toBinaryString(mylong));
        // Float myfloat = Float.MAX_VALUE;
        // Formatter f = new Formatter(System.out);
        // f.format("%f %f%n",myfloat,3.1415926F);
        // Double defaultDouble = 3.1415926;
        // f.format("%f %f%n",Double.MAX_VALUE,defaultDouble);
        // System.out.println(String.format("%.2f",3.1415926d));

        System.out.println(5/2);
        System.out.println(7/3);
        System.out.println(Math.round(5/2d)); //3
        System.out.println(Math.round(7/3d));
        System.out.println(-Math.round(Math.abs(-5/2d))); //-3 myround
        System.out.println(-Math.round(Math.abs(-7/3d)));

        int choose = 3;
        switch(choose){
            case 1 : break;
            case 3 : choose = 4;
            case 4 : System.out.println(choose);
            default: System.out.println("default");
        }

//traverse
//length
        Integer[][] a;
        a = new Integer[3][];
        for(int i = 0; i < a.length; i++) {
            a[i] = new Integer[3];
            for(int j = 0; j < a[i].length; j++)
                a[i][j] = i * j; // Autoboxing
        }
        System.out.println(Arrays.deepToString(a));

        for(char c : "An African Swallow".toCharArray())
        System.out.print(c + " "); System.out.println();

        List<String> stringlist = new ArrayList<String>();
        for(String string : mystring.replaceAll("[^0-9]", ",").split(",")){
            if (string.length()>0)
                stringlist.add(string);
        }
        System.out.println("stringlist"+stringlist+" "+stringlist.size());

        int myarray[] = { 1, 2, 3, 4, 5 };
        int ad[][] = { { 11, 12, 13, 14}, { 21, 22, 23,24 },{31,32,33,34} };
        System.out.println(Arrays.toString(ad));
        Integer[] a1 = new Integer[] { new Integer(1),};
        int[][] a2 = new int[2][4];
        a2[1][0] = 21;
        a2[1][3] = 32;

        System.out.println(Arrays.toString(myarray)+" "+myarray.length+" "+java.lang.reflect.Array.getLength(myarray));


        stringlist.forEach(System.out::print); System.out.println();
        stringlist.forEach(x -> System.out.print(x+" ")); System.out.println();      
//size()
        List<String> myarraylist = Arrays.asList("Buenos Aires", "Córdoba", "La Plata");
        // myarraylist = [ "1" ];
        ArrayList<String> c =
            new ArrayList<>(myarraylist);
        c.removeAll(myarraylist);
        c.addAll(myarraylist);
        System.out.println(c.containsAll(myarraylist));
        c.clear();
        c.add("ten");
        c.add("eleven");
        c.add(1,"add");
        System.out.println(c.contains("add"));
        c.remove(2);
        for(int i = 0;i < c.size();i++){
            System.out.print(c.get(i)+" ");
        }System.out.println();

        Map<String, String> map = new HashMap<String, String>()
        {//匿名内部类 Anonymous Inner Class
            {//初始化块 instance initializer block
            put("key1", "value11");
            put("key2", "value12");
            }
        };
        // map = {"key11":"value11","key22":"value22"};
        map.put("key3", "value13");
        System.out.println(map.keySet()+" "+map.get("key1"));
        map.remove("key1");
 
        Set set = map.keySet();
        Iterator iter = set.iterator();
        while(iter.hasNext()) {
            String key = (String)iter.next();
            System.out.print(key + ":" + map.get(key)+" ");
        }
        System.out.println();

        Iterator<Map.Entry<String,String>> it = map.entrySet().iterator();
        while(it.hasNext()) {
            Map.Entry entry = it.next();
            System.out.print(entry.getKey() + ":" + entry.getValue() +" ");
        }
        System.out.println();    
        
    }






    public double myround(double num){//rint
        double a=Math.signum(num); //判断是正数负数还是0，负数返回-1.0，正数返回1.0
        if(a<0.0)
            return 0.0-Math.round(Math.abs(num));
        return Math.round(num);
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
