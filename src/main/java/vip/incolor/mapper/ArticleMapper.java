package vip.incolor.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import vip.incolor.entity.Article;
import vip.incolor.entity.ArticleExample;

@Mapper
@Repository
public interface ArticleMapper {
    int deleteByPrimaryKey(Integer article_id);

    int insert(Article record);

    int insertSelective(Article record);

    List<Article> selectByExample(ArticleExample example);

    Article selectByPrimaryKey(Integer article_id);

    int updateByPrimaryKeySelective(Article record);

    int updateByPrimaryKey(Article record);


    /**
     * 根据关键字搜索创意文章
     *
     * @param searchContent 搜索内容
     * @return
     */
    List<Article> selectArticleByName(String searchContent);

    List<Article> selectAllArticle();

    Article selectArticleById(Integer articleId);
}
