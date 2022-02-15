package vip.incolor.utils;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author LiYizhan
 * @email 1062585732@qq.com
 * @description
 * @date 2018/4/9
 * @time 16:32
 */
public class QRCodeUtil {
    public static final int QRCODE_WIDTH=100;
    public static final int QRCODE_HEIGHT=100;
    public static final String FILE_TYPE="png";

    public static BitMatrix generateBitMatrix(String contents)throws WriterException{
        Map<EncodeHintType,Object> hints=new HashMap<>();
        hints.put(EncodeHintType.CHARACTER_SET,"utf-8");
        hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.M);
        hints.put(EncodeHintType.MARGIN,2);
        return new MultiFormatWriter().encode(contents, BarcodeFormat.QR_CODE,QRCODE_WIDTH,QRCODE_HEIGHT,hints);
    }

    public static byte[] getQRCodeByteArray(BitMatrix bitMatrix) throws IOException{
        BufferedImage bufferedImage= MatrixToImageWriter.toBufferedImage(bitMatrix);
        ByteArrayOutputStream baos=new ByteArrayOutputStream();
        ImageIO.write(bufferedImage,FILE_TYPE,baos);
        return baos.toByteArray();
    }
}
