package br.com.reneluan.news.ui.main

import android.os.Bundle
import br.com.reneluan.news.di.ActivityScope
import br.com.reneluan.news.di.components.MainComponent;
import br.com.reneluan.news.di.HasComponent
import br.com.reneluan.news.ui.base.BaseActivity
import br.com.reneluan.news.R
import br.com.reneluan.news.application.App
import br.com.reneluan.news.di.components.DaggerMainComponent
import br.com.reneluan.news.di.modules.MainModule



import javax.inject.Inject

@ActivityScope
class MainActivity : BaseActivity<MainPresenter>(), MainView, HasComponent<MainComponent>{

    @Inject
    lateinit var mainPresenter: MainPresenter

    lateinit var mainComponent: MainComponent

    override fun injectModule() {
        mainComponent = DaggerMainComponent.builder().applicationComponent(App.get(this).getComponent()).mainModule(MainModule(this)).build()
        mainComponent.inject(this)
    }

    
    override fun getPresenter(): MainPresenter {
        return mainPresenter
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun getLayoutResource(): Int {
        return R.layout.activity_main
    }

    override fun getComponent(): MainComponent {
        return mainComponent
    }

    
    override fun onResume() {
        super.onResume()
        getPresenter().takeView(this)
    }

    override fun onPause() {
        super.onPause()
        getPresenter().dropView()
    }
}
