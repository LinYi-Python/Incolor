package vip.incolor.dto;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author LiYizhan
 * @email 1062585732@qq.com
 * @description
 * @date 2018/4/2
 * @time 21:36
 */
public class UploadFile {
    private MultipartFile image;

    public MultipartFile getImage() {
        return image;
    }

    public void setImage(MultipartFile image) {
        this.image = image;
    }
}
