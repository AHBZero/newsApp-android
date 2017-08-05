package br.com.reneluan.news.model

import com.google.gson.annotations.SerializedName
import paperparcel.PaperParcel
import paperparcel.PaperParcelable

/**
 * Created by Luan on 30/07/2017.
 */
@PaperParcel
data class ArticleResponse(
        @SerializedName("status") var status: String,
        @SerializedName("source") var source: String,
        @SerializedName("sortBy") var sortBy: String,
        @SerializedName("articles") var articles: List<Article> = listOf()
): PaperParcelable {
    companion object {
        val CLASS_NAME = "ArticleResponse"
        @JvmField val CREATOR = PaperParcelArticleResponse.CREATOR
    }
}