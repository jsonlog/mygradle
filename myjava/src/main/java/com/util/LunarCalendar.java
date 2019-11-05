package com.util;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by log on 9/11/2018.
 * 农历日历</p>
 * 算法及基础数据来自：http://sean.o4u.com/ap/calendar/
 *
 */
public class LunarCalendar {

    /** 一天的毫秒数	 */
    public static final long DAY_MILLIS = 24 * 60 * 60 * 1000;
    /** 农历1900-1-1 的公历毫秒数(与公历1970-1-1的偏移值) */
    public static final long LUNAR_BASE_MILLIS = -2206425952000L;

    /** 农历年字段 */
    public static final int LUNAR_YEAR = 0;
    /** 农历月字段 */
    public static final int LUNAR_MONTH = 1;
    /** 农历日字段 */
    public static final int LUNAR_DAY = 2;
    /** 农历是否为闰月字段  */
    public static final int LUNAR_IS_LEAP = 3;
    public String GREGORIAN_FESTIVAL = "GREGORIAN_FESTIVAL";
    public String LUNAR_FESTIVAL = "LUNAR_FESTIVAL";
    public String BIRTHDAY_FESTIVAL = "BIRTHDAY_FESTIVAL";
    public String BIRTHDAY_LUNAR = "BIRTHDAY_LUNAR";
    public String WEEK_Festival = "WEEK_Festival";
    // 公历节日
    private static final String[][] GREGORIAN_FESTIVALS = {
            {"12", "29", "元旦work"},
            {"12", "31", "元旦rest"},
            {"1", "1", "元旦rest"},
            {"5", "1", "国际劳动节rest"},
            {"9", "29", "国庆节work"},
            {"9", "30", "国庆节work"},
            {"10", "1", "国庆节rest"},
            {"10", "2", "国庆节rest"},
            {"10", "3", "国庆节rest"},
            {"10", "4", "国庆节rest"},
            {"10", "5", "国庆节rest"},

            {"2", "14", "情人节"},
            {"3", "8", "妇女节"},
            {"3", "12", "植树节"},
            {"3", "15", "消费者权益日"},
            {"4", "1", "愚人节"},
            {"5", "12", "护士节"},
            {"5", "4", "青年节"},
            {"6", "1", "国际儿童节"},
            {"7", "1", "建党节"},
            {"8", "1", "建军节"},
            {"9", "10", "教师节"},
            {"10", "31", "万圣节"},
            {"11", "11", "双十一"},
            {"12", "24", "平安夜"},
            {"12", "25", "圣诞节"},
    };
/* private final static String[] sFtv = { "0808 父亲节",
    };  */
    // 农历节日
    private static final String[][] LUNAR_FESTIVALS = {
        {"1","1","春节"},
        {"5", "5", "端午节rest"},
        {"8", "15", "中秋节rest"},

        {"1", "15", "元宵节"},
        {"7", "7", "七夕"},
        {"7", "15", "中元节"},
        {"9", "9", "重阳节"},
        {"10", "1", "祭祖节"},
        {"12", "8", "腊八节"},
        {"12", "24", "小年"},//bei 24
        {"12", "0", "除夕"},
    };
    private static final String[][] BIRTHDAY_FESTIVALS = {
    };
    private static final String[][] BIRTHDAY_LUNARS = {
    };
    String[] animalYear = new String[]{"1鼠","2牛","3虎","4兔","5龙","6蛇","7马","8羊","9猴","10鸡","11狗","12猪"};//-2008 1996 1984 1804 %4  +30
    private static String[] solarTerm = {
            "小寒",
            "大寒",
            "立春",
            "雨水",
            "惊蛰",
            "春分",
            "清明",
            "谷雨",
            "立夏",
            "小满",
            "芒种",
            "夏至",
            "小暑",
            "大暑",
            "立秋",
            "处暑",
            "白露",
            "秋分",
            "寒露",
            "霜降",
            "立冬",
            "小雪",
            "大雪",
            "冬至",
    };
    private String[] chineseDigital = {
            "〇",
            "一",
            "二",
            "三",
            "四",
            "五",
            "六",
            "七",
            "八",
            "九",
            "十",
    };
    private String[] chinesePrefix = {
            "初",
            "十",
            "廿",
            "正",
            "冬",
            "腊",
            "闰",
    };
    private String[] chineseTime = {
            "年",
            "月",
            "日",
    };
    private String[] chinese_gan = {
            "甲",
            "乙",
            "丙",
            "丁",
            "戊",
            "己",
            "庚",
            "辛",
            "壬",
            "癸",
    };
    private String[] chinese_zhi = {
            "子",
            "丑",
            "寅",
            "卯",
            "辰",
            "巳",
            "午",
            "未",
            "申",
            "酉",
            "戌",
            "亥",
    };

