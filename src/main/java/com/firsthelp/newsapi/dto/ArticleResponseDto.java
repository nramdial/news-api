package com.firsthelp.newsapi.dto;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"totalArticles", "articles"})
public class ArticleResponseDto {

  @JsonProperty("totalArticles")
  private Integer totalArticles;

  @JsonProperty("articles")
  private List<ArticleDto> articles;

}
