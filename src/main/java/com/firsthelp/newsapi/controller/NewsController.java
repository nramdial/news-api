package com.firsthelp.newsapi.controller;

import com.firsthelp.newsapi.SearchFilter;
import com.firsthelp.newsapi.dto.ArticleResponseDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface NewsController {
  ResponseEntity<ArticleResponseDto> getArticles(Integer limit, String keywords, List<SearchFilter> filter);
}
