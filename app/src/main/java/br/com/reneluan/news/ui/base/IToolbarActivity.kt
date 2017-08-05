package br.com.reneluan.news.ui.base

import android.graphics.PorterDuff
import android.graphics.drawable.Drawable
import android.support.annotation.DrawableRes
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import br.com.reneluan.news.R

/**
 * Created by rene on 11/18/16.
 */
interface IToolbarActivity {

    fun configureToolbar(toolbar: Toolbar, activity: AppCompatActivity, @DrawableRes icon: Int, color: Int? = null, homeEnable: Boolean) {
        activity.setSupportActionBar(toolbar)
        activity.supportActionBar?.title = ""
        activity.supportActionBar?.setDisplayHomeAsUpEnabled(homeEnable)
        activity.supportActionBar?.setDisplayShowHomeEnabled(homeEnable)
        color?.let{
//            R.drawable.abc_ic_ab_back_material
            val upArrow: Drawable? = ContextCompat.getDrawable(activity, icon)
            upArrow?.let {
                upArrow.setColorFilter(ContextCompat.getColor(activity, color), PorterDuff.Mode.SRC_ATOP)
                activity.supportActionBar?.setHomeAsUpIndicator(upArrow)
            }
        }

    }

}