    // 农历信息字段总数
    private static final int LUNAR_FIELD_COUNT = 4;

    // 1900-2100 农历日期信息
    private static final long[] LUNAR_INFO = {
            0x4bd8L,0x4ae0L,0xa570L,0x54d5L,0xd260L,0xd950L,0x5554L,0x56afL,0x9ad0L,0x55d2L,
            0x4ae0L,0xa5b6L,0xa4d0L,0xd250L,0xd295L,0xb54fL,0xd6a0L,0xada2L,0x95b0L,0x4977L,
            0x497fL,0xa4b0L,0xb4b5L,0x6a50L,0x6d40L,0xab54L,0x2b6fL,0x9570L,0x52f2L,0x4970L,
            0x6566L,0xd4a0L,0xea50L,0x6a95L,0x5adfL,0x2b60L,0x86e3L,0x92efL,0xc8d7L,0xc95fL,
            0xd4a0L,0xd8a6L,0xb55fL,0x56a0L,0xa5b4L,0x25dfL,0x92d0L,0xd2b2L,0xa950L,0xb557L,
            0x6ca0L,0xb550L,0x5355L,0x4dafL,0xa5b0L,0x4573L,0x52bfL,0xa9a8L,0xe950L,0x6aa0L,
            0xaea6L,0xab50L,0x4b60L,0xaae4L,0xa570L,0x5260L,0xf263L,0xd950L,0x5b57L,0x56a0L,
            0x96d0L,0x4dd5L,0x4ad0L,0xa4d0L,0xd4d4L,0xd250L,0xd558L,0xb540L,0xb6a0L,0x95a6L,
            0x95bfL,0x49b0L,0xa974L,0xa4b0L,0xb27aL,0x6a50L,0x6d40L,0xaf46L,0xab60L,0x9570L,
            0x4af5L,0x4970L,0x64b0L,0x74a3L,0xea50L,0x6b58L,0x5ac0L,0xab60L,0x96d5L,0x92e0L,
            0xc960L,0xd954L,0xd4a0L,0xda50L,0x7552L,0x56a0L,0xabb7L,0x25d0L,0x92d0L,0xcab5L,
            0xa950L,0xb4a0L,0xbaa4L,0xad50L,0x55d9L,0x4ba0L,0xa5b0L,0x5176L,0x52bfL,0xa930L,
            0x7954L,0x6aa0L,0xad50L,0x5b52L,0x4b60L,0xa6e6L,0xa4e0L,0xd260L,0xea65L,0xd530L,
            0x5aa0L,0x76a3L,0x96d0L,0x4afbL,0x4ad0L,0xa4d0L,0xd0b6L,0xd25fL,0xd520L,0xdd45L,
            0xb5a0L,0x56d0L,0x55b2L,0x49b0L,0xa577L,0xa4b0L,0xaa50L,0xb255L,0x6d2fL,0xada0L,
            0x4b63L,0x937fL,0x49f8L,0x4970L,0x64b0L,0x68a6L,0xea5fL,0x6b20L,0xa6c4L,0xaaefL,
            0x92e0L,0xd2e3L,0xc960L,0xd557L,0xd4a0L,0xda50L,0x5d55L,0x56a0L,0xa6d0L,0x55d4L,
            0x52d0L,0xa9b8L,0xa950L,0xb4a0L,0xb6a6L,0xad50L,0x55a0L,0xaba4L,0xa5b0L,0x52b0L,
            0xb273L,0x6930L,0x7337L,0x6aa0L,0xad50L,0x4b55L,0x4b6fL,0xa570L,0x54e4L,0xd260L,
            0xe968L,0xd520L,0xdaa0L,0x6aa6L,0x56dfL,0x4ae0L,0xa9d4L,0xa4d0L,0xd150L,0xf252L,
            0xd520L};

