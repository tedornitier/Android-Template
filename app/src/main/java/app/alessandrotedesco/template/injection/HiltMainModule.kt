package app.alessandrotedesco.template.injection

import android.content.Context
import app.alessandrotedesco.template.apiservice.RemoteDataSourceRetrofit
import app.alessandrotedesco.template.datastore.DataStoreManager
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object HiltMainModule {
    @Singleton
    @Provides
    fun provideWebService() = RemoteDataSourceRetrofit()

    @Provides
    @Singleton
    fun provideDataStoreManager(@ApplicationContext context: Context): DataStoreManager = DataStoreManager(context)
}