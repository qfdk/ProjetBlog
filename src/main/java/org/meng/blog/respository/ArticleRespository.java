package org.meng.blog.respository;

import org.meng.blog.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRespository extends JpaRepository<Article,Integer> {
}