    // 二十四节气在各月的基准日期
    private static final int[] SOLAR_TERM_BASE = {4, 19, 3, 18, 4, 19, 4, 19, 4, 20, 4, 20, 6, 22, 6, 22, 6, 22, 7, 22, 6, 21, 6, 21};

    // 1900-2100各年的二十四节气分布种类，对应上表中的序号
    private static final int[] SOLAR_TERM_INDEX = {0,1,2,3,4,1,5,3,4,1,5,3,6,7,8,9,10,11,12,9,10,13,12,14,10,13,1,14,15,0,1,2,16,0,1,5,16,0,1,5,16,0,1,5,17,18,7,8,19,20,21,8,19,20,13,1,22,20,0,1,23,24,0,1,23,24,0,1,25,24,0,1,25,26,0,27,28,29,30,11,28,29,18,21,31,32,20,33,34,35,36,0,34,37,24,0,34,38,24,0,34,39,24,0,34,39,29,0,40,41,29,30,42,43,29,18,44,45,32,36,46,47,35,36,48,47,39,24,48,47,39,24,48,47,39,29,48,47,39,29,48,49,41,29,50,51,43,29,52,53,45,35,54,53,45,55,54,56,47,55,57,56,47,39,57,56,47,39,58,56,49,39,58,59,49,43,58,59,60,43,58,61,62,45,63,64,53,45,65,64,56,47,65,66,56,47,67,68,56,47,39};

