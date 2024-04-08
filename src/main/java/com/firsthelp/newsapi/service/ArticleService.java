package com.firsthelp.newsapi.service;

import com.firsthelp.newsapi.dto.ArticleResponseDto;

public interface ArticleService {
    ArticleResponseDto searchArticles(Integer limit, String keywords, String searchCriteria);
}
