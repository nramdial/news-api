package com.firsthelp.newsapi;

import com.firsthelp.newsapi.controller.NewsController;
import com.firsthelp.newsapi.service.ArticleService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class NewsApiApplicationTests {

	@Autowired
	NewsController newsController;
	@Autowired
	ArticleService articleService;

	@Test
	void contextLoads() {
		assertThat(newsController).isNotNull();
		assertThat(articleService).isNotNull();
	}

}