    // 二十四节气以年为单位，在1900-2100年间，共有69种分布种类，共有 24* 69 项)
    private static final int[] SOLAR_TERM_OS = {2,1,1,1,2,2,1,1,2,1,2,2,1,1,2,1,2,1,2,2,2,2,1,1,2,2,1,1,2,2,1,2,2,2,2,2,2,1,2,2,2,2,2,2,2,2,2,1,2,2,2,1,2,2,2,2,2,2,3,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,3,3,2,2,3,2,3,2,2,2,3,2,3,2,2,2,2,2,2,2,3,2,2,2,2,2,1,1,2,1,2,2,1,1,2,1,2,1,2,2,2,2,1,1,2,2,2,1,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,3,2,2,2,2,2,1,1,2,1,2,2,1,1,2,1,2,1,2,2,2,1,1,1,2,1,1,1,2,2,1,2,2,2,2,2,2,1,2,2,2,1,2,2,2,2,2,1,2,2,1,1,2,2,1,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,3,2,2,2,2,3,2,2,2,2,2,3,2,2,2,2,2,2,2,2,2,2,2,2,2,1,1,2,1,2,2,1,1,2,1,2,1,1,2,2,1,1,1,2,1,1,1,2,2,1,2,2,1,2,2,2,1,2,2,2,1,2,2,2,2,2,1,2,2,1,1,2,2,1,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,1,2,1,1,1,2,2,1,1,2,1,2,2,2,1,2,2,2,1,2,2,2,2,1,1,2,2,2,1,2,2,2,2,2,2,3,2,2,2,2,2,3,2,2,2,2,2,2,2,2,2,2,2,2,2,1,1,2,1,2,2,1,1,2,1,2,1,1,1,1,1,1,1,2,2,2,2,2,2,1,1,2,1,2,1,1,1,2,1,2,1,1,1,1,1,1,1,2,2,2,2,2,2,1,1,1,1,2,1,1,1,2,1,2,1,1,1,1,1,1,1,2,1,1,1,2,2,1,1,2,1,2,2,1,1,2,1,2,1,1,2,2,1,1,1,2,2,2,2,1,2,1,1,1,1,2,1,1,1,1,1,2,1,1,1,1,1,1,1,1,1,1,1,2,2,1,1,2,1,2,2,1,1,2,1,2,1,1,2,2,1,1,1,2,1,1,1,2,2,1,1,2,1,2,2,2,1,2,2,2,1,2,2,2,2,2,1,2,2,2,2,1,1,1,1,1,1,2,1,1,1,1,1,2,1,1,1,1,1,1,1,2,2,2,1,1,1,1,1,1,1,2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2,2,1,1,2,1,2,1,1,1,2,1,2,1,1,1,1,1,1,1,2,2,2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2,2,1,1,1,1,2,1,1,1,2,1,2,1,1,1,1,1,1,1,2,2,1,1,2,2,1,2,2,2,2,2,2,1,2,2,2,1,2,2,2,2,2,1,2,2,2,1,1,1,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2,2,1,1,1,1,2,1,1,1,1,1,2,1,1,1,1,1,1,1,2,1,1,1,2,2,1,1,2,1,2,2,1,1,2,1,2,1,1,2,2,2,1,1,2,2,1,1,1,1,0,1,1,1,1,1,1,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2,1,1,1,1,2,1,1,1,1,1,2,1,1,1,1,1,1,1,2,1,1,1,2,2,1,1,2,1,2,2,1,1,2,2,2,1,2,2,2,2,1,1,2,2,1,1,1,1,0,1,1,1,1,1,1,0,1,1,1,1,1,1,1,1,1,0,1,1,1,1,1,1,1,1,1,1,2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2,2,1,1,2,1,2,1,1,1,2,1,2,1,1,2,2,1,1,1,1,1,1,0,1,1,1,1,1,1,2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,1,1,1,1,1,1,1,1,1,1,2,1,1,1,1,1,1,1,1,1,1,1,1,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2,2,1,1,1,1,0,1,1,1,1,1,1,0,1,1,1,0,1,1,1,1,1,0,1,1,1,0,1,1,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2,2,1,1,1,1,0,1,1,0,1,1,1,0,1,1,1,0,1,1,1,1,1,0,1,1,1,0,1,1,0,1,1,1,1,1,1,0,1,1,1,1,1,1,1,1,1,1,2,1,1,1,1,1,0,0,1,0,1,1,1,0,1,1,1,0,1,1,1,1,1,0,1,1,0,0,1,1,0,1,1,1,1,1,1,0,1,1,1,1,1,1,1,1,1,1,2,1,1,1,1,1,0,0,1,0,1,1,0,0,1,0,1,0,1,1,1,1,1,0,1,1,0,0,1,1,0,1,1,1,1,1,1,0,1,1,1,1,1,1,1,1,1,0,2,1,1,1,1,1,0,0,1,0,1,1,0,0,1,0,1,0,1,1,1,1,0,0,1,1,0,0,1,1,0,1,1,0,1,1,1,0,1,1,1,0,1,1,1,1,1,0,2,1,1,1,1,1,0,0,1,0,1,1,0,0,1,0,1,0,0,1,1,1,0,0,1,1,0,0,1,1,0,0,1,0,1,1,1,0,1,1,1,0,1,1,1,1,1,0,2,1,1,1,1,1,0,0,1,0,1,0,0,0,1,0,1,0,0,1,1,0,0,0,1,0,0,0,1,1,0,0,1,0,1,1,0,0,1,0,1,0,1,1,1,1,1,0,1,1,1,1,1,1,0,0,1,0,1,0,0,0,1,0,1,0,0,1,1,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,0,0,1,0,1,1,0,0,1,0,1,0,1,1,1,1,0,0,1,1,1,1,1,1,0,0,1,0,1,0,0,0,1,0,1,0,0,0,0,0,0,0,1,1,1,1,1,1,0,0,0,0,1,0,0,0,0,0,1,0,0,0,0,0,0,0,1,0,0,0,1,1,0,0,1,0,1,1,0,0,1,0,1,0,0,1,1,1,0,0,1,1,0,0,1,1,0,0,1,0,1,1,0,0,1,1,1,0,1,1,1,1,1,0,1,0,0,0,1,1,0,0,1,0,1,0,0,0,1,0,1,0,0,1,1,0,0,0,1,1,0,0,1,1,0,0,1,0,1,1,0,0,1,0,1,0,1,1,1,1,1,0,1,1,1,1,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,0,0,1,0,1,0,0,0,1,0,1,0,0,1,1,0,0,0,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,0,0,1,0,1,0,0,0,1,0,1,0,0,0,0,0,0,0,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,0,0,1,0,1,0,0,0,0,0,1,0,0,0,0,0,0,0};
    private static final int YEAR_MAX = 2100;
    private static final int YEAR_MIN = 1900;

    private Calendar gregorianDate;
    private int[] lunarFields;

    /**
     * 支持范围最大年份
     * @return
     */
    public static int getMaxYear(){
        return YEAR_MAX;
    }

    /**
     * 支持范围最小年份
     * @return
     */
    public static int getMinYear(){
        return YEAR_MIN + 1;
    }

