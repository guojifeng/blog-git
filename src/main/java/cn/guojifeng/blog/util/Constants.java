package cn.guojifeng.blog.util;

public class Constants {

    // 系统全局是否标识
    public static final int YES = 1;
    public static final int NO = 0;

    public static final int ZERO = 0;
    public static final int ONE = 1;
    public static final int TWO = 2;
    public static final int THREE = 3;
    public static final int FOUR = 4;
    public static final int FIVE = 5;
    public static final int SIX = 6;
    public static final int SEVEN = 7;
    public static final int EIGHT = 8;
    public static final int NINE = 9;
    public static final int TEN = 10;

    // 默认文件路径分隔符
    public static final String PATH_SEPARATOR = "/";

    // token有效期
    public static final long EXPIRE_TIME = 7 * 24 * 3600 * 1000;

    // 分页默认起始页
    public static final int DEFAULT_PAGE_INDEX = 1;
    // 分页默认每页条数
    public static final int DEFAULT_PAGE_SIZE = 10;
    // 事务有效时间（持续300秒）
    public static final int TX_METHOD_TIMEOUT = 300;

    // 树形路径分隔符
    public static final String TREE_PATH = ".";

    public static final String QINIU_ACCESS_KEY = "qiniu_access_key";

    public static final String QINIU_SECRET_KEY = "qiniu_secret_key";

    public static final String QINIU_BUCKET = "qiniu_bucket";

    public static final String QINIU_IMAGE_DOMAIN = "qiniu_image_domain";

    // header认证字段
    public static final String AUTHENTICATION = "Authorization";

    //异常类型
    public static final String DELIMITER_TO = "@";
    public static final String DELIMITER_COLON = ":";

}
