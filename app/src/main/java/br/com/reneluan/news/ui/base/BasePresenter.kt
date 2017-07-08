package br.com.reneluan.news.ui.base

import io.reactivex.disposables.Disposable
import java.util.*


abstract class BasePresenter<V : PresenterView> : Presenter<V>() {
    private var disposableList = ArrayList<Disposable>()

    fun add(disposable: Disposable) {
        disposableList .add(disposable)
    }

    fun unSubscribe() {
        disposableList
                .filter { ! it.isDisposed }
                .forEach { it.dispose() }
    }

    override fun dropView() {
        super.dropView()
        unSubscribe()
    }
}

