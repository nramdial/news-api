package com.firsthelp.newsapi.controller;

import com.firsthelp.newsapi.dto.ArticleResponseDto;
import com.firsthelp.newsapi.service.ArticleService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class NewsControllerImplIntTests {
  @Autowired ArticleService articleService;
  @LocalServerPort private int port;
  @Autowired private TestRestTemplate restTemplate;
  private String url;

  @BeforeEach
  public void setup() {
    url = "http://localhost:" + port + "/articles";
  }

  @Test
  @DisplayName("GET /articles Happy Path")
  public void getArticlesHappyPath() {
    url = url + "?keyword=test";
    ArticleResponseDto articleResponseDto =
        restTemplate.getForEntity(url, ArticleResponseDto.class).getBody();

    assert articleResponseDto != null;
  }

  @Test
  @DisplayName("GET /articles Happy Path w/ limit")
  public void getArticlesHappyPathWithLimit() {
    int size = 5;

    url = url + "?keyword=test&limit=" + size;

    ArticleResponseDto articleResponseDto =
        restTemplate.getForEntity(url, ArticleResponseDto.class).getBody();

    assert articleResponseDto != null;

    assertEquals(size, articleResponseDto.getArticles().size());
  }
}
