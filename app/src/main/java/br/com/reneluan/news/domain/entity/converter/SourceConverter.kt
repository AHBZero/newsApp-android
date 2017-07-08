package br.com.reneluan.news.domain.entity.converter;

import br.com.reneluan.news.domain.entity.SourceEntity;
import br.com.reneluan.news.model.Source;

object SourceConverter {

    fun wrap(entity: SourceEntity?): Source? {
        if (entity == null) return null
            return Source(entity.id?: "", entity.name?:"", entity.description?:"", entity.url?:"")
        }

    fun unwrap(model: Source): SourceEntity {
        val entity = SourceEntity()
        entity.id = model.id
        entity.name = model.name
        entity.description = model.description
        entity.url = model.url

        return entity
    }

}