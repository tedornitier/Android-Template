package app.alessandrotedesco.template.apiservice

import app.alessandrotedesco.template.apiservice.model.Pokemon
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface Service {
    @GET("pokemon/{name}") // TODO example
    suspend fun getPokemon(@Path(value = "name") name: String): Response<Pokemon>
}