    /**
     * 取得二十四节气
     * @param year 公历年
     * @param index 节气序号,从小寒开始的节气序号 [1-24]
     * @return 公历当月日期
     */
    public static int getSolarTerm(int year, int index){
        return SOLAR_TERM_OS[SOLAR_TERM_INDEX[year - YEAR_MIN] * 24 + index - 1] + SOLAR_TERM_BASE[index - 1];
    }

    public static String getSolarTerm(int index){
        if(index >=0 & index < solarTerm.length)
            return solarTerm[index];
        else
            return  "";
    }

    public LunarCalendar(){
        this(new Date());
    }

    public LunarCalendar(Calendar calendar){
        this(calendar.getTimeInMillis());
    }

    public LunarCalendar(Date date){
        this(date.getTime());
    }

    public LunarCalendar(long milliSeconds){
        setGregorianDate(milliSeconds);
    }

    /**
     * 返回公历信息<br/>
     * 参照:{@link java.util.Calendar#get(int)}
     * @param field
     * @return
     */
    public int getGregorianDate(int field){
        return gregorianDate.get(field);
    }

    public Calendar getGregorianDate() {
        return gregorianDate;
    }

    public void setGregorianDate(Calendar gregorianDate) {
        lunarFields = new int[LUNAR_FIELD_COUNT];
        this.gregorianDate = gregorianDate;
        computeLunar();
    }

    public void setGregorianDate(long milliSeconds) {
        Calendar date = Calendar.getInstance();
        date.setTimeInMillis(milliSeconds);
        setGregorianDate(date);
    }

    /**
     * 获取农历信息
     * @param field  字段 id
     * @return 字段值，闰月返回1
     */
    public int getLunar(int field){
        return lunarFields[field];
    }

