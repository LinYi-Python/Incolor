package vip.incolor.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import vip.incolor.entity.Carousel;
import vip.incolor.entity.CarouselExample;

import java.util.List;

@Mapper
@Repository
public interface CarouselMapper {
    int deleteByPrimaryKey(Integer carousel_id);

    int insert(Carousel record);

    int insertSelective(Carousel record);

    List<Carousel> selectByExample(CarouselExample example);

    Carousel selectByPrimaryKey(Integer carousel_id);

    int updateByPrimaryKeySelective(Carousel record);

    int updateByPrimaryKey(Carousel record);

    List<Carousel> selectCarousel();

    List<Carousel> selectTriangleCarousel();

    int updatePathById(@Param("carouseId") Integer carouseId, @Param("carouselPath") String carouselPath);
}