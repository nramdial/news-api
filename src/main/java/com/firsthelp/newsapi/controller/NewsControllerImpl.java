package com.firsthelp.newsapi.controller;

import com.firsthelp.newsapi.dto.ArticleResponseDto;
import com.firsthelp.newsapi.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NewsControllerImpl implements NewsController {

  @Autowired private ArticleService articleService;

  @Override
  @GetMapping("/articles")
  public ResponseEntity<ArticleResponseDto> getArticles(
      @RequestParam(required = false, defaultValue = "10") Integer limit,
      @RequestParam String keywords) {
    ArticleResponseDto response = articleService.searchArticles(limit, keywords);
    return new ResponseEntity<>(response, HttpStatus.OK);
  }
}
