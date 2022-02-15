package vip.incolor.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.transaction.annotation.Transactional;
import vip.incolor.dto.RequestResult;
import vip.incolor.entity.Article;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import vip.incolor.exception.DeleteRemoteFileException;
import vip.incolor.exception.ServerInternalException;
import vip.incolor.exception.UploadFileException;
import vip.incolor.exception.WrongInputException;
import vip.incolor.mapper.ArticleMapper;
import vip.incolor.service.ArticleService;
import vip.incolor.utils.IncolorResultUtil;
import vip.incolor.utils.PhotoUtil;
import vip.incolor.utils.QiniuUtil;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author: JimLin
 * @description:
 * @email leafyunjim@gmail.com
 * @date: 2018-05-03
 * @time: 22:45
 */
@Service
public class ArticleServiceImpl implements ArticleService {

    @Resource
    private ArticleMapper articleMapper;

    /**
     * 添加创意文章
     *
     * @param imgs
     * @param label
     * @param title
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void addArticle(List<MultipartFile> imgs, String label, String title, String desc, HttpSession session) {
        try {
            String urls = "";
            for (MultipartFile img : imgs) {
                String result = QiniuUtil.uploadFile(img);
                urls = urls + result + "+";
            }
            Article article = new Article();
            article.setArticle_label(label);
            article.setArticle_desc(desc);
            article.setArticle_picture(urls);
            article.setArticle_title(title);
            int i = articleMapper.insert(article);
            if (i < 0) {
                throw new ServerInternalException();
            }
        } catch (UploadFileException | ServerInternalException e) {
            e.printStackTrace();
            throw e;
        } catch (Exception e) {
            e.printStackTrace();
            throw new ServerInternalException();
        }
    }

    @Override
    public List<Article> getAllArticle() {
        return articleMapper.selectAllArticle();
    }

    @Override
    public HashMap<String, Object> getAllArticle(int pageNum, int pageSize) {
        Page<Article> page = PageHelper.startPage(pageNum, pageSize);
        List<Article> list = articleMapper.selectAllArticle();
        if (list.isEmpty()) {
            return null;
        }
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("data", page.getResult());
        map.put("pages", page.getPages());
        map.put("total", page.getTotal());
        return map;
    }

    @Override
    public Article getArticleDetail(Integer articleId) {
        return articleMapper.selectArticleById(articleId);
    }

    @Override
    public void deleteArticle(Integer articleId) {
        try {
            // 先删除七牛文件
            Article article = articleMapper.selectArticleById(articleId);
            if (article == null) {
                throw new WrongInputException();
            }
            List<String> list = Arrays.asList(article.getArticle_picture().split("\\+"));
            for (String url : list) {
                QiniuUtil.deleteFile(url.substring(url.lastIndexOf("/") + 1));
            }
            int i = articleMapper.deleteByPrimaryKey(articleId);
            if (i < 0) {
                throw new ServerInternalException();
            }
        } catch (DeleteRemoteFileException | ServerInternalException | WrongInputException e) {
            e.printStackTrace();
            throw e;
        } catch (Exception e) {
            e.printStackTrace();
            throw new ServerInternalException();
        }
    }
}


