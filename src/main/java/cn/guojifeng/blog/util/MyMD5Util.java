package cn.guojifeng.blog.util;

import java.io.IOException;
import java.security.MessageDigest;

/**
 * @Author 郭继峰
 * @Description MD5加密工具类
 * @Date 2019/12/30 15:50
 **/
public class MyMD5Util {

    //盐，用于混交md5
    private static final String slat = "zero";

    public static String encrypt(String dataStr) {
        try {
            dataStr = dataStr + slat;
            MessageDigest m = MessageDigest.getInstance("MD5");
            m.update(dataStr.getBytes("UTF8"));
            byte s[] = m.digest();
            String result = "";
            for (int i = 0; i < s.length; i++) {
                result += Integer.toHexString((0x000000FF & s[i]) | 0xFFFFFF00).substring(6);
            }
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    public static void main(String[] args) throws IOException {
       String str = MyMD5Util.encrypt("guojifeng");
       System.out.println(str);
    }
}
