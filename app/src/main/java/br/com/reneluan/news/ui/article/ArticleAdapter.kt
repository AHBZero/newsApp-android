package br.com.reneluan.news.ui.article

import android.content.Context
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import br.com.reneluan.news.R
import br.com.reneluan.news.model.Article
import br.com.reneluan.news.ui.base.BaseAdapter
import com.bumptech.glide.Glide
import org.jetbrains.anko.find

/**
 * Created by Luan on 30/07/2017.
 */
class ArticleAdapter(val context: Context) : BaseAdapter<Article>() {
    override fun getLayoutForType(viewType: Int): Int = R.layout.item_article

    override fun onCreateViewHolder(inflatedView: View, viewType: Int): BaseAdapter.ViewHolder<Article> {
        return ViewHolder(inflatedView, this)
    }

    inner class ViewHolder(val item: View, adapter: ArticleAdapter) : BaseAdapter.ViewHolder<Article>(item, adapter) {
        val image by lazy { item.find<ImageView>(R.id.img_article) }
        val txtTitle by lazy { item.find<TextView>(R.id.txt_title) }
        val txtDescription by lazy { item.find<TextView>(R.id.txt_description) }
        val txtAuthor by lazy { item.find<TextView>(R.id.txt_author) }
        val txtPublished by lazy { item.find<TextView>(R.id.txt_published_at) }

        override fun bindItem(value: Article, position: Int) {
            Glide.with(context)
                    .load(value.urlToImage)
                    .into(image)

            txtTitle.text = value.title
            txtDescription.text = value.description
            txtAuthor.text = value.author
            txtPublished.text = value.publishedAt
        }

    }
}