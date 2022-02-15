package vip.incolor.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import vip.incolor.dto.RequestResult;
import vip.incolor.entity.Article;
import vip.incolor.entity.ProductStyle;
import vip.incolor.exception.DeleteRemoteFileException;
import vip.incolor.exception.ServerInternalException;
import vip.incolor.exception.UploadFileException;
import vip.incolor.exception.WrongInputException;
import vip.incolor.mapper.ArticleMapper;
import vip.incolor.service.ArticleService;
import vip.incolor.service.RegisterService;
import vip.incolor.utils.GsonUtil;
import vip.incolor.utils.IncolorResultUtil;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;

/**
 * @author: JimLin
 * @description:
 * @email leafyunjim@gmail.com
 * @date: 2018-05-02
 * @time: 20:46
 */
@RestController
@RequestMapping("article")
public class ArticleController {
    @Resource
    private ArticleService articleService;

    /**
     * 添加创意文章
     *
     * @return
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addArticle(List<MultipartFile> imgs, String label, String title, String desc, HttpSession session) {
        if (imgs == null || imgs.isEmpty()) {
            return GsonUtil.getErrorJson("图片未上传");
        }
        try {
            articleService.addArticle(imgs, label, title, desc, session);
        } catch (UploadFileException | ServerInternalException e) {
            e.printStackTrace();
            return GsonUtil.getSuccessJson("添加创意文章失败");
        }
        return GsonUtil.getSuccessJson("添加创意文章成功");
    }


    /**
     * 点击创意文章类目，得到所有的创意文章
     *
     * @return
     */
    @RequestMapping(value = "/get/all", method = RequestMethod.GET)
    public RequestResult getAllArticle() {
        List<Article> articles = articleService.getAllArticle();
        if (articles.isEmpty()) {
            return IncolorResultUtil.error("没有数据");
        }
        return IncolorResultUtil.success(articles);
    }


    /**
     * 点击创意文章类目，得到所有的创意文章（后台管理系统分页）
     *
     * @return
     */
    @RequestMapping(value = "/manager/get/all", method = RequestMethod.POST)
    public RequestResult getAllArticle(@RequestParam("pageNum") Integer pageNum, @RequestParam("pageSize") Integer pageSize) {
        HashMap<String, Object> articles = articleService.getAllArticle(pageNum, pageSize);
        if (articles == null) {
            return IncolorResultUtil.error("没有数据");
        }
        return IncolorResultUtil.success(articles);
    }


    /**
     * 点击某一个创意文章，得到详细内容
     *
     * @return
     */
    @RequestMapping(value = "/get/detail", method = RequestMethod.GET)
    public RequestResult getArticleDetail(@RequestParam("articleId") Integer articleId) {
        Article article = articleService.getArticleDetail(articleId);
        if (article == null) {
            return IncolorResultUtil.error("没有数据");
        }
        return IncolorResultUtil.success(article);
    }


    /**
     * 删除某创意文章（同时删除网上文件）
     *
     * @return
     */
    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String deleteArticle(@RequestParam Integer articleId) {
        try {
            articleService.deleteArticle(articleId);
        } catch (DeleteRemoteFileException | ServerInternalException | WrongInputException e) {
            e.printStackTrace();
            return GsonUtil.getErrorJson("删除创意文章失败");
        }
        return GsonUtil.getSuccessJson("删除创意文章成功");
    }


}
