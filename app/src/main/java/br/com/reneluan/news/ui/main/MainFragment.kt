package br.com.reneluan.news.ui.main

import br.com.reneluan.news.di.components.MainComponent
import br.com.reneluan.news.ui.base.BaseFragment
import br.com.reneluan.news.ui.base.EmptyPresenter
import br.com.reneluan.news.R


class MainFragment : BaseFragment<EmptyPresenter>() {

    override fun inject() {
        getComponent(MainComponent::class.java).inject(this)
    }

    override fun getLayoutResource(): Int {
        return R.layout.fragment_main
    }

    override fun getPresenter(): EmptyPresenter {
        return EmptyPresenter()
    }
}
