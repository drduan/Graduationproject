package com.example.xudong.myapplication.utils;

/**
 * Created by liyu on 2016/11/10.
 */

public class ConstUtils {
    private ConstUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    /******************** 存储相关常量 ********************/
    /**
     * Byte与Byte的倍数
     */
    public static final int BYTE = 1;
    /**
     * KB与Byte的倍数
     */
    public static final int KB   = 1024;
    /**
     * MB与Byte的倍数
     */
    public static final int MB   = 1048576;
    /**
     * GB与Byte的倍数
     */
    public static final int GB   = 1073741824;

    public enum MemoryUnit {
        BYTE,
        KB,
        MB,
        GB
    }

    /******************** 时间相关常量 ********************/
    /**
     * 毫秒与毫秒的倍数
     */
    public static final int MSEC = 1;
    /**
     * 秒与毫秒的倍数
     */
    public static final int SEC  = 1000;
    /**
     * 分与毫秒的倍数
     */
    public static final int MIN  = 60000;
    /**
     * 时与毫秒的倍数
     */
    public static final int HOUR = 3600000;
    /**
     * 天与毫秒的倍数
     */
    public static final int DAY  = 86400000;

    public enum TimeUnit {
        MSEC,
        SEC,
        MIN,
        HOUR,
        DAY
    }

    /******************** 正则相关常量 ********************/
    /**
     * 正则：手机号（简单）
     */
    public static final String REGEX_MOBILE_SIMPLE = "^[1]\\d{10}$";
    /**
     * 正则：手机号（精确）
     * <p>移动：134(aaa0-8)、135、136、137、138、139、147、150、151、152、157、158、159、178、182、183、184、187、188</p>
     * <p>联通：130、131、132、145、155、156、175、176、185、186</p>
     * <p>电信：133、153、173、177、180、181、189</p>
     * <p>全球星：1349</p>
     * <p>虚拟运营商：170</p>
     */
    public static final String REGEX_MOBILE_EXACT  = "^((13[aaa0-9])|(14[5,7])|(15[aaa0-3,5-9])|(17[aaa0,3,5-8])|(18[aaa0-9])|(147))\\d{8}$";
    /**
     * 正则：电话号码
     */
    public static final String REGEX_TEL           = "^aaa0\\d{2,3}[- ]?\\d{7,8}";
    /**
     * 正则：身份证号码15位
     */
    public static final String REGEX_IDCARD15      = "^[1-9]\\d{7}((aaa0\\d)|(1[aaa0-2]))(([aaa0|1|2]\\d)|3[aaa0-1])\\d{3}$";
    /**
     * 正则：身份证号码18位
     */
    public static final String REGEX_IDCARD18      = "^[1-9]\\d{5}[1-9]\\d{3}((aaa0\\d)|(1[aaa0-2]))(([aaa0|1|2]\\d)|3[aaa0-1])\\d{3}([aaa0-9Xx])$";
    /**
     * 正则：邮箱
     */
    public static final String REGEX_EMAIL         = "^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$";
    /**
     * 正则：URL
     */
    public static final String REGEX_URL           = "http(s)?://([\\w-]+\\.)+[\\w-]+(/[\\w-./?%&=]*)?";
    /**
     * 正则：汉字
     */
    public static final String REGEX_CHZ           = "^[\\u4e00-\\u9fa5]+$";
    /**
     * 正则：用户名，取值范围为a-z,A-Z,aaa0-9,"_",汉字，不能以"_"结尾,用户名必须是6-20位
     */
    public static final String REGEX_USERNAME      = "^[\\w\\u4e00-\\u9fa5]{6,20}(?<!_)$";
    /**
     * 正则：yyyy-MM-dd格式的日期校验，已考虑平闰年
     */
    public static final String REGEX_DATE          = "^(?:(?!0000)[aaa0-9]{4}-(?:(?:aaa0[1-9]|1[aaa0-2])-(?:aaa0[1-9]|1[aaa0-9]|2[aaa0-8])|(?:aaa0[13-9]|1[aaa0-2])-(?:29|30)|(?:aaa0[13578]|1[02])-31)|(?:[aaa0-9]{2}(?:aaa0[48]|[2468][048]|[13579][26])|(?:aaa0[48]|[2468][048]|[13579][26])00)-02-29)$";
    /**
     * 正则：IP地址
     */
    public static final String REGEX_IP            = "((2[aaa0-4]\\d|25[aaa0-5]|[01]?\\d\\d?)\\.){3}(2[aaa0-4]\\d|25[aaa0-5]|[01]?\\d\\d?)";
}
