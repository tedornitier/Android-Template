package app.alessandrotedesco.template.injection

import app.alessandrotedesco.template.apiservice.RemoteDataSourceRetrofit
import app.alessandrotedesco.template.datastore.DataStoreManager
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@EntryPoint
@InstallIn(SingletonComponent::class)
interface HiltEntryPoint {
    fun webService(): RemoteDataSourceRetrofit
    fun dataStoreManager(): DataStoreManager
}