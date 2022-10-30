package app.alessandrotedesco.template.apiservice

import app.alessandrotedesco.template.apiservice.model.ErrorResponse
import com.squareup.moshi.Moshi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.ResponseBody
import retrofit2.HttpException
import retrofit2.Response
import timber.log.Timber
import java.io.IOException

abstract class BaseRepo {
    suspend fun <T> safeApiCall(apiToBeCalled: suspend () -> Response<T>): Resource<T> {
        return withContext(Dispatchers.IO) {
            try {
                val response: Response<T> = apiToBeCalled()

                if (response.isSuccessful) {
                    Resource.Success(data = response.body()!!)
                } else {
                    val errorResponse: ErrorResponse? = convertErrorBody(response.errorBody())
                    Timber.e("OkHttp API error response: ${errorResponse?.error}")
                    Resource.Error(errorMessage = errorResponse?.error ?: "Something went wrong")
                }

            } catch (e: HttpException) {
                Resource.Error(errorMessage = e.message ?: "Something went wrong, code: ${e.code()}")
            } catch (e: IOException) {
                Resource.Error(errorMessage = "Please check your network connection: ${e.message}")
            } catch (e: Exception) {
                Resource.Error(errorMessage = "Something went wrong: ${e.message}")
            }
        }
    }

    private fun convertErrorBody(errorBody: ResponseBody?): ErrorResponse? {
        return try {
            errorBody?.source()?.let {
                val moshiAdapter = Moshi.Builder().build().adapter(ErrorResponse::class.java)
                moshiAdapter.fromJson(it)
            }
        } catch (exception: Exception) {
            null
        }
    }
}