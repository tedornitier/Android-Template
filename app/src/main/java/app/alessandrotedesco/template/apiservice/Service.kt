package app.alessandrotedesco.template.apiservice

import app.alessandrotedesco.template.apiservice.model.MyEnum
import retrofit2.Response
import retrofit2.http.GET

interface Service {
    @GET("Enum") // TODO example
    suspend fun getEnum(): Response<MyEnum>
}
