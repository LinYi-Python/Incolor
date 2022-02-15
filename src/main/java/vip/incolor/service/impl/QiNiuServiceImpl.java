package vip.incolor.service.impl;

import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.storage.BucketManager;
import com.qiniu.storage.Configuration;
import com.qiniu.util.Auth;
import com.qiniu.util.StringMap;
import org.springframework.stereotype.Service;
import vip.incolor.exception.DeleteRemoteFileException;
import vip.incolor.service.QiNiuService;
import vip.incolor.utils.URLEncodeUtil;
import vip.incolor.utils.UUIDUtil;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

/**
 * @author LiYizhan
 * @email 1062585732@qq.com
 * @description     七牛云服务，请叫我Psion
 * @date 2018/5/9
 * @time 21:22
 */
@Service
public class QiNiuServiceImpl implements QiNiuService {

    private static final String access_key="";
    private static final String secret_key="";

    private static final String public_bucket_name="";
    private static final String private_bucket_name="";

    private static final String public_bucket_domain="";
    private static final String private_bucket_domain="";

    private static final int upload_token_expired_time=3600;
    private static final int download_token_expired_time=3600;

    @Override
    public String getUploadToken(@NotNull String fileName, boolean isPublic) {
        String key=rename(fileName);
        Auth auth=Auth.create(access_key,secret_key);
        StringMap putPolicy=new StringMap();
        putPolicy.put("returnBody", "{\"key\":\"$(key)\",\"hash\":\"$(etag)\",\"bucket\":\"$(bucket)\",\"fsize\":$(fsize)}");
        String bucketName=isPublic?public_bucket_name:private_bucket_name;
        return auth.uploadToken(bucketName,key,upload_token_expired_time,putPolicy);
    }

    @Override
    public String getDownloadUrl(@NotNull String fileName,boolean isPublic) {
        String encodedFileName= URLEncodeUtil.getURLEncoderString(fileName);
        if(isPublic){
            return String.format("%s/%s",public_bucket_domain,encodedFileName);
        }else{
            String privateUrl=String.format("%s/%s",private_bucket_domain,encodedFileName);
            Auth auth=Auth.create(access_key,secret_key);
            return auth.privateDownloadUrl(privateUrl,download_token_expired_time);
        }
    }

    @Override
    public List<String> getDownloadUrls(@NotNull List<String> fileNames, boolean isPublic) {
        List<String> downloadUrls=new ArrayList<>();
        Auth auth=Auth.create(access_key,secret_key);
        for(int i=0;i<fileNames.size();i++){
            String encodedFileName= URLEncodeUtil.getURLEncoderString(fileNames.get(i));
            if(isPublic){
                downloadUrls.add(String.format("%s/%s",public_bucket_domain,encodedFileName));
            }else{
                String privateUrl=String.format("%s/%s",private_bucket_domain,encodedFileName);
                downloadUrls.add(auth.privateDownloadUrl(privateUrl,download_token_expired_time));
            }
        }
        return downloadUrls;
    }

    @Override
    public void deleteFile(@NotNull String fileName, boolean isPublic){
        Configuration cfg=new Configuration(Zone.autoZone());
        Auth auth=Auth.create(access_key,secret_key);
        String bucket=isPublic?public_bucket_name:private_bucket_name;
        BucketManager bucketManager=new BucketManager(auth,cfg);
        try {
            bucketManager.delete(bucket,fileName);
        } catch (QiniuException ex) {
            System.err.println(ex.response.toString());
            System.err.println(ex.code());
            throw new DeleteRemoteFileException(ex.getMessage());
        }
    }

    private String rename(String fileName){
        String uuid= UUIDUtil.getUUID();
        return fileName+"-"+uuid;
    }
}
