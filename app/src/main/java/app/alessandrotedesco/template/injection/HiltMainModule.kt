package app.alessandrotedesco.template.injection

import app.alessandrotedesco.template.apiservice.RemoteDataSourceRetrofit
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object HiltMainModule {
    @Singleton
    @Provides
    fun provideWebService() = RemoteDataSourceRetrofit()
}