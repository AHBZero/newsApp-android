package br.com.reneluan.news.ui.source

import android.content.Context
import android.view.View
import android.widget.TextView
import br.com.reneluan.news.R
import br.com.reneluan.news.model.Source
import br.com.reneluan.news.ui.base.BaseAdapter
import org.jetbrains.anko.find

/**
 * Created by Luan on 06/07/2017.
 */
class SourceAdapter(val context: Context) : BaseAdapter<Source>() {
    override fun getLayoutForType(viewType: Int): Int = R.layout.item_source

    override fun onCreateViewHolder(inflatedView: View, viewType: Int): BaseAdapter.ViewHolder<Source> {
        return ViewHolder(inflatedView, this)
    }

    inner class ViewHolder(val item: View, adapter: SourceAdapter) : BaseAdapter.ViewHolder<Source>(item, adapter) {

        val txtTitle by lazy { item.find<TextView>(R.id.txt_title) }
        val txtDescription by lazy { item.find<TextView>(R.id.txt_description) }

        override fun bindItem(value: Source, position: Int) {
            txtTitle.text = value.name
            txtDescription.text = value.description
        }

    }
}