    public int[][] str2int(String[][] str)
    {
        int a,b;
        a = str.length;
        b = str[0].length -1;//去掉最后一列
        int result[][] = new int[a][b];
        for(int i = 0 ; i < a ; ++ i)
            for(int j = 0 ; j < b ; ++ j)
                result[i][j] = Integer.parseInt(str[i][j]);
        return result;
    }
    /**
     * 返回当前的公历节日序号,从0开始,如果不是公历节日,返回-1
     * @return 公历节日序号 [-1, 0, ...]
     */
    public String getGregorianFestival(){
        int[][] GREGORIAN_FESTIVAL = str2int(GREGORIAN_FESTIVALS);
        for(int i = 0; i<GREGORIAN_FESTIVALS.length; i++){
            if ((GREGORIAN_FESTIVAL[i][0] - 1) == gregorianDate.get(Calendar.MONTH)
                    && GREGORIAN_FESTIVAL[i][1] == gregorianDate.get(Calendar.DAY_OF_MONTH)){
                return GREGORIAN_FESTIVALS[i][2];
            }
        }
        return "";
    }
    /**
     * 返回当前的农历节日序号,从0开始,如果不是农历节日,返回-1
     * @return 农历节日序号 [-1, 0, ...]
     */
    public String getLunarFestival(){
        int[][] LUNAR_FESTIVAL = str2int(LUNAR_FESTIVALS);
        for(int i = 0; i<LUNAR_FESTIVALS.length; i++){
            // 当前月,并且不是闰月
            if (LUNAR_FESTIVAL[i][0] == lunarFields[LUNAR_MONTH]
                    && lunarFields[LUNAR_IS_LEAP] == 0){
                // 日期相同
                if (LUNAR_FESTIVAL[i][1] == lunarFields[LUNAR_DAY]){
                    return LUNAR_FESTIVALS[i][2];
                }else if(LUNAR_FESTIVAL[i][1] == 0
                        && lunarFields[LUNAR_DAY] ==
                        getDaysOfLunarMonth(lunarFields[LUNAR_YEAR], lunarFields[LUNAR_MONTH])){
                    // 月内最后一天(除夕)
                    return LUNAR_FESTIVALS[i][2];
                }
            }
        }
        return "";
    }
    public String getBirthdayFestival(){
        if(BIRTHDAY_FESTIVALS.length == 0) return "";
        int[][] BIRTHDAY_FESTIVAL = str2int(BIRTHDAY_FESTIVALS);
        for(int i = 0; i<BIRTHDAY_FESTIVAL.length; i++) {
            if ((BIRTHDAY_FESTIVAL[i][0] - 1) == gregorianDate.get(Calendar.MONTH)
                    && BIRTHDAY_FESTIVAL[i][1] == gregorianDate.get(Calendar.DAY_OF_MONTH)) {
                return BIRTHDAY_FESTIVALS[i][2]+"国历生日";
            }
        }
        return "";
    }
    public String getBirthdayLunar(){
        if(BIRTHDAY_LUNARS.length == 0) return "";
        int year = gregorianDate.get(Calendar.YEAR);
        int[][] BIRTHDAY_LUNAR = str2int(BIRTHDAY_LUNARS);
        for(int i=0;i<BIRTHDAY_LUNAR.length;i++){
            if (BIRTHDAY_LUNAR[i][0] == lunarFields[LUNAR_MONTH] && BIRTHDAY_LUNAR[i][1] == lunarFields[LUNAR_DAY]){
                if(lunarFields[LUNAR_IS_LEAP] == 1 ) {
                    if(BIRTHDAY_LUNARS[i][2].contains("闰"))
                    return BIRTHDAY_LUNARS[i][2] + "闰月农历生日";
                }else {
                    if(BIRTHDAY_LUNARS[i][2].contains("闰") && ((year== 2052)|| (year==2071) ||( year==2090)))
                        return "";//di
                    return BIRTHDAY_LUNARS[i][2].replace("闰","")+"农历生日";
                }
            }
        }
        return "";
    }
    public String getWeekFestival(){
        int month = gregorianDate.get(Calendar.MONTH)+1;
        int day = gregorianDate.get(Calendar.DATE);
        int week = gregorianDate.get(Calendar.DAY_OF_WEEK);
//        System.out.println("month"+month+"week"+week+"day"+day);
        //1 2 3 4 5 6 7-8
        //1 2 3 4 5 6-7 8 9 10 11 12 13-14
        //每年5月的第二个星期日 母亲节 1+7*(2-1) 7*2
        if(month == 5 && week == 1 && day >=8 && day <= 14)
            return "母亲节";

        //1 2 3 4 5 6 7-8 9 10 11 12 13 14-15
        //1 2 3 4 5 6-7 8 9 10 11 12 13-14 15 16 17 18 19 20-21
        //每年6月的第三个星期天 父亲节 1+7*(3-1) 7*3
        if(month == 6 && week == 1 && day >=15 && day <= 21)
            return "父亲节";
        //清明节
//        int year = gregorianDate.get(Calendar.YEAR);
//        double[] coefficient = { 5.15, 5.37, 5.59, 4.82, 5.02, 5.26, 5.48, 4.70, 4.92, 5.135, 5.36, 4.60, 4.81, 5.04,
//                5.26 };
//        int mod = year % 100;
//        int qingming = (int) (mod * 0.2422 + coefficient[year / 100 - 17] - mod / 4);
//        if (year == 2232) {
//            qingming = 4;
//        }
//        if(lunarFields[LUNAR_MONTH] == 4 && day == 4){
//            return "清明节rest";
//        }
        return "";
    }
    private  int subtractYear(int year){
        int jiaziYear = 1804;
        if(year<jiaziYear){//如果年份小于起始的甲子年(startYear = 1804),则起始甲子年往前偏移
            jiaziYear = jiaziYear-(60+60*((jiaziYear-year)/60));//60年一个周期
        }
        return year-jiaziYear;
    }

    public String getAnimalYearName(int year){//---------计算生肖方法------------
        String name = animalYear[subtractYear(year)%12];
        return name;
    }
    public String getAnimalYearName(){
        return getAnimalYearName(gregorianDate.get(Calendar.YEAR));
    }
    public String[][] getSpecialDay(){
        return new String[][]{{GREGORIAN_FESTIVAL,getGregorianFestival()},{LUNAR_FESTIVAL,getLunarFestival()},{BIRTHDAY_FESTIVAL,getBirthdayFestival()},{BIRTHDAY_LUNAR,getBirthdayLunar()},{WEEK_Festival,getWeekFestival()}};
    }
    public CharSequence getYearName() {
        StringBuilder result = new StringBuilder();
        int year = getLunar(LunarCalendar.LUNAR_YEAR);
        result.append(chineseDigital[ (year / 1000) % 10]);
        result.append(chineseDigital[ (year / 100) % 10]);
        result.append(chineseDigital[ (year / 10) % 10]);
        result.append(chineseDigital[ year % 10]);
        result.append(chineseTime[0]);

        return result;
    }
    public CharSequence getMonthName() {
        StringBuilder result = new StringBuilder();
        if (getLunar(LunarCalendar.LUNAR_IS_LEAP) == 1) {
            result.append(chinesePrefix[6]);
        }
        int month = getLunar(LunarCalendar.LUNAR_MONTH);
        switch (month) {
            case 1:
                result.append(chinesePrefix[3]);
                break;
            case 11:
                result.append(chinesePrefix[4]);
                break;
            case 12:
                result.append(chinesePrefix[5]);
                break;
            default:
                result.append(chineseDigital[month]);
                break;
        }
        result.append(chineseTime[1]);
        return result;
    }

