package vip.incolor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import vip.incolor.constant.CarouselConsant;
import vip.incolor.dto.UploadFile;
import vip.incolor.exception.PhotoIdOutOfBoundException;
import vip.incolor.exception.PhotoTypeIncorrectException;
import vip.incolor.exception.ServerInternalException;
import vip.incolor.service.PhotoService;
import vip.incolor.utils.GsonUtil;
import vip.incolor.utils.PhotoUtil;

import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author LiYizhan
 * @email 1062585732@qq.com
 * @description
 * @date 2018/4/2
 * @time 21:02
 */

@RestController
@RequestMapping("photo")
public class PhotoController {
    private PhotoService photoService;

    @Autowired
    public PhotoController(PhotoService photoService) {
        super();
        this.photoService=photoService;
    }

    @RequestMapping("/alterHomeCyclePicture")
    public String alterHomeCyclePicture(Integer id, UploadFile uploadFile, HttpSession session,boolean isCompress){
        try{
            photoService.alterHomeCyclePicture(id,uploadFile.getImage(),session,isCompress);
            return GsonUtil.getSuccessJson();
        }catch (PhotoIdOutOfBoundException e){
            return GsonUtil.getErrorJson("Photo id incorrect.");
        }catch (PhotoTypeIncorrectException e){
            return GsonUtil.getErrorJson("Photo type incorrect.");
        }catch (ServerInternalException e){
            return GsonUtil.getErrorJson("Server internal error.");
        }
    }

    @RequestMapping("/alterHomeTrianglePicture")
    public String alterHomeTrianglePicture(Integer id,UploadFile uploadFile,HttpSession session,boolean isCompress){
        try{
            photoService.alterHomeTrianglePicture(id,uploadFile.getImage(),session,isCompress);
            return GsonUtil.getSuccessJson();
        }catch (PhotoIdOutOfBoundException e){
            return GsonUtil.getErrorJson("Photo id incorrect.");
        }catch (PhotoTypeIncorrectException e){
            return GsonUtil.getErrorJson("Photo type incorrect.");
        }catch (ServerInternalException e){
            return GsonUtil.getErrorJson("Server internal error.");
        }
    }

/**
     * 得到首页轮播图片
     *
     * @return
     */
    @RequestMapping(value = "/get/index", method = RequestMethod.GET)
    public String getIndexCarousel() {
        return GsonUtil.getSuccessJson(CarouselConsant.INDEX_CAROUSEL);
    }

    /**
     * 得到体育轮播图片
     *
     * @return
     */
    @RequestMapping(value = "/get/sports", method = RequestMethod.GET)
    public String getSportsCarousel() {
        return GsonUtil.getSuccessJson(CarouselConsant.INDEX_CAROUSEL);
    }

    /**
     * 得到生活轮播图片
     *
     * @return
     */
    @RequestMapping(value = "/get/life", method = RequestMethod.GET)
    public String getLifeCarousel() {
        return GsonUtil.getSuccessJson(CarouselConsant.INDEX_CAROUSEL);
    }

    /**
     * 得到新品轮播图片
     *
     * @return
     */
    @RequestMapping(value = "/get/new/product", method = RequestMethod.GET)
    public String getNewProductCarousel() {
        return GsonUtil.getSuccessJson(CarouselConsant.INDEX_CAROUSEL);
    }

    /**
     * 得到音乐轮播图片
     *
     * @return
     */
    @RequestMapping(value = "/get/music", method = RequestMethod.GET)
    public String getMusicCarousel() {
        return GsonUtil.getSuccessJson(CarouselConsant.INDEX_CAROUSEL);
    }

    /**
     * 得到创意轮播图片
     *
     * @return
     */
    @RequestMapping(value = "/get/idea", method = RequestMethod.GET)
    public String getIdeaCarousel() {
        return GsonUtil.getSuccessJson(CarouselConsant.INDEX_CAROUSEL);
    }

    /**
     * 得到工艺轮播图片
     *
     * @return
     */
    @RequestMapping(value = "/get/arts", method = RequestMethod.GET)
    public String getArtsCarousel() {
        return GsonUtil.getSuccessJson(CarouselConsant.INDEX_CAROUSEL);
    }

    /**
     * 得到工艺轮播图片
     *
     * @return
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addCarousel(MultipartFile img, HttpSession session) {
        try {
            session.setAttribute("user_id","78");
            String s = PhotoUtil.saveSinglePicture("1.jpg", "sbfolder/sbsubfolder", img, session, false);
            System.out.println("s: "+s);
        } catch (IOException e) {
            System.out.println("上传出错");
            e.printStackTrace();
        }
        return GsonUtil.getSuccessJson(CarouselConsant.INDEX_CAROUSEL);
    }
}
