package vip.incolor.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import vip.incolor.dto.RequestResult;
import vip.incolor.entity.Carousel;
import vip.incolor.exception.DeleteRemoteFileException;
import vip.incolor.exception.ServerInternalException;
import vip.incolor.exception.UploadFileException;
import vip.incolor.exception.WrongInputException;
import vip.incolor.service.CarouselService;
import vip.incolor.utils.GsonUtil;
import vip.incolor.utils.IncolorResultUtil;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author: JimLin
 * @description:
 * @email leafyunjim@gmail.com
 * @date: 2018-05-12
 * @time: 22:23
 */
@RestController
@RequestMapping("carousel")
public class CarouselController {

    @Resource
    private CarouselService carouselService;

    /**
     * 添加轮播图
     *
     * @return
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addCarouse(MultipartFile img) {
        if (img == null) {
            return GsonUtil.getErrorJson("图片未上传");
        }
        try {
            carouselService.addCarouse(img);
        } catch (UploadFileException | ServerInternalException e) {
            e.printStackTrace();
            return GsonUtil.getSuccessJson("添加轮播图失败");
        }
        return GsonUtil.getSuccessJson("添加轮播图成功");
    }

    /**
     * 得到所有的轮播图
     *
     * @return
     */
    @RequestMapping(value = "/get/all", method = RequestMethod.GET)
    public RequestResult getAllCarouse() {
        List<Carousel> carousels = carouselService.getAllCarouse();
        if (carousels.isEmpty()) {
            return IncolorResultUtil.error("没有数据");
        }
        return IncolorResultUtil.success(carousels);
    }

    /**
     * 删除轮播图（同时删除网上文件）
     *
     * @return
     */
    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String deleteCarouse(@RequestParam("carouseId") Integer carouseId) {
        try {
            carouselService.deleteCarouse(carouseId);
        } catch (DeleteRemoteFileException | ServerInternalException | WrongInputException e) {
            e.printStackTrace();
            return GsonUtil.getErrorJson("删除创意文章失败");
        }
        return GsonUtil.getSuccessJson("删除创意文章成功");
    }


    /**
     * 添加三角图
     *
     * @return
     */
    @RequestMapping(value = "/triangle/add", method = RequestMethod.POST)
    public String addTriangleCarouse(MultipartFile leftImg, MultipartFile rightImg) {
        if (leftImg == null || rightImg == null) {
            return GsonUtil.getErrorJson("图片未上传");
        }
        try {
            carouselService.addTriangleCarouse(leftImg, rightImg);
        } catch (UploadFileException | ServerInternalException e) {
            e.printStackTrace();
            return GsonUtil.getSuccessJson("添加三角图失败");
        }
        return GsonUtil.getSuccessJson("添加三角图成功");
    }

    /**
     * 得到所有的三角图
     *
     * @return
     */
    @RequestMapping(value = "/triangle/get/all", method = RequestMethod.GET)
    public RequestResult getAllTriangleCarouse() {
        List<Carousel> carousels = carouselService.getAllTriangleCarouse();
        if (carousels.isEmpty()) {
            return IncolorResultUtil.error("没有数据");
        }
        return IncolorResultUtil.success(carousels);
    }

    /**
     * 跟换三角图（同时删除网上文件）
     *
     * @param tab: 0 更换左边的图片， 1 更换右边的图片
     * @return
     */
    @RequestMapping(value = "/triangle/replace", method = RequestMethod.POST)
    public String replaceTriangleCarouse(@RequestParam("carouseId") Integer carouseId, @RequestParam("img") MultipartFile img, @RequestParam("tab") String tab) {
        try {
            carouselService.replaceTriangleCarouse(carouseId, img, tab);
        } catch (DeleteRemoteFileException | ServerInternalException | WrongInputException e) {
            e.printStackTrace();
            return GsonUtil.getErrorJson("跟换三角图失败");
        }
        return GsonUtil.getSuccessJson("跟换三角图成功");
    }


}
