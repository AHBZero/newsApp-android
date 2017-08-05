package br.com.reneluan.news.ui.article

import android.net.Uri
import android.os.Bundle;
import android.support.customtabs.CustomTabsIntent
import android.support.v4.content.ContextCompat
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.AdapterView
import br.com.reneluan.news.di.ActivityScope
import br.com.reneluan.news.ui.base.BaseActivity
import br.com.reneluan.news.di.HasComponent
import br.com.reneluan.news.R
import br.com.reneluan.news.application.App
import br.com.reneluan.news.di.components.DaggerArticleComponent
import br.com.reneluan.news.di.components.ArticleComponent
import br.com.reneluan.news.di.modules.ArticleModule
import br.com.reneluan.news.model.Article
import br.com.reneluan.news.model.Source
import br.com.reneluan.news.ui.base.IToolbarActivity
import kotlinx.android.synthetic.main.activity_article.*
import kotlinx.android.synthetic.main.toolbar.*
import javax.inject.Inject

@ActivityScope
class ArticleActivity : BaseActivity<ArticlePresenter>(), ArticleView, HasComponent<ArticleComponent>, AdapterView.OnItemClickListener, IToolbarActivity {
    @Inject
    lateinit var articlePresenter: ArticlePresenter

    lateinit var articleComponent: ArticleComponent

    private val adapter by lazy { ArticleAdapter(this) }

    private var source: Source? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        configureToolbar(toolbar, this, R.drawable.abc_ic_ab_back_material, homeEnable = true)
        toolbar_title.text = "Ultimas"

        recycler_sources.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recycler_sources.adapter = adapter
        adapter.setOnItemClickListener(this)

        val bundle = intent.extras
        if(bundle.get(Source.CLASS_NAME) != null){
            source = bundle.get(Source.CLASS_NAME) as Source
        }

        source?.id?.let {
            getPresenter().getAllArticles(it)
        }
    }

    override fun getLayoutResource(): Int {
        return R.layout.activity_article
    }

    override fun getComponent():  ArticleComponent {
        return articleComponent
    }

    override fun onResume() {
        super.onResume()
        getPresenter().takeView(this)
    }

    override fun onPause() {
        super.onPause()
        getPresenter().dropView()
    }

    override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        val item: Article? = adapter.getItem(position)

        item?.let {
            CustomTabsIntent
                    .Builder()
                    .setToolbarColor(ContextCompat.getColor(this, R.color.colorPrimary))
                    .build()
                    .launchUrl(this, Uri.parse(it.url))
        }
    }

    override fun showArticles(list: List<Article>) {
        if (!list.isEmpty()) {
            adapter.replace(list)
        }
    }

    override fun injectModule() {
        articleComponent = DaggerArticleComponent.builder().applicationComponent(App.get(this).getComponent()).articleModule(ArticleModule(this)).build()
        articleComponent.inject(this)
    }

    override fun getPresenter(): ArticlePresenter = articlePresenter
}
