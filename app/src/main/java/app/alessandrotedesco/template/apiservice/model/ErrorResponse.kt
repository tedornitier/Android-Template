package app.alessandrotedesco.template.apiservice.model

import com.squareup.moshi.Json

data class ErrorResponse(
    @Json(name = "error") val error: String, // TODO example
    @Json(name = "description") val description: String // TODO example
)