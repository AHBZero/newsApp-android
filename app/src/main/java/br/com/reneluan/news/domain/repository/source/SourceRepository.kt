package br.com.reneluan.news.domain.repository.source;

import br.com.reneluan.news.model.Source
import io.reactivex.Observable
import javax.inject.Inject

class SourceRepository @Inject constructor() {

    @Inject
    lateinit var remoteRepository: SourceRemoteRepository

    fun getAllSources(): Observable<List<Source>> {
        return remoteRepository
                .getAllSources()
                .map {
                    it.sources
                }
    }

}