    public CharSequence getDayName() {
        StringBuilder result = new StringBuilder();
        int day = getLunar(LunarCalendar.LUNAR_DAY);
        if (day < 11) {
            result.append(chinesePrefix[0]);
            result.append(chineseDigital[day]);
        } else if (day < 20) {
            result.append(chinesePrefix[1]);
            result.append(chineseDigital[day - 10]);
        } else if (day == 20) {
            result.append(chineseDigital[2]);
            result.append(chineseDigital[10]);
        } else if (day < 30) {
            result.append(chinesePrefix[2]);
            result.append(chineseDigital[day - 20]);
        } else {
            result.append(chineseDigital[3]);
            result.append(chineseDigital[10]);
        }

        return result;
    }


    public CharSequence[] getFullDateInfo() {
        CharSequence[] result = new CharSequence[2];

        int year = getGregorianDate(Calendar.YEAR);
        int month = getGregorianDate(Calendar.MONTH);
        int day = getGregorianDate(Calendar.DAY_OF_MONTH);

        int lYear, lMonth, lDay, solarTerm = -1;

        // 取年柱,以春分为分界点
        int st_spring = LunarCalendar.getSolarTerm(year, 3); // 立春
        if ((month == 1 && st_spring > day) || month < 1) {
            lYear = -1;
        } else {
            lYear = 0;
        }
        lYear = year - 1900 + lYear + 36;

        // 月柱,月柱以节令为界
        int st_monthFirst = (month == 1 ? st_spring : LunarCalendar
                .getSolarTerm(year, month * 2 + 1));
        lMonth = (st_monthFirst > day ? -1 : 0);
        lMonth = (year - 1900) * 12 + +month + lMonth + 13;

        // 日柱,单纯的日循环
        lDay = (int) ((getTimeInMillis() - LunarCalendar.LUNAR_BASE_MILLIS) / LunarCalendar.DAY_MILLIS) + 40;

        // 节气
        if (st_monthFirst == day) {
            solarTerm = month * 2;
        } else if (day > 15) {
            int st2 = LunarCalendar.getSolarTerm(year, month * 2 + 2);
            if (st2 == day) {
                solarTerm = month * 2 + 1;
            }
        }

        // 节气,节日
        StringBuilder cs = new StringBuilder();
        if (solarTerm > -1) {
            cs.append(getSolarTerm(solarTerm));
            cs.append(' ');
        }
            cs.append(getGregorianFestival());
            cs.append(' ');
        
            cs.append(getLunarFestival());
        
        result[0] = cs;

        // 农历年月日信息
        cs = new StringBuilder();
        cs.append(getYearName());
        cs.append(' ');
        cs.append(getMonthName());
        cs.append(' ');
        cs.append(getDayName());
        cs.append("  ");

        cs.append(chinese_gan[lYear % 10]);
        cs.append(chinese_zhi[lYear % 12]);
        cs.append(chineseTime[0]); // 年
        cs.append(' ');
        cs.append(chinese_gan[lMonth % 10]);
        cs.append(chinese_zhi[lMonth % 12]);
        cs.append(chineseTime[1]); // 月
        cs.append(' ');
        cs.append(chinese_gan[lDay % 10]);
        cs.append(chinese_zhi[lDay % 12]);
        cs.append(chineseTime[2]); // 日
        result[1] = cs;

        return result;
    }
    /**
     * @see Calendar#getTimeInMillis()
     * @return
     */
    public long getTimeInMillis(){
        return gregorianDate.getTimeInMillis();
    }

