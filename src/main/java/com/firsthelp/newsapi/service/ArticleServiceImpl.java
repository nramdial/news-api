package com.firsthelp.newsapi.service;

import com.firsthelp.newsapi.dto.ArticleResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Slf4j
@Service
public class ArticleServiceImpl implements ArticleService {

  @Value("${gnews.api.key}")
  private String API_KEY;

  @Autowired private WebClient webClient;

  @Override
  public ArticleResponseDto searchArticles(Integer limit, String keywords) {
    log.info("Searching for articles using keywords {} and limit {}", keywords, limit);

    ArticleResponseDto response =
        webClient
            .get()
            .uri(
                uriBuilder ->
                    uriBuilder
                        .path("/search")
                        .queryParam("max", limit)
                        .queryParam("q", keywords)
                        .queryParam("apikey", API_KEY)
                        .build())
            .retrieve()
            .bodyToMono(ArticleResponseDto.class)
            .block();

    assert response != null;
    log.info("Found {} of articles", response.getTotalArticles());
    return response;
  }
}
