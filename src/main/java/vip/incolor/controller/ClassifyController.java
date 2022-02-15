package vip.incolor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import vip.incolor.dto.RequestResult;
import vip.incolor.entity.ProductPicture;
import vip.incolor.entity.ProductStyle;
import vip.incolor.exception.ServerInternalException;
import vip.incolor.exception.UploadFileException;
import vip.incolor.service.ClassifyService;
import vip.incolor.utils.GsonUtil;
import vip.incolor.utils.IncolorResultUtil;
import vip.incolor.vo.ProductVO;

import java.util.HashMap;
import java.util.List;

/**
 * @author: JimLin
 * @description: 类目 controller
 * @email leafyunjim@gmail.com
 * @date: 2018-04-12
 * @time: 14:53
 */
@RestController
@RequestMapping("classify")
public class ClassifyController {

    private ClassifyService classifyService;

    @Autowired
    public ClassifyController(ClassifyService classifyService) {
        super();
        this.classifyService = classifyService;
    }

    /**
     * 首页得到所有类目
     *
     * @return
     */
    @RequestMapping(value = "/get/all", method = RequestMethod.GET)
    public RequestResult getAllClassify() {
        List<ProductStyle> list = classifyService.getAllClassify();
        if (!list.isEmpty()) {
            return IncolorResultUtil.success(list);
        } else {
            return IncolorResultUtil.error("没有数据");
        }
    }


    /**
     * 后台管理系统得到所有一级类目
     *
     * @return
     */
    @RequestMapping(value = "/manager/get/all", method = RequestMethod.GET)
    public RequestResult getAllManagerClassify() {
        List<ProductStyle> list = classifyService.getAllManagerClassify();
        if (!list.isEmpty()) {
            return IncolorResultUtil.success(list);
        } else {
            return IncolorResultUtil.error("没有数据");
        }
    }

    /**
     * 首页搜索
     *
     * @param searchContent 搜索内容
     */
    @RequestMapping(value = "/index/search", method = RequestMethod.POST)
    public RequestResult indexSearch(@RequestParam("searchContent") String searchContent) {
        if (searchContent == null || searchContent.equals("")) {
            return IncolorResultUtil.error("没有数据");
        }
        HashMap map = classifyService.indexSearch(searchContent);
        if (map.get("products") != null || map.get("articles") != null) {
            return IncolorResultUtil.success(map);
        } else {
            return IncolorResultUtil.error("没有数据");
        }
    }

    /**
     * 首页鼠标触碰某一级类目
     *
     * @param classId 产品类型 Id
     */
    @RequestMapping(value = "/get/secondary/classify", method = RequestMethod.GET)
    public RequestResult getSecondaryClassify(@RequestParam("classId") Integer classId) {
        List<ProductStyle> list = classifyService.getSecondaryClassify(classId);
        if (!list.isEmpty()) {
            return IncolorResultUtil.success(list);
        } else {
            return IncolorResultUtil.error("没有数据");
        }
    }

    /**
     * 首页鼠标触碰某一级类目
     *
     * @param classId 产品类型 Id
     */
    @RequestMapping(value = "/get/manager/secondary/classify", method = RequestMethod.GET)
    public RequestResult getManagerSecondaryClassify(@RequestParam("classId") Integer classId) {
        List<ProductStyle> list = classifyService.getManagerSecondaryClassify(classId);
        if (!list.isEmpty()) {
            return IncolorResultUtil.success(list);
        } else {
            return IncolorResultUtil.error("没有数据");
        }
    }


    /**
     * 首页点击某二级类目
     *
     * @param classId 产品类型 Id
     */
    @RequestMapping(value = "/get/product", method = RequestMethod.GET)
    public RequestResult getProduct(@RequestParam("classId") Integer classId) {
        HashMap<String, Object> map = classifyService.getProduct(classId);
        if (!map.isEmpty()) {
            return IncolorResultUtil.success(map);
        } else {
            return IncolorResultUtil.error("没有数据");
        }
    }


    /**
     * 添加一级类目
     *
     * @param classifyName 产品类型 Id
     */
    @RequestMapping(value = "/add/top/classify", method = RequestMethod.POST)
    public String addTopClassify(@RequestParam("classifyName") String classifyName, @RequestParam("img") MultipartFile img) {
        try {
            classifyService.addTopClassify(classifyName, img);
        } catch (UploadFileException | ServerInternalException e) {
            e.printStackTrace();
            return GsonUtil.getErrorJson("添加一级类目失败");
        }
        return GsonUtil.getSuccessJson("添加一级类目成功");

    }

    /**
     * 类目上线
     *
     * @param classifyId 产品类型 Id
     */
    @RequestMapping(value = "/on/line", method = RequestMethod.GET)
    public String onLine(@RequestParam("classifyId") Integer classifyId) {
        try {
            classifyService.onLine(classifyId);
        } catch (ServerInternalException e) {
            e.printStackTrace();
            return GsonUtil.getErrorJson("类目上线失败");
        }
        return GsonUtil.getSuccessJson("类目上线成功");
    }

    /**
     * 类目下线
     *
     * @param classifyId 产品类型 Id
     */
    @RequestMapping(value = "/under/line", method = RequestMethod.GET)
    public String underLine(@RequestParam("classifyId") Integer classifyId) {
        try {
            classifyService.underLine(classifyId);
        } catch (ServerInternalException e) {
            e.printStackTrace();
            return GsonUtil.getErrorJson("类目下线失败");
        }
        return GsonUtil.getSuccessJson("类目下线成功");

    }


    /**
     * 添加二级类目
     *
     * @param classifyName 产品类型 Id
     */
    @RequestMapping(value = "/add/second/classify", method = RequestMethod.POST)
    public String addSecondClassify(@RequestParam("classifyName") String classifyName, @RequestParam("classifyId") Integer classifyId, @RequestParam("img") MultipartFile img) {
        try {
            classifyService.addSecondClassify(classifyName, classifyId, img);
        } catch (UploadFileException | ServerInternalException e) {
            e.printStackTrace();
            return GsonUtil.getErrorJson("添加二级类目失败");
        }
        return GsonUtil.getSuccessJson("添加二级类目成功");

    }

    /**
     * 得到新品
     *
     * @return
     */
    @RequestMapping(value = "/get/new/product", method = RequestMethod.GET)
    public RequestResult getNewProduct() {
        List<ProductPicture> list = classifyService.getNewProduct();
        if (!list.isEmpty()) {
            return IncolorResultUtil.success(list);
        } else {
            return IncolorResultUtil.error("没有数据");
        }

    }

    /**
     * 删除类目
     *
     * @param classifyId 产品类型 Id
     */
    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String delete(@RequestParam("classifyId") Integer classifyId) {
        try {
            classifyService.delete(classifyId);
        } catch (ServerInternalException e) {
            e.printStackTrace();
            return GsonUtil.getErrorJson("删除类目失败");
        }
        return GsonUtil.getSuccessJson("删除类目成功");

    }


}
