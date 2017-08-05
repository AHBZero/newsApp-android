package br.com.reneluan.news.ui.source


import android.os.Bundle
import android.support.v4.view.GravityCompat
import android.support.v7.widget.LinearLayoutManager
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import br.com.reneluan.news.R
import br.com.reneluan.news.application.App
import br.com.reneluan.news.di.ActivityScope
import br.com.reneluan.news.di.HasComponent
import br.com.reneluan.news.di.components.DaggerSourceComponent
import br.com.reneluan.news.di.components.SourceComponent
import br.com.reneluan.news.di.modules.SourceModule
import br.com.reneluan.news.model.Source
import br.com.reneluan.news.ui.article.ArticleActivity
import br.com.reneluan.news.ui.base.BaseActivity
import kotlinx.android.synthetic.main.activity_source.*
import org.jetbrains.anko.intentFor
import javax.inject.Inject
import android.support.design.widget.NavigationView
import br.com.reneluan.news.ui.base.IToolbarActivity
import kotlinx.android.synthetic.main.toolbar.*


@ActivityScope
class SourceActivity : BaseActivity<SourcePresenter>(), SourceView, HasComponent<SourceComponent>, AdapterView.OnItemClickListener, IToolbarActivity {

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
        adapter.setOnItemClickListener(this)

        configureToolbar(toolbar, this, R.drawable.ic_dehaze_black_24dp, homeEnable = true)
        toolbar_title.text = "Fontes de Noticias"

        getPresenter().getAllSources()

        navigation_drawer_container.setNavigationItemSelectedListener(
                { menuItem ->
                    selectDrawerItem(menuItem)
                    true
                })

    }

    fun selectDrawerItem(menuItem: MenuItem) {
        when(menuItem.itemId){
            R.id.menu_all-> {
                drawer_layout.closeDrawer(GravityCompat.START)
                getPresenter().getAllSources()
            }
            R.id.menu_business -> {
                drawer_layout.closeDrawer(GravityCompat.START)
                getPresenter().getSources("business")
            }
            R.id.menu_entertainment -> {
                drawer_layout.closeDrawer(GravityCompat.START)
                getPresenter().getSources("entertainment")
            }
            R.id.menu_gaming -> {
                drawer_layout.closeDrawer(GravityCompat.START)
                getPresenter().getSources("gaming")
            }
            R.id.menu_general -> {
                drawer_layout.closeDrawer(GravityCompat.START)
                getPresenter().getSources("general")
            }
            R.id.menu_music -> {
                drawer_layout.closeDrawer(GravityCompat.START)
                getPresenter().getSources("music")
            }
            R.id.menu_politics -> {
                drawer_layout.closeDrawer(GravityCompat.START)
                getPresenter().getSources("politics")
            }
            R.id.menu_science_and_nature -> {
                drawer_layout.closeDrawer(GravityCompat.START)
                getPresenter().getSources("science-and-nature")
            }
            R.id.menu_sport -> {
                drawer_layout.closeDrawer(GravityCompat.START)
                getPresenter().getSources("sport")
            }
            R.id.menu_technology -> {
                drawer_layout.closeDrawer(GravityCompat.START)
                getPresenter().getSources("technology")
            }
        }
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

    override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        val item: Source? = adapter.getItem(position)

        item?.let {
            goToArticle(it)
        }
    }

    private fun goToArticle(source: Source) {
        startActivity(intentFor<ArticleActivity>(
                Source.CLASS_NAME to source
        ))
    }

    override fun getPresenter(): SourcePresenter = sourcePresenter
}
