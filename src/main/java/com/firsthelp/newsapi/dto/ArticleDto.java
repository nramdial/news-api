package com.firsthelp.newsapi.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"title", "description", "content", "url", "image", "publishedAt", "source"})
public class ArticleDto {

    @JsonProperty("title")
    private String title;

    @JsonProperty("description")
    private String description;

    @JsonProperty("content")
    private String content;

    @JsonProperty("url")
    private String url;

    @JsonProperty("image")
    private String image;

    @JsonProperty("publishedAt")
    private String publishedAt;

    @JsonProperty("source")
    private Source source;


    @Getter
    @Setter
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonPropertyOrder({"name", "url"})
    static class Source {

        @JsonProperty("name")
        private String name;

        @JsonProperty("url")
        private String url;
    }
}