package vip.incolor.service;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;

/**
 * @author LiYizhan
 * @email 1062585732@qq.com
 * @description
 * @date 2018/4/2
 * @time 21:43
 */
public interface PhotoService {
    void alterHomeCyclePicture(Integer id, MultipartFile photo, HttpSession session,boolean isCompress);
    void alterHomeTrianglePicture(Integer id, MultipartFile photo, HttpSession session,boolean isCompress);
}
