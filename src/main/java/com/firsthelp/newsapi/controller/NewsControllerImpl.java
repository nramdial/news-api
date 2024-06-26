package com.firsthelp.newsapi.controller;

import com.firsthelp.newsapi.util.SearchFilter;
import com.firsthelp.newsapi.dto.ArticleResponseDto;
import com.firsthelp.newsapi.service.ArticleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@Validated
@RestController
public class NewsControllerImpl implements NewsController {

  @Autowired private ArticleService articleService;

  @Override
  @GetMapping("/articles")
  public ResponseEntity<ArticleResponseDto> getArticles(
      Integer limit, String keyword, List<SearchFilter> filter) {
    log.info("Invoking GET /articles endpoint");
    String criteriaString = filter.toString();
    ArticleResponseDto response = articleService.searchArticles(limit, keyword, criteriaString);
    return new ResponseEntity<>(response, HttpStatus.OK);
  }
}
