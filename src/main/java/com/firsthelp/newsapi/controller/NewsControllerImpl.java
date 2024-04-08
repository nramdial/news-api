package com.firsthelp.newsapi.controller;

import com.firsthelp.newsapi.SearchFilter;
import com.firsthelp.newsapi.dto.ArticleResponseDto;
import com.firsthelp.newsapi.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class NewsControllerImpl implements NewsController {

  @Autowired private ArticleService articleService;

  @Override
  @GetMapping("/articles")
  public ResponseEntity<ArticleResponseDto> getArticles(
      @RequestParam(required = false, defaultValue = "10") Integer limit,
      @RequestParam String keyword,
      @RequestParam(name = "filter", required = false, defaultValue = "") List<SearchFilter> filter) {
    String criteriaString = filter.toString();
    ArticleResponseDto response = articleService.searchArticles(limit, keyword, criteriaString);
    return new ResponseEntity<>(response, HttpStatus.OK);
  }
}
