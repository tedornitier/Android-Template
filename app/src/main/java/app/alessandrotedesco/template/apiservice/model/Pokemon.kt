package app.alessandrotedesco.template.apiservice.model

import com.squareup.moshi.Json

data class Pokemon(
    @Json(name = "name") val name: String,
    @Json(name = "id") val id: Int,
    @Json(name = "height") val height: Int
)
