package vip.incolor.service;

import org.springframework.web.multipart.MultipartFile;
import vip.incolor.entity.Carousel;

import java.util.List;

/**
 * @author: JimLin
 * @description:
 * @email leafyunjim@gmail.com
 * @date: 2018-05-12
 * @time: 22:30
 */
public interface CarouselService {
    void addCarouse(MultipartFile img);

    List<Carousel> getAllCarouse();

    void deleteCarouse(Integer carouselId);

    void addTriangleCarouse(MultipartFile leftImg, MultipartFile rightImg);


    List<Carousel> getAllTriangleCarouse();

    void replaceTriangleCarouse(Integer carouseId, MultipartFile img,String tab);

}
