package br.com.reneluan.news.model;

import com.google.gson.annotations.SerializedName
import paperparcel.PaperParcel
import paperparcel.PaperParcelable

@PaperParcel
data class Source(
        @SerializedName("id") var id: String? = null,
        @SerializedName("name") var name: String? = null,
        @SerializedName("description") var description: String? = null,
        @SerializedName("url") var url: String? = null
): PaperParcelable {
    companion object {
        val CLASS_NAME = "Source"
        @JvmField val CREATOR = PaperParcelSource.CREATOR
    }
}