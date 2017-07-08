package br.com.reneluan.news.model

import com.google.gson.annotations.SerializedName
import paperparcel.PaperParcel
import paperparcel.PaperParcelable

/**
 * Created by Luan on 06/07/2017.
 */
@PaperParcel
data class SourceResponse(
        @SerializedName("status") var status: String? = null,
        @SerializedName("sources") var sources: List<Source> = listOf()
): PaperParcelable {
    companion object {
        val CLASS_NAME = "SourceResponse"
        @JvmField val CREATOR = PaperParcelSourceResponse.CREATOR
    }
}