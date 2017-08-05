package br.com.reneluan.news.model

import com.google.gson.annotations.SerializedName
import paperparcel.PaperParcel
import paperparcel.PaperParcelable

@PaperParcel
data class Article(
        @SerializedName("id") var id: Long? = null,
        @SerializedName("author") var author: String? = null,
        @SerializedName("title") var title: String? = null,
        @SerializedName("description") var description: String? = null,
        @SerializedName("url") var url: String? = null,
        @SerializedName("urlToImage") var urlToImage: String? = null,
        @SerializedName("publishedAt") var publishedAt: String? = null
): PaperParcelable {
    companion object {
        val CLASS_NAME = "Article"
        @JvmField val CREATOR = PaperParcelArticle.CREATOR
    }
}