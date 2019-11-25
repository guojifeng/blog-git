package cn.guojifeng.blog.util;

import cn.guojifeng.blog.domain.User;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

//鉴权工具类
public class JwtUtil {

    //生成token
    public static String getToken(User user) {
        String token="";
        token= JWT.create().withAudience(user.getId().toString())
                .sign(Algorithm.HMAC256(user.getPassword()));
        return token;
    }
}
