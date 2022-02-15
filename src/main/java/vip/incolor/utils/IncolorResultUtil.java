package vip.incolor.utils;


import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import vip.incolor.dto.RequestResult;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author JimLin
 * @email leafyunjim@gmail.com
 * @description incolor 返回结果工具类
 * @date 2018-03-07
 * @time 17:22
 */
public class IncolorResultUtil {
    /**
     * 成功时返回数据
     *
     * @return 返回自定义 json
     */
    public static RequestResult success() {
        RequestResult result = new RequestResult();
        result.setMessage("success");
        return result;
    }

    /**
     * 成功时返回数据
     *
     * @return 返回自定义 json
     */
    public static RequestResult success(Object o) {
        RequestResult result = new RequestResult();
        result.setMessage("success");
        result.setResult(o);
        return result;
    }


    /**
     * 成功时返回数据分页
     *
     * @return 返回自定义 json
     */
    public static RequestResult success(Object o, int pages) {
        RequestResult result = new RequestResult();
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("result", o);
        map.put("pages", pages);
        result.setMessage("success");
        result.setResult(map);
        return result;
    }

    /**
     * 成功时返回数据分页
     *
     * @return 返回自定义 json
     */
    public static RequestResult success(Object o, int pages, long total) {
        RequestResult result = new RequestResult();
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("result", o);
        map.put("pages", pages);
        map.put("total", total);
        result.setMessage("success");
        result.setResult(map);
        return result;
    }

    /**
     * 封装错误信息，返回 Result 对象和 code
     *
     * @param error
     * @return 返回自定义 json
     */
    public static RequestResult error(String error) {
        RequestResult result = new RequestResult();
        result.setMessage("false");
        result.setResult(error);
        return result;
    }


    /**
     * 封装错误信息，返回 Result 对象
     *
     * @param bindingResult
     * @return 返回自定义 json
     */
    public static RequestResult error(BindingResult bindingResult) {
        //数据格式有错误
        Map<String, String> errors = new HashMap<String, String>(5);
        List<FieldError> list = bindingResult.getFieldErrors();
        for (FieldError item : list) {
            errors.put(item.getField(), item.getDefaultMessage());
        }
        RequestResult result = new RequestResult();
        result.setResult(errors);
        result.setMessage("false");
        return result;
    }


}