    /**
     * 是否为今天
     * @return
     */
    public boolean isToday(){
        Calendar today = Calendar.getInstance();
        if ((gregorianDate.get(Calendar.YEAR) == today.get(Calendar.YEAR))
                && (gregorianDate.get(Calendar.MONTH) == today.get(Calendar.MONTH))
                && (gregorianDate.get(Calendar.DAY_OF_MONTH) == today.get(Calendar.DAY_OF_MONTH)))
        {
            return true;
        }

        return false;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("[Gregorian:");
        result.append(gregorianDate.get(Calendar.YEAR));
        result.append('-');
        result.append(gregorianDate.get(Calendar.MONTH));
        result.append('-');
        result.append(gregorianDate.get(Calendar.DAY_OF_MONTH));
        result.append("] [Lunar:");
        result.append(lunarFields[LUNAR_YEAR]);
        result.append('-');
        result.append(lunarFields[LUNAR_MONTH]);
        result.append('-');
        result.append(lunarFields[LUNAR_DAY]);
        result.append('(');
        result.append(lunarFields[LUNAR_IS_LEAP]);
        result.append(")]");
        return result.toString();
    }

    /**
     * 由公历计算农历
     */
    private void computeLunar(){
        if ((gregorianDate.get(Calendar.YEAR) <= YEAR_MIN && gregorianDate.get(Calendar.MONTH) < 1)
                || gregorianDate.get(Calendar.YEAR) > YEAR_MAX){
            throw new IllegalArgumentException("Current lunar calendar only support the year from 1901 to 2100.");
        }
        // 取得与农历1900-1-1相差的天数
        long offset = (gregorianDate.getTimeInMillis() - LUNAR_BASE_MILLIS) / DAY_MILLIS;
        int year = YEAR_MIN;
        int daysOfYear = 0;
        for(; year<YEAR_MAX && offset > 0; year++){
            daysOfYear = getDaysOfLunarYear(year);
            offset -= daysOfYear;
        }

        if (offset < 0){
            offset += daysOfYear;
            year--;
        }

        lunarFields[LUNAR_YEAR] = year;
        int leapMonth = getLeapMonthOfLunar(year);
        lunarFields[LUNAR_IS_LEAP] = 0;

        int month = 1;
        int daysOfMonth = 0;
        for(; month < 13 && offset > 0; month++){
            if(leapMonth > 0 && month==(leapMonth + 1) && lunarFields[LUNAR_IS_LEAP] == 0){
                month--;
                lunarFields[LUNAR_IS_LEAP] = 1;
                daysOfMonth = getLeapDaysOfLunar(year);
            }else{
                daysOfMonth = getDaysOfLunarMonth(year, month);
            }

            if (lunarFields[LUNAR_IS_LEAP] == 1 && month == leapMonth + 1){
                lunarFields[LUNAR_IS_LEAP] = 0;
            }

            offset -= daysOfMonth;
        }

        if (offset == 0 && leapMonth > 0 && month == leapMonth + 1){
            if (lunarFields[LUNAR_IS_LEAP] == 1){
                lunarFields[LUNAR_IS_LEAP] = 0;
            }else{
                lunarFields[LUNAR_IS_LEAP] = 1;
                month--;
            }
        }

        if (offset < 0){
            offset += daysOfMonth;
            month--;
        }

        lunarFields[LUNAR_MONTH] = month;
        lunarFields[LUNAR_DAY] = (int)offset + 1;
    }

    // 返回农历指定月份的天数
    private int getDaysOfLunarMonth(int year, int month){
        return (LUNAR_INFO[year - YEAR_MIN] & (0x10000>>month)) == 0 ? 29 : 30;
    }

    // 取得农历年天数
    private int getDaysOfLunarYear(int year){
        int result = 348;
        for(int i=0x8000; i>0x8; i>>=1){
            result += (LUNAR_INFO[year - YEAR_MIN] & i) == 0 ? 0 : 1;
        }
        return result + getLeapDaysOfLunar(year);
    }

    // 取得农历年闰月天数
    private int getLeapDaysOfLunar(int year){
        if (getLeapMonthOfLunar(year) > 0){
            return (LUNAR_INFO[year - YEAR_MIN + 1] & 0xF) == 0xF ? 30 : 29;
        }else{
            return 0;
        }
    }

    // 取得农历年闰月月份 1-12,如果没闰,返回0
    private int getLeapMonthOfLunar(int year){
        int leapMonth = (int)(LUNAR_INFO[year - YEAR_MIN] & 0xF);
        return leapMonth == 0xF ? 0 : leapMonth;
    }

}
