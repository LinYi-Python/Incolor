package vip.incolor.service.impl;

import net.coobird.thumbnailator.Thumbnails;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import vip.incolor.exception.PhotoIdOutOfBoundException;
import vip.incolor.exception.PhotoTypeIncorrectException;
import vip.incolor.exception.ServerInternalException;
import vip.incolor.service.PhotoService;
import vip.incolor.utils.UUIDUtil;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.Date;

/**
 * @author LiYizhan
 * @email 1062585732@qq.com
 * @description
 * @date 2018/4/2
 * @time 21:44
 */
@PropertySource({"classpath:photoParams.properties"})
@Service
public class PhotoServiceImpl implements PhotoService {

    @Value("${icphoto.quality}")
    private double quality;

    @Value("${icphoto.scale}")
    private double scale;

    @Value("${icphoto.cyclePicNum}")
    private int cyclePicNum;

    @Value("${icphoto.trianglePicNum}")
    private int trianglePicNum;

    @Override
    public void alterHomeCyclePicture(Integer id, MultipartFile photo, HttpSession session,boolean isCompress) {
        //检查id号是否在范围内
        if(id<=0||id>cyclePicNum){
            throw new PhotoIdOutOfBoundException();
        }
        alterPictureWithoutDB(id,photo,session,"cyclePic",isCompress);
    }

    @Override
    public void alterHomeTrianglePicture(Integer id, MultipartFile photo, HttpSession session,boolean isCompress) {
        //检查id号是否在范围内
        if(id<=0||id>trianglePicNum){
            throw new PhotoIdOutOfBoundException();
        }
        alterPictureWithoutDB(id,photo,session,"trianglePic",isCompress);
    }

    private void alterPictureWithoutDB(Integer id, MultipartFile photo, HttpSession session, String folder,boolean isCompress) {
        try{
            //检查文件类型
            if(!(photo.getOriginalFilename().endsWith(".jpg")||photo.getOriginalFilename().endsWith(".png"))){
                throw new PhotoTypeIncorrectException();
            }
            String parentFolder=session.getServletContext().
                    getRealPath("/img/"+folder);
            //临时生成一个图片文件
            String tempName= UUIDUtil.getUUID()+".jpg";
            File tempCyclePic=new File(parentFolder,tempName);
            tempCyclePic.getParentFile().mkdirs();
            //传入数据流
            try{
                photo.transferTo(tempCyclePic);
            }catch (IOException e){
                throw new ServerInternalException();
            }
            //压缩
            if(isCompress){
                Thumbnails.of(tempCyclePic)
                        .scale(scale)
                        .outputQuality(quality)
                        .toFile(tempCyclePic);
            }
            //删除图
            String fileName=id+".jpg";
            File oldPic=new File(parentFolder,fileName);
            if(oldPic.exists()){
                oldPic.delete();
            }
            //重命名临时文件成新的轮播图
            tempCyclePic.renameTo(oldPic);
        }catch (PhotoTypeIncorrectException|ServerInternalException e){
            throw e;
        }catch (Exception e){
            throw new ServerInternalException(e.getMessage());
        }
    }

}
