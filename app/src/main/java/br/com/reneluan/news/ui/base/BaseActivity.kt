package br.com.reneluan.news.ui.base

import android.content.Context
import android.os.Bundle
import android.support.annotation.CallSuper
import br.com.reneluan.news.application.App
import android.support.v7.app.AppCompatActivity

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper

abstract class BaseActivity<P : BasePresenter<*>?> : AppCompatActivity() {

    @CallSuper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutResource())
        injectModule()
    }

    protected abstract fun injectModule()

    protected abstract fun getLayoutResource(): Int

    @CallSuper
    override fun onDestroy() {
        
        super.onDestroy()
    }

    @CallSuper
    override fun attachBaseContext(newBase: Context) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase))
    }

    
    @CallSuper
    override fun onResume() {
        super.onResume()
    }

    @CallSuper
    override fun onPause() {
        super.onPause()
    }

    abstract fun getPresenter(): P
    

}
