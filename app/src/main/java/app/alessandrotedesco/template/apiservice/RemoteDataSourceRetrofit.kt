package app.alessandrotedesco.template.apiservice

import app.alessandrotedesco.template.BuildConfig
import app.alessandrotedesco.template.apiservice.adapter.MyEnumAdapter
import app.alessandrotedesco.template.apiservice.interceptors.HeaderInterceptor
import app.alessandrotedesco.template.apiservice.model.Pokemon
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

class RemoteDataSourceRetrofit: BaseRepo() {
    private var client: Service

    init {
        val headerInterceptor = HeaderInterceptor()
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = if (BuildConfig.DEBUG) {
            HttpLoggingInterceptor.Level.BODY
        } else HttpLoggingInterceptor.Level.NONE

        val oAuthClient = OkHttpClient.Builder()
            .addInterceptor(headerInterceptor)
            .addInterceptor(loggingInterceptor)
            .writeTimeout(1, TimeUnit.MINUTES)
            .readTimeout(1, TimeUnit.MINUTES)
            .build()

        val moshiBuilder = MoshiConverterFactory.create(
            Moshi.Builder()
                .add(MyEnumAdapter())
                .add(KotlinJsonAdapterFactory())
                .build()
        )

        val retrofit = Retrofit.Builder()
            .baseUrl(BuildConfig.ENDPOINT)
            .addConverterFactory(moshiBuilder)
            .client(oAuthClient)
            .build()

        client = retrofit.create(Service::class.java)
    }

    suspend fun getPokemon(name: String): Resource<Pokemon> = safeApiCall { // TODO example
        client.getPokemon(name)
    }
}