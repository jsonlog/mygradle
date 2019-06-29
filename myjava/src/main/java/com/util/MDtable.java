package com.util;

import java.util.Scanner;
import clipboard.util.SysClipboardUtil;

public class MDtable
{
    public static void main(String[] args)
    {
        String text=SysClipboardUtil.getSysClipboardText();
//        System.out.println(text);
        Scanner scanner=new Scanner(text);
        String line;
        String[] fragments;
        System.out.println("-------------------------------------------");
        boolean flag=true;
        while(scanner.hasNextLine())
        {
            line=scanner.nextLine();
            //刚好两个的地方分割
            fragments=line.split("\\s{2}");
//          System.out.println("line:--->");
//          System.out.println("fragments:");
            System.out.print("|");
            for (String string : fragments)
            {
                System.out.print(string+"|");
            }
            System.out.println();
            //打印表格对其方式,使用默认对齐方式
            if(flag)
            {
                System.out.print("|");
                for(int i=0;i<fragments.length;i++)
                {
                    System.out.print("-|");
                }
                System.out.println();
                flag=false;
            }
        }
    }
}
