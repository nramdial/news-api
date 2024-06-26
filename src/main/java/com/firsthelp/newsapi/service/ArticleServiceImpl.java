package com.firsthelp.newsapi.service;

import com.firsthelp.newsapi.dto.ArticleResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Optional;

@Slf4j
@Service
public class ArticleServiceImpl implements ArticleService {

  @Value("${gnews.api.key}")
  private String API_KEY;

  @Autowired private WebClient webClient;

  @Override
  @Cacheable(value = "articles", key = "{ #keyword, #limit}")
  public ArticleResponseDto searchArticles(Integer limit, String keyword, String filterBy) {
    log.info("Searching for articles using keywords {}, filter {}, and limit {}", keyword, filterBy, limit);

    ArticleResponseDto response =
        webClient
            .get()
            .uri(
                uriBuilder ->
                    uriBuilder
                        .path("/search")
                        .queryParam("max", limit)
                        .queryParam("q", keyword)
                        .queryParamIfPresent("in", Optional.of(String.join(",", filterBy)))
                        .queryParam("apikey", API_KEY)
                        .build())
            .retrieve()
            .bodyToMono(ArticleResponseDto.class)
            .block();

    assert response != null;
    log.info("Found {} article(s)", response.getTotalArticles());
    return response;
  }
}
