package com.firsthelp.newsapi.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class GNewsConfig {

  @Value("${gnews.api.key}")
  private String API_KEY;
  @Value("${gnews.api.host}")
  private String API_HOST;

  @Bean
  public WebClient gnewsApiClient() {
      return WebClient.builder()
            .baseUrl(API_HOST)
            .defaultCookie("cookieKey", "cookieValue")
            .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
            .build();
  }
}
