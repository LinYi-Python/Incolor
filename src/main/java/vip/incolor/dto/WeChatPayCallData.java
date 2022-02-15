package vip.incolor.dto;

import com.google.gson.annotations.SerializedName;

/**
 * @author LiYizhan
 * @email 1062585732@qq.com
 * @description
 * @date 2018/4/9
 * @time 20:17
 */
public class WeChatPayCallData {
    @SerializedName("appid")
    private String appID;
    @SerializedName("openid")
    private String openID;
    @SerializedName("mch_id")
    private String mchID;
    @SerializedName("is_subscribe")
    private String subscribeStatus;
    @SerializedName("nonce_str")
    private String randomStr;
    @SerializedName("product_id")
    private String productID;
    @SerializedName("sign")
    private String sign;

    public String getAppID() {
        return appID;
    }

    public void setAppID(String appID) {
        this.appID = appID;
    }

    public String getOpenID() {
        return openID;
    }

    public void setOpenID(String openID) {
        this.openID = openID;
    }

    public String getMchID() {
        return mchID;
    }

    public void setMchID(String mchID) {
        this.mchID = mchID;
    }

    public String getSubscribeStatus() {
        return subscribeStatus;
    }

    public void setSubscribeStatus(String subscribeStatus) {
        this.subscribeStatus = subscribeStatus;
    }

    public String getRandomStr() {
        return randomStr;
    }

    public void setRandomStr(String randomStr) {
        this.randomStr = randomStr;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }
}
