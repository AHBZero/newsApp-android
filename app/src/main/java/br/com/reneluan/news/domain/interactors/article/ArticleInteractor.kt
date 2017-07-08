package br.com.reneluan.news.domain.interactors.article

import io.reactivex.Scheduler
import br.com.reneluan.news.domain.interactors.base.BaseInteractor

import javax.inject.Inject
import io.reactivex.Observable

class ArticleInteractor @Inject constructor(executor: Scheduler) : BaseInteractor(executor)  {

    fun invoke(): Observable<Any> {
        return Observable.just(Any());
    }

}
