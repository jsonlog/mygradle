package com.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

public class Caldate {
    public static void main(String args[]) {
        System.out.println("Hello World!");
        String string = "2019-1-1";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        printDate(date,null);
        try {date = simpleDateFormat.parse(string);
        }catch (ParseException e){}
        LunarCalendar lunardate = new LunarCalendar(date);//date);//.getTime()-2*24*60*60*1000);
        Calendar greDate = lunardate.getGregorianDate();
        int year = greDate.get(Calendar.YEAR);
        int month = greDate.get(Calendar.MONTH);//+1
        int day = greDate.get(Calendar.DATE);
        int weekYear = greDate.get(Calendar.WEEK_OF_YEAR);
        int weekMonth = greDate.get(Calendar.WEEK_OF_MONTH);
        int weekDay = greDate.get(Calendar.DAY_OF_WEEK);


        int solarTerm1 = LunarCalendar.getSolarTerm(year, month*2+1);
        int solarIndex1 = 2*greDate.get(Calendar.MONTH);
        int solarTerm2 = LunarCalendar.getSolarTerm(year,month*2+2);
        int solarIndex2 = 1+2*greDate.get(Calendar.MONTH);
        int gregorianYear = greDate.get(Calendar.YEAR);
        int gregorianMonth = greDate.get(Calendar.MONTH);//+1
        int gregorianDay = greDate.get(Calendar.DAY_OF_MONTH);

        System.out.println(year+"-"+(month+1)+"-"+day+"-"+weekYear+"-"+weekMonth+"-"+weekDay);
        System.out.println(lunardate.getLunarFestival()+"="+lunardate.getGregorianFestival()+"="+"="+lunardate.getYearName()+"="+lunardate.getMonthName()+"="+lunardate.getDayName()+"="+lunardate.getFullDateInfo()[0]+lunardate.getFullDateInfo()[1]);
//        System.out.println(gregorianYear+"="+gregorianMonth+"="+gregorianDay);
        System.out.println("solarTerm1="+solarTerm1+"solarTerm2="+solarTerm2);
        System.out.println("solarIndex1="+solarIndex1+"solarIndex2="+solarIndex2);
        if(gregorianDay == solarTerm1 || gregorianDay == solarTerm2) {
            System.out.println(lunardate.getSolarTerm(solarIndex1) + lunardate.getSolarTerm(solarIndex2));
        }
//        System.out.println(lunardate.getLunar(0)+"+"+lunardate.getLunar(1)+"+"+lunardate.getLunar(2)+"+"+lunardate.getLunar(3));
//        for(int i=2000;i<2100;i++){
//            try {date = simpleDateFormat.parse(i+"0101");
//            }catch (ParseException e){}
//            Calendar cal = Calendar.getInstance();
//            cal.setTime(date);
//            lunardate.setGregorianDate(cal);
//            System.out.println(lunardate.getAnimalYearName(i)+lunardate.getFullDateInfo()[1]);
//        }
    }
    public static void printDate(Date start,Date util){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy.MM.dd");
        Date last = util;
        try {
            last = simpleDateFormat.parse("2049.10.01");
        }catch (ParseException e){}
        String[] weeklist = new String[]{"Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"};
        String[] weeklist_zh = new String[]{"星期日","星期一","星期二","星期三","星期四","星期五","星期六"};
        String cut = "|";
        Calendar endcalendar = Calendar.getInstance();
        endcalendar.setTime(last);
        final int endyear = endcalendar.get(Calendar.YEAR);
        final int endmonth = endcalendar.get(Calendar.MONTH);
        final int endday = endcalendar.get(Calendar.DATE);

        LunarCalendar lunardate = new LunarCalendar(start);
//        int startyear = lunardate.getGregorianDate(Calendar.YEAR);
        for(int i=0;true;i++){
            Calendar greDate = lunardate.getGregorianDate();
            Date date = greDate.getTime();
            int year = greDate.get(Calendar.YEAR);
            int month = greDate.get(Calendar.MONTH);
            int day = greDate.get(Calendar.DATE);
            int weekYear = greDate.get(Calendar.WEEK_OF_YEAR);//52
            int weekMonth = greDate.get(Calendar.WEEK_OF_MONTH);//+1
            int weekDay = greDate.get(Calendar.DAY_OF_WEEK);//-1
            int diffDays = (int)((last.getTime() - greDate.getTimeInMillis())/(LunarCalendar.DAY_MILLIS));
            String hour = "0-6|-7|-8|-9|-10|-11|-12|-1|-2|-3|-4|-5|-6|-7|-8|-9|-10|-11|-12|todo|";
            String title = "|date|day|week|moon|lunar|week|holiday|plany|planm|planw|todo|tag|";//holiday/birthday/solarter
            String Special[][] = lunardate.getSpecialDay();
            String SpecialDay = Special[0][1]+""+Special[1][1]+""+Special[2][1]+""+Special[3][1]+""+Special[4][1];
            int solarTerm1 = LunarCalendar.getSolarTerm(year, month*2+1);
            int solarTerm2 = LunarCalendar.getSolarTerm(year,month*2+2);
            if(day == solarTerm1){
                SpecialDay+=""+lunardate.getSolarTerm(2*greDate.get(Calendar.MONTH));
            }
            if(day == solarTerm2){
                SpecialDay+=""+lunardate.getSolarTerm(1+2*greDate.get(Calendar.MONTH));
            }
            SpecialDay = SpecialDay.replace("春节",lunardate.getAnimalYearName()+"<!--"+lunardate.getFullDateInfo()[0]+lunardate.getFullDateInfo()[1]+"-->");
            String string =
                    cut+simpleDateFormat.format(date)
                    +cut+lunardate.getMonthName()+lunardate.getDayName()
                    +cut+weeklist_zh[weekDay-1]
                    +cut+(365-greDate.get(Calendar.DAY_OF_YEAR))
                    +cut+weekYear
                    +cut+diffDays
                    +cut+(diffDays/7)
                    +cut+(diffDays/31)
                    +cut+SpecialDay//+lunardate.getFullDateInfo()[1]
                    +cut;//+" | | | | |";// | | | | | | | | | | | | | | | | | | |";

            //---------------------------------------
            System.out.println(string);
            lunardate.setGregorianDate(greDate.getTimeInMillis()+LunarCalendar.DAY_MILLIS);
            if(year == endyear & month == endmonth & day == endday) break;
        }
    }
}
