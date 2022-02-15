package vip.incolor.utils;

import net.coobird.thumbnailator.Thumbnails;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.multipart.MultipartFile;
import vip.incolor.exception.PhotoIdOutOfBoundException;
import vip.incolor.exception.PhotoTypeIncorrectException;
import vip.incolor.exception.ServerInternalException;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;

/**
 * @author: JimLin
 * @description:
 * @email leafyunjim@gmail.com
 * @date: 2018-05-03
 * @time: 22:05
 */
@PropertySource({"classpath:photoParams.properties"})
public class PhotoUtil {

    @Value("${icphoto.quality}")
    private static double quality;

    @Value("${icphoto.scale}")
    private static double scale;

    @Value("${icphoto.cyclePicNum}")
    private static int cyclePicNum;

    @Value("${icphoto.trianglePicNum}")
    private static int trianglePicNum;


    /**
     * 输出incolor/sbfolder/sbsubfolder/sb.jpg，输入有误，返回null，有异常就直接抛出
     *
     * @param fileName   文件名，例子：sb.jpg，如果在字符串前有文件分隔符，将会被过滤，其余地方不能再有文件分隔符，图片支持jpg,png,jpeg,bmp
     * @param filePath   文件上级路径，例子：sbfolder/sbsubfolder，如果在字符串前有文件分隔符，将会被过滤，输入的文件分隔符会被统一替换成因环境而定的分隔符
     * @param photo      图片
     * @param session    用于获取tomcat项目路径
     * @param isCompress 是否启用压缩
     * @return
     */

    public static String saveSinglePicture(String fileName, String filePath, MultipartFile photo, HttpSession session, boolean isCompress) throws IOException {
        //判断输入是否为空
        if (fileName == null || filePath == null || photo == null ) {
            return null;
        }
        //检查文件后缀名是支持的格式
        if (!fileName.endsWith(".jpg") && !fileName.endsWith(".png") && !fileName.endsWith(".jpeg") && !fileName.endsWith(".bmp")) {
            return null;
        }
        //检查文件是支持的格式
        if (!photo.getOriginalFilename().endsWith(".jpg") && !photo.getOriginalFilename().endsWith(".png") && !photo.getOriginalFilename().endsWith(".jpeg") && !photo.getOriginalFilename().endsWith(".bmp")) {
            return null;
        }
        //去除掉fileName第一个文件分隔符
        if (fileName.startsWith(File.pathSeparator) || fileName.startsWith("\\") || fileName.startsWith("/")) {
            fileName = fileName.substring(1);
        }
        //检查fileName无文件分隔符
        if (fileName.contains(File.pathSeparator) || fileName.startsWith("\\") || fileName.startsWith("/")) {
            return null;
        }
        //去除掉filePath第一个文件分隔符
        if (filePath.startsWith(File.pathSeparator) || fileName.startsWith("\\") || fileName.startsWith("/")) {
            filePath = filePath.substring(1);
        }
        //统一使用环境下的文件分隔符
        filePath = filePath.replaceAll("\\\\", File.pathSeparator);
        filePath = filePath.replaceAll("/", File.pathSeparator);

        String parentFolder = File.pathSeparator + filePath;
        String parentPath = session.getServletContext().getRealPath(parentFolder);
        File pic = new File(parentPath, fileName);
        pic.getParentFile().mkdirs();
        photo.transferTo(pic);
        if (isCompress) {
            Thumbnails.of(pic)
                    .scale(scale)
                    .outputQuality(quality)
                    .toFile(pic);
        }
        return session.getServletContext().getContextPath() + File.pathSeparator + filePath + File.pathSeparator + fileName;
    }

}
