package com.firsthelp.newsapi.controller;

import com.firsthelp.newsapi.dto.ArticleResponseDto;
import org.springframework.http.ResponseEntity;

public interface NewsController {
  ResponseEntity<ArticleResponseDto> getArticles(Integer limit, String keywords);
}
