package br.com.reneluan.news.ui.source

import br.com.reneluan.news.domain.interactors.source.SourceInteractor
import br.com.reneluan.news.ui.base.BasePresenter
import io.reactivex.android.schedulers.AndroidSchedulers
import timber.log.Timber
import javax.inject.Inject

class SourcePresenter @Inject constructor() : BasePresenter<SourceView>() {

    @Inject
    lateinit var sourceInteractor: SourceInteractor

    fun getAllSources() {
        sourceInteractor
                .getAllSources()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe (
                    {
                        view?.showSources(it)
                    },
                    {
                        Timber.e(it)
                    }
                )
    }


}
