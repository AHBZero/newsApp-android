package br.com.reneluan.news.ui.source

import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import br.com.reneluan.news.di.ActivityScope
import br.com.reneluan.news.ui.base.BaseActivity
import br.com.reneluan.news.di.HasComponent
import br.com.reneluan.news.R
import br.com.reneluan.news.application.App
import br.com.reneluan.news.di.components.DaggerSourceComponent
import br.com.reneluan.news.di.components.SourceComponent
import br.com.reneluan.news.di.modules.SourceModule
import br.com.reneluan.news.model.Source
import kotlinx.android.synthetic.main.activity_source.*


import javax.inject.Inject

@ActivityScope
class SourceActivity : BaseActivity<SourcePresenter>(), SourceView, HasComponent<SourceComponent> {

    @Inject
    lateinit var sourcePresenter: SourcePresenter

    lateinit var sourceComponent: SourceComponent

    private val adapter by lazy { SourceAdapter(this) }

    override fun injectModule() {
        sourceComponent = DaggerSourceComponent.builder().applicationComponent(App.get(this).getComponent()).sourceModule(SourceModule(this)).build()
        sourceComponent.inject(this)

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        recycler_sources.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recycler_sources.adapter = adapter
        recycler_sources.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))

        getPresenter().getAllSources()
    }

    override fun showSources(sources: List<Source>) {
        if (!sources.isEmpty()) {
            adapter.replace(sources)
        }
    }

    override fun getLayoutResource(): Int {
        return R.layout.activity_source
    }

    override fun getComponent():  SourceComponent {
        return sourceComponent
    }


    override fun onResume() {
        super.onResume()
        getPresenter().takeView(this)
    }

    override fun onPause() {
        super.onPause()
        getPresenter().dropView()
    }

    override fun getPresenter(): SourcePresenter = sourcePresenter
}
