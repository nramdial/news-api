package com.firsthelp.newsapi.controller;

import com.firsthelp.newsapi.SearchFilter;
import com.firsthelp.newsapi.dto.ArticleResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface NewsController {

  @Operation(summary = "Get a list of articles")
  @ApiResponses(
      value = {
        @ApiResponse(
            responseCode = "200",
            description = "Found a list of articles",
            content = {
              @Content(
                  mediaType = "application/json",
                  schema = @Schema(implementation = ArticleResponseDto.class))
            }),
        @ApiResponse(responseCode = "400", description = "Bad Request", content = @Content),
        @ApiResponse(responseCode = "404", description = "No articles found", content = @Content)
      })
  ResponseEntity<ArticleResponseDto> getArticles(
      @Valid
          @RequestParam(required = false, defaultValue = "10")
          @Parameter(description = "Number of articles to return")
          @Min(1)
          @Max(100)
          Integer limit,
      @RequestParam @Parameter(description = "Required keyword to search by") String keyword,
      @RequestParam(name = "filter", required = false, defaultValue = "")
          @Parameter(description = "Comma-separated filter categories (e.g. \"title,content\", \"content\" ")
          List<SearchFilter> filter);
}
