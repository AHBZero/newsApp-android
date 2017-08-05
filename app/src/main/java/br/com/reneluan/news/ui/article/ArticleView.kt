package br.com.reneluan.news.ui.article

import br.com.reneluan.news.model.Article
import br.com.reneluan.news.ui.base.PresenterView

interface ArticleView : PresenterView {
    fun showArticles(list: List<Article>)
}
