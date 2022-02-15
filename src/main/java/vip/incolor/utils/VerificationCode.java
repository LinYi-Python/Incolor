package vip.incolor.utils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

public class VerificationCode {
	// 图片的宽度。  
    private int width = 120;  
    // 图片的高度。  
    private int height = 40;  
    // 验证码字符个数  
    private int codeCount = 4;  
    // 验证码干扰线数  
    private int lineCount = 50;  
    // 验证码  
    private String code = null;  
    // 验证码图片Buffer  
    private BufferedImage buffImg = null;  
  
    private char[] codeSequence = {'0', '1','2', '3', '4', '5', '6', '7', '8', '9' };  
  
    // 生成随机数  
    private Random random = new Random();  
  
    public VerificationCode() {
        this.createCode();  
    }  
  
    /** 
     *  
     * @param width 
     *            图片宽 
     * @param height 
     *            图片高 
     */  
    public VerificationCode(int width, int height) {
        this.width = width;  
        this.height = height;  
        this.createCode();  
    }  
  
    /** 
     *  
     * @param width 
     *            图片宽 
     * @param height 
     *            图片高 
     * @param codeCount 
     *            字符个数 
     * @param lineCount 
     *            干扰线条数 
     */  
    public VerificationCode(int width, int height, int codeCount, int lineCount) {
        this.width = width;  
        this.height = height;  
        this.codeCount = codeCount;  
        this.lineCount = lineCount;  
        this.createCode();  
    }  
  
    public void createCode() {  
        int codeX = 0;  
        int fontHeight = 0;  
        fontHeight = height - 5;// 字体的高度  
        codeX = width / (codeCount+3);// 每个字符的宽度  
  
        // 图像buffer  
        buffImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);  
        Graphics2D g = buffImg.createGraphics();  
  
        // 将图像填充为白色  
        g.setColor(Color.WHITE);  
        g.fillRect(0, 0, width, height);  
  
        // 创建字体  
        ImgFontByte imgFont = new ImgFontByte();  
        Font font = imgFont.getFont(fontHeight);  
        g.setFont(font);  
  
        // 绘制干扰线  
        for (int i = 0; i < lineCount; i++) {  
            int xs = getRandomNumber(width);  
            int ys = getRandomNumber(height);  
            int xe = xs + getRandomNumber(width / 8);  
            int ye = ys + getRandomNumber(height / 8);  
            g.setColor(getRandomColor());  
            g.drawLine(xs, ys, xe, ye);  
        }  
  
        StringBuffer randomCode = new StringBuffer();  
        // 随机产生验证码字符  
        for (int i = 0; i < codeCount; i++) {  
            String strRand = String.valueOf(codeSequence[random  
                    .nextInt(codeSequence.length)]);  
            // 设置字体颜色  
            g.setColor(getRandomColor());  
            // 设置字体位置  
            g.drawString(strRand, (i + 1) * codeX,  
                    getRandomNumber(height / 2) + 25);  
            randomCode.append(strRand);  
        }  
        code = randomCode.toString();  
    }  
  
    /** 获取随机颜色 */  
    private Color getRandomColor() {  
        int r = getRandomNumber(255);  
        int g = getRandomNumber(255);  
        int b = getRandomNumber(255);  
        return new Color(r, g, b);  
    }  
  
    /** 获取随机数 */  
    private int getRandomNumber(int number) {  
        return random.nextInt(number);  
    }  
  
    public void write(String path) throws IOException {  
        OutputStream sos = new FileOutputStream(path);  
        this.write(sos);  
    }  
  
    public void write(OutputStream sos) throws IOException {  
        ImageIO.write(buffImg, "png", sos);  
        sos.close();  
    }  
  
    public BufferedImage getBuffImg() {  
        return buffImg;  
    }  
  
    public String getCode() {  
        return code;  
    }  
  
    /** 字体样式类 */  
    class ImgFontByte {  
        public Font getFont(int fontHeight) {  
            try {  
                Font baseFont = Font.createFont(Font.TRUETYPE_FONT,  
                        new ByteArrayInputStream(hex2byte(getFontByteStr())));  
                return baseFont.deriveFont(Font.PLAIN, fontHeight);  
            } catch (Exception e) {  
                return new Font("Arial", Font.PLAIN, fontHeight);  
            }  
        }  
  
        private byte[] hex2byte(String str) {  
            if (str == null)  
                return null;  
            str = str.trim();  
            int len = str.length();  
            if (len == 0 || len % 2 == 1)  
                return null;  
  
            byte[] b = new byte[len / 2];  
            try {  
                for (int i = 0; i < str.length(); i += 2) {  
                    b[i / 2] = (byte) Integer.decode(  
                            "0x" + str.substring(i, i + 2)).intValue();  
                }  
                return b;  
            } catch (Exception e) {  
                return null;  
            }  
        }  
  
        // 字体文件的十六进制字符串  
        private String getFontByteStr() {  
  
            return "0001000000100040000400c04f532f327d8175d4000087740000005650434c5461e3d9fb000087cc00000036636d61709cbc69ab00007a64000005e863767420bb32bf1600000f24000000326670676d8333c24f00000f1000000014676c7966302665d800000fc40000663c68646d7806beef530000806c0000070868656164c6469a91000088040000003668686561068002f40000883c00000024686d7478e8bd09b4000077b0000001ac6b65726efffe00650000804c0000001e6c6f6361001a319600007600000001b06d617870013e049f00008860000000206e616d65a927f7000000010c00000e04706f737469df66ea0000795c0000010670726570eacfd8a800000f580000006b0000001f017a000000000000000001de00000000000000000001001c00520000000000000002000e01de0000000000000003003201ec0000000000000004001c005200000000000000050024021e0000000000000006001a02420000000000000007005c0052000100000000000000ef025c0001000000000001000e028500010000000000020007034b0001000000000003001903520001000000000004000e028500010000000000050012036b0001000000000006000d037d0001000000000007002e0285000300010409000001de00000003000104090001001c00520003000104090002000e01de0003000104090003003201ec0003000104090004001c005200030001040900050024021e0003000104090006001a02420003000104090007005c00520003000104090008002c038a000300010409000900180aa2000300010409000a01300b16000300010409000b004c0a12000300010409000c00440c46000300010409000d076003b6000300010409000e00600a120068007400740070003a002f002f006d0065006d0062006500720073002e0061006f006c002e0063006f006d002f00760072006f006f006d0066006f006e00640065002f007400740066002f0020002d00200041006300740069006f006e0020004a00610063006b0073006f006e00200043006f007000790072006900670068007400200028004300290020003100390039003800200054006f006d0020004d00750072007000680079002000370020002d00200046007200650065002100200042007500740020006e006f007400200074006f0020006200650020007200650073006f006c006400200028006f006e00200043004400200066006f007200200069006e007300740061006e00630065002100290020002d00200049006d0069006700680074006200650054004d00400061006f006c002e0063006f006d0020002d00200033003300390020005300740069006c006c002000480069006c006c002000520064002e0020002d002000480061006d00640065006e";  
        }  
    }  
}
