package br.com.reneluan.news.domain.entity;

import com.google.gson.annotations.SerializedName;

class SourceEntity {
    @SerializedName("id") var id: String? = null
    @SerializedName("name") var name: String? = null
    @SerializedName("description") var description: String? = null
    @SerializedName("url") var url: String? = null
}
