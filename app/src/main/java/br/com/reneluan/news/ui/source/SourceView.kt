package br.com.reneluan.news.ui.source

import br.com.reneluan.news.model.Source
import br.com.reneluan.news.ui.base.PresenterView

interface SourceView : PresenterView {
    fun  showSources(sources: List<Source>)
}
