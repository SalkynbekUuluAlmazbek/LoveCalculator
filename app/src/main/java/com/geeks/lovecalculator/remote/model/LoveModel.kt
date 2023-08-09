package com.geeks.lovecalculator.remote.model

import com.google.gson.annotations.SerializedName

data class LoveModel(
    @SerializedName("fname")
    var firstName: String? = null,
    @SerializedName("sname")
    var secondName: String? = null,
    var percentage: String? = null,
    var result: String? = null,
    var error: String? = null,
): java.io.Serializable
