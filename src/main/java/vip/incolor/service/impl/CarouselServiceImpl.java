package vip.incolor.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import vip.incolor.entity.Carousel;
import vip.incolor.entity.CarouselExample;
import vip.incolor.exception.DeleteRemoteFileException;
import vip.incolor.exception.ServerInternalException;
import vip.incolor.exception.UploadFileException;
import vip.incolor.exception.WrongInputException;
import vip.incolor.mapper.CarouselMapper;
import vip.incolor.service.CarouselService;
import vip.incolor.utils.QiniuUtil;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

/**
 * @author: JimLin
 * @description:
 * @email leafyunjim@gmail.com
 * @date: 2018-05-12
 * @time: 22:31
 */
@Service
public class CarouselServiceImpl implements CarouselService {

    @Resource
    private CarouselMapper carouselMapper;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void addCarouse(MultipartFile img) {
        try {
            String result = QiniuUtil.uploadFile(img);
            Carousel carousel = new Carousel();
            carousel.setCarousel_path(result);
            carousel.setCarousel_style(false);
            int i = carouselMapper.insert(carousel);
            if (i < 0) {
                throw new ServerInternalException();
            }
        } catch (UploadFileException | ServerInternalException e) {
            e.printStackTrace();
            throw e;
        } catch (Exception e) {
            e.printStackTrace();
            throw new ServerInternalException();
        }
    }

    @Override
    public List<Carousel> getAllCarouse() {
        return carouselMapper.selectCarousel();
    }


    @Override
    public void deleteCarouse(Integer carouselId) {
        try {
            // 先删除七牛文件
            Carousel carousel = carouselMapper.selectByPrimaryKey(carouselId);
            if (carousel == null) {
                throw new WrongInputException();
            }
            QiniuUtil.deleteFile(carousel.getCarousel_path().substring(carousel.getCarousel_path().lastIndexOf("/") + 1));
            int i = carouselMapper.deleteByPrimaryKey(carouselId);
            if (i < 0) {
                throw new ServerInternalException();
            }
        } catch (DeleteRemoteFileException | ServerInternalException | WrongInputException e) {
            e.printStackTrace();
            throw e;
        } catch (Exception e) {
            e.printStackTrace();
            throw new ServerInternalException();
        }
    }

    @Override
    public void addTriangleCarouse(MultipartFile leftImg, MultipartFile rightImg) {
        try {
            String left = QiniuUtil.uploadFile(leftImg);
            String right = QiniuUtil.uploadFile(rightImg);
            Carousel carousel = new Carousel();
            carousel.setCarousel_path(left + "+" + right);
            carousel.setCarousel_style(true);
            int i = carouselMapper.insert(carousel);
            if (i < 0) {
                throw new ServerInternalException();
            }

        } catch (UploadFileException | ServerInternalException e) {
            e.printStackTrace();
            throw e;
        } catch (Exception e) {
            e.printStackTrace();
            throw new ServerInternalException();
        }
    }

    @Override
    public List<Carousel> getAllTriangleCarouse() {
        return carouselMapper.selectTriangleCarousel();
    }


    @Override
    public void replaceTriangleCarouse(Integer carouseId, MultipartFile img, String tab) {
        Carousel carousel = carouselMapper.selectByPrimaryKey(carouseId);
        List<String> list = Arrays.asList(carousel.getCarousel_path().split("\\+"));
        String left = list.get(0);
        String right = list.get(1);
        try {
            String path = QiniuUtil.uploadFile(img);
            String carouselPath = null;
            // 先删除网上的图片，0 为更换左边图片，1 为跟换右边图片
            if (tab.equals("0")) {
                QiniuUtil.deleteFile(left.substring(left.lastIndexOf("/") + 1));
                carouselPath = path + "+" + right;
            } else {
                QiniuUtil.deleteFile(right.substring(right.lastIndexOf("/") + 1));
                carouselPath = left + "+" + path;
            }
            int i = carouselMapper.updatePathById(carouseId, carouselPath);
            if (i < 0) {
                throw new ServerInternalException();
            }
        } catch (DeleteRemoteFileException | UploadFileException | ServerInternalException e) {
            e.printStackTrace();
            throw e;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
}
