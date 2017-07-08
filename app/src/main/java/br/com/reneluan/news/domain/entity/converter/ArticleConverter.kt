package br.com.reneluan.news.domain.entity.converter;

import br.com.reneluan.news.domain.entity.ArticleEntity;
import br.com.reneluan.news.model.Article;

object ArticleConverter {

    fun wrap(entity: ArticleEntity?): Article? {
        if (entity == null) return null
            return Article(
                    entity.id?: 0L,
                    entity.author?:"",
                    entity.title?:"",
                    entity.description?:"",
                    entity.url?:"",
                    entity.urlToImage?:"",
                    entity.publishedAt?:""
            )
        }

    fun unwrap(model: Article): ArticleEntity {
        val entity = ArticleEntity()
        entity.id = model.id
        entity.author = model.author
        entity.title = model.title
        entity.description = model.description
        entity.url = model.url
        entity.urlToImage = model.urlToImage
        entity.publishedAt = model.publishedAt
        return entity
    }

}