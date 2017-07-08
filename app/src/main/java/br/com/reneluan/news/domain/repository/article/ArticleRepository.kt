package br.com.reneluan.news.domain.repository.article;

import javax.inject.Inject;

class ArticleRepository @Inject constructor() {

    @Inject
    lateinit var remoteRepository: ArticleRemoteRepository

  }
