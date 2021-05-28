package com.doraemon.microservice.base.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.Map;

/**
 * json web token 相关工具类
 */
public class JwtTokenUtil {
    // Token请求头
    public static final String TOKEN_HEADER = "Authorization";
    // Token前缀
    public static final String TOKEN_PREFIX = "Bearer ";

    // 签名主题
    public static final String SUBJECT = "doraemon";
    // 过期时间-1天
    public static final long EXPIRITION = 1000 * 60 * 60 * 24;
    // 应用密钥
    public static final String APPSECRET_KEY = "doraemon_secret";
    // 角色权限声明
    private static final String ROLE_CLAIMS = "role";

    /**
     * 生成Token
     * @param claims
     * @return
     */
    public static String createToken(Map<String, Object> claims) {
        JwtBuilder builder = Jwts.builder();
        String token = builder.setClaims(claims)
                .setId(SUBJECT)
                // 设置签发日期
                .setIssuedAt(new Date())
                // 设置过期时间
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRITION))
                // 设置加密方式、密钥
                .signWith(SignatureAlgorithm.HS256, APPSECRET_KEY)
                .compact();
        return token;
    }

    public static Claims checkJWT(String token) {
        try {
            final Claims claims = Jwts.parser()
                    // 设置解析密钥
                    .setSigningKey(APPSECRET_KEY)
                    // 解析
                    .parseClaimsJws(token)
                    .getBody();
            return claims;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 从Token中根据key获取相关信息
     * @param token
     * @param key
     * @return
     */
    public static String getInfoByKey(String token, String key){
        Claims claims = Jwts.parser().setSigningKey(APPSECRET_KEY).parseClaimsJws(token).getBody();
        return claims.get(key).toString();
    }

    /**
     * 校验Token是否过期
     */
    public static boolean isExpiration(String token){
        Claims claims = Jwts.parser().setSigningKey(APPSECRET_KEY).parseClaimsJws(token).getBody();
        return claims.getExpiration().before(new Date());
    }
}
