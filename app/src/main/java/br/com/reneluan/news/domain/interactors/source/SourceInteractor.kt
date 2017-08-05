package br.com.reneluan.news.domain.interactors.source

import io.reactivex.Scheduler
import br.com.reneluan.news.domain.interactors.base.BaseInteractor
import br.com.reneluan.news.domain.repository.source.SourceRepository
import br.com.reneluan.news.model.Source
import br.com.reneluan.news.model.SourceResponse

import javax.inject.Inject
import io.reactivex.Observable

class SourceInteractor @Inject constructor(executor: Scheduler) : BaseInteractor(executor)  {

    @Inject
    lateinit var sourceRepository: SourceRepository

    fun getAllSources(): Observable<List<Source>> {
        return sourceRepository
                .getAllSources()
                .subscribeOn(executor)
    }

    fun getSources(category: String): Observable<List<Source>>{
        return sourceRepository
                .getSources(category)
                .subscribeOn(executor)
    }

}
