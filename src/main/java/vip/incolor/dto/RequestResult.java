package vip.incolor.dto;

/**
 * @author LiYizhan
 * @email 1062585732@qq.com
 * @description 通用前后端交互数据载体
 * @date 2018-03-20
 * @time 17:30
 */
public class RequestResult {
    /**
     * 后端响应前端请求的结果，可填入如"Wrong input"等提示语
     */
    private String message;
    /**
     * 用于序列化的字段，可存放对象，供GSON序列化成JSON对象
     */
    private Object result;

    public RequestResult(){
    }

    public RequestResult(String message, Object result) {
        this.message = message;
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }
}
