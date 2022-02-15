package vip.incolor.service;


import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author LiYizhan
 * @email 1062585732@qq.com
 * @description
 * @date 2018/5/9
 * @time 21:03
 */
public interface QiNiuService {

    /**
     * 获取上传凭证
     * @param fileName    文件上传名
     * @param isPublic    上传至公有空间还是私有空间
     * @return  上传凭证
     */
    String getUploadToken(@NotNull String fileName, boolean isPublic);

    /**
     * 获取下载凭证
     * @param fileName  文件名
     * @param isPublic  上传至公有空间还是私有空间
     * @return  下载地址
     */
    String getDownloadUrl(@NotNull String fileName, boolean isPublic);

    /**
     * 循环获取下载凭证，内部优化逻辑
     * @param fileNames
     * @param isPublic
     * @return
     */
    List<String> getDownloadUrls(@NotNull List<String> fileNames, boolean isPublic);

    void deleteFile(@NotNull String fileName, boolean isPublic);

}
