import org.springframework.core.Constants;

/**
 * @Author: jsonlog
 * @Date: 2019-7-22 15:52
 */
public class ConstantsUtil {
    public static final int MAX_NUM = 5;
    public static final int MIN_NUM = 2; //常量必须是 public static final 修饰的，否则使用asXX方法取出的时候抛exception
    public static final String NAME = "kipeng";
    public static void test() {
        Constants constants = new Constants(ConstantsUtil.class);
        System.out.println("MAX_NUM:"+constants.asNumber("MAX_NUM").intValue());
        System.out.println("NAME:"+constants.asString("NAME"));
    }
}