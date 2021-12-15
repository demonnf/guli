package com.demon.ossservice.Util;


import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Component
public class OssUtil implements InitializingBean {
    @Value("${aliyun.oss.file.endpoint}")
    private String endpoints;
    @Value("${aliyun.oss.file.keyid}")
    private String keyid;
    @Value("${aliyun.oss.file.keysecret}")
    private String keysecret;
    @Value("${aliyun.oss.file.bucketname}")
    private String bucketname;
    public static String ENDPOINT;
    public static String KEYID;
    public static String KEYSECRET;
    public static String BUCKETNAME;

    @Override
    public void afterPropertiesSet() throws Exception {
        ENDPOINT = endpoints;
        KEYID = keyid;
        KEYSECRET = keysecret;
        BUCKETNAME = bucketname;
    }
}
