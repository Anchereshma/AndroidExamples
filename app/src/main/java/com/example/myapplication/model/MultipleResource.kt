package com.example.myapplication.model

import com.example.myapplication.model.Datum
import com.google.gson.annotations.SerializedName

data class MultipleResource(
    @SerializedName("page") val page: Int,
    @SerializedName("per_page") val perPage: Int,
    @SerializedName("total") val total: Int,
    @SerializedName("total_pages") val totalPages: Int,
    @SerializedName("data") val userList: List<Datum>
)