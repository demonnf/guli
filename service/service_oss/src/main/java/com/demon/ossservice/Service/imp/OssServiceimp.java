package com.demon.ossservice.Service.imp;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.demon.ossservice.Service.OssService;
import com.demon.ossservice.Util.OssUtil;
import org.joda.time.DateTime;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;
@Service
public class OssServiceimp implements OssService {
    @Override
    public String uploadfile(MultipartFile file) throws FileNotFoundException {
        // yourEndpoint填写Bucket所在地域对应的Endpoint。以华东1（杭州）为例，Endpoint填写为https://oss-cn-hangzhou.aliyuncs.com。
        String endpoint = OssUtil.ENDPOINT;
// 阿里云账号AccessKey拥有所有API的访问权限，风险很高。强烈建议您创建并使用RAM用户进行API访问或日常运维，请登录RAM控制台创建RAM用户。
        String accessKeyId = OssUtil.KEYID;
        String accessKeySecret = OssUtil.KEYSECRET;
        try {
// 创建OSSClient实例。
            OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);

// 填写本地文件的完整路径。如果未指定本地路径，则默认从示例程序所属项目对应本地路径中上传文件流。
            InputStream inputStream = null;

            inputStream = file.getInputStream();

//        获取文件名
            String Filename = file.getOriginalFilename();
//        获取uuid
            String uuid = UUID.randomUUID().toString().replace("-", "");
            Filename = uuid + Filename;
//       根据日期分类
            String datepath = new DateTime().toString("yyyy/MM/dd");
            Filename = datepath + "/" + Filename;
// 依次填写Bucket名称（例如examplebucket）和Object完整路径（例如exampledir/exampleobject.txt）。Object完整路径中不能包含Bucket名称。
            ossClient.putObject(OssUtil.BUCKETNAME, Filename, inputStream);
            // 关闭OSSClient。
            ossClient.shutdown();
            String url = "https://" + OssUtil.BUCKETNAME + "." + endpoint + "/" + Filename;
            return url;

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
