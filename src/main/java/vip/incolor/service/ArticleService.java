package vip.incolor.service;

import org.springframework.web.multipart.MultipartFile;
import vip.incolor.dto.RequestResult;
import vip.incolor.entity.Article;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;

/**
 * @author: JimLin
 * @description:
 * @email leafyunjim@gmail.com
 * @date: 2018-05-03
 * @time: 22:45
 */
public interface ArticleService {

    void addArticle(List<MultipartFile> imgs, String label, String title, String desc, HttpSession session);

    List<Article> getAllArticle();

    HashMap<String,Object> getAllArticle(int pageNum, int pageSize);

    Article getArticleDetail(Integer articleId);

    void deleteArticle(Integer article);

}
