package vip.incolor.utils;

import com.github.wxpay.sdk.WXPayConfig;

import java.io.*;

/**
 * @author LiYizhan
 * @email 1062585732@qq.com
 * @description
 * @date 2018/4/19
 * @time 9:40
 */
public class MyWxPayConfig implements WXPayConfig {
    /*private String key; //测试*/
    //private byte[] certData;

    public MyWxPayConfig() throws IOException{
        //String certPath="";
        //File file=new File(certPath);
        //InputStream certStream=new FileInputStream(file);
        //this.certData=new byte[(int)file.length()];
        //certStream.read(this.certData);
        //certStream.close();
    }

    @Override
    public String getAppID() {
        return "wxa25a67f19e569a89";
    }

    @Override
    public String getMchID() {
        return "1490191822";
    }

    @Override
    public String getKey() {
        return "incolorYingKaiLuGuangZhouNanPu18";
    }

    /*@Override
    public String getKey() {
        return "5f9d85b292bf954dea97e8bebcffbf32";      //沙盒测试key
    }*/

    @Override
    public InputStream getCertStream() {
        /*ByteArrayInputStream certBis=new ByteArrayInputStream(this.certData);
        return certBis;*/
        return null;
    }

    @Override
    public int getHttpConnectTimeoutMs() {
        return 8000;
    }

    @Override
    public int getHttpReadTimeoutMs() {
        return 10000;
    }

    /*//测试
    public void setKey(String key){
        this.key=key;
    }*/
}
