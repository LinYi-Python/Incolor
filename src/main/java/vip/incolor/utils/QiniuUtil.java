package vip.incolor.utils;

import com.google.gson.Gson;
import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.BucketManager;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import org.springframework.web.multipart.MultipartFile;
import vip.incolor.dto.RequestResult;
import vip.incolor.exception.DeleteRemoteFileException;
import vip.incolor.exception.UploadFileException;

import java.io.ByteArrayInputStream;
import java.io.IOException;

/**
 * 七牛云工具类
 *
 * @author JimLin
 * @version V1.0.0
 * @date 2017/9/19
 * Email:lzhabc@163.com
 */

public class QiniuUtil {


    /**
     * 七牛云存储空间名
     */
    public static final String BUCKET_NAME = "taotao-image";

    /**
     * 七牛云绑定域名
     */
    public static final String DOMAIN = "http://otr2g5crb.bkt.clouddn.com/";

    /**
     * ACCESS_KEY
     */
    private static final String ACCESS_KEY = "Tpc3uxu2da_EIYGzA2p2ZQ7RMO5RV1Ndnbs1UAW5";

    /**
     * 七牛云服务配置项 账号的 SECRET_KEY
     */
    private static final String SECRET_KEY = "2Itmomt5LL9HlQLn4wL7AtI_qTGr0axIz3mxRyqb";


    /**
     * 上传文件
     *
     * @param file 文件名
     * @return 图片路径
     */
    public static String uploadFile(MultipartFile file) {
        Configuration cfg = new Configuration(Zone.zone2());
        UploadManager uploadManager = new UploadManager(cfg);

        String key = UUIDUtil.getUUID();
        try {
            byte[] uploadBytes = file.getBytes();
            ByteArrayInputStream byteInputStream = new ByteArrayInputStream(uploadBytes);
            Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);
            String upToken = auth.uploadToken(BUCKET_NAME);
            System.out.println(upToken);
            Response response = uploadManager.put(byteInputStream, key, upToken, null, null);
            DefaultPutRet putRet = (DefaultPutRet) new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
            System.out.println("putRet.key: " + putRet.key);
            return DOMAIN + putRet.key;
        } catch (IOException e) {
            System.out.println("上传失败");
            e.printStackTrace();
            throw new UploadFileException();
        }
    }


    /**
     * 文件删除
     *
     * @param key 文件名
     * @return PlayerResult
     */
    public static void deleteFile(String key) {
        // 文件名
        Configuration cfg = new Configuration(Zone.zone2());
        Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);
        BucketManager bucketManager = new BucketManager(auth, cfg);
        try {
            bucketManager.delete(BUCKET_NAME, key);
        } catch (QiniuException ex) {
            //如果遇到异常，说明删除失败
            System.err.println(ex.code());
            System.err.println(ex.response.toString());
            throw new DeleteRemoteFileException();
        }
    }


